package org.example.services;
import org.example.domain.Player;

import java.util.Random;

public class Battle {
    private Player player1;
    private Player player2;
    private Player currentAttacker;
    private Player currentDefender;
    private final int diceRoll = 6;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        if (player1.getHealth() <= player2.getHealth()) {
            this.currentAttacker = player1;
            this.currentDefender = player2;
        } else {
            this.currentAttacker = player2;
            this.currentDefender = player1;
        }
    }

    public Player getCurrentAttacker() {
        return currentAttacker;
    }

    public Player getCurrentDefender() {
        return currentDefender;
    }

    public void switchTurn() {
        Player temp = currentAttacker;
        currentAttacker = currentDefender;
        currentDefender = temp;
    }

    public void processTurn() {
          while(currentDefender.isAlive()){
              Random random = new Random();
              int attackRoll = random.nextInt(diceRoll) + 1;
              int defenseRoll = random.nextInt(diceRoll) + 1;

              int attackValue = currentAttacker.attack(attackRoll);
              int defenseValue = currentDefender.defend(defenseRoll);

              int damage = Math.max(0, attackValue - defenseValue);

              currentDefender.reduceHealth(damage);

              System.out.println(currentAttacker.getplayerName() + " attacks with " + attackValue + " damage. " +
                      currentDefender.getplayerName() + " defends with " + defenseValue + " defense. " +
                      currentDefender.getplayerName() + " takes " + damage + " damage.");

              if (!currentDefender.isAlive()) {
                  System.out.println(currentDefender.getplayerName() + " has lost.");
                  break;
              } else {
                  switchTurn();
              }
          }

    }
}
