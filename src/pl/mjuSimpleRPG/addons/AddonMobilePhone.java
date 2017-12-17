package pl.mjuSimpleRPG.addons;

public class AddonMobilePhone extends GenericAddon {

    public AddonMobilePhone() {
        super();
        super.setHealthPointsBonus(0);
        super.setDefencePointsBonus(5);
        super.setAttackPointsBonus(0);
        super.setPossibleForPlayer(true);
        super.setPossibleForEnemy(false);
        super.setAddonName("Telefon komórkowy");
    }
}
