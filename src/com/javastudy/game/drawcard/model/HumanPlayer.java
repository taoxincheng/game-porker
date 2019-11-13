package com.javastudy.game.drawcard.model;

import com.yizhuoyan.util.ConsoleUtil;

public class HumanPlayer  extends AbstractPlayer{
	
	
	public HumanPlayer() {
	}
	
	@Override
	String initName() {
		String name;
		while(true) {
			name=ConsoleUtil.readString("请输入您的姓名>");
			if(name.length()==0) {
				System.out.println("你没有输入名字，请重新输入");
				continue;
			}
			break;
		}
		return name;
	}
	

	/**
	 * 抽牌的行为
	 * 
	 * @param cards
	 */
	public void drawCard(Porker porker) {
		int index;
		int leftAmount=porker.leftCardCount();
		while(true) {
			index=ConsoleUtil.readPositiveInt(this.getName()+",请输入您要抽取的牌(1"+leftAmount+"):1>");
			if(index>52) {
				System.out.println("输入错误，请输入1-"+leftAmount);
				continue;
			}
			break;
		}
		Card card=porker.drawCard(index-1);
		
		this.setHandCard(card);
	}
	
	public boolean isContinuePlay() {
		return ConsoleUtil.readBoolean(this.getName()+",是否继续游戏?默认y是，其他否:y>", true);
	}
}
