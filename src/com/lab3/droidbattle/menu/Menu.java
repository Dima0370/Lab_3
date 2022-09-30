package com.lab3.droidbattle.menu;

import com.lab3.droidbattle.battle.*;
import com.lab3.droidbattle.droids.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	List<Droid> droids = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public Menu() {
	}

	// Додавання дроїда
	public void createDroid() {

		System.out.println("\nНовий дроїд");

		System.out.println(
				"\nВиберiть клас дроїда:\n\n 1 - Стрiлець\n 2 - Пiдривник\n 3 - Лiкар\n 4 - Снайпер\n 5 - Танк\n");

		int choice = in.nextInt();

		switch (choice) {
		case 1:
			droids.add(new AssaulterDroid(inputName()));
			break;
		case 2:
			droids.add(new ExploderDroid(inputName()));
			break;
		case 3:
			droids.add(new HealerDroid(inputName()));
			break;
		case 4:
			droids.add(new SniperDroid(inputName()));
			break;
		case 5:
			droids.add(new TankDroid(inputName()));
			break;
		default:
			System.out.println("\nНеправильний вибір, введiть ще раз");
			createDroid();
		}
	}

	// Введення ім'я для дроїда
	public String inputName() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nIм'я дроїда: ");
		String droidName = in.nextLine();
		return droidName;
	}

	// Виведення списку дроїдів
	public void showDroidList() {

		if (droids.size() == 0) {
			System.out.println("\nСписок дроїдiв пустий");
		}

		else {

			System.out.println("\nСписок дроїдiв: ");

			for (int i = 0; i < droids.size(); i++) {

				System.out.println("\n" + i + ") " + droids.get(i));
			}
		}
	}

	// Виведення списку команди
	public void showTeam(List<Droid> team) {

		if (team.size() == 0) {
			System.out.println("\nСписок дроїдiв команди пустий");
		}

		else {
			
			System.out.println("\nСписок дроїдiв команди: ");
			
			for (Droid droid : team) {
				System.out.println("\n" + droid);
			}
		}
	}

	// Додавання дроїда до команди
	public void addDroidToTeam(List<Droid> team) {

		if (droids.size() == 0) {

			System.out.println("\nПотрiбно мати в списку не менше одного дроїда для додавання в команду");
		}

		else {

			System.out.print("\nВведiть iндекс дроїда: ");
			int index = in.nextInt();

			// Додавання дроїда в команду за індексом
			team.add(droids.get(index));
			
			// Видалення дроїда з загального списку
			droids.remove(droids.get(index));
		}
	}

	// Запуск битви
	public void startBattle(BattleArena teamBattle) {

		teamBattle.teamFight();
	}
}
