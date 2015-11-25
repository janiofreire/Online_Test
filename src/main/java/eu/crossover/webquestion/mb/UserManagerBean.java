package eu.crossover.webquestion.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DataAccessException;

import eu.crossover.webquestion.entity.User;
import eu.crossover.webquestion.facade.UserFacade;

@ManagedBean(name="userMB")
@SessionScoped
public class UserManagerBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{UserFacade}")
	private UserFacade userFacade;
	private String name;
	private String password;
	@ManagedProperty(value="#{UserAplication}")
	private User user;
	
	/**
     * Verify if the input name and password have a user in the system.
     * 
     * @return String - Response Message
     */
    public String loginUser() {
        try {
            User localUser = userFacade.getUser(getName(),getPassword());
            if(localUser!=null && localUser.getId()>0){
            	user.setId(localUser.getId());
            	return "SUCCESS";
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
         
        return "ERROR";
    }

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
