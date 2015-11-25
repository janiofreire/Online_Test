package eu.crossover.webquestion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Class that represents a relation between user and test.
 * @author janiofreire
 *
 */
@Entity
@Table(name="user_test")
public class UserTest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Test test;
	@OneToMany
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinTable(name="user_answer", joinColumns={@JoinColumn(name="user_test_id",referencedColumnName="id")})
	private List<UserAnswer> userAnswers;
	
	public UserTest(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}

	public List<UserAnswer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(List<UserAnswer> userQuestions) {
		this.userAnswers = userQuestions;
	}
	
}
