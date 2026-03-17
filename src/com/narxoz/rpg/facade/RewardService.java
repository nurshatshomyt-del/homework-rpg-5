package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) return "No reward";
        if (battleResult.getWinner().equals("Draw")) return "Consolation: 10 Gold";

        String reward = "Gold 100";
        if (battleResult.getRounds() <= 3) {
            reward += ", Epic Rune";
        }
        return reward;
    }
}