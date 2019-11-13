package com.javastudy.game.drawcard.model;

/**
 * 游戏控制类
 * 
 * @author Administrator
 *
 */
public class Game {
	private Porker porker;

	//游戏玩家
	private AbstractPlayer[] playes=new AbstractPlayer[10];
	//玩家数量
	private int playerCount=0;

	public Game() {
		// 创建参与游戏的对象
		this.porker = new Porker();
	}

	/**
	 * 添加玩家
	 * @param p
	 */
	public void addPlayer(AbstractPlayer p) {
		this.playes[this.playerCount++]=p;
	}
	/**
	 * 游戏开始
	 */
	public void start() {
		// 1 游戏说明
		welcome();
		
		AbstractPlayer[] ps=this.playes;
		//2 让玩家依次设置姓名
		for (int i = 0; i < this.playerCount; i++) {
			String name=ps[i].initName();
			ps[i].setName(name);
		}
		
		System.out.println("正在创建扑克牌...");
		while (true) {
			if(this.playerCount<2) {
				System.out.println("玩家不足，无法开始游戏");
				break;
			}
			// 3洗牌
			System.out.println("正在洗牌...");
			porker.shuffle();
			// 4抽牌
			System.out.println("牌已经洗好，开始抽牌");
			
			for (int i = 0; i < this.playerCount; i++) {
				ps[i].drawCard(porker);
			}
			// 5展示牌
			for (int i = 0; i < this.playerCount; i++) {
				ps[i].showHandCard();
			}
			// 6比大小
			AbstractPlayer winner= this.whoWin();

			// 7显示结果
			System.out.println(winner.getName()+"赢了");
			// 8是否继续
			
			for (int i = 0; i < this.playerCount; i++) {
				
				if(!ps[i].isContinuePlay()) {
					//删除玩家
					for(int j=i;j<this.playerCount-1;j++) {
						ps[j]=ps[j+1];
					}
					this.playerCount--;
				}
			}
		}
		
		System.out.println("再见!");

	}

	private void welcome() {
		System.out.println("欢迎游戏");
		System.out.println("----------------");
		System.out.println("当前玩家数量:"+this.playerCount);
	}

	/**
	 * 返回胜利玩家
	 * @return
	 */
	private AbstractPlayer whoWin() {
		AbstractPlayer[] ps=this.playes;
		AbstractPlayer winner=ps[0];
		for (int i = 1; i < this.playerCount; i++) {
			if(winner.getHandCard().compare(ps[i].getHandCard())<0) {
				winner=ps[i];
			}
		}
		return winner;
	}

}
