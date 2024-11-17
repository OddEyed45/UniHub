package org.springframework.samples.petclinic.owner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.samples.petclinic.model.NamedEntity;

@Table(name = "exerciseTracker")
public class ExerciseTracker extends NamedEntity  {

	@Column(name = "heavy")
	private int heavy;

	private int heavyGoal;

	@Column(name = "medium")
	private int medium;

	private int mediumGoal;

	@Column(name = "light")
	private int light;

	private int lightGoal;

	public void setHeavy(int heavy) {
		this.heavy = heavy;
	}
	public int getHeavy() {
		return this.heavy;
	}

	public void setMedium(int carbs) {
		this.medium = medium;
	}
	public int getMedium() {
		return this.medium;
	}

	public void setLight(int light) {
		this.light = light;
	}
	public int getLight() {
		return this.light;
	}

}
