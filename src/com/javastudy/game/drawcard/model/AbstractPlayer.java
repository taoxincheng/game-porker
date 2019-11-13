package com.javastudy.game.drawcard.model;
/**
 * 玩家
 * @author Administrator
 *
 */
public abstract class AbstractPlayer {
	// 名字
	private String name;
	// 当前手牌
	private Card handCard;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Card getHandCard() {
		return handCard;
	}


	public void setHandCard(Card handCard) {
		this.handCard = handCard;
	}


	/**
	 * 展示手牌
	 * 
	 * @return
	 */
	public void showHandCard() {
		Card card=this.handCard;
		System.out.println(this.name+"的牌是:"+card.format());
	}
	
	
	abstract public void drawCard(Porker porker);
	
	abstract public boolean isContinuePlay();
	/**
	 * 初始化名称
	 * @return
	 */
	abstract String initName();
	
	
	
}
