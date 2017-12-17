package pl.mjuSimpleRPG.service;

import pl.mjuSimpleRPG.players.GenericPlayer;
import java.util.List;

public class UserInterfaceService {

    public void displayPossiblePlayerCharacters(List<GenericPlayer> playerList) {
        for(GenericPlayer currentCharacter : playerList) {
            System.out.println(
                    "["+(playerList.indexOf(currentCharacter)+1)+"] "+currentCharacter.getPlayerName() +
                            " (HP: " + currentCharacter.getHealthPoints() +
                            ", AP: " + currentCharacter.getAttackPoints() +
                            ", DP: " + currentCharacter.getDefencePoints() +
                            ")");
        }
        System.out.println("----------------------");
    }



}
