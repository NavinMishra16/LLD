package org.example.domain;

public  class PlayerAbstract implements Player {
    private int health;
    private int strength;
    private int attack;
    private String playerName;

    //Constructor
    public PlayerAbstract(String playerName, int health, int strength, int attack) {
        if (health < 0 || strength < 0 || attack < 0) {
            throw new IllegalArgumentException("Health, strength, and attack must be non-negative.");
        }
        this.playerName = playerName;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAttack() {
        return attack ;
    }

    @Override
    public String getplayerName() {
        return playerName;
    }

    @Override
    public int attack(int diceRoll) {
        return safeMultiply(attack,diceRoll);
    }
    @Override
    public int defend(int diceRoll) {
        return safeMultiply(strength,diceRoll);
    }

    @Override
    public void reduceHealth(int damage) {
         if(damage>0)health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    private int safeMultiply(int a, int b) {
        long result = (long) a * b;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

}
