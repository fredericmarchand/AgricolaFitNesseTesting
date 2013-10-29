package fixtures;

import math.MyMath;
import fit.ColumnFixture;
import agricola.AgricolaController;

public class MyFixture extends ColumnFixture {

	public int a;
	public int b;

	public int playerIndex;

	public boolean playerTakesWood;

	public int playerFoodBeforeHarvest;
	public int playerFamilyMembers;

	public int numplayers;
	
	public int farmX, farmY;
	
	// random test to try fitnesse
	public int sum() {
		int result;
		result = MyMath.sum(a, b);
		return result;
	}

	// r-001
	public int playersFoodMultiplayerGame() {
		AgricolaController ac = new AgricolaController(5);
		return ac.getPlayer(playerIndex).getFood();
	}

	// r-002
	public int playersRoomCount() {
		AgricolaController ac = new AgricolaController(5);
		return ac.getPlayer(playerIndex).getRooms();
	}

	// r-002
	public int playersFamilyMembersCount() {
		AgricolaController ac = new AgricolaController(5);
		return ac.getPlayer(playerIndex).getFamily();
	}

	// r-003
	public int onePlayerWoodReplenishment() {
		AgricolaController ac = new AgricolaController(1);
		ac.b_clay.doClick();
		if (playerTakesWood)
			ac.b_wood.doClick();
		else
			ac.b_reed.doClick();
		return ac.wood;
	}

	// r-004
	public int playersEatFoodAtHarvestSinglePlayer() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].food = playerFoodBeforeHarvest;
		ac.players[0].family = playerFamilyMembers;
		ac.players[0].activefam = 0;
		ac.turn = 4;
		ac.update(false);
		return ac.getPlayer(0).getFood();
	}

	// r-004
	public int playerScoreDeductByBegging() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].food = playerFoodBeforeHarvest;
		ac.players[0].family = playerFamilyMembers;
		ac.players[0].activefam = 0;
		ac.players[0].score = 0;
		ac.turn = 4;
		ac.update(false);
		return ac.getPlayer(0).getScore();
	}

	// r-005
	public int multiplayerWoodReplenishment() {
		AgricolaController ac = new AgricolaController(numplayers);
		for (int i = 0; i < numplayers; ++i) {
			ac.players[i].activefam = 0;
		}
		ac.turn = 2;
		ac.update(false);
		return ac.wood;
	}
	
	// r-005
	public int multiplayerWoodReplenishmentAndTakeWood() {
		AgricolaController ac = new AgricolaController(numplayers);
		if (playerTakesWood)
			ac.b_wood.doClick();
		for (int i = 0; i < numplayers; ++i) {
			ac.players[i].activefam = 0;
		}
		ac.turn = 2;
		ac.update(false);
		return ac.wood;
	}
	
	// r-006
	public int playersEatFoodAtHarvestMultiplayer() {
		AgricolaController ac = new AgricolaController(5);
		ac.players[playerIndex].food = playerFoodBeforeHarvest;
		ac.players[playerIndex].family = playerFamilyMembers;
		for (int i = 0; i < 5; ++i) {
			ac.players[i].activefam = 0;
		}
		ac.turn = 4;
		ac.update(false);
		return ac.getPlayer(playerIndex).getFood();
	}

	// r-006
	public int playerScoreDeductByBeggingMultiplayer() {
		AgricolaController ac = new AgricolaController(5);
		ac.players[playerIndex].food = playerFoodBeforeHarvest;
		ac.players[playerIndex].family = playerFamilyMembers;
		for (int i = 0; i < 5; ++i) {
			ac.players[i].activefam = 0;
		}
		ac.players[playerIndex].score = 0;
		ac.turn = 4;
		ac.update(false);
		return ac.getPlayer(playerIndex).getScore();
	}
	
	// r-007
	public char playerBuildRoom() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].wood = 5;
		ac.players[0].reed = 5;
		ac.wRoom = true;
		ac.b[farmX][farmY].doClick();
		return ac.farm[0][farmX][farmY].getType();
	}

}
