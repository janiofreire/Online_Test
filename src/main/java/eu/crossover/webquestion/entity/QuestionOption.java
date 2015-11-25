package eu.crossover.webquestion.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents the relation between question and option.
 * @author janiofreire
 *
 */
@Entity
@Table(name="question_options")
public class QuestionOption implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Question question;
	@ManyToOne(cascade=CascadeType.ALL)
	private Option options;
	@Column(name="is_correct")
	private Boolean isCorrect;

	public QuestionOption(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Option getOptions() {
		return options;
	}

	public void setOptions(Option options) {
		this.options = options;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
}
