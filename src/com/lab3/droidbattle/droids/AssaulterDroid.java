package com.lab3.droidbattle.droids;

public class AssaulterDroid extends Droid {

	public AssaulterDroid(String name) {
		this.name = name;
		this.droidClass = "Дроїд-стрiлець";
		this.maxHealth = (int) (Math.random() * 250) + 150;
		this.currentHealth = maxHealth;
		this.damage = (int) (Math.random() * 55) + 25;
		this.accuracy = (int) (Math.random() * 50) + 40;
		this.criticalChance = 40;
		this.healer = false;
	}

	@Override
	public void attack(Droid enemyTarget) {

		if ((Math.random() * 100) > accuracy) {
			System.out.println("Дроїд " + this.name + " промахнувся");
		}

		else {
			if ((Math.random() * 100) > criticalChance) {
				enemyTarget.currentHealth -= this.damage;
				System.out.println("Дроїд " + this.name + " влучив у дроїда " + enemyTarget.name);
			}

			else {
				enemyTarget.currentHealth -= (this.damage * 1.25);
				System.out.println("Дроїд " + this.name + " влучив критичним пострiлом у дроїда " + enemyTarget.name);
			}
		}
	}
}
