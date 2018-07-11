package com.scg.net.server;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.net.cmd.Command;

// TODO: Auto-generated Javadoc
/**
 * The server for creation of account invoices based on time cards sent from the
 * client.
 *
 * @author Russ Moul
 */
public final class InvoiceServer {
    /** The class' logger. */
    private static final Logger logger =
                         LoggerFactory.getLogger(InvoiceServer.class);

	/** The Constant SERVERDIRNAME. */
	private static final String SERVERDIRNAME = "server_";

    /** The clients/accounts. */
    private final List<ClientAccount> clientList;

    /** The consultants. */
    private final List<Consultant> consultantList;

    /** The server socket socket. */
    private static ServerSocket serverSocket = null;

    /** The server socket port. */
    private final int port;



    /**
     * Construct an InvoiceServer with a port.
     *
     * @param port The port for this server to listen on
     * @param clientList the initial list of clients
     * @param consultantList the initial list of consultants
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InvoiceServer(final int port, final List<ClientAccount> clientList,
                         final List<Consultant> consultantList) throws IOException{
        this.port = port;
        this.clientList = clientList;
        this.consultantList = consultantList;
        ServerSocket serverSocket = new ServerSocket(port);
    		InvoiceServer.serverSocket = serverSocket;
            logger.info("InvoiceServer started on: "
                      + serverSocket.getInetAddress().getHostName() + ":"
                      + serverSocket.getLocalPort());

        Runtime.getRuntime().addShutdownHook(new InvoiceServerShutdownHook(clientList, consultantList));
        }


    /**
     * Run this server, establishing connections, receiving commands, and
     * sending them to the CommandProcesser.
     */


    //create a file a new subdirectory - @8mins

    //errors to catch:
    //unable to create directory
    //server socket closed
    //connection accept failed
    //unable to close the listening socket
    //shutting down due to quit command from client

    public void run() {
    	int processorNumber = 0;
             while (!serverSocket.isClosed()) {
                logger.info("InvoiceServer waiting for connection on port " + port);
                Socket client;
				try {
					client = serverSocket.accept();
                	processorNumber++;
                    //client.shutdownOutput();
                    logger.info("Connection made.");
                    final CommandProcessor cmdProc =
                        new CommandProcessor(client, "Command Processor " + processorNumber, clientList, consultantList, this);
                    final File serverDir= new File(SERVERDIRNAME + processorNumber);
                    if(serverDir.exists() || serverDir.mkdir()) {
                    	cmdProc.setOutPutDirectoryName(serverDir.getAbsolutePath());
                    	final Thread thread = new Thread(cmdProc, "Command Processor" + processorNumber);
                    	thread.start();
                    } else {
                    	logger.error("unable to create the output, o " + serverDir.getAbsolutePath());
                    }
				} catch (IOException e) {
					e.printStackTrace();
				}

                }
                }





    /**
     * Shutdown the server.
     */
    static void shutdown() {
    	//logger.error("Shutting Down");
        try {
            if (!serverSocket.isClosed()) {

            	serverSocket.close();
            }
        } catch (final IOException e) {
            logger.error("Shutdown unable to close listening socket.", e);
        }
    }
}
