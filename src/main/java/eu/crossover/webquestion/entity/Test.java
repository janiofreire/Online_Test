package eu.crossover.webquestion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Class that represents a test.
 * @author janiofreire
 *
 */
@Entity(name="test")
public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="description")
	private String description;
	@Column(name="time")
	private int time;
	@ManyToMany
	@JoinTable(name="test_question_options",joinColumns={@JoinColumn(name="test_id")},inverseJoinColumns={@JoinColumn(name="question_options_id")})
	private List<QuestionOption> questionsOptions;
	
	public Test(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<QuestionOption> getQuestionsOptions() {
		return questionsOptions;
	}
	public void setQuestionsOptions(List<QuestionOption> questions) {
		this.questionsOptions = questions;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
