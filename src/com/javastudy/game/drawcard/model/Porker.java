package com.javastudy.game.drawcard.model;

import com.yizhuoyan.util.RandomUtil;

/**
 * 一副扑克
 * @author Administrator
 *
 */
public class Porker {
	//所有的牌
	final Card[] cards=new Card[52];
	//剩余的牌
	private Card[] leftCards;
	
	
	public Card[] getLeftCards() {
		return leftCards;
	}

	public Card[] getCards() {
		return cards;
	}

	public Porker() {
		//初始化扑克牌
		this.init();
		//默认剩余的牌和初始化的牌一样
		this.leftCards=this.cards;
	}
	
	private void init() {
		int i=0;
		for(int color=1;color<=4;color++) {
			for(int dot=2;dot<=14;dot++) {
				//创建一张牌
				Card card=new Card(color,dot);
				//放入数组中
				this.cards[i++]=card;
			}
		}
	}
	/**
	 * 从扑克中抽取一张牌
	 * @param index
	 * @return
	 */
	public Card drawCard(int index) {
		//获取被抽调的牌
		Card drawCard=this.leftCards[index];
		//创建剩余牌的数组
		Card[] leftCards=new Card[this.leftCards.length-1];
		
		//拷贝剩余的牌
		System.arraycopy(this.leftCards, 0, leftCards, 0,index);
		System.arraycopy(this.leftCards, index+1, leftCards, index,this.leftCards.length-index-1);
		//保存最小的剩余的牌的数组
		this.leftCards=leftCards;
		
		return drawCard;
	}
	
	/**
	 * 返回剩余牌的数量
	 * @return
	 */
	public int leftCardCount() {
		return this.leftCards.length;
	}
	
	/**
	 * 洗牌
	 */
	public void shuffle() {
		//剩余的牌恢复到开始状态
		this.leftCards=this.cards;
		
		Card[] cards=this.cards;
		for(int i=cards.length;i-->0;) {
			int ranIndex=RandomUtil.randomMinMax(0, cards.length);
			Card temp=cards[ranIndex];
			cards[ranIndex]=cards[0];
			cards[0]=temp;
		}
	}
	
	
}
