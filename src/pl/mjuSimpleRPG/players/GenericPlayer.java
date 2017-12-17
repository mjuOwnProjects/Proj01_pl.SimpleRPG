package pl.mjuSimpleRPG.players;

import pl.mjuSimpleRPG.addons.GenericAddon;
import pl.mjuSimpleRPG.enemies.Enemy;

public class GenericPlayer {

    private int healthPoints = 10;
    private int defencePoints = 10;
    private int attackPoints = 10;
    private GenericAddon genericAddon1 = new GenericAddon();
    private GenericAddon genericAddon2 = new GenericAddon();
    private String playerName = "Player";

    public GenericPlayer() {
    }

    public GenericPlayer(int healthPoints, int defencePoints, int attackPoints, String playerName) {
        this.healthPoints = healthPoints;
        this.defencePoints = defencePoints;
        this.attackPoints = attackPoints;
        this.playerName = playerName;
    }

    public void attack(Enemy enemy) {
        int enemyHP = enemy.getHealthPointsWithAddon();
        int enemyDP = enemy.getDefencePointsWithAddon();

        int attackResult = (enemyHP+enemyDP) - (this.getAttackPointsWithAddon());

        if ((attackResult-enemyDP)<=0) {
            enemy.setHealthPoints(0);
            System.out.print(enemy.getEnemyName() + " przegrywa. ");
        } else {
            enemy.setHealthPoints(attackResult-enemyDP);
        }
    }

    public void stealAddonFromEnemy (Enemy enemy) {
        if (enemy.isCanUseAddons() && checkIfEnemyHasAddon(enemy)) {
            System.out.println("Czy chcesz ukraść " + (enemy.getGenericAddon1().getAddonName()).toLowerCase() + "?");
        } else {
            System.out.println(enemy.getEnemyName() +" nie korzystał z żadnych przedmiotów, więc nic mu nie rąbnę");
        }
    }

    private boolean checkIfEnemyHasAddon (Enemy enemy) {
        if (null!=enemy.getGenericAddon1().getAddonName()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return playerName;
    }


    //------------------------------- getter setter


    public int getHealthPoints() {
        return healthPoints;
    }

    public int getHealthPointsWithAddon() {
        int playerHealthPoints = this.healthPoints;

        if (genericAddon1.getPossibleForPlayer()) {
            playerHealthPoints+= genericAddon1.getHealthPointsBonus();
        }

        if (genericAddon2.getPossibleForPlayer()) {
            playerHealthPoints+= genericAddon2.getHealthPointsBonus();
        }
        return playerHealthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public int getDefencePointsWithAddon() {
        int playerDefencePoints = this.defencePoints;

        if (genericAddon1.getPossibleForPlayer()) {
            playerDefencePoints+= genericAddon1.getDefencePointsBonus();
        }

        if (genericAddon2.getPossibleForPlayer()) {
            playerDefencePoints+= genericAddon2.getDefencePointsBonus();
        }

        return playerDefencePoints;
    }

    public void setDefencePoints(int defencePoints) {
        this.defencePoints = defencePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getAttackPointsWithAddon() {
        int playerAttackPoints = this.attackPoints;

        if (genericAddon1.getPossibleForPlayer()) {
            playerAttackPoints+= genericAddon1.getAttackPointsBonus();
        }

        if (genericAddon2.getPossibleForPlayer()) {
            playerAttackPoints+= genericAddon2.getAttackPointsBonus();
        }

        return playerAttackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public GenericAddon getGenericAddon1() {
        return genericAddon1;
    }

    public void setGenericAddon1(GenericAddon genericAddon1) {
        this.genericAddon1 = genericAddon1;
    }

    public GenericAddon getGenericAddon2() {
        return genericAddon2;
    }

    public void setGenericAddon2(GenericAddon genericAddon2) {
        this.genericAddon2 = genericAddon2;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
