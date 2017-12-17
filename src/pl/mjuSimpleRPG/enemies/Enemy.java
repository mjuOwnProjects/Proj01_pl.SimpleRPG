package pl.mjuSimpleRPG.enemies;

import pl.mjuSimpleRPG.players.GenericPlayer;
import pl.mjuSimpleRPG.addons.GenericAddon;

public class Enemy {

    private int healthPoints = 10;
    private int defencePoints = 10;
    private int attackPoints = 10;
    private boolean canUseAddons = true;
    private GenericAddon genericAddon1 = new GenericAddon();
    private String enemyName = "";

    public Enemy() {
    }

    public Enemy(int healthPoints, int defencePoints, int attackPoints, boolean canUseAddons, String enemyName) {
        this.healthPoints = healthPoints;
        this.defencePoints = defencePoints;
        this.attackPoints = attackPoints;
        this.canUseAddons = canUseAddons;
        this.enemyName = enemyName;
    }

    public void attack(GenericPlayer genericPlayer) {
        int playerHP = genericPlayer.getHealthPointsWithAddon();
        int playerDP = genericPlayer.getDefencePointsWithAddon();

        int attackResult = (playerHP+playerDP) - (this.getAttackPointsWithAddon());

        if ((attackResult-playerDP)<=0) {
            genericPlayer.setHealthPoints(0);
            System.out.print(genericPlayer.getPlayerName() + " przegrywa. 4");
        } else {
            genericPlayer.setHealthPoints(attackResult-playerDP);
        }
    }

    @Override
    public String toString() {
        return "Jestem wrogiem";
    }

    //------------------------------------ getter setter


    public int getHealthPoints() {
        return healthPoints;
    }

    public int getHealthPointsWithAddon() {
        if (this.canUseAddons && genericAddon1.getPossibleForEnemy()) {
            return healthPoints + genericAddon1.getHealthPointsBonus();
        } else return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public int getDefencePointsWithAddon() {
        if (this.canUseAddons && genericAddon1.getPossibleForEnemy()) {
            return defencePoints+ genericAddon1.getDefencePointsBonus();
        } else return defencePoints;
    }

    public void setDefencePoints(int defencePoints) {
        this.defencePoints = defencePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getAttackPointsWithAddon() {
        if (this.canUseAddons && genericAddon1.getPossibleForEnemy()) {
            return attackPoints+ genericAddon1.getAttackPointsBonus();
        } else return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public boolean isCanUseAddons() {
        return canUseAddons;
    }

    public void setCanUseAddons(boolean canUseAddons) {
        this.canUseAddons = canUseAddons;
    }

    public GenericAddon getGenericAddon1() {
        return genericAddon1;
    }

    public void setGenericAddon1(GenericAddon genericAddon1) {
        this.genericAddon1 = genericAddon1;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }
}
