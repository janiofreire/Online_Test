package eu.crossover.webquestion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class that represents a option of a question.
 * @author janiofreire
 *
 */
@Entity
@Table(name="options")
public class Option implements Serializable{
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
	
	public Option() {
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
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Option){
			return ((Option)obj).getId() == this.getId();
		}
		return false;
	}
	
}
