package com.demo.magical_arena_game.dto;

public class Player {

	private String name;
	private int health;
	private int strength;
	private int attack;

	public Player() {
		super();
	}

	public Player(String name, int health, int strength, int attack) {
		super();
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.attack = attack;
	}

	public Player(String name, int health) {
		super();
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getStrength() {
		return strength;
	}

	public int getAttack() {
		return attack;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	
}
