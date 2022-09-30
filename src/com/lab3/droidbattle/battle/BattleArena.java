package com.lab3.droidbattle.battle;

import com.lab3.droidbattle.droids.*;

import java.util.List;
import java.util.Random;

public class BattleArena {

	List<Droid> team1;
	List<Droid> team2;
	List<Droid> assaultTeam;
	List<Droid> targetTeam;

	public BattleArena(List<Droid> team1, List<Droid> team2) {

		this.team1 = team1;
		this.team2 = team2;
	}

	
	// Проведення битви між командами
	public void teamFight() {

		// Якщо обидві команди не створені
		if (team1.size() == 0 && team2.size() == 0) {

			System.out.println("\nСтворiть команди перед тим, як почати битву");
		}

		// Якщо лише команда 1 не створена
		else if (team1.size() == 0 && team2.size() > 0) {

			System.out.println("\nДодайте дроїдiв до команди 1 для битви");
		}
		
		// Якщо лише команда 2 не створена
		else if (team1.size() > 0 && team2.size() == 0) {

			System.out.println("\nДодайте дроїдiв до команди 2 для битви");
		}

		else {

			int round = 1;

			do {

				System.out.println("\n----------------------------------------" + "\nРаунд " + (round++) + "\n");

				pickAttackerTeam();

				// Проведення бою
				for (Droid attacker : assaultTeam) {

					// Якщо команда, яку атакують, знищена
					if (!isTeamAlive(targetTeam)) {
						break;
					}

					// Якщо дроїд атакуючої команди вміє лікувати
					if (attacker.isHealer()) {
						attacker.heal(pickTargetInTeam(assaultTeam));
						attacker.attack(pickTargetInTeam(targetTeam));

					}

					// Якщо не вміє лікувати
					else {
						attacker.attack(pickTargetInTeam(targetTeam));
					}

					
					removeKilledDroid();
				}

				System.out.println("\n" + assaultTeam);
				System.out.println("\n" + targetTeam);

			} while (isTeamAlive(targetTeam));

			System.out.println("\n\n" + "Команда " + assaultTeam + " перемогла");
		}
	}

	// Вибір однієї з команд як нападника
	public void pickAttackerTeam() {

		if (new Random().nextBoolean()) {
			assaultTeam = team1;
			targetTeam = team2;
		}

		else {
			targetTeam = team1;
			assaultTeam = team2;
		}
	}

	// Перевіряє, чи є хтось з дроїдів в живих
	public boolean isTeamAlive(List<Droid> team) {

		for (Droid droid : team) {

			if (droid.isAlive()) {

				return true;
			}
		}

		return false;
	}

	// Видаляє знищенного дроїда зі списку
	public void removeKilledDroid() {
		targetTeam.removeIf(droid -> !droid.isAlive());
	}

	// Обирає випадкову ціль з союзної або ворожої команди
	public Droid pickTargetInTeam(List<Droid> target) {
		return target.get(new Random().nextInt(target.size()));
	}

}
