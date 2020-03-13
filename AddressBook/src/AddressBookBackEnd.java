import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class AddressBookBackEnd {

	private static String user = "myuser";
	private static String password = "12345";
	private static String path = "jdbc:mysql://localhost:3306";
	private static String newPath = "jdbc:mysql://localhost:3306/AddressBook_db?useSSL=false";

	AddressBookBackEnd() throws SQLException {
		// Establishing the connection and creating database with two tables (primary
		// and foreign key)
		System.out.println("Establishing connection...");
		Connection database = DriverManager.getConnection(path, user, password);
		System.out.println("Establishing statement...");
		Statement stateMent = database.createStatement();

		// Creating the database in mySQL along with the two tables that will be used
		System.out.println("Creating database...");
		String sqlQuery = "create database if not exists AddressBook_db";
		stateMent.executeUpdate(sqlQuery);
		System.out.println("using AddressBook database...");
		sqlQuery = "use AddressBook_db";
		stateMent.executeUpdate(sqlQuery);
		System.out.println("Creating table people_tb for database...");
		sqlQuery = "create table if not exists people_tb (id int(9) not null auto_increment, firstName varchar(30), secondName varchar(40) not null, primary key(id))";
		stateMent.executeUpdate(sqlQuery);
		System.out.println("Creating table contact_tb for database... with foreign key");
		sqlQuery = "create table if not exists contact_tb (id int (9),secondid int (9) not null, cellphoneNumber int(15) not null, emailaddress varchar(40), primary key(id), foreign key(secondid) references people_tb(id))";
		stateMent.executeUpdate(sqlQuery);
		System.out.println("Generated database called AddressBook_db with people_tb and contact table_tb...");

		String sqlUpdate = ""; 
		sqlUpdate = "insert into people_tb values ('1', 'Peter', 'Johnson')";
		stateMent.executeUpdate(sqlUpdate);
		sqlUpdate = "insert into people_tb values ('2', 'Albert', 'Jones')";
		stateMent.executeUpdate(sqlUpdate);
		sqlUpdate = "insert into people_tb values ('3', 'John', 'Williams')";
		stateMent.executeUpdate(sqlUpdate);

		sqlUpdate = "insert into contact_tb values('1', '1', '0867362512', 'Peter@gmail.com')";
		stateMent.executeUpdate(sqlUpdate);
		sqlUpdate = "insert into contact_tb values('2', '1', '0213647829', 'PeterJohnson@company.com')";
		stateMent.executeUpdate(sqlUpdate);

		sqlUpdate = "insert into contact_tb values('3', '2', '0793782812', 'Albert@gmail.com')";
		stateMent.executeUpdate(sqlUpdate);
		sqlUpdate = "insert into contact_tb values('4', '2', '0216573828', 'AlbertJones@company.com')";
		stateMent.executeUpdate(sqlUpdate);
		sqlUpdate = "insert into contact_tb values('5', '2', '0846123784', ' ')";
		stateMent.executeUpdate(sqlUpdate);

		System.out.println("Inserted succesfully...");
	}

	/**
	 * @return list of the all the entries in the database (user first and second
	 *         name)
	 * @throws SQLException
	 */
	public static DefaultListModel<String> viewAll() throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		DefaultListModel<String> listOfPeople = new DefaultListModel<String>();
		String sqlSelect = "select * from people_tb";
		System.out.println("Your Query: " + sqlSelect);
		ResultSet rset = stateMent.executeQuery(sqlSelect);

		while (rset.next()) {

			String str = rset.getInt("id") + " - " + rset.getString("firstName") + " - " + rset.getString("secondName");
			listOfPeople.addElement(str);

		}

		return listOfPeople;

	}

	/**
	 * Selects the current contact details and fills the text boxes with the
	 * information
	 * 
	 * @param parseInt - selects contact based on id
	 * @return list of all entries in the database
	 * @throws SQLException
	 */
	public static DefaultListModel<String> selectContact(int parseInt) throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		DefaultListModel<String> listOfContacts = new DefaultListModel<String>();
		String sqlSelect = "select * from contact_tb where secondid = " + parseInt;
		System.out.println("Your Query: " + sqlSelect);
		ResultSet rset = stateMent.executeQuery(sqlSelect);

		while (rset.next()) {

			String str = rset.getInt("id") + " - " + rset.getInt("secondid") + " - " + rset.getString("cellphoneNumber")
					+ " - " + rset.getString("emailaddress");
			listOfContacts.addElement(str);

		}

		return listOfContacts;

	}

	/**
	 * Similar to previous method but changed to work with the administrator page
	 * 
	 * @param parseInt - selects contact based on id
	 * @return list of entries in the database
	 * @throws SQLException
	 */
	public static DefaultListModel<String> selectContactAdministrator(int parseInt) throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		DefaultListModel<String> listOfContacts = new DefaultListModel<String>();
		String sqlSelect = "select * from contact_tb where secondid = " + parseInt;
		System.out.println("Your Query: " + sqlSelect);
		ResultSet rset = stateMent.executeQuery(sqlSelect);

		while (rset.next()) {

			String str = rset.getInt("id") + " - " + rset.getInt("secondid") + " - " + rset.getString("cellphoneNumber")
					+ " - " + rset.getString("emailaddress");
			listOfContacts.addElement(str);

		}

		return listOfContacts;

	}

	/**
	 * Method that adds an additional contact to the database
	 * 
	 * @param id         - id of the individual
	 * @param firstName
	 * @param secondName
	 * @throws SQLException
	 */
	public static void add(int id, String firstName, String secondName) throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database.prepareStatement("insert into people_tb values (?,?,?)");
		prepareStatement.setInt(1, id);
		prepareStatement.setString(2, firstName);
		prepareStatement.setString(3, secondName);
		prepareStatement.executeUpdate();
		System.out.println(prepareStatement + " Has been inserted into people_tb successfully.\n");
	}

	/**
	 * After selecting the user, this method will add a contact under their code
	 * 
	 * @param id
	 * @param secondid       - second id to keep track on the contacts separately
	 * @param contactDetails
	 * @param emailAddress
	 * @throws SQLException
	 */
	public static void addContact(int id, int secondid, int contactDetails, String emailAddress) throws SQLException {

		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database.prepareStatement("insert into contact_tb values (?,?,?,?)");
		prepareStatement.setInt(1, secondid);
		prepareStatement.setInt(2, id);
		prepareStatement.setInt(3, contactDetails);
		prepareStatement.setString(4, emailAddress);
		prepareStatement.executeUpdate();
		System.out.println(prepareStatement + " Has been inserted into contact_tb successfully.\n");

	}

	/**
	 * This method updates the user's first and second name
	 * 
	 * @param firstName
	 * @param secondName
	 * @param id
	 * @throws SQLException
	 */
	public static void updateUser(String firstName, String secondName, int id) throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database
				.prepareStatement("update people_tb set firstName = ?, secondName = ? where id = ?");

		prepareStatement.setString(1, firstName);
		prepareStatement.setString(2, secondName);
		prepareStatement.setInt(3, id);
		prepareStatement.executeUpdate();

	}

	/**
	 * This method updates the contact details
	 * 
	 * @param id
	 * @param secondid
	 * @param cellphoneNumber
	 * @param emailAddress
	 * @param id2
	 * @throws SQLException
	 */
	public static void updateContact(int id, int secondid, int cellphoneNumber, String emailAddress, int id2)
			throws SQLException {
		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database.prepareStatement(
				"update contact_tb set id = ?, secondid = ?, cellphoneNumber = ?, emailaddress = ? where id = ?  ");
		prepareStatement.setInt(1, id);
		prepareStatement.setInt(2, secondid);
		prepareStatement.setInt(3, cellphoneNumber);
		prepareStatement.setString(4, emailAddress);
		prepareStatement.setInt(5, id2);

		prepareStatement.executeUpdate();

	}

	/**
	 * This method deletes a user but not their contact details, wont be able to
	 * delete user without first deleting their contact details
	 * 
	 * @param id
	 * @param firstName
	 * @param secondName
	 * @throws SQLException
	 */
	public static void delete(int id, String firstName, String secondName) throws SQLException {

		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database
				.prepareStatement("delete from people_tb where id = ? and firstName = ? and secondName = ? ");
		prepareStatement.setInt(1, id);
		prepareStatement.setString(2, firstName);
		prepareStatement.setString(3, secondName);

		prepareStatement.executeUpdate();
	}

	/**
	 * This method deletes the current select contact details
	 * 
	 * @param id
	 * @param secondid
	 * @param contactDetails
	 * @param emailAddress
	 * @throws SQLException
	 */
	public static void deleteContact(int id, int secondid, int contactDetails, String emailAddress)
			throws SQLException {

		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		PreparedStatement prepareStatement = database.prepareStatement(
				"delete from contact_tb where id = ? and secondid = ? and cellphoneNumber = ? and emailaddress = ? ");
		prepareStatement.setInt(1, id);
		prepareStatement.setInt(2, secondid);
		prepareStatement.setInt(3, contactDetails);
		prepareStatement.setString(4, emailAddress);

		prepareStatement.executeUpdate();
	}

	/**
	 * This method searches for an individual, based on their first name - can be
	 * changed to search for the user id or surname, depending on user requirements
	 * 
	 * @param firstName
	 * @return
	 * @throws SQLException
	 */
	public static DefaultListModel<String> search(String firstName) throws SQLException {

		Connection database = DriverManager.getConnection(newPath, user, password);
		Statement stateMent = database.createStatement();
		DefaultListModel<String> listOfPeople = new DefaultListModel<String>();
		PreparedStatement prepareStatement = database.prepareStatement("select * from people_tb where firstName = ? ");
		System.out.println("Selecting from people...");
		prepareStatement.setString(1, firstName);

		ResultSet rset = prepareStatement.executeQuery();

		while (rset.next()) {

			String str = rset.getInt("id") + " - " + rset.getString("firstName") + " - " + rset.getString("secondName");
			listOfPeople.addElement(str);

		}
		System.out.println("Selected...");
		return listOfPeople;

	}

}
