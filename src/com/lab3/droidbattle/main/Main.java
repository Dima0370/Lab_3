package com.lab3.droidbattle.main;

import com.lab3.droidbattle.battle.*;
import com.lab3.droidbattle.droids.*;
import com.lab3.droidbattle.menu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);

		List<Droid> team1 = new ArrayList<>();
		List<Droid> team2 = new ArrayList<>();
		BattleArena teamBattle = new BattleArena(team1, team2);

		Menu menu = new Menu();

		commands();

		// Консольне меню
		while (true) {

			int choice;

			System.out.print("\nВведiть будь-яку команду меню (1-8): ");

			choice = in.nextInt();

			switch (choice) {
			case 1:
				menu.createDroid();
				commands();
				break;
			case 2:
				menu.showDroidList();
				commands();
				break;
			case 3:
				menu.addDroidToTeam(team1);
				commands();
				break;
			case 4:
				menu.addDroidToTeam(team2);
				commands();
				break;
			case 5:
				menu.showTeam(team1);
				commands();
				break;
			case 6:
				menu.showTeam(team2);
				commands();
				break;
			case 7:
				menu.startBattle(teamBattle);
				commands();
				break;
			case 8:
				return;
			default:
				System.out.println("\nНеправильна команда, спробуйте ще раз");
			}
		}
	}

	// Виведення списку команд
	public static void commands() {
		System.out.println("\n1. Додати нового дроїда");
		System.out.println("2. Показати список дроїдiв");
		System.out.println("3. Додати дроїда до команди 1");
		System.out.println("4. Додати дроїда до команди 2");
		System.out.println("5. Показати список команди 1");
		System.out.println("6. Показати список команди 2");
		System.out.println("7. Почати битву");
		System.out.println("8. Вихiд");
	}
}
