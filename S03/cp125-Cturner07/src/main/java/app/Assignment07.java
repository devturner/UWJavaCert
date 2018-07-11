package app;

import java.sql.SQLException;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.Invoice;
import com.scg.persistent.DbServer;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment07.
 */
public class Assignment07 {



	/** The Constant INVOICE_MONTH. */
	private static final int INVOICE_MONTH = 2;

	/** The Constant INVOICE_YEAR. */
	private static final int INVOICE_YEAR = 2006;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		DbServer dbS = new DbServer("jdbc:derby://localhost:1527/memory:scgDb","student", "student");

		System.out.println("The cons");
		try {
			for(final Consultant consultant : dbS.getConsultants()) {
				System.out.println(consultant.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		System.out.println();

		try {
			for(final ClientAccount client : dbS.getClients()) {
				System.out.println(client.getName());

				final Invoice inv = dbS.getInvoice(client, INVOICE_MONTH, INVOICE_YEAR);

				System.out.println(inv.toReportString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
