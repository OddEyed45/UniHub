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
class NoteController {

	private static final String VIEWS_NOTES_CREATE_OR_UPDATE_FORM = "notes/createOrUpdateNotesForm";

	private final StudentRepository students;

	public NoteController(StudentRepository students) {
		this.students = students;
	}

	@ModelAttribute("student")
	public Student findStudent(@PathVariable("studentId") int studentId) {
		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student student = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		return student;
	}

	@ModelAttribute("note")
	public Note findNote(@PathVariable("studentId") int studentId,
									 @PathVariable(name = "noteId", required = false) Integer noteId) {

		if (noteId == null) {
			return new Note();
		}

		Optional<Student> optionalStudent = this.students.findById(studentId);
		Student student = optionalStudent.orElseThrow(() -> new IllegalArgumentException(
			"Student not found with id: " + studentId + ". Please ensure the ID is correct "));
		return student.getNote(studentId);
	}

	@InitBinder("student")
	public void initStudentBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/*
	@InitBinder("assignment")
	public void initPetBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new PetValidator());
	}
	*/

	@GetMapping("/notes/new")
	public String initCreationForm(Student student, ModelMap model) {
		Note note = new Note();
		student.addNote(note);
		return VIEWS_NOTES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/notes/new")
	public String processCreationForm(Student student, Note note, BindingResult result,
									  RedirectAttributes redirectAttributes) {

		if (StringUtils.hasText(note.getName()) && note.isNew() && student.getAssignment(note.getName(), true) != null)
			result.rejectValue("name", "duplicate", "already exists");

		if (result.hasErrors()) {
			return VIEWS_NOTES_CREATE_OR_UPDATE_FORM;
		}

		student.addNote(note);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "New Note has been Added");
		return "redirect:/notes/{noteId}";
	}

	@GetMapping("/notes/{noteId}/edit")
	public String initUpdateForm() {
		return VIEWS_NOTES_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/notes/{noteId}/edit")
	public String processUpdateForm(Student student, Note note, BindingResult result,
									RedirectAttributes redirectAttributes) {

		String noteName = note.getName();

		// checking if the pet name already exist for the owner
		if (StringUtils.hasText(noteName)) {
			Note existingNote = student.getNote(noteName, false);
			if (existingNote != null && !existingNote.getId().equals(note.getId())) {
				result.rejectValue("name", "duplicate", "already exists");
			}
		}

		if (result.hasErrors()) {
			return VIEWS_NOTES_CREATE_OR_UPDATE_FORM;
		}

		student.addNote(note);
		this.students.save(student);
		redirectAttributes.addFlashAttribute("message", "Note details has been edited");
		return "redirect:/students/{studentId}";
	}

}
