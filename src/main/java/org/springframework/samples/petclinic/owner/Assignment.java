package org.springframework.samples.petclinic.owner;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "assignment")
public class Assignment extends NamedEntity {
	//@Id
	@Column(name = "name")
	private String name;

	@JoinColumn(name = "due_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dueDate;

	/*
	@JoinColumn(name = "class_id")
	private Course course;
	*/
	@JoinColumn(name = "category")
	private String category;

	@JoinColumn(name = "status")
	private String status;

	public void setDueDate(LocalDate birthDate) {
		this.dueDate = birthDate;
	}
	public LocalDate getDueDate() {
		return this.dueDate;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return this.category;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
/*
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {this.course = course;}
	*/
}
