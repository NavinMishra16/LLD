package org.example;

import org.example.domain.Player;
import org.example.domain.Warrior;
import org.example.services.Arena;

public class Main {
    public static void main(String[] args) {
        try {
            Arena arena = new Arena();
            Player player1 = new Warrior("Navin", 90, 10, 6);
            Player player2 = new Warrior("Yuvraj", 100, 5, 10);
            Player player3 = new Warrior("Alice", 190, 240, 25);
            Player player4 = new Warrior("Bob", 150, 15, 20);
            Player player5 = new Warrior("Kame", 10000, 5, 25);
            Player player6 = new Warrior("Kazi", 200, 500, 460);

            arena.startBattle(player1, player2);
            arena.startBattle(player3, player4);
            arena.startBattle(player5, player6);
            arena.processBattles();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

       }
    }
