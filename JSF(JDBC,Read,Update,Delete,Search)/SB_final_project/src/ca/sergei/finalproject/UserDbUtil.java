package ca.sergei.finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDbUtil {

	private static UserDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/sbfp";

	public static UserDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new UserDbUtil();
		}

		return instance;
	}

	private UserDbUtil() throws Exception {
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();

		DataSource theDataSource = (DataSource) context.lookup(jndiName);

		return theDataSource;
	}

	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();

		return theConn;
	}

	private void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}

	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<User> getUsers() throws Exception {

		List<User> users = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = getConnection();

			String sql = "select * from users order by id desc";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String phone = myRs.getString("phone");
				String address = myRs.getString("address");
				String email = myRs.getString("email");
				String username = myRs.getString("username");
				String password = myRs.getString("password");				
				String receiving = myRs.getString("receiving");
				String profileType = myRs.getString("profileType");		


				// create new User object
				User tempUser = new User(id, firstName, lastName, phone, address, email, username, password, receiving, profileType);

				// add it to the list of Users
				users.add(tempUser);
			}

			return users;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public User getUser(int userId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = getConnection();

			String sql = "select * from users where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, userId);

			myRs = myStmt.executeQuery();

			User theUser = null;

			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String phone = myRs.getString("phone");
				String address = myRs.getString("address");
				String email = myRs.getString("email");
				String username = myRs.getString("username");
				String password = myRs.getString("password");	
				String receiving = myRs.getString("receiving");	
				String profileType = myRs.getString("profileType");	

				theUser = new User(id, firstName, lastName, phone, address, email, username, password, receiving, profileType);
			} else {
				throw new Exception("Could not find user id: " + userId);
			}

			return theUser;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	public void addUser(User theUser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "insert into users (first_name, last_name, phone, address, email, username, password, receiving, profileType) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getPhone());
			myStmt.setString(4, theUser.getAddress());
			myStmt.setString(5, theUser.getEmail());
			myStmt.setString(6, theUser.getUsername());
			myStmt.setString(7, theUser.getPassword());
			myStmt.setString(8, theUser.getReceiving());
			myStmt.setString(9, theUser.getProfileType());

			myStmt.execute();
		} finally {
			close(myConn, myStmt);
		}

	}

	public void updateUser(User theUser) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "update users " + " set first_name=?, last_name=?, phone=?, address=?, email=?, username=?, password=?, receiving=?, profileType=?" + " where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theUser.getFirstName());
			myStmt.setString(2, theUser.getLastName());
			myStmt.setString(3, theUser.getPhone());
			myStmt.setString(4, theUser.getAddress());
			myStmt.setString(5, theUser.getEmail());
			myStmt.setString(6, theUser.getUsername());
			myStmt.setString(7, theUser.getPassword());
			myStmt.setString(8, theUser.getReceiving());
			myStmt.setString(9, theUser.getProfileType());
			myStmt.setInt(10, theUser.getId());

			myStmt.execute();
		} finally {
			close(myConn, myStmt);
		}

	}

	public void deleteUser(int userId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from users where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, userId);

			myStmt.execute();
		} finally {
			close(myConn, myStmt);
		}
	}

	// Search method ----------------------------------------------------------------
	public List<User> searchUsers(String theSearchName) throws Exception {

		// 1- Result list
		List<User> users = new ArrayList<>();

		// 2- Clean attributes
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
//		int userId;

		try {

			// 3- Get connection to database
			myConn = dataSource.getConnection();

			// 4- Only search by name if theSearchName is not empty
			if (theSearchName != null && theSearchName.trim().length() > 0) {

				// 5- Create sql to search for users by name
				String sql = "select * from users where lower(first_name) like ? or lower(last_name) like ? or lower(phone) like ? or lower(address) like ? or lower(email) like ? or lower(username) like ? or lower(receiving) like ? or lower(profileType) like ?";


				// 6- Create prepared statement
				myStmt = myConn.prepareStatement(sql);

				// 7- Set params
				String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
				myStmt.setString(1, theSearchNameLike);
				myStmt.setString(2, theSearchNameLike);
				myStmt.setString(3, theSearchNameLike);
				myStmt.setString(4, theSearchNameLike);
				myStmt.setString(5, theSearchNameLike);
				myStmt.setString(6, theSearchNameLike);
				myStmt.setString(7, theSearchNameLike);
				myStmt.setString(8, theSearchNameLike);

			} else {
				// 8- Create sql to get all users
				String sql = "select * from users order by last_name";

				// 9- Create prepared statement
				myStmt = myConn.prepareStatement(sql);
			}

			// 10- Execute statement
			myRs = myStmt.executeQuery();

			// 11- Retrieve data from result set row
			while (myRs.next()) {

				// 12- Retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String phone = myRs.getString("phone");
				String address = myRs.getString("address");
				String email = myRs.getString("email");
				String username = myRs.getString("username");
				String password = myRs.getString("password");	
				String receiving = myRs.getString("receiving");
				String profileType = myRs.getString("profileType");					

				// 13- Create new user object
				User tempUser = new User(id, firstName, lastName, phone, address, email, username, password, receiving, profileType);

				// 14- Add it to the list of Users
				users.add(tempUser);
			}

			return users;
		} finally {

			// 15- Clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}
	// ------------------------------------------------------------------------------

}
