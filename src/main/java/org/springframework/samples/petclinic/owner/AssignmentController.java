package org.springframework.samples.petclinic.owner;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/students/{studentId}")
class AssignmentController {

	private static final String VIEWS_ASSIGNMENTS_CREATE_OR_UPDATE_FORM = "assignments/createOrUpdateAssignmentForm";

	private final StudentRepository students;

	public AssignmentController(StudentRepository students) {
		this.students = students;
	}

	@ModelAttribute("student")
	public Student findStudent(@PathVariable("studentId") int studentId) {
		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student student = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		return student;
	}

	@ModelAttribute("assignment")
	public Assignment findAssignment(@PathVariable("studentId") int studentId,
					   @PathVariable(name = "assignmentId", required = false) Integer assignmentId) {

		if (assignmentId == null) {
			return new Assignment();
		}

		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student student = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Owner not found with id: " + studentId + ". Please ensure the ID is correct "));
		return student.getAssignment(studentId);
	}

	@InitBinder("student")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/*
	@InitBinder("assignment")
	public void initPetBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new PetValidator());
	}
	*/

	@GetMapping("/assignments/new")
	public String initCreationForm(Student student, ModelMap model) {
		Assignment asst = new Assignment();
		student.addAssignment(asst);
		return VIEWS_ASSIGNMENTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/assignments/new")
	public String processCreationForm(Student student, Assignment assignment, BindingResult result,
									  RedirectAttributes redirectAttributes) {

		if (StringUtils.hasText(assignment.getName()) && assignment.isNew() && student.getAssignment(assignment.getName(), true) != null)
			result.rejectValue("name", "duplicate", "already exists");

		LocalDate currentDate = LocalDate.now();
		if (assignment.getDueDate() != null && assignment.getDueDate().isBefore(currentDate)) {
			result.rejectValue("dueDate", "typeMismatch.dueDate");
		}

		if (result.hasErrors()) {
			return VIEWS_ASSIGNMENTS_CREATE_OR_UPDATE_FORM;
		}

		student.addAssignment(assignment);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "New Assignment has been Added");
		return "redirect:/students/{studentId}";
	}

	@GetMapping("/assignments/{assignmentId}/edit")
	public String initUpdateForm() {
		return VIEWS_ASSIGNMENTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/assignments/{assignmentId}/edit")
	public String processUpdateForm(Student student, Assignment assignment, BindingResult result,
									RedirectAttributes redirectAttributes) {

		String asstName = assignment.getName();

		// checking if the pet name already exist for the owner
		if (StringUtils.hasText(asstName)) {
			Assignment existingAsst = student.getAssignment(asstName, false);
			if (existingAsst != null && !existingAsst.getId().equals(assignment.getId())) {
				result.rejectValue("name", "duplicate", "already exists");
			}
		}

		LocalDate currentDate = LocalDate.now();
		if (assignment.getDueDate() != null && assignment.getDueDate().isBefore(currentDate)) {
			result.rejectValue("dueDate", "typeMismatch.dueDate");
		}

		if (result.hasErrors()) {
			return VIEWS_ASSIGNMENTS_CREATE_OR_UPDATE_FORM;
		}

		student.addAssignment(assignment);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "Assignment details has been edited");
		return "redirect:/students/{studentId}";
	}

}

