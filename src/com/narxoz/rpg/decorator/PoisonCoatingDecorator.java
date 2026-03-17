package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " [Poison]";
    }

    @Override
    public int getDamage() {
        return super.getDamage() + 3;
    }

    @Override
    public String getEffectSummary() {
        String base = super.getEffectSummary();
        return base + (base.isEmpty() ? "" : ";") + "poison:dot=2:dur=3";
    }
}