package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " [FireRune]";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {
        String base = super.getEffectSummary();
        return base + (base.isEmpty() ? "" : ";") + "fire:burn=3:dur=2";
    }
}