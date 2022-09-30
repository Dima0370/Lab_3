package com.lab3.droidbattle.droids;

public class HealerDroid extends Droid {

	// Кількість здоров'я, яке можна відновити
	private int restoreHP;

	public HealerDroid(String name) {
		this.name = name;
		this.droidClass = "Дроїд-лiкар";
		this.maxHealth = (int) (Math.random() * 500) + 200;
		this.currentHealth = maxHealth;
		this.damage = (int) (Math.random() * 20) + 15;
		this.accuracy = (int) (Math.random() * 40) + 15;
		this.criticalChance = 0;
		this.healer = true;
		this.restoreHP = (int) (Math.random() * 75) + 30;
	}

	@Override
	public void heal(Droid allyTarget) {

		if (allyTarget.currentHealth < allyTarget.maxHealth) {
			allyTarget.currentHealth += this.restoreHP;
			System.out.println("Дроїд " + this.name + " вилiкував дроїда " + allyTarget.name + " на " + this.restoreHP
					+ " очкiв здоров'я");
		}
	}

	@Override
	public void attack(Droid enemyTarget) {

		if ((Math.random() * 100) > accuracy) {
			System.out.println("Дроїд " + this.name + " промахнувся");
		}

		else {
			enemyTarget.currentHealth -= this.damage;
			System.out.println("Дроїд " + this.name + " влучив у дроїда " + enemyTarget.name);
		}
	}
}
