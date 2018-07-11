package com.scg.net.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.cmd.AddClientCommand;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.cmd.AddTimeCardCommand;
import com.scg.net.cmd.Command;
import com.scg.net.cmd.CreateInvoicesCommand;
import com.scg.net.cmd.DisconnectCommand;
import com.scg.net.cmd.ShutdownCommand;
import com.scg.util.Address;
import com.scg.util.Name;
import com.scg.util.StateCode;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceClient.
 */
public final class InvoiceClient {

	/** The port. */
	private int port;

	/** The client list. */
	private List<ClientAccount> clientList = new ArrayList<ClientAccount>();

	/** The consultant list. */
	private List<Consultant> consultantList = new ArrayList<Consultant>();

	/** The time cards list. */
	private List<TimeCard> timeCardsList = new ArrayList<TimeCard>();

	/** The Constant log. */
	private static final Logger log = LoggerFactory
			.getLogger(InvoiceClient.class);

    /** The Constant INVOICE_MONTH. */
    private static final int INVOICE_MONTH = Calendar.MARCH;

    /** The Constant INVOICE_YEAR. */
    private static final int INVOICE_YEAR = 2006;

	/**
	 * Instantiates a new invoice client.
	 *
	 * @param port the port
	 * @param timeCards the time cards
	 */
	public InvoiceClient(int port, List<TimeCard> timeCards) {
		this.port = port;
		this.timeCardsList = timeCards;
	}

	/**
	 * Creates the invoices.
	 *
	 * @param out the out
	 * @param month the month
	 * @param year the year
	 */
	public void createInvoices(ObjectOutputStream out, int month, int year) {
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        CreateInvoicesCommand cmd = new CreateInvoicesCommand(cal.getTime());
        log.info("The invoices were created and sent! \n");
		sendCommand(out, cmd);
    }



	/**
	 * Run.
	 */
	public void run() {

		try (Socket s = new Socket("127.0.0.1", port)){
			log.info("We got a connection!");
			s.shutdownInput();

			ObjectOutputStream out = null;
			try {
				out = new ObjectOutputStream(s.getOutputStream());
			sendClients(out);
			sendConsultants(out);
			sendTimeCards(out);
			createInvoices(out, INVOICE_MONTH, INVOICE_YEAR);
			sendDisconnect(out);
			sendShutdown("127.0.0.1", port);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


    /**
     * Send clients.
     *
     * @param out the out
     */
    public void sendClients(ObjectOutputStream out) {
    	ClientAccount test = new ClientAccount("Fake Client", new Name("Last","First","Middle"), new Address("444 Pen St.","New York", StateCode.NY, "00012"));
    	ClientAccount test1 = new ClientAccount("FarFigNewton", new Name("Smith","Ned","Eldon"), new Address("3133 Shark Dr.","Austin", StateCode.TX, "54312"));
		clientList.add(test);
		clientList.add(test1);
        for (ClientAccount client : clientList) {
            AddClientCommand cmd = new AddClientCommand(client);
			log.info("The client " + client.getName() + " was sent! \n");
			sendCommand(out, cmd);
        }
    }

	/**
	 * Send consultants.
	 *
	 * @param out the out
	 */
	public void sendConsultants(ObjectOutputStream out) {
		Consultant test = new Consultant(new Name("Turner", "Chris", "Lee"));
		Consultant test1 = new Consultant(new Name("Rock", "Greg", "Sam"));
		consultantList.add(test);
		consultantList.add(test1);
		for (Consultant consultant : consultantList){
			log.info("The consultant " + consultant.getName().getLastName() + " was sent!\n");
            AddConsultantCommand cmd = new AddConsultantCommand(consultant);
			sendCommand(out, cmd);
        }
	}

	/**
	 * Send disconnect.
	 *
	 * @param out the out
	 */
	public void sendDisconnect(ObjectOutputStream out) {
		DisconnectCommand cmd = new DisconnectCommand();
		log.info("The disconnect command was sent to the server.");
		sendCommand(out, cmd);
	}

	/**
	 * Send shutdown.
	 *
	 * @param host the host
	 * @param port the port
	 */
	static void sendShutdown(String host, int port) {
		ShutdownCommand cmd = new ShutdownCommand();
		log.info("The shutdown command was sent to the server.");
		try (Socket s = new Socket(host, port)){
			ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
			outputStream.writeObject(cmd);
			outputStream.flush();
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Send time cards.
	 *
	 * @param out the out
	 */
	public void sendTimeCards(ObjectOutputStream out) {
		for (TimeCard timeCard : timeCardsList) {
            AddTimeCardCommand cmd = new AddTimeCardCommand(timeCard);
            log.info("The timecard for " + timeCard.getConsultant().getName() + " was sent!\n");
			sendCommand(out, cmd);
        }
    }

	/**
	 * Send command.
	 *
	 * @param out the out
	 * @param command the command
	 */
	private static void sendCommand(ObjectOutputStream out, Command<?> command) {

		try {
			out.writeObject(command);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
