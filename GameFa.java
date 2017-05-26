package game1;

import java.util.Scanner;

public class GameFa extends GameGra {

	String startGame() {
		//初始化操作
		System.out.println("请选择游戏模式：");
		System.out.println("0-石头剪刀布，1-石头剪刀布蜥蜴史波克，2-老虎棒子鸡");
		String n;
		Scanner in=new Scanner(System.in);
		n=in.next();
		return n;
	}

	void endGame() {
		// TODO Auto-generated method stub
		System.out.println("Gameover");
	}

	@Override
	int peoShow() {
		// TODO Auto-generated method stub
		int n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		return n;
		
	}

	@Override
	int conShow(int x) {
		// TODO Auto-generated method stub
		int n;
		n=(int) ((Math.random()*10)%x);//x为猜拳游戏中不同模式的个数，比如石头剪刀布为3，然后老虎棒子鸡也为3
		System.out.println(n);
		return n;
	}

	@Override
	void showMessage(int n) {
		// TODO Auto-generated method stub
		if(n==0)
			System.out.println("平局");
		else if(n==1)
			System.out.println("电脑取得胜利");
		else
			System.out.println("你取得胜利");
	}

	@Override
	void showResult(int countPeo,int countCon) 
	{
		// TODO Auto-generated method stub
		if(countPeo>countCon)
			System.out.println("恭喜你，赢得胜利");
		else if (countPeo<countCon)
			System.out.println("电脑取得最后的胜利");
		else
			System.out.println("平局");
	}
	
	public void showGameName(int peoShow,int comShow,int n)
	{
		
	}

}
