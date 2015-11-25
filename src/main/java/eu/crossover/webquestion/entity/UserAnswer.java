package eu.crossover.webquestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class the represents a choice for a {@code Option}, made by the user. 
 * @author janiofreire
 *
 */
@Entity
@Table(name="user_answer")
public class UserAnswer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne
	@JoinColumn(name="user_test_id")
	private UserTest userTest;
	@OneToOne
	@JoinTable(name="test_question_options",joinColumns={@JoinColumn(name="test_question_options_id")},inverseJoinColumns={@JoinColumn(name="question_options_id")})
	private QuestionOption questionOption;
	@Column(name="is_correct")
	private Boolean iscorrect;
	
	public UserTest getUserTest() {
		return userTest;
	}
	public void setUserTest(UserTest userTest) {
		this.userTest = userTest;
	}
	public QuestionOption getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(QuestionOption questionOption) {
		this.questionOption = questionOption;
	}
	public Boolean isIscorrect() {
		return iscorrect;
	}
	public void setIscorrect(Boolean iscorrect) {
		this.iscorrect = iscorrect;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof UserAnswer){
			UserAnswer userAnswer = (UserAnswer) obj;
			return userAnswer.getId() == this.getId();
		}
		return false;
	}	
}
