package pl.mjuSimpleRPG.addons;

import java.util.List;
import java.util.Random;

/**
 * This class is mainly for setting general addon, and will be extendended by other classess
 */

public class GenericAddon {

    private int healthPointsBonus = 0;
    private int defencePointsBonus = 0;
    private int attackPointsBonus = 0;
    private boolean possibleForPlayer = true;
    private boolean possibleForEnemy = true;
    private String addonName = null;

    public GenericAddon() {
    }

    /**
     *
     * @param healthPointsBonus define bonus which is given by Addon on Health Points. Might be negative
     * @param defencePointsBonus define bonus which is given by Addon on Defence Points. Might be negative
     * @param attackPointsBonus define bonus which is given by Addon on Attack Points. Might be negative
     * @param possibleForPlayer define if this Addon might be used by Human Player
     * @param possibleForEnemy define if this can be used by CPU
     * @param addonName name of the addon
     */
    public GenericAddon(int healthPointsBonus, int defencePointsBonus, int attackPointsBonus, boolean possibleForPlayer, boolean possibleForEnemy, String addonName) {
        this.healthPointsBonus = healthPointsBonus;
        this.defencePointsBonus = defencePointsBonus;
        this.attackPointsBonus = attackPointsBonus;
        this.possibleForPlayer = possibleForPlayer;
        this.possibleForEnemy = possibleForEnemy;
        this.addonName = addonName;
    }

    public int getHealthPointsBonus() {
        return healthPointsBonus;
    }

    public void setHealthPointsBonus(int healthPointsBonus) {
        this.healthPointsBonus = healthPointsBonus;
    }

    public int getDefencePointsBonus() {
        return defencePointsBonus;
    }

    public void setDefencePointsBonus(int defencePointsBonus) {
        this.defencePointsBonus = defencePointsBonus;
    }

    public int getAttackPointsBonus() {
        return attackPointsBonus;
    }

    public void setAttackPointsBonus(int attackPointsBonus) {
        this.attackPointsBonus = attackPointsBonus;
    }

    public boolean getPossibleForPlayer() {
        return possibleForPlayer;
    }

    public void setPossibleForPlayer(boolean possibleForPlayer) {
        this.possibleForPlayer = possibleForPlayer;
    }

    public boolean getPossibleForEnemy() {
        return possibleForEnemy;
    }

    public void setPossibleForEnemy(boolean possibleForEnemy) {
        this.possibleForEnemy = possibleForEnemy;
    }

    public String getAddonName() {
        return addonName;
    }

    public void setAddonName(String addonName) {
        this.addonName = addonName;
    }
}
