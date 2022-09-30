package com.lab3.droidbattle.droids;

public class TankDroid extends Droid {

	public TankDroid(String name) {
		this.name = name;
		this.droidClass = "Дроїд-танк";
		this.maxHealth = (int) (Math.random() * 700) + 300;
		this.currentHealth = maxHealth;
		this.damage = (int) (Math.random() * 20) + 15;
		this.accuracy = (int) (Math.random() * 30) + 20;
		this.criticalChance = 5;
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
