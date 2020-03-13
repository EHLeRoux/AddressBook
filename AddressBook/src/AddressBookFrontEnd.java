import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AddressBookFrontEnd {

	private int width = 900;
	private int height = 800;

	AddressBookFrontEnd() {

		// Creating of frame and setting background color
		JFrame addressBookFrontEnd = new JFrame();
		addressBookFrontEnd.getContentPane().setBackground(Color.DARK_GRAY);

		try {
			AddressBookBackEnd backEnd = new AddressBookBackEnd();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Creating of buttons on user interface
		JButton showContactList = new JButton("Show List");
		JButton selectContact = new JButton("Select User");
		JButton changeToAdministrator = new JButton("Administrator");
		JButton searchForUser = new JButton("Search User");

		// Creating of Labels
		JLabel firstName = new JLabel("First Name");
		JLabel secondName = new JLabel("Second Name");
		JLabel addressBookHeading = new JLabel("Address Book");
		JLabel contactDetails = new JLabel("Contact Details");
		JLabel personID = new JLabel("Person");

		// Creating of textfields
		JTextField firstNameText = new JTextField();
		JTextField secondNameText = new JTextField();

		// Creating the display where contacts will be shown and listModel where
		// contacts will appear
		JScrollPane listOfContactsPane = new JScrollPane();
		DefaultListModel<String> listOfContacts = new DefaultListModel<String>();
		JList<String> listOfContactsFromModel = new JList<String>(listOfContacts);
		listOfContactsPane.setViewportView(listOfContactsFromModel);

		// Creating of the sub-display where the contact details will be shown of the
		// people
		JScrollPane subContactsPane = new JScrollPane();
		DefaultListModel<String> subContactsDetails = new DefaultListModel<String>();
		JList<String> subContactsListFromModel = new JList<String>(subContactsDetails);
		subContactsPane.setViewportView(subContactsListFromModel);

		// Creating the sizes of buttons, labels and user interface
		// ScrollPanes
		listOfContactsPane.setBounds(20, 250, 400, 475);
		subContactsPane.setBounds(450, 500, 400, 225);

		// Buttons
		showContactList.setBounds(25, 100, 125, 45);
		selectContact.setBounds(325, 100, 125, 45);
		changeToAdministrator.setBounds(725, 100, 125, 45);
		searchForUser.setBounds(175, 100, 125, 45);

		// Labels
		firstName.setBounds(450, 250, 100, 50);
		secondName.setBounds(450, 335, 100, 50);
		addressBookHeading.setBounds(315, 0, 350, 100);
		contactDetails.setBounds(450, 400, 350, 100);
		personID.setBounds(25, 150, 350, 100);

		// Text Field
		firstNameText.setBounds(550, 250, 300, 50);
		secondNameText.setBounds(550, 335, 300, 50);

		// Setting colors of labels
		firstName.setForeground(Color.white);
		secondName.setForeground(Color.white);
		addressBookHeading.setForeground(Color.white);
		contactDetails.setForeground(Color.white);
		personID.setForeground(Color.white);
		addressBookHeading.setFont(new Font("Serif", Font.BOLD, 40));
		contactDetails.setFont(new Font("Serif", Font.BOLD, 25));
		personID.setFont(new Font("Serif", Font.BOLD, 25));

		// Adding the separate buttons to the frame
		addressBookFrontEnd.add(showContactList);
		addressBookFrontEnd.add(selectContact);
		addressBookFrontEnd.add(changeToAdministrator);
		addressBookFrontEnd.add(listOfContactsPane);
		addressBookFrontEnd.add(subContactsPane);
		addressBookFrontEnd.add(firstName);
		addressBookFrontEnd.add(secondName);
		addressBookFrontEnd.add(firstNameText);
		addressBookFrontEnd.add(secondNameText);
		addressBookFrontEnd.add(addressBookHeading);
		addressBookFrontEnd.add(contactDetails);
		addressBookFrontEnd.add(personID);
		addressBookFrontEnd.add(searchForUser);

		// Initialization of the main frame and displaying of interface
		addressBookFrontEnd.setSize(width, height);
		addressBookFrontEnd.setLayout(null);
		addressBookFrontEnd.setVisible(true);
		addressBookFrontEnd.setLocationRelativeTo(null);
		addressBookFrontEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Changing from the user front end to the administrator - CRUD
		// Administrator Button
		changeToAdministrator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addressBookFrontEnd.setVisible(false);
				AdministratorFrontEnd userInterface = new AdministratorFrontEnd();
			}

		});

		// Show contact list Button
		// Views all the people in your address book
		showContactList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					listOfContactsFromModel.setModel(AddressBookBackEnd.viewAll());
				} catch (Exception exception) {

					exception.printStackTrace();
				}
			}
		});

		// Select contact and displays in the information in the text boxes
		selectContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listOfContactsFromModel.getSelectedValue() != null) {
					String selected = listOfContactsFromModel.getSelectedValue();
					String[] stringArray = new String[selected.length()];
					stringArray = selected.split(" - ");
					firstNameText.setText(stringArray[1]);
					secondNameText.setText(stringArray[2]);

					try {
						subContactsListFromModel
								.setModel(AddressBookBackEnd.selectContact(Integer.parseInt(stringArray[0])));
					} catch (Exception exception) {
						exception.printStackTrace();
					}

				}

			}
		});
		// Searches for the user, only used the first name as a searching function - can
		// update it to surname or id for user requirements
		searchForUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					listOfContactsFromModel.setModel(AddressBookBackEnd.search(firstNameText.getText()));
				} catch (Exception exception) {

					exception.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		AddressBookFrontEnd mainScreenAddress = new AddressBookFrontEnd();
	}
}
