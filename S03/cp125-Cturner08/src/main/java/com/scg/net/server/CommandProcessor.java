package com.scg.net.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.net.cmd.*;


// TODO: Auto-generated Javadoc
/**
 * The Class CommandProcessor.
 */
public final class CommandProcessor {

	/** The connection. */
	private Socket connection = null;

	/** The client list. */
	private List<ClientAccount> clientList = new ArrayList<ClientAccount>();

	/** The consultant list. */
	private List<Consultant> consultantList = new ArrayList<Consultant>();

	/** The time cards. */
	private List<TimeCard> timeCards = new ArrayList<TimeCard>();

	/** The server. */
	private InvoiceServer server = null;

	/** The out put directory name. */
	private String outPutDirectoryName = ".";

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CommandProcessor.class);

	/**
	 * Instantiates a new command processor.
	 *
	 * @param connection the connection
	 * @param clientList the client list
	 * @param consultantList the consultant list
	 * @param server the server
	 */
	public CommandProcessor(Socket connection, List<ClientAccount> clientList,
			List<Consultant> consultantList, InvoiceServer server) {
		this.connection = connection;
		this.clientList = clientList;
		this.consultantList = consultantList;
		this.server = server;
	}

	/**
	 * Execute.
	 *
	 * @param addConsultantCommand the add consultant command
	 */
	public void execute(AddConsultantCommand addConsultantCommand) {
		consultantList.add(addConsultantCommand.getTarget());

	}

	/**
	 * Execute.
	 *
	 * @param addClientCommand the add client command
	 */
	public void execute(AddClientCommand addClientCommand) {
		clientList.add(addClientCommand.getTarget());
	}

	/**
	 * Execute.
	 *
	 * @param addTimeCardCommand the add time card command
	 */
	public void execute(AddTimeCardCommand addTimeCardCommand) {
		timeCards.add(addTimeCardCommand.getTarget());

	}

	/**
	 * Execute.
	 *
	 * @param createInvoicesCommand the create invoices command
	 */
	public void execute(CreateInvoicesCommand createInvoicesCommand) {
		log.info("Executing" + createInvoicesCommand);
		Invoice invoice = null;
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(createInvoicesCommand.getTarget());
		final SimpleDateFormat formatter = new SimpleDateFormat("MMMMyyyy");
		final String monthString = formatter.format(calendar.getTime());
		for (ClientAccount client : clientList) {
			invoice = new Invoice(client, calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
			for(final TimeCard timecard : timeCards)
				invoice.extractLineItems(timecard);
		if(invoice.getTotalHours() > 0) {
			final File serverDir = new File(outPutDirectoryName);
			if(!serverDir.exists()) {
				if(!serverDir.mkdirs()) {
					log.error("Unable to make the directory. " + serverDir.getAbsolutePath());
					return;
				}
			}
			final String outFileName = String.format("%s%sinvoice.txt", client.getName().replace(" ", ""),monthString);
			final File outFile = new File(outPutDirectoryName, outFileName);
			try (PrintStream printout = new PrintStream(new FileOutputStream(outFile), true)) {
				printout.print(invoice.toReportString());
				log.info("The invoice files were created!");
				printout.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}




//	}

	/**
 * Execute.
 *
 * @param disconnectCommand the disconnect command
 */
public void execute(DisconnectCommand disconnectCommand) {
		try {
			connection.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * Execute.
	 *
	 * @param shutdownCommand the shutdown command
	 */
	public void execute(ShutdownCommand shutdownCommand) {
		try {
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sets the out put directory name.
	 *
	 * @param outPutDirectoryName the new out put directory name
	 */
	public void setOutPutDirectoryName(String outPutDirectoryName) {
		this.outPutDirectoryName = outPutDirectoryName;
	}





}
