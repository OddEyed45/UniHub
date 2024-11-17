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

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @author Wick Dynex
 */
@Controller
class StudentController {

	private static final String VIEWS_STUDENT_CREATE_OR_UPDATE_FORM = "students/createOrUpdateStudentForm";

	private final StudentRepository students;

	public StudentController(StudentRepository clinicService) {
		this.students = clinicService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("student")
	public Student findStudent(@PathVariable(name = "studentId", required = false) Integer studentId) {
		return studentId == null ? new Student()
			: this.students.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId
				+ ". Please ensure the ID is correct " + "and the student exists in the database."));
	}

	@GetMapping("/students/new")
	public String initCreationForm() {
		return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/students/new")
	public String processCreationForm(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "There was an error in creating the student.");
			return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
		}

		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "New Student Created");
		return "redirect:/students/" + student.getId();
	}

	@GetMapping("/students/find")
	public String initFindForm() {
		return "students/findStudents";
	}

	@GetMapping("/students")
	public String processFindForm(@RequestParam(defaultValue = "1") int page, Student student, BindingResult result,
								  Model model) {
		// allow parameterless GET request for /owners to return all records
		if (student.getLastName() == null) {
			student.setLastName(""); // empty string signifies broadest possible search
		}

		// find owners by last name
		Page<Student> studentsResults = findPaginatedForStudentsLastName(page, student.getLastName());
		if (studentsResults.isEmpty()) {
			// no owners found
			result.rejectValue("lastName", "notFound", "not found");
			return "students/findStudents";
		}

		if (studentsResults.getTotalElements() == 1) {
			// 1 owner found
			student = studentsResults.iterator().next();
			return "redirect:/students/" + student.getId();
		}

		// multiple owners found
		return addPaginationModel(page, model, studentsResults);
	}

	private String addPaginationModel(int page, Model model, Page<Student> paginated) {
		List<Student> listStudent = paginated.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", paginated.getTotalPages());
		model.addAttribute("totalItems", paginated.getTotalElements());
		model.addAttribute("listStudents", listStudent);
		return "students/studentsList";
	}

	private Page<Student> findPaginatedForStudentsLastName(int page, String lastname) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return students.findByLastNameStartingWith(lastname, pageable);
	}

	@GetMapping("/students/{studentId}/edit")
	public String initUpdateOwnerForm() {
		return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/students/{studentId}/edit")
	public String processUpdateOwnerForm(Student student, BindingResult result, @PathVariable("studentId") int studentId,
										 RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("error", "There was an error in updating the student.");
			return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
		}

		if (student.getId() != studentId) {
			result.rejectValue("id", "mismatch", "The student ID in the form does not match the URL.");
			redirectAttributes.addFlashAttribute("error", "Student ID mismatch. Please try again.");
			return "redirect:/students/{studentId}/edit";
		}

		student.setId(studentId);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "Student Values Updated");
		return "redirect:/students/{studentId}";
	}

	/**
	 * Custom handler for displaying an owner.
	 * @param studentId the ID of the owner to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@GetMapping("/students/{studentId}")
	public ModelAndView showStudent(@PathVariable("studentId") int studentId) {
		ModelAndView mav = new ModelAndView("students/studentDetails");
		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student stud = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		mav.addObject(stud);
		return mav;
	}

}
