
package org.javaturk.jpa.ch08.entity.factory;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Project")
@Table(name="QProject")
public class Project {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "NAME", length = 80, nullable = false)
	private String name;
	
	@Column(name = "TEAMSIZE")
	private int size;
	
	@OneToOne
	private Manager pm;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> team;
	
	@OneToOne
	private Consultant consultant;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.PERSIST)
	private Set<Task> tasks;
	
	public Project(){}
	
	public Project(String name, int size){
		this.name = name;
		this.size = size;
		team = new HashSet<>(size);
		tasks = new HashSet<>();
	}
	
	public boolean addEmployee(Employee e){
		e.include(this);
		return team.add(e);
	}
	
	public boolean removeEmployee(Employee e){
		e.exclude(this);
		return team.remove(e);
	}

	public Consultant getConsultant() {
		return consultant;
	}

	public void setConsultant(Consultant consultant) {
		this.consultant = consultant;
		consultant.setProject(this);
	}
	
	public Manager getPm() {
		return pm;
	}

	public void setPm(Manager pm) {
		this.pm = pm;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public Set<Employee> getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", size=" + size + ", pm=" + pm + "]";
	}

	public void addTask(Task t) {
		tasks.add(t);	
		t.setProject(this);
	}
}
