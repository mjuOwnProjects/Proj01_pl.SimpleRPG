package pl.mjuSimpleRPG.addons;

public class AddonM16 extends GenericAddon {

    public AddonM16() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(0);
        super.setAttackPointsBonus(30);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(true);
        super.setAddonName("Karabin M16");
    }
}
