package app;

import java.io.FileNotFoundException;
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

// TODO: Auto-generated Javadoc
//Creates the Consultants, Clients and TimeCards as in previous assignments

/**
 * The Class initLists.
 */
public final class InitLists {

	/** This class' logger. */

	private static final Logger log = LoggerFactory.getLogger("initLists");



	/** The Constant accounts. */
	final static List<ClientAccount> accounts = new ArrayList<ClientAccount>();

	/** The Constant consultants. */
	final static List<Consultant> consultants = new ArrayList<Consultant>();

	/** The Constant timeCards. */
	final static List<TimeCard> timeCards = new ArrayList<TimeCard>();


	/**
	 * Make lists.
	 */
	private static void makeLists() {
		ListFactory.populateLists(accounts, consultants, timeCards);
	}

	/**
	 * Write file accounts.
	 */
	private static void writeFileAccounts(){
		try(FileOutputStream fs = new FileOutputStream("ClientList.ser")){
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(accounts);
			os.close();
		} catch (FileNotFoundException e) {
			log.error("The file was not be created.", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("The file could not be read.", e);
		}

	}

	/**
	 * Write file time cards.
	 */
	private static void writeFileTimeCards(){
		try(FileOutputStream fs = new FileOutputStream("TimeCardList.ser")){
			ObjectOutputStream os = new ObjectOutputStream(fs);
			//os.writeInt(timeCards.size());
			os.writeObject(timeCards);
			os.close();
		} catch (FileNotFoundException e) {
			log.error("The file was not be created.", e);
		} catch (IOException e) {
			log.error("The file could not be read.", e);
		}
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		makeLists();
		//System.out.println(timeCards.toString());
		writeFileAccounts();
		writeFileTimeCards();
//		System.out.println(timeCards.size());
//
//		System.out.println("This was done, refresh the files!");
	}



}
