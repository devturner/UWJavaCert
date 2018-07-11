package com.scg.net.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Assignment09;
import app.Assignment09Server;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.net.client.InvoiceClient;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceServerShutdownHook.
 */
public final class InvoiceServerShutdownHook extends Thread {

	/** The client list. */
	List<ClientAccount> clientList = new ArrayList<ClientAccount>();

	/** The consultant list. */
	List<Consultant> consultantList = new ArrayList<Consultant>();

	/** The shutdown delay seconds. */
	private final long SHUTDOWN_DELAY_SECONDS = 5000;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(InvoiceServerShutdownHook.class);

	/** The Constant clientFile. */
	private static final String clientFile = "server/ClientList.txt";

	/** The Constant consultantFile. */
	private static final String consultantFile = "server/ConsultantList.txt";

	/**
	 * Instantiates a new invoice server shutdown hook.
	 *
	 * @param clientList the client list
	 * @param consultantList the consultant list
	 */
	public InvoiceServerShutdownHook(List<ClientAccount> clientList,
			List<Consultant> consultantList) {
		this.clientList = clientList;
		this.consultantList = consultantList;
	}

	// Called by the Runtime when a shutdown signal is received.
	// This will write the client and consultant lists to file, then shut down
	// after SHUTDOWN_DELAY_SECONDS seconds.

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try (PrintStream clientOut = new PrintStream(new FileOutputStream(
				clientFile), true);
				PrintStream consultantOut = new PrintStream(
						new FileOutputStream(consultantFile), true);) {
			synchronized (clientList) {
				for (final ClientAccount client : clientList) {
					clientOut.print(client.toString());
				}

				synchronized (consultantList) {
					for (final Consultant cons : consultantList) {
						consultantOut.println(cons.toString());
					}
				}
				clientOut.close();
				consultantOut.close();
				//System.out.println(Thread.activeCount());
				try {
					System.out.println("We will shut down after this short delay");
					Thread.sleep(SHUTDOWN_DELAY_SECONDS);
					System.out.println("Now");
					InvoiceServer.shutdown();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
