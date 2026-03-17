package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " [CriticalFocus]";
    }

    @Override
    public int getDamage() {
        return (int) Math.floor(super.getDamage() * 1.5);
    }

    @Override
    public String getEffectSummary() {
        String base = super.getEffectSummary();
        return base + (base.isEmpty() ? "" : ";") + "crit:mult=1.5";
    }
}