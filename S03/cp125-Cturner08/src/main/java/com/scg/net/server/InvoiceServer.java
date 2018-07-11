package com.scg.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.net.cmd.AbstractCommand;
import com.scg.net.cmd.Command;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceServer.
 */
public final class InvoiceServer {
	// serversocket
	/** The port. */
	private int port;

	/** The s. */
	private ServerSocket s;

	/** The Constant log. */
	private static final Logger log = LoggerFactory
			.getLogger(InvoiceServer.class);

	/** The client list. */
	List<ClientAccount> clientList = new ArrayList<ClientAccount>();

	/** The consultant list. */
	List<Consultant> consultantList = new ArrayList<Consultant>();

	/**
	 * Instantiates a new invoice server.
	 *
	 * @param port the port
	 * @param clientList the client list
	 * @param consultantList the consultant list
	 */
	public InvoiceServer(int port, List<ClientAccount> clientList,
			List<Consultant> consultantList) {
		this.port = port;
		this.clientList = clientList;
		this.consultantList = consultantList;
	}

	/**
	 * Run.
	 */
	public void run() {
		try {
			s = new ServerSocket(port);
			log.info("Server ready on port " + port + "...");
			while (s != null && !s.isClosed()) {
				try (Socket incoming = s.accept();) {
					incoming.shutdownOutput();
					ObjectInputStream inputStream = new ObjectInputStream(
							incoming.getInputStream());
					try {
						CommandProcessor cP = new CommandProcessor(incoming,
								clientList, consultantList, this);
						cP.setOutPutDirectoryName("Server");
						while (!s.isClosed()) {
							final Object obj = inputStream.readObject();
							if (obj instanceof Command<?>) {
								final Command<?> command = (Command<?>) obj;
								log.info("Received Command: "
										+ command.getClass().getSimpleName());
								command.setReceiver(cP);
								command.execute();

							} else {
								log.warn(String
										.format("Received non command object, %s, discarding.",
												obj.getClass().getSimpleName()));
							}
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shutdown.
	 */
	void shutdown() {
		if (!s.isClosed()) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
