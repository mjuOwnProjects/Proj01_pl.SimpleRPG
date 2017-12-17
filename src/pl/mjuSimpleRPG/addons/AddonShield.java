package pl.mjuSimpleRPG.addons;

public class AddonShield extends GenericAddon {

    public AddonShield() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(10);
        super.setAttackPointsBonus(0);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(false);
        super.setAddonName("Tarcza");
    }
}
