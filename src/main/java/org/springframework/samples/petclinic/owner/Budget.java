package org.springframework.samples.petclinic.owner;

import jakarta.persistence.*;
import org.springframework.samples.petclinic.model.NamedEntity;


public class Budget extends NamedEntity  {

	@Column(name = "food")
	private int food;

	@Column(name = "housing")
	private int housing;

	@Column(name = "school")
	private int school;

	@Column(name = "miscellaneous")
	private int misc;

	@Column(name = "utilities")
	private int utilities;

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	public int getHousing() {
		return housing;
	}
	public void setHousing(int housing) {
		this.housing = housing;
	}
	public int getSchool() {
		return school;
	}
	public void setSchool(int school) {
		this.school = school;
	}
	public int getMisc() {
		return misc;
	}
	public void setMisc(int misc) {
		this.misc = misc;
	}
	public int getUtilities() {
		return utilities;
	}
	public void setUtilities(int utilities) {
		this.utilities = utilities;
	}
}
