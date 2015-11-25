package eu.crossover.webquestion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class that represents a question.
 * @author janiofreire
 *
 */
@Entity
@Table(name="question")
public class Question implements Serializable{
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
	@ManyToMany/*(fetch=FetchType.EAGER)*/
	@JoinTable(name="question_options",joinColumns={@JoinColumn(name="question_id")},inverseJoinColumns={@JoinColumn(name="options_id")})
	private List<Option> options;
	
	public Question() {
	}

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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Question){
			
			return((Question) obj).getId() == this.getId(); 
		}
		
		return false;
	}
	
}
