package org.example.services;
import org.example.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Battle> ongoingBattles;

    public Arena() {
        ongoingBattles = new ArrayList<>();
    }
    public List<Battle> getOngoingBattles(){
        return ongoingBattles;
    }

    public void startBattle(Player player1, Player player2) {
        Battle battle = new Battle(player1, player2);
        ongoingBattles.add(battle);
        System.out.println("Battle started between " + player1.getplayerName() + " and " + player2.getplayerName());
    }
    public void processBattles() {
        List<Battle> finishedBattles = new ArrayList<>();
        while (!ongoingBattles.isEmpty()) {
            for (Battle battle : ongoingBattles) {
                battle.processTurn();
                if (!battle.getCurrentDefender().isAlive()) {
                    finishedBattles.add(battle);
                }
            }
            ongoingBattles.removeAll(finishedBattles);
        }
    }
}
