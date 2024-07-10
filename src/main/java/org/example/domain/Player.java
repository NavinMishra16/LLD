package org.example.domain;

public interface Player {
    int getHealth();
    int getStrength();
    int getAttack();
    String getplayerName();
    int attack(int diceRoll);
    int defend(int diceRoll);
    void reduceHealth(int damage);
    boolean isAlive();
}
