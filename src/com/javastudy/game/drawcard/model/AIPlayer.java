package com.javastudy.game.drawcard.model;

import com.yizhuoyan.util.RandomUtil;

/**
 * 电脑玩家
 * @author Administrator
 *
 */
public class AIPlayer extends AbstractPlayer{
	private String name;
	public AIPlayer(String name) {
		this.name=name;
	}		
		
	
	/**
	 * 抽牌的行为
	 * 
	 * @param cards
	 */
	public void drawCard(Porker porker) {
		int index=RandomUtil.randomMinMax(0, porker.leftCardCount());
		Card card=porker.drawCard(index);
		this.setHandCard(card);
		
	}
	@Override
	String initName() {
		return this.name;
	}
	
	@Override
	public boolean isContinuePlay() {
		return true;
	}
	
}
