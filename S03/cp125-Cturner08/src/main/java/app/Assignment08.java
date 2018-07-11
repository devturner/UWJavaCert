package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.client.InvoiceClient;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.server.CommandProcessor;
import com.scg.util.ListFactory;
import com.scg.util.Name;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment08.
 */
public class Assignment08 {

	/** The Constant DEFAULT_PORT. */
	public static final int DEFAULT_PORT = 10888;


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		final List<Consultant> consultants = new ArrayList<Consultant>();
		final List<TimeCard> timeCards = new ArrayList<TimeCard>();
		ListFactory.populateLists(accounts, consultants, timeCards);






		//getTarget();
		//System.out.println(test1.setReceiver(addConsultantCommand)));

		//test1.execute();

//		CommandProcessor recvr = test1.setReceiver(receiver);;
//		test1.setReceiver(recvr);
//		System.out.println(test1.toString());
//
//		recvr.execute(test1);

		//ObjectOutputStream output = new ObjectOutputStream(test1);

		InvoiceClient iClient = new InvoiceClient(DEFAULT_PORT, timeCards);
		iClient.run();

		//iClient.sendConsultants(test1);

	}

}
