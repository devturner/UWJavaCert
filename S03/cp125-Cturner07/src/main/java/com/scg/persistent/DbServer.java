package com.scg.persistent;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.ConsultantTime;
import com.scg.domain.Invoice;
import com.scg.domain.InvoiceLineItem;
import com.scg.domain.NonBillableAccount;
import com.scg.domain.Skill;
import com.scg.domain.TimeCard;
import com.scg.util.Address;
import com.scg.util.DateRange;
import com.scg.util.Name;
import com.scg.util.StateCode;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * Responsible for providing a programmatic interface to store and access
 * objects in the database.
 *
 * @author christurner
 */

public final class DbServer {

	/** The db url. */
	private String dbUrl;

	/** The username. */
	private String username;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new db server.
	 *
	 * @param dbUrl
	 *            the db url
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public DbServer(String dbUrl, String username, String password) {
		this.dbUrl = dbUrl;
		this.username = username;
		this.password = password;
	}

	/**
	 * Adds the client.
	 *
	 * @param client
	 *            the client
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	public void addClient(ClientAccount client) throws SQLException,
			ClassNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try (Connection conn1 = DriverManager.getConnection(dbUrl, username,
				password);) {
			ps = conn1
					.prepareStatement(
							"INSERT INTO CLIENTS (NAME, STREET, CITY, STATE, POSTAL_CODE, "
									+ "CONTACT_LAST_NAME, CONTACT_FIRST_NAME, CONTACT_MIDDLE_NAME) VALUES (?,?,?,?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, client.getName());
			ps.setString(2, client.getAddress().getStreetNumber());
			ps.setString(3, client.getAddress().getCity());
			ps.setString(4, client.getAddress().getState().toString());
			ps.setString(5, client.getAddress().getPostalCode());
			ps.setString(6, client.getContact().getLastName());
			ps.setString(7, client.getContact().getFirstName());
			ps.setString(8, client.getContact().getMiddleName());
			ps.executeUpdate();
		}
	}

	/**
	 * Adds the consultant.
	 *
	 * @param consultant
	 *            the consultant
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void addConsultant(Consultant consultant) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try (Connection conn = DriverManager.getConnection(dbUrl, username,
				password);) {
			ps = conn
					.prepareStatement(
							"INSERT INTO CONSULTANTS (LAST_NAME, FIRST_NAME, MIDDLE_NAME) VALUES (?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, consultant.getName().getLastName());
			ps.setString(2, consultant.getName().getFirstName());
			ps.setString(3, consultant.getName().getMiddleName());
			ps.executeUpdate();
		}
	}

	/**
	 * Adds the time card.
	 *
	 * @param timeCard
	 *            the time card
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void addTimeCard(TimeCard timeCard) throws SQLException {
		PreparedStatement psTimeCard = null;
		int conID = 0;
		try (Connection conn = DriverManager.getConnection(dbUrl, username,
				password);) {
			Statement tempStatement = conn.createStatement();
			String query = String.format("SELECT ID " + "FROM CONSULTANTS x "
					+ "WHERE x.last_name='%s'", timeCard.getConsultant()
					.getName().getLastName());
			ResultSet rs = tempStatement.executeQuery(query);
			if (rs.next()) {
				conID = rs.getInt("ID");
				rs.close();
			}
			psTimeCard = conn
					.prepareStatement(
							"INSERT INTO TIMECARDS (CONSULTANT_ID, START_DATE) VALUES(?,?)",
							Statement.RETURN_GENERATED_KEYS);
			psTimeCard.setInt(1, conID);
			psTimeCard.setDate(2, new java.sql.Date(timeCard
					.getWeekStartingDay().getTime()));
			psTimeCard.executeUpdate();
			rs = psTimeCard.getGeneratedKeys();
			if (rs.next()) {
				final int timeCardId = rs.getInt(1);
				psTimeCard.close();
				rs.close();
				final List<ConsultantTime> entries = timeCard
						.getConsultingHours();
				PreparedStatement billableStatement = conn
						.prepareStatement("INSERT INTO BILLABLE_HOURS (CLIENT_ID, TIMECARD_ID, DATE, SKILL, HOURS) "
								+ "VALUES ((SELECT DISTINCT ID "
								+ "FROM CLIENTS "
								+ "WHERE NAME = ?),"
								+ "?,?,?,?)");
				PreparedStatement nonbillableStatement = conn
						.prepareStatement("INSERT INTO NON_BILLABLE_HOURS (ACCOUNT_NAME, TIMECARD_ID, DATE, HOURS) VALUES (?,?,?,?)");
				for (final ConsultantTime entry : entries) {
					if (entry.isBillable()) {
						billableStatement.setString(1, entry.getAccount()
								.getName());
						billableStatement.setInt(2, timeCardId);
						billableStatement.setDate(3, new Date(entry.getDate()
								.getTime()));
						billableStatement.setString(4, entry.getSkill().name());
						billableStatement.setInt(5, entry.getHours());
						billableStatement.executeUpdate();
					} else {
						nonbillableStatement.setString(1, entry.getAccount()
								.getName().toUpperCase().replace(" ", "_"));
						nonbillableStatement.setInt(2, timeCardId);
						nonbillableStatement.setDate(3, new Date(entry
								.getDate().getTime()));
						nonbillableStatement.setInt(4, entry.getHours());
						nonbillableStatement.executeUpdate();
					}
				}
			}
		}
	}

	/**
	 * Gets the consultants.
	 *
	 * @return the consultants
	 * @throws SQLException
	 *             the SQL exception
	 */
	public List<Consultant> getConsultants() throws SQLException {
		List<Consultant> consultants = new ArrayList<Consultant>();
		Statement tempStatement = null;
		try (Connection connection1 = DriverManager.getConnection(dbUrl,
				username, password);) {
			tempStatement = connection1.createStatement();
			String query = String.format("SELECT * FROM CONSULTANTS");
			ResultSet rSet = tempStatement.executeQuery(query);

			while (rSet.next()) {
				Name consultantName = new Name(rSet.getString(1),
						rSet.getString(2), rSet.getString(3));
				Consultant newConsultant = new Consultant(consultantName);
				consultants.add(newConsultant);
			}
		}
		return consultants;
	}

	/**
	 * Gets the clients.
	 *
	 * @return the clients
	 * @throws SQLException
	 *             the SQL exception
	 */
	public List<ClientAccount> getClients() throws SQLException {
		List<ClientAccount> clients = new ArrayList<>();
		Statement tempStatement = null;
		try (Connection conn = DriverManager.getConnection(dbUrl, username,
				password);) {
			tempStatement = conn.createStatement();
			String query = String.format("SELECT * FROM CLIENTS");
			ResultSet rSet = tempStatement.executeQuery(query);

			while (rSet.next()) {
				String clientsName = rSet.getString(2);
				String streetAddy = rSet.getString(3);
				String cityAddy = rSet.getString(4);
				StateCode stateAddy = StateCode.valueOf(rSet.getString(5));
				String postalCodeAddy = rSet.getString(6);
				Name contact = new Name(rSet.getString(7), rSet.getString(8),
						rSet.getString(9));
				Address address = new Address(streetAddy, cityAddy, stateAddy,
						postalCodeAddy);
				ClientAccount account = new ClientAccount(clientsName, contact,
						address);
				clients.add(account);
			}
		}
		return clients;
	}

	/**
	 * Gets the invoice.
	 *
	 * @param client
	 *            the client
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @return the invoice
	 * @throws SQLException
	 *             the SQL exception
	 */
	public Invoice getInvoice(ClientAccount client, int month, int year)
			throws SQLException {
		final Invoice invoice = new Invoice(client, month, year);
		try (Connection connection1 = DriverManager.getConnection(dbUrl,
				username, password);) {
			PreparedStatement ps = connection1
					.prepareStatement("SELECT b.date, c.last_name, c.first_name, c.middle_name, "
							+ "b.skill, s.rate, b.hours FROM billable_hours b, consultants c, skills s, timecards t "
							+ "WHERE b.client_id = (SELECT DISTINCT id FROM clients WHERE name = ?) AND b.skill = s.name "
							+ "AND b.timecard_id = t.id AND c.id = t.consultant_id AND b.date >= ? AND b.date <= ?");

			DateRange dr = new DateRange(month, year);
			ps.setString(1, client.getName());
			ps.setDate(2, new java.sql.Date(dr.getStartDate().getTime()));
			ps.setDate(3, new java.sql.Date(dr.getEndDate().getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				final Date date = rs.getDate(1);
				final String cLastName = rs.getString(2);
				final String cFirstName = rs.getString(3);
				final String cMiddleName = rs.getString(4);
				final Skill cSkill = Skill.valueOf(rs.getString(5));
				final int rate = rs.getInt(6);
				final int hours = rs.getInt(7);
				Name name = new Name(cLastName, cFirstName, cMiddleName);
				Consultant con = new Consultant(name);
				InvoiceLineItem lI = new InvoiceLineItem(date, con, cSkill,
						hours);
				invoice.addLineItem(lI);
			}
		}
		return invoice;
	}
}
