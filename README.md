# AddressBook
AddressBook database using mysql and java - User can Create, Update, Delete and Search for contacts and add contact details for each user. 

Welcome to the AddressBook! 

- There are two pages, one for the user and one for the administrator. 
- The user page shows the current contact list with each person's contact details. 
- To switch between the two pages, click 'Administrator' at the top right or 'User' 
- The database runs on mysql, please change the user name and password (at the top of the AddressBookBackEnd) to your localhost username and password.
- If you run the application the first time examples are inputted into the database, delete or comment out the part where the insertions are made into the database (AddressBookBackEnd)

User page:
- Show List will display all the contacts in your address book 
- Click on the user and click on Select User 
- The user's name and contact details will appear 
- To search for a user, type in their first name and click search 


Administrator page: 

Adding a new contact: 
- Select clear All
- Select Show List 
- Input first name, second name and a unique id that is not in the list 
- Select Add User 
- To refresh Click Show List 

Update Existing user: 
- Select Clear All 
- Select Show List 
- Change the person's first name or second name and click update contact
- Select Show List and the person's details will be updated 

Deleting a user: 
- A User cannot be deleted if he/she has contact details, please delete them first. 
- Select clear All 
- Select Show List 
- Click on User and click Select User
- Click Delete User 
- Click Show List and user will be deleted 

Deleting a contact from a user: 
- Select Clear All 
- Select Show List 
- Click on User and click Select User 
- Click on the contact details you want to delete and click Select Contact 
- Click on Delete Contact 
- Click Show list, select your user and click Select user. Those contact details will be deleted 

Adding a contact for a user: 
- Click on the user and select Select User 
- Input the details for the cellphone number and email address along with a unique contact id 
- The first user will have a contact ID from 1 - 5, for 5 different contact entries 
- The second user will have different contact ID from 6 - 10, for 5 different contact entries 
- The third user will have different contact ID from 11 - 15, for 5 different contact entries and so on 
- After the details have been inputted Click Add Contact 
- To refresh click Show List, select user and the new contact details will appear

Updating a contact for a user: 
- Click on the user and Select Select User 
- Making changes to the email address or to the cellphone number 
- Click Update Contact 
- To refresh click on show List, select the user and click on Select User  and the new contact details will be updated

Searching for a user: 
- Only available on the user page and not on the administrator page 
- Input a Name and select search, the search function only searches first names and is case sensitive.






