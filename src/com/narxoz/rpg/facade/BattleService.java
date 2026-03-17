package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int heroHp = hero.getHealth();
        int bossHp = boss.getHealth();
        int round = 0;

        result.addLine("Battle Start!");

        while (heroHp > 0 && bossHp > 0 && round < 100) {
            round++;

            int heroDamage = action.getDamage();
            bossHp -= heroDamage;
            if (bossHp < 0) bossHp = 0;
            result.addLine(String.format("Round %d: %s hits %s for %d (Boss HP -> %d)",
                    round, hero.getName(), boss.getName(), heroDamage, bossHp));

            if (bossHp <= 0) break;

            int bossDamage = boss.getAttackPower();
            heroHp -= bossDamage;
            if (heroHp < 0) heroHp = 0;
            result.addLine(String.format("Round %d: %s hits %s for %d (Hero HP -> %d)",
                    round, boss.getName(), hero.getName(), bossDamage, heroHp));
        }

        String winner;
        if (heroHp > 0 && bossHp <= 0) winner = hero.getName();
        else if (bossHp > 0 && heroHp <= 0) winner = boss.getName();
        else winner = "Draw";

        result.setWinner(winner);
        result.setRounds(round);
        return result;
    }
}