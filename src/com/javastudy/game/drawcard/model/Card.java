package com.javastudy.game.drawcard.model;
/**
 * 一张扑克牌
 * @author Administrator
 *
 */
public class Card {
	
	
	public final int color;
	public final int dot;
	
	public Card(int color,int dot) {
		this.color=color;
		this.dot=dot;
	}
	
	public int getColor() {
		return color;
	}
	public int getDot() {
		return dot;
	}
	
	/**
	 * 可其他比大小
	 * @param other 其他牌
	 * @return 
	 * 当前>other，则返回正数
	 * 当前<other，则返回负数
	 * 一样，则返回0
	 */
	public int compare(Card other) {
		if(this.dot==other.dot) {
			return this.color-other.color;
		}
		return this.dot-other.dot;
	}
	/**
	 * 返回扑克牌的格式化形式
	 * @return
	 */
	public String format() {
		return formatCardColor(this.color)+formatCardDot(this.dot);
	}
	/**
	 * 格式化花色
	 * @param color
	 * @return
	 */
	private static String formatCardColor(int color) {
		return new String[] {"♦","♣","♥","♠"}[color-1];
	}
	/**
	 * 格式化点数
	 * @param dot
	 * @return
	 */
	private static String formatCardDot(int dot) {
		switch (dot) {
		case 11:
			return "J";
		case 12:
			return "Q";	
		case 13:
			return "K";
		case 14:	
			return "A";
		}
		return dot+"";
	}
}
