package pl.mjuSimpleRPG.addons;

public class AddonTNT extends GenericAddon {

    public AddonTNT() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(-20);
        super.setAttackPointsBonus(40);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(true);
        super.setAddonName("Dynamit");
    }
}
