package com.lab3.droidbattle.droids;

public class Droid {

	public String name; // Ім'я дроїда
	public String droidClass; // Клас дроїда
	public int maxHealth; // Максимальна кількість здоров'я
	public int currentHealth; // Поточна кількість здоров'я
	public int damage; // Шкода
	public int accuracy; // Точність
	public int criticalChance; // Шанс критичної атаки (на 25% більше шкоди буде нанесено)
	public boolean healer; // Наявність здібності лікувати

	public Droid() {
	}

	// чи є дроїд живим
	public boolean isAlive() {
		return currentHealth > 0;
	}

	// Функція атаки
	public void attack(Droid target) {
	}

	// Функція лікування
	public void heal(Droid target) {
	}

	// Наявність здібності лікувати
	public boolean isHealer() {
		return healer;
	}

	@Override
	public String toString() {
		return "Iм'я: " + name + ", клас: " + droidClass + ", очки здоров'я: " + currentHealth + ", шкода: " + damage;
	}
}
