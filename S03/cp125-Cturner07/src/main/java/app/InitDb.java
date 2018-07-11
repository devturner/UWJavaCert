package app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.persistent.DbServer;
import com.scg.util.ListFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class InitDb.
 */
public class InitDb {

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
		// Print them
		// ListFactory.printTimeCards(timeCards, System.out);

		DbServer dbS = new DbServer("jdbc:derby://localhost:1527/memory:scgDb",
				"student", "student");

		for (ClientAccount account : accounts) {
			try {
				dbS.addClient(account);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		for (Consultant connsultant : consultants) {
			try {
				dbS.addConsultant(connsultant);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for(TimeCard timeCard : timeCards) {
			try {
				dbS.addTimeCard(timeCard);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
