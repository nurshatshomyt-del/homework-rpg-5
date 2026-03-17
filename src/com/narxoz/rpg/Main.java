package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Aldin", 100);
        BossEnemy boss = new BossEnemy("Gorgath", 120, 12);

        AttackAction basic = new BasicAttack("Strike", 10);
        AttackAction critThenPoison = new PoisonCoatingDecorator(new CriticalFocusDecorator(basic));
        AttackAction allEnhanced = new FireRuneDecorator(critThenPoison);

        System.out.println("--- Decorator Preview ---");
        System.out.println("Base action: " + basic.getActionName());
        System.out.println("Base damage: " + basic.getDamage());
        System.out.println("Base effects: " + basic.getEffectSummary());
        System.out.println();
        System.out.println("Enhanced action: " + allEnhanced.getActionName());
        System.out.println("Enhanced damage: " + allEnhanced.getDamage());
        System.out.println("Enhanced effects: " + allEnhanced.getEffectSummary());

        System.out.println("\n--- Facade Preview ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, allEnhanced);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}