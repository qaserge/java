package ca.sergei.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserController {

	private List<User> users;
	private UserDbUtil userDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());

	// 1- Add theSearchName attribute -----------------------------------------------
	private String theSearchName;
	// ------------------------------------------------------------------------------

	// 2- theSearchName getter and setter -------------------------------------------
	public String getTheSearchName() {
		return theSearchName;
	}

	public void setTheSearchName(String theSearchName) {
		this.theSearchName = theSearchName;
	}
	// ------------------------------------------------------------------------------

	public List<User> getUsers() {
		return users;
	}

	public UserController() throws Exception {
		users = new ArrayList<>();

		userDbUtil = UserDbUtil.getInstance();
	}

	// 3- Add logic to loadUsers() method which will be called when page is reloaded
	// ------------------------------------------------------------------------------
	public void loadUsers() {

		logger.info("Loading users");
		logger.info("theSearchName = " + theSearchName);

		try {

			// ------------------------------------------------------------------------------
			if (theSearchName != null && theSearchName.trim().length() > 0) {
				// Search for user by name
				users = userDbUtil.searchUsers(theSearchName);
			}
			// ------------------------------------------------------------------------------

			else {
				// Get all Users from database
				users = userDbUtil.getUsers();
			}

		} catch (Exception exc) {
			// Send this to server logs
			logger.log(Level.SEVERE, "Error loading Users", exc);

			// Add error message for JSF page
			addErrorMessage(exc);
		} finally {
			// Reset the search info
			theSearchName = null;
		}
	}
	// ------------------------------------------------------------------------------

	public String addUser(User theUser) {

		logger.info("Adding User: " + theUser);

		try {

			// add User to the database
			userDbUtil.addUser(theUser);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding Users", exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "userList?faces-redirect=true";
	}

	public String loadUser(int userId) {

		logger.info("loading user: " + userId);

		try {
			// get user from database
			User theUser = userDbUtil.getUser(userId);

			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("user", theUser);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading user id:" + userId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "userUpdate.xhtml";
	}

	public String updateUser(User theUser) {

		logger.info("updating User: " + theUser);

		try {

			// update User in the database
			userDbUtil.updateUser(theUser);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating User: " + theUser, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "userList?faces-redirect=true";
	}

	public String deleteUser(int userId) {

		logger.info("Deleting user id: " + userId);

		try {

			// delete the user from the database
			userDbUtil.deleteUser(userId);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting user id: " + userId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "userList";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
