package com.scg.net.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import com.scg.net.cmd.AddClientCommand;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.cmd.AddTimeCardCommand;
import com.scg.net.cmd.Command;
import com.scg.net.cmd.CreateInvoicesCommand;
import com.scg.net.cmd.DisconnectCommand;
import com.scg.net.cmd.ShutdownCommand;

// TODO: Auto-generated Javadoc
/**
 * The command processor for the invoice server. Implements the receiver role in
 * the Command design pattern.
 *
 * @author Russ Moul
 */

public final class CommandProcessor implements Runnable {
	/** The class' logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CommandProcessor.class);

	/** The socket connection. */
	private final Socket connection;

	/** The client list to be maintained by this CommandProcessor. */
	private final List<ClientAccount> clientList;

	/** The consultant list to be maintained by this CommandProcessor. */
	private final List<Consultant> consultantList;

	/** The time card list to be maintained by this CommandProcessor. */
	private final List<TimeCard> timeCardList = new ArrayList<TimeCard>();

	/** The name of the directory to be used for files output by commands. */
	private String outputDirectoryName = ".";

	/** The server this command processor is spawned from. */
	private final InvoiceServer server;

	/** The name. */
	private String name;

	// private Thread t;

	/**
	 * Construct a CommandProcessor.
	 *
	 * @param connection            the Socket connecting the server to the client.
	 * @param name the name
	 * @param clientList            the ClientList to add Clients to.
	 * @param consultantList            the ConsultantList to add Consultants to.
	 * @param server            the server that created this command processor
	 */
	public CommandProcessor(final Socket connection, final String name,
			final List<ClientAccount> clientList,
			final List<Consultant> consultantList, final InvoiceServer server) {
		this.name = name;
		this.connection = connection;
		this.clientList = clientList;
		this.consultantList = consultantList;
		this.server = server;
		//System.out.println("Does this print COMMAND PROCESSOR?");

	}

	/**
	 * Set the output directory name.
	 *
	 * @param outPutDirectoryName
	 *            the output directory name.
	 */
	public void setOutPutDirectoryName(final String outPutDirectoryName) {
		this.outputDirectoryName = outPutDirectoryName;
	}

	/**
	 * Execute and AddTimeCardCommand.
	 *
	 * @param command
	 *            the command to execute.
	 */
	public void execute(final AddTimeCardCommand command) {
		logger.info("Executing add time card command: " + command);
		//timeCardList.add(command.getTarget());
		TimeCard timeCard = command.getTarget();
		synchronized (timeCard) {
			for (TimeCard tempTimeCard : timeCardList) {
				timeCardList.add(tempTimeCard);
			}

		}
	}

	/**
	 * Execute an AddClientCommand.
	 *
	 * @param command
	 *            the command to execute.
	 */
	public void execute(final AddClientCommand command) {
		logger.info(String.format(
				"Processor %s executing add client command: %s", name, command
						.getTarget().getName()));
		ClientAccount client = command.getTarget();
		synchronized (clientList) {
			if (!clientList.contains(client)) {
				clientList.add(client);
			}
		}
	}

	/**
	 * Execute and AddConsultantCommand.
	 *
	 * @param command
	 *            the command to execute.
	 */
	public void execute(final AddConsultantCommand command) {
		logger.info(String.format(
				"Processor %s executing add consultant command: %s", name,
				command.getTarget().getName()));
		// consultantList.add(command.getTarget());
		final Consultant cons = command.getTarget();
		synchronized (consultantList) {
			if (!consultantList.contains(cons)) {
				consultantList.add(cons);
			}
		}
	}

	/**
	 * Execute a CreateInvoicesCommand.
	 *
	 * @param command
	 *            the command to execute.
	 */
	public void execute(final CreateInvoicesCommand command) {
		logger.info("Executing invoice command: " + command);
		Invoice invoice = null;
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(command.getTarget());
		final SimpleDateFormat formatter = new SimpleDateFormat("MMMMyyyy");
		final String monthString = formatter.format(calendar.getTime());
		synchronized (clientList) {
			for (final ClientAccount client : clientList) {
				invoice = new Invoice(client, calendar.get(Calendar.MONTH),
						calendar.get(Calendar.YEAR));
				for (final TimeCard currentTimeCard : timeCardList) {
					invoice.extractLineItems(currentTimeCard);
				}
				if (invoice.getTotalHours() > 0) {
					final File serverDir = new File(outputDirectoryName);
					if (!serverDir.exists()) {
						if (!serverDir.mkdirs()) {
							logger.error("Unable to create directory, "
									+ serverDir.getAbsolutePath());
							return;
						}
					}
					final String outFileName = String.format("%s%sInvoice.txt",
							client.getName().replaceAll(" ", ""), monthString);
					final File outFile = new File(outputDirectoryName,
							outFileName);
					try (PrintStream printOut = new PrintStream(
							new FileOutputStream(outFile), true);) {
						printOut.println(invoice.toReportString());
					} catch (final FileNotFoundException e) {
						logger.error("Can't open file " + outFileName, e);
					}
				}
			}
		}
	}

	/**
	 * Execute a DisconnectCommand.
	 *
	 * @param command
	 *            the input DisconnectCommand.
	 */
	public void execute(final DisconnectCommand command) {
		logger.info("Executing disconnect command: " + command);
		try {
			connection.close();
		} catch (final IOException e) {
			logger.warn("Disconnect unable to close client connection.", e);
		}
	}

	/**
	 * Execute a ShutdownCommand. Closes any current connections, stops
	 * listening for connections and then terminates the server, without calling
	 * System.exit.
	 *
	 * @param command
	 *            the input ShutdownCommand.
	 */
	public void execute(final ShutdownCommand command) {
		logger.info("Executing shutdown command: " + command);
		try {
			connection.close();
		} catch (final IOException e) {
			logger.warn("Shutdown unable to close client connection.", e);
		} finally {
			server.shutdown();
		}
	}

	// in = new ObjectInputStream(client.getInputStream());
	// create a file a new subdirectory - @8mins

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		logger.info("Running " + name);
		ObjectInputStream in = null;
		try{in = new ObjectInputStream(connection.getInputStream());
		while (!connection.isClosed()) {
            final Object obj = in.readObject();
            if (obj instanceof Command<?>) {
                final Command<?> command = (Command<?>)obj;
                logger.info("Received command: "
                          + command.getClass().getSimpleName());
                command.setReceiver(this);
                command.execute();
            } else {
                logger.warn(String.format("Received non command object, %s, discarding.",
                        obj.getClass().getSimpleName()));
            }

		//catch Attepmt to read command failed
        //
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
