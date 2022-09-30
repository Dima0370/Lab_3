package com.lab3.droidbattle.droids;

public class ExploderDroid extends Droid {

	public ExploderDroid(String name) {
		this.name = name;
		this.droidClass = "Дроїд-пiдривник";
		this.maxHealth = (int) (Math.random() * 225) + 100;
		this.currentHealth = maxHealth;
		this.damage = (int) (Math.random() * 100) + 70;
		this.accuracy = (int) (Math.random() * 50) + 40;
		this.criticalChance = 20;
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
				System.out.println("Droid " + this.name + " влучив критичним пострiлом у дроїда " + enemyTarget.name);
			}
		}
	}
}
