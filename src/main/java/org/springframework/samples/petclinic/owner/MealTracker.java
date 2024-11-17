package org.springframework.samples.petclinic.owner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.NamedEntity;

@Table(name = "mealTracker")
public class MealTracker extends NamedEntity {

	@Column(name = "protein")
	private int protein;

	private int proteinGoal;

	@Column(name = "carbs")
	private int carbs;

	private int carbsGoal;

	@Column(name = "fats")
	private int fats;

	private int fatsGoal;

	public void setProtein(int protein) {
		this.protein = protein;
	}
	public int getProtein() {
		return this.protein;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}
	public int getCarbs() {
		return this.carbs;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}
	public int getFats() {
		return this.fats;
	}

}
