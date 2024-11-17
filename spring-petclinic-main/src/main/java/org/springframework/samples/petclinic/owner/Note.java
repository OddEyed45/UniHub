package org.springframework.samples.petclinic.owner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;

import java.time.LocalDate;

@Entity
@Table(name = "note")
public class Note extends NamedEntity {
	@Column(name = "class")
	private String lectureTitle;

	@JoinColumn(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	//@JoinColumn(name = "class_id")
	//private Course course;

	@JoinColumn(name = "notes")
	private String notes;

	public void setDate(LocalDate birthDate) {
		this.date = birthDate;
	}
	public LocalDate getDate() {
		return this.date;
	}

	public String getTitle() {
		return this.lectureTitle;
	}
	public void setTitle(String title) {
		this.lectureTitle = title;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getNotes() {
		return this.notes;
	}

	/*public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {this.course = course;} */
}
