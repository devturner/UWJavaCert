package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.util.ListFactory;

/**
 * Initialize client list files.
 */
public final class InitLists {
	/** This class' logger. */
	private static final Logger log = LoggerFactory.getLogger(InitLists.class);

	/**
	 * Prevent instantiation.
	 */
	private InitLists() {
	}

	/**
	 * Serialize the client, consultant and time card lists.
	 *
	 * @param accounts
	 *            the account list to serialize
	 * @param timeCards
	 *            the time card list to serialize
	 */
	private static void serializeLists(final List<ClientAccount> accounts,
			final List<TimeCard> timeCards) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("ClientList.ser"))) {
			out.writeObject(accounts);
		} catch (final IOException e) {
			log.error("Serialization of client list failed.", e);
		}

		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("TimeCardList.ser"))) {
			out.writeObject(timeCards);
		} catch (final IOException e) {
			log.error("Serialization of timecard list failed.", e);
		}
	}

	/**
	 * InitLists application method.
	 *
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(final String[] args) {
		// Create lists to be populated by factory
		final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		final List<Consultant> consultants = new ArrayList<Consultant>();
		final List<TimeCard> timeCards = new ArrayList<TimeCard>();
		ListFactory.populateLists(accounts, consultants, timeCards);
		// Print them
		ListFactory.printTimeCards(timeCards, System.out);
		// Serialize the lists
		serializeLists(accounts, timeCards);
	}
}
