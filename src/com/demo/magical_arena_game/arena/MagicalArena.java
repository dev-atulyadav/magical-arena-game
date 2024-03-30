package com.demo.magical_arena_game.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.magical_arena_game.dto.Player;

@SuppressWarnings(value = "resource")
public class MagicalArena {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int option = 0;
		System.out.println("Welcome to Magical Arena!!!");
		System.out.println("--------------------------");
		do {
			System.out.println("Enter 1 to start new game!!!");
			System.out.println("Enter 2 for exit!!!");
			option = scanner.nextInt();
			List<Player> players = new ArrayList<Player>();
			if (option == 1) {
				players = setPlayers();
				for (Player player : players) {
					getPlayerDetails(player);
				}
				Player winner = startTheGame(players);
				if (winner != null) {
					System.out.println("--------------------------");
					System.out.println("Congrats!!!");
					System.out.println(winner.getName() + " is the winner!!!");
					System.out.println("--------------------------");
				}
			}

		} while (option == 1);

		System.out.println("Game Ends!!!");
	}

	public static List<Player> setPlayers() {
		Scanner scanner = new Scanner(System.in);
		List<Player> players = new ArrayList<Player>();
		for (int i = 1; i <= 2; i++) {
			System.out.println("Enter name of Player :" + i);
			int tensDigit = (int) (Math.random() * 10) + 1;
			int health = tensDigit * 10;

			int strength = (int) (Math.random() * 10) + 1;
			int attack = (int) (Math.random() * 10) + 1;
			players.add(new Player(scanner.next(), health, strength, attack));
			if (i == 2)
				return players;
		}
		return null;
	}

	public static int rollTheDie() {
		int min = 1;
		int max = 6;
		return (int) (Math.random() * (max - min + 1)) + min;

	}

	public static Player startTheGame(List<Player> players) {

		Scanner scanner = new Scanner(System.in);
		Player p1 = players.get(0);
		Player p2 = players.get(1);
		int damage = 1;
		int defend = 1;
		int temp;
		int finalDamage = 0;
		Player attacker = p1.getHealth() > p2.getHealth() ? p2 : p1;
		Player defender = p1.getHealth() < p2.getHealth() ? p2 : p1;
		do {
			System.out.println("--------------------------");
			System.out.println("Attacker:-");
			System.out.println(attacker.getName() + " rolls the die...");
			System.err.println("Press value greater >= 0 to roll the die");
			temp = scanner.nextInt();
			int attackerDie = rollTheDie();
			System.out.println("Number got on die " + attackerDie);
			System.out.println("Attack damage is "+attackerDie * attacker.getAttack());
			System.out.println("--------------------------");
			System.out.println("Defender:-");
			System.out.println(defender.getName() + " rolls the die...");
			System.err.println("Press value greater >= 0 to roll the die");
			temp = scanner.nextInt();
			int defenderDie = rollTheDie();
			System.out.println("Number got on die " + defenderDie);
			System.out.println("Defending strength is "+defenderDie * defender.getStrength());
			if (temp >= 0) {
				damage = attackerDie * attacker.getAttack();
				defend = defenderDie * defender.getStrength();
				finalDamage = damage - defend > 0 ? damage - defend : 0;
			}
			if (p1.getName().equals(attacker.getName())) {
				System.out.println(defender.getName() + " got total damage of " + finalDamage);
				p2.setHealth(defender.getHealth() - finalDamage>0?defender.getHealth() - finalDamage:0);
				attacker = p2;
				defender = p1;
			}
			else if (p2.getName().equals(attacker.getName())) {
				System.out.println(defender.getName() + " got total damage of " + finalDamage);
				p1.setHealth(defender.getHealth() - finalDamage>0?defender.getHealth() - finalDamage:0);
				attacker = p1;
				defender = p2;
			}

			getPlayerDetails(p1);
			getPlayerDetails(p2);
			if (attacker.getHealth() == 0) {
				return defender;
			}
			if (defender.getHealth() == 0) {
				return attacker;
			}
		} while (p1.getHealth() > 0 || p2.getHealth() > 0);
		return null;
	}

	public static void getPlayerDetails(Player player) {
		System.out.println("Player Details!!!");
		System.out.println("--------------------------");
		System.out.println("Player name: " + player.getName());
		System.out.println("Player health: " + player.getHealth());
		System.out.println("Player strength: " + player.getStrength());
		System.out.println("Player attack: " + player.getAttack());
	}

}
