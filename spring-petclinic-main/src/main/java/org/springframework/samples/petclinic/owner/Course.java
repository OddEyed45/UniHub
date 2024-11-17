/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

/**
 * Simple business object representing a pet.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Wick Dynex
 */
@Entity
@Table(name = "course")
public class Course extends NamedEntity {

	@Column(name = "course_name")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private LocalDate birthDate;
	private String courseName;

	@Column(name = "prof_name")
	private String professorName;

	@Column(name = "location")
	private String location;

	@Column(name = "time")
	private String time;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
//	@OrderBy("course_name ASC")
//	private final Set<Visit> visits = new LinkedHashSet<>();

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setProfessorName(String profName) {
		this.professorName = profName;
	}

	public String getProfessorName() {
		return this.professorName;
	}

	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getLocation() {
		return this.location;
	}

	public void setTime(String time) {this.time = time;}

	public String getTime() {return this.time;}


}
