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
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Wick Dynex
 */
@Controller
@RequestMapping("/students/{studentId}")
class CourseController {

	private static final String VIEWS_COURSES_CREATE_OR_UPDATE_FORM = "courses/createOrUpdateCourseForm";

	private final StudentRepository students;

	public CourseController(StudentRepository students) {
		this.students = students;
	}

	@ModelAttribute("student")
	public Student findStudent(@PathVariable("studentId") int studentId) {
		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student stud = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		return stud;
	}

	@ModelAttribute("course")
	public Course findCourse(@PathVariable("studentId") int studentId,
					   @PathVariable(name = "courseId", required = false) Integer courseId) {

		if (courseId == null) {
			return new Course();
		}

		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student student1 = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		return student1.getCourse(courseId);
	}

	@InitBinder("student")
	public void initStudentBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

//	@InitBinder("course")
//	public void initCourseBinder(WebDataBinder dataBinder) {
//		//dataBinder.setValidator();
//	}

	@GetMapping("/courses/new")
	public String initCreationForm(Student student, ModelMap model) {
		Course course = new Course();
		student.addCourse(course);
		return VIEWS_COURSES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/courses/new")
	public String processCreationForm(Student student, Course course, BindingResult result,
									  RedirectAttributes redirectAttributes) {

		if (StringUtils.hasText(course.getName()) && course.isNew() && student.getCourse(course.getName(), true) != null)
			result.rejectValue("name", "duplicate", "already exists");

//		LocalDate currentDate = LocalDate.now();
//		if (pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)) {
//			result.rejectValue("birthDate", "typeMismatch.birthDate");
//		}

		if (result.hasErrors()) {
			return VIEWS_COURSES_CREATE_OR_UPDATE_FORM;
		}

		student.addCourse(course);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "New Course has been Added");
		return "redirect:/students/{studentId}";
	}

	@GetMapping("/courses/{courseId}/edit")
	public String initUpdateForm() {
		return VIEWS_COURSES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/courses/{courseId}/edit")
	public String processUpdateForm(Student student, Course course, BindingResult result,
									RedirectAttributes redirectAttributes) {

		String courseName = course.getName();

		// checking if the pet name already exist for the owner
		if (StringUtils.hasText(courseName)) {
			Course existingCourse = student.getCourse(courseName, false);
			if (existingCourse != null && !existingCourse.getId().equals(course.getId())) {
				result.rejectValue("name", "duplicate", "already exists");
			}
		}

//		LocalDate currentDate = LocalDate.now();
//		if (pet.getBirthDate() != null && pet.getBirthDate().isAfter(currentDate)) {
//			result.rejectValue("birthDate", "typeMismatch.birthDate");
//		}

		if (result.hasErrors()) {
			return VIEWS_COURSES_CREATE_OR_UPDATE_FORM;
		}

		student.addCourse(course);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "Course details has been edited");
		return "redirect:/students/{studentId}";
	}

}
