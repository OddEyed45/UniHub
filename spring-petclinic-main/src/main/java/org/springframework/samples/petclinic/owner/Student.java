package org.springframework.samples.petclinic.owner;
import java.util.ArrayList;
import java.util.List;

//import org.hibernate.sql.ast.tree.update.Assignment;
import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;
//import org.springframework.samples.petclinic.model.Note;
import org.springframework.util.Assert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;

/**
 * Simple JavaBean domain object representing an owner.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Oliver Drotbohm
 * @author Wick Dynex
 */
@Entity
@Table(name = "owners")
public class Student extends Person {

	@Column(name = "email")
	@NotBlank
	private String email;

	@Column(name = "telephone")
	@NotBlank
	@Pattern(regexp = "\\d{10}", message = "Telephone must be a 10-digit number")
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "courses")
	@OrderBy("name")
	private final List<Course> courses = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "notes")
	@OrderBy("name")
	private final List<Note> notes = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "assignments")
	@OrderBy("name")
	private final List<Assignment> assignments = new ArrayList<>();

	/*
	@JoinColumn(name = "budget")
	private Budget budget; // = new Budget();

	@JoinColumn(name = "exercise")
	private ExerciseTracker exercise = new ExerciseTracker();

	@JoinColumn(name = "meals")
	private MealTracker meals = new MealTracker();
*/

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Course> getCourses() {
		return this.courses;
	}
	public List<Note> getNotes() {
		return this.notes;
	}
	public List<Assignment> getAssignments() {
		return this.assignments;
	}

	public void addCourse(Course crs) {
		if (crs.isNew()) {
			getCourses().add(crs);
		}
	}

	public void addNote(Note nt) {
		if (nt.isNew()) {
			getNotes().add(nt);
		}
	}
	public void addAssignment(Assignment ast) {
		if (ast.isNew()) {
			getAssignments().add(ast);
		}
	}
	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @return the Pet with the given name, or null if no such Pet exists for this Owner
	 */
	public Course getCourse(String name) {
		return getCourse(name, false);
	}
	public Note getNote(String name) {
		return getNote(name, false);
	}
	public Assignment getAssignment(String name) {
		return getAssignment(name, false);
	}

	/**
	 * Return the Pet with the given id, or null if none found for this Owner.
	 * @param id to test
	 * @return the Pet with the given id, or null if no such Pet exists for this Owner
	 */
	public Course getCourse(Integer id) {
		for (Course course : getCourses()) {
			if (!course.isNew()) {
				Integer compId = course.getId();
				if (compId.equals(id)) {
					return course;
				}
			}
		}
		return null;
	}
	public Note getNote(Integer id) {
		for (Note note : getNotes()) {
			if (!note.isNew()) {
				Integer compId = note.getId();
				if (compId.equals(id)) {
					return note;
				}
			}
		}
		return null;
	}
	public Assignment getAssignment(Integer id) {
		for (Assignment ast : getAssignments()) {
			if (!ast.isNew()) {
				Integer compId = ast.getId();
				if (compId.equals(id)) {
					return ast;
				}
			}
		}
		return null;
	}
	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @param ignoreNew whether to ignore new pets (pets that are not saved yet)
	 * @return the Pet with the given name, or null if no such Pet exists for this Owner
	 */
	public Course getCourse(String name, boolean ignoreNew) {
		for (Course course : getCourses()) {
			String compName = course.getName();
			if (compName != null && compName.equalsIgnoreCase(name)) {
				if (!ignoreNew || !course.isNew()) {
					return course;
				}
			}
		}
		return null;
	}
	public Note getNote(String name, boolean ignoreNew) {
		for (Note note : getNotes()) {
			String compName = note.getName();
			if (compName != null && compName.equalsIgnoreCase(name)) {
				if (!ignoreNew || !note.isNew()) {
					return note;
				}
			}
		}
		return null;
	}
	public Assignment getAssignment(String name, boolean ignoreNew) {
		for (Assignment asgt : getAssignments()) {
			String compName = asgt.getName();
			if (compName != null && compName.equalsIgnoreCase(name)) {
				if (!ignoreNew || !asgt.isNew()) {
					return asgt;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("id", this.getId())
			.append("new", this.isNew())
			.append("lastName", this.getLastName())
			.append("firstName", this.getFirstName())
			.append("email", this.email)
			.append("telephone", this.telephone)
			.toString();
	}

	/**
	 * Adds the given {@link Visit} to the {@link Pet} with the given identifier.
	 * @param petId the identifier of the {@link Pet}, must not be {@literal null}.
	 * @param visit the visit to add, must not be {@literal null}.
	 */
	/*
	public void addVisit(Integer petId, Visit visit) {

		Assert.notNull(petId, "Pet identifier must not be null!");
		Assert.notNull(visit, "Visit must not be null!");

		Pet pet = getPet(petId);

		Assert.notNull(pet, "Invalid Pet identifier!");

		pet.addVisit(visit);
	}
	*/
}

