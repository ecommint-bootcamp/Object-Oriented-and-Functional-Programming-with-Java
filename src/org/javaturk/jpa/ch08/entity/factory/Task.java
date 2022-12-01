
package org.javaturk.jpa.ch08.entity.factory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Task")
@Table(name="QTask")
public class Task {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@ManyToOne
	private Project project;
	
	@ManyToOne
	private Employee responsible;
	
	public Task() {
	}

	public Task(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Employee getResposible() {
		return responsible;
	}

	public void setResponsible(Employee employee) {
		this.responsible = employee;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", project=" + project + ", responsible=" + responsible + "]";
	}
}
