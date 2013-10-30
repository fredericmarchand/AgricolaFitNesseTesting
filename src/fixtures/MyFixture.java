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
	
	public int animalType, animalsBeforeHarvest;
	
	public boolean orthAdj;
	
	public int playerWood;
	public int playerReed;
	
	public int stableCost;
	
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
	
	// r-008
	public int animalsAfterHarvest() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].space = 20;
		
		if (animalType == 0)
			ac.players[0].sheep = animalsBeforeHarvest;
		else if (animalType == 1)
			ac.players[0].boar = animalsBeforeHarvest;
		else if (animalType == 2)
			ac.players[0].cattle = animalsBeforeHarvest;
		
		ac.turn = 4;
		ac.players[0].activefam = 0;
		ac.players[0].food = 6;
		ac.update(false);
		
		if (animalType == 0)
			return ac.players[0].sheep;
		else if (animalType == 1)
			return ac.players[0].boar;
		else if (animalType == 2)
			return ac.players[0].cattle;
		return 0;
	}

	// r-009
	public char playerBuildPastures() {
		AgricolaController ac = new AgricolaController(1);
		ac.turn = 3;
		ac.update(false);
		ac.players[0].wood = 15;
		ac.b_fences.doClick();
		ac.b[farmX-1][farmY].doClick();
		ac.b[farmX+1][farmY].doClick();
		ac.b[farmX][farmY+1].doClick();
		ac.b[farmX][farmY-1].doClick();
		
		if (orthAdj)
			farmY+=2;
		else farmY+=4;
		
		ac.b[farmX-1][farmY].doClick();
		ac.b[farmX+1][farmY].doClick();
		ac.b[farmX][farmY+1].doClick();
		ac.b[farmX][farmY-1].doClick();
		ac.b_finish.doClick();
		return ac.farm[0][farmX][farmY].getType();
	}
	
	// r-010
	public char playerBuildField() {
		AgricolaController ac = new AgricolaController(1);
		ac.b_field.doClick();
		ac.b[farmX][farmY].doClick();
		ac.b_wood.doClick();
		
		if (orthAdj)
			farmY+=2;
		else farmY+=4;
		ac.b_field.doClick();
		ac.b[farmX][farmY].doClick();
		return ac.farm[0][farmX][farmY].getType();
	}
	
	// r-011
	//@TODO last
	
	// r-012
	public char playerBuildRoomCheck() {
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = playerWood;
		ac.players[0].reed = playerReed;
		ac.update(false);
		ac.b_room.doClick();

		ac.b[farmX][farmY].doClick();
		return ac.farm[0][farmX][farmY].getType();
	}
	// r-012
	public int getFirstPlayerWood() {
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = playerWood;
		ac.players[0].reed = playerReed;
		ac.update(false);
		ac.b_room.doClick();

		ac.b[farmX][farmY].doClick();
		return ac.players[0].getWood();
	}
	// r-012
	public int getFirstPlayerReed() {
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = playerWood;
		ac.players[0].reed = playerReed;
		ac.update(false);
		ac.b_room.doClick();

		ac.b[farmX][farmY].doClick();
		return ac.players[0].getReed();
	}
	
	// r-013
	public char playerBuildStableCheck() {
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = playerWood;
		ac.update(false);
		if (stableCost == 1)
			ac.b_stable.doClick();
		else ac.b_room.doClick();

		ac.b[farmX][farmY].doClick();
		return ac.farm[0][farmX][farmY].getType();
	}
	// r-013
	public int playerBuildStableCheckRemainingWood() {
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = playerWood;
		ac.update(false);
		if (stableCost == 1)
			ac.b_stable.doClick();
		else ac.b_room.doClick();

		ac.b[farmX][farmY].doClick();
		return ac.players[0].getWood();
	}
	
	// r-014
	public int playerBuilFiveStables() {
		int stables = 0;
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = 10;
		ac.update(false);
		ac.b_stable.doClick();

		ac.b[farmX][farmY].doClick();
		ac.wStable = false;
		ac.update(false);
		ac.b_stable.doClick();
		ac.b[farmX+2][farmY].doClick();
		ac.wStable = false;
		ac.update(false);
		ac.b_stable.doClick();
		ac.b[farmX-2][farmY].doClick();
		ac.wStable = false;
		ac.update(false);
		ac.b_stable.doClick();
		ac.b[farmX][farmY-2].doClick();
		ac.wStable = false;
		ac.update(false);
		ac.b_stable.doClick();
		ac.b[farmX][farmY+2].doClick();
		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 11; col++) {
				if (ac.farm[0][row][col].getType() == 's')
					stables++;
			}
		}
		return stables;
	}
	
	// r-015
	public int playerBuilSixteenFences() {
		int fences = 0;
		AgricolaController ac = new AgricolaController(1);

		ac.players[0].wood = 17;
		ac.update(false);
		ac.b_fences.doClick();
		ac.view.getButtons()[1][2].doClick();
		ac.view.getButtons()[1][4].doClick();
		ac.view.getButtons()[1][6].doClick();
		ac.view.getButtons()[0][3].doClick();
		ac.view.getButtons()[0][5].doClick();
		ac.view.getButtons()[2][3].doClick();
		ac.view.getButtons()[2][5].doClick();
		ac.view.getButtons()[0][7].doClick();
		ac.view.getButtons()[2][7].doClick();
		ac.view.getButtons()[1][8].doClick();
		ac.view.getButtons()[0][9].doClick();
		ac.view.getButtons()[2][9].doClick();
		ac.view.getButtons()[1][10].doClick();
		ac.view.getButtons()[3][4].doClick();
		ac.view.getButtons()[3][6].doClick();
		ac.view.getButtons()[3][8].doClick();

		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 11; col++) {
				if (ac.farm[0][row][col].getType() == 'x')
					fences++;
			}
		}
		return fences;
	}
}
