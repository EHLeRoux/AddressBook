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

public class AdministratorFrontEnd {

	private int width = 900;
	private int height = 800;
	static int userID = 0;

	AdministratorFrontEnd() {

		// Creating of frame and setting background color
		JFrame addressBookFrontEndAdministrator = new JFrame();
		addressBookFrontEndAdministrator.getContentPane().setBackground(Color.DARK_GRAY);

		// Creating of buttons on user interface
		JButton showContactList = new JButton("Show List");
		JButton selectContact = new JButton("Select User");
		JButton selectContactDetails = new JButton("Select Contact");
		JButton changeToUser = new JButton("User");
		JButton update = new JButton("Update User");
		JButton updateContact = new JButton("Update contact");
		JButton delete = new JButton("Delete User");
		JButton deleteContact = new JButton("Delete Contact");
		JButton search = new JButton("Search");
		JButton add = new JButton("Add User");
		JButton addContact = new JButton("Add Contact");
		JButton clearAll = new JButton("Clear All");

		// Creating of Labels
		JLabel firstName = new JLabel("First Name");
		JLabel secondName = new JLabel("Second Name");
		JLabel contactDetails = new JLabel("Cell Phone Num");
		JLabel emailAddress = new JLabel("Email Address");
		JLabel contactID = new JLabel("Contact ID");
		JLabel addressBookAdminHeading = new JLabel ("Administrator");

		JLabel personHeading = new JLabel("Person");
		JLabel contactDetailsHeading = new JLabel("Contact Details");

		JLabel personID = new JLabel("ID Number");

		// Creating of textfields
		JTextField firstNameText = new JTextField();
		JTextField secondNameText = new JTextField();
		JTextField contactDetailText = new JTextField();
		JTextField emailAddressText = new JTextField();
		JTextField idText = new JTextField();
		JTextField contactIdText = new JTextField();

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
		listOfContactsPane.setBounds(500, 200, 350, 200);
		subContactsPane.setBounds(500, 500, 350, 200);

		// Buttons
		showContactList.setBounds(25, 550, 125, 45);
		selectContact.setBounds(300, 550, 125, 45);
		selectContactDetails.setBounds(165, 550, 125, 45);
		changeToUser.setBounds(725, 100, 125, 45);
		updateContact.setBounds(25, 650, 125, 45);
		update.setBounds(25, 600, 125, 45);
		delete.setBounds(300, 600, 125, 45);
		deleteContact.setBounds(300, 650, 125, 45);
		search.setBounds(325, 550, 125, 45);
		add.setBounds(165, 600, 125, 45);
		addContact.setBounds(165, 650, 125, 45);
		clearAll.setBounds(500, 100, 125, 45);

		// Labels
		firstName.setBounds(25, 100, 100, 50);
		secondName.setBounds(25, 175, 100, 50);
		contactDetails.setBounds(25, 250, 100, 50);
		emailAddress.setBounds(25, 325, 100, 50);
		personID.setBounds(25, 400, 100, 50);
		contactID.setBounds(25, 475, 100, 50);
		personHeading.setBounds(500, 135, 100, 50);
		contactDetailsHeading.setBounds(500, 350, 300, 200);
		addressBookAdminHeading.setBounds(315, -50, 300, 200);

		// Text Field
		firstNameText.setBounds(150, 100, 300, 50);
		secondNameText.setBounds(150, 175, 300, 50);
		contactDetailText.setBounds(150, 250, 300, 50);
		emailAddressText.setBounds(150, 325, 300, 50);
		idText.setBounds(150, 400, 300, 50);
		contactIdText.setBounds(150, 475, 300, 50);

		// Setting colors of labels
		firstName.setForeground(Color.white);
		secondName.setForeground(Color.white);
		contactID.setForeground(Color.white);
		contactDetails.setForeground(Color.white);
		personID.setForeground(Color.white);
		emailAddress.setForeground(Color.white);
		personHeading.setForeground(Color.white);
		addressBookAdminHeading.setForeground(Color.white);
		contactDetailsHeading.setForeground(Color.white);
		addressBookAdminHeading.setFont(new Font("Serif", Font.BOLD, 40));
		personHeading.setFont(new Font("Serif", Font.BOLD, 25));
		contactDetailsHeading.setFont(new Font("Serif", Font.BOLD, 25));

		// Adding the separate buttons and labels to the frame
		addressBookFrontEndAdministrator.add(showContactList);
		addressBookFrontEndAdministrator.add(selectContact);
		addressBookFrontEndAdministrator.add(selectContactDetails);
		addressBookFrontEndAdministrator.add(changeToUser);
		addressBookFrontEndAdministrator.add(listOfContactsPane);
		addressBookFrontEndAdministrator.add(subContactsPane);
		addressBookFrontEndAdministrator.add(firstName);
		addressBookFrontEndAdministrator.add(secondName);
		addressBookFrontEndAdministrator.add(addContact);

		//Text fields and labels
		addressBookFrontEndAdministrator.add(contactID);
		addressBookFrontEndAdministrator.add(contactDetails);
		addressBookFrontEndAdministrator.add(personID);
		addressBookFrontEndAdministrator.add(emailAddress);
		addressBookFrontEndAdministrator.add(firstNameText);
		addressBookFrontEndAdministrator.add(secondNameText);
		addressBookFrontEndAdministrator.add(contactDetailText);
		addressBookFrontEndAdministrator.add(idText);
		addressBookFrontEndAdministrator.add(emailAddressText);
		addressBookFrontEndAdministrator.add(contactIdText);
		addressBookFrontEndAdministrator.add(addressBookAdminHeading);

		//headings
		addressBookFrontEndAdministrator.add(personHeading);
		addressBookFrontEndAdministrator.add(contactDetailsHeading);

		//buttons
		addressBookFrontEndAdministrator.add(update);
		addressBookFrontEndAdministrator.add(updateContact);
		addressBookFrontEndAdministrator.add(delete);
		addressBookFrontEndAdministrator.add(deleteContact);
		addressBookFrontEndAdministrator.add(add);
		addressBookFrontEndAdministrator.add(clearAll);
		
		

		// Initialization of the main frame and displaying of interface
		addressBookFrontEndAdministrator.setSize(width, height);
		addressBookFrontEndAdministrator.setLayout(null);
		addressBookFrontEndAdministrator.setVisible(true);
		addressBookFrontEndAdministrator.setLocationRelativeTo(null);
		addressBookFrontEndAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Changing from the user front end to the administrator - CRUD
		// Administrator Button
		changeToUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addressBookFrontEndAdministrator.setVisible(false);
				AddressBookFrontEnd frontend = new AddressBookFrontEnd();
			}

		});
		//Clears the current text inputted in the text fields
		clearAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				firstNameText.setText("");
				secondNameText.setText("");
				contactDetailText.setText("");
				emailAddressText.setText("");
				idText.setText("");
				contactIdText.setText("");

			}

		});

		// Sets the Jlist pane model equal to the string output of the mySQL database
		// and prints it out to the area
		showContactList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					listOfContactsFromModel.setModel(AddressBookBackEnd.viewAll());
				} catch (Exception exception) {

					exception.printStackTrace();
				}
			}
		});

		// Selects contact and displays the information in the textfields
		selectContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listOfContactsFromModel.getSelectedValue() != null) {

					String selected = listOfContactsFromModel.getSelectedValue();
					String[] stringArray = new String[selected.length()];
					stringArray = selected.split(" - ");
					firstNameText.setText(stringArray[1]);
					secondNameText.setText(stringArray[2]);
					idText.setText(stringArray[0]);
					userID = Integer.parseInt(stringArray[0]);
					try {
						subContactsListFromModel
								.setModel(AddressBookBackEnd.selectContact(Integer.parseInt(stringArray[0])));
					} catch (Exception exception) {
						exception.printStackTrace();
					}

				}

			}
		});

		//Selects contact details and displays them on the text fields
		selectContactDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (subContactsListFromModel.getSelectedValue() != null) {
					String selected = subContactsListFromModel.getSelectedValue();
					String[] stringArray2 = new String[selected.length()];
					stringArray2 = selected.split(" - ");
					idText.setText(stringArray2[0]);
					contactIdText.setText(stringArray2[1]);
					contactDetailText.setText(stringArray2[2]);
					emailAddressText.setText(stringArray2[3]);

					try {
						subContactsListFromModel.setModel(AddressBookBackEnd.selectContactAdministrator(userID));
					} catch (Exception exception) {
						exception.printStackTrace();
					}

				}

			}
		});

		// Adding a new user to the address book
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int idConvertToInt = Integer.parseInt(idText.getText());
					AddressBookBackEnd.add(idConvertToInt, firstNameText.getText(), secondNameText.getText());
				} catch (Exception exception) {
					exception.printStackTrace();
				}

			}
		});

		//After adding a new contact user can add contact details under that user's name and id
		addContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AddressBookBackEnd.addContact(Integer.parseInt(idText.getText()),
							Integer.parseInt(contactIdText.getText()), Integer.parseInt(contactDetailText.getText()),
							emailAddressText.getText());
				} catch (Exception exception) {
					exception.printStackTrace();
				}

			}
		});

		//This updates the current user's first name and second name
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					AddressBookBackEnd.updateUser(firstNameText.getText(), secondNameText.getText(),
							Integer.parseInt(idText.getText()));

				} catch (Exception exception) {
					exception.printStackTrace();
				}

			}
		});

		// This updates the user's contact details
		updateContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String email = emailAddressText.getText();
					AddressBookBackEnd.updateContact(Integer.parseInt(idText.getText()),
							Integer.parseInt(contactIdText.getText()), Integer.parseInt(contactDetailText.getText()),
							email, Integer.parseInt(idText.getText()));

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});

		//Deletes the current selected user, can only be used when the contact details are also deleted first
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AddressBookBackEnd.delete(Integer.parseInt(idText.getText()), firstNameText.getText(),
							secondNameText.getText());

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});

		//Deletes a contact details for the user
		deleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AddressBookBackEnd.deleteContact(Integer.parseInt(idText.getText()),
							Integer.parseInt(contactIdText.getText()), Integer.parseInt(contactDetailText.getText()),
							emailAddressText.getText());

				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});

	}
}
