package com.javastudy.game.drawcard;

import com.javastudy.game.drawcard.model.AIPlayer;
import com.javastudy.game.drawcard.model.Game;
import com.javastudy.game.drawcard.model.HumanPlayer;

public class App {

	public static void main(String[] args) {
		Game game=new Game();
		game.addPlayer(new HumanPlayer());
		game.addPlayer(new HumanPlayer());
		game.addPlayer(new AIPlayer("小冰"));
		game.addPlayer(new AIPlayer("小爱"));
		game.start();
	}
	
}
