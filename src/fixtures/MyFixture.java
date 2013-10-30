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
	
	public int playersClayBeforeFireplace;
	
	public int playerClayBeforeOven;
	public int playerStoneBeforeOven;
	public boolean clayOrStone;
	
	public int playerStoneBeforeJoinery;
	public int playerWoodBeforeJoinery;
	public boolean woodOrStone;
	
	public int playerClayBeforePottery;
	public int playerStoneBeforePottery;
	
	public int playerReedBeforeBasket;
	public int playerStoneBeforeBasket;
	public boolean reedOrStone;
	
	public int playerWoodBeforeWell;
	public int playerStoneBeforeWell;
	
	public int grain;
	public int vege;
	public int rooms;
	public int sheep;
	public int cattle;
	public int boar;
	public int fields;
	public int pastures;
	public int stables;
	
	public int woodBefore;
	public int clayBefore;
	public int stoneBefore;
	public int reedBefore;
	public boolean woodOrReed, clayOrReed, stoneOrReed;
	public boolean whichOption;
	
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
	public int buildWoodRoomCheckCost() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].wood = woodBefore;
		ac.players[0].reed = reedBefore;
		ac.turn = 13;
		ac.update(false);
		
		ac.wRoom = true;
		ac.b[1][1].doClick();
		
		if (woodOrReed)
			return ac.players[0].getWood();
		return ac.players[0].getReed();
	}
	// r-011
	public int buildClayRoomCheckCost() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].clay = clayBefore;
		ac.players[0].reed = reedBefore;
		ac.turn = 13;
		ac.players[0].roomtype = 'c';
		ac.farm[0][3][1].type = 'c';
		ac.update(false);
		
		ac.wRoom = true;
		ac.b[1][1].doClick();
		
		if (clayOrReed)
			return ac.players[0].getClay();
		return ac.players[0].getReed();
	}
	// r-011
	public int buildStoneRoomCheckCost() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].stone = stoneBefore;
		ac.players[0].reed = reedBefore;
		ac.turn = 13;
		ac.players[0].roomtype = 't';
		ac.farm[0][3][1].type = 't';
		ac.update(false);
		
		ac.wRoom = true;
		ac.b[1][1].doClick();
		
		if (stoneOrReed)
			return ac.players[0].getStone();
		return ac.players[0].getReed();
	}
	// r-011
	public int buildFenceCheckCost() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].wood = woodBefore;
		ac.players[0].reed = reedBefore;
		ac.turn = 13;
		ac.update(false);
		
		ac.wFences = true;
		ac.b[0][1].doClick();
		ac.b[1][0].doClick();
		ac.b[2][1].doClick();
		ac.b[1][2].doClick();
		return ac.players[0].getWood();
	}
	// r-011
	public int buildStableCheckCost() {
		AgricolaController ac = new AgricolaController(1);
		ac.players[0].wood = woodBefore;
		ac.turn = 13;
		ac.update(false);
		if (whichOption){
			ac.wStable = true;
		}
		else {
			ac.wStableRoom = true;
		}
		ac.b[1][1].doClick();
		
		return ac.players[0].getWood();
	}
	
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
	
	// r-016
	public int playerCalcScore() {
		AgricolaController ac = new AgricolaController(1);
		
		ac.players[0].addGrain(grain);
		for (int i = 0; i < vege; ++i)
			ac.players[0].addVege();
		ac.players[0].addRooms(rooms);
		ac.players[0].addSheep(sheep);
		ac.players[0].addCattle(cattle);
		ac.players[0].addBoar(boar);
		for (int i = 0; i < fields; ++i)
			ac.players[0].addField();
		ac.players[0].addPasture(pastures);
		ac.players[0].addStable(stables);
		ac.players[0].calcScore();
	
		return ac.players[0].getScore();
	}
	
	
	// r-017
	public int getPlayersClayAfterBuildingFireplaces() {
		AgricolaController ac =  new AgricolaController(2);
		ac.improveChoice = 0;
		ac.players[0].clay = playersClayBeforeFireplace;
		ac.players[1].clay = playersClayBeforeFireplace;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		ac.b_wood.doClick();
		ac.b_reed.doClick();
		ac.b_improve.doClick();
		return ac.players[playerIndex].getClay();
	}
	
	
	// r-021
	public int playerBuildClayOven() {
		AgricolaController ac =  new AgricolaController(1);
		ac.improveChoice = 2; //clay oven
		ac.players[0].clay = playerClayBeforeOven;
		ac.players[0].stone = playerStoneBeforeOven;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		if (clayOrStone)
			return ac.players[0].getClay();
		return ac.players[0].getStone();
	}
	
	// r-023
	public int playerBuildStoneOven() {
		AgricolaController ac =  new AgricolaController(1);
		ac.improveChoice = 3; //stone oven
		ac.players[0].clay = playerClayBeforeOven;
		ac.players[0].stone = playerStoneBeforeOven;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		if (clayOrStone)
			return ac.players[0].getClay();
		return ac.players[0].getStone();
	}
	
	// r-025
	public int playerBuildJoinery() {
		AgricolaController ac =  new AgricolaController(1);
		ac.improveChoice = 4; //joinery
		ac.players[0].wood = playerWoodBeforeJoinery;
		ac.players[0].stone = playerStoneBeforeJoinery;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		if (woodOrStone)
			return ac.players[0].getWood();
		return ac.players[0].getStone();
	}
	
	// r-027
	public int playerBuildPottery() {
		AgricolaController ac =  new AgricolaController(1);
		ac.improveChoice = 5; //pottery
		ac.players[0].clay = playerClayBeforePottery;
		ac.players[0].stone = playerStoneBeforePottery;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		if (clayOrStone)
			return ac.players[0].getClay();
		return ac.players[0].getStone();
	}
	
	// r-029
	public int playerBuildBasketmakersWorkshop() {
		AgricolaController ac =  new AgricolaController(1);
		ac.improveChoice = 6; //basketmaker workshop
		ac.players[0].reed = playerReedBeforeBasket;
		ac.players[0].stone = playerStoneBeforeBasket;
		ac.turn = 5;
		ac.update(false);
		ac.cur_player = 0;
		ac.b_improve.doClick();
		if (reedOrStone)
			return ac.players[0].getReed();
		return ac.players[0].getStone();
	}
	
	// r-031
		public int playerBuildWell() {
			AgricolaController ac =  new AgricolaController(1);
			ac.improveChoice = 7; //well
			ac.players[0].wood = playerWoodBeforeWell;
			ac.players[0].stone = playerStoneBeforeWell;
			ac.turn = 5;
			ac.update(false);
			ac.cur_player = 0;
			ac.b_improve.doClick();
			if (woodOrStone)
				return ac.players[0].getWood();
			return ac.players[0].getStone();
		}
	
}
