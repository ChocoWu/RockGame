package game1;

import java.util.Scanner;

public class GameFa extends GameGra {

	String startGame() {
		//��ʼ������
		System.out.println("��ѡ����Ϸģʽ��");
		System.out.println("0-ʯͷ��������1-ʯͷ����������ʷ���ˣ�2-�ϻ����Ӽ�");
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
		n=(int) ((Math.random()*10)%x);//xΪ��ȭ��Ϸ�в�ͬģʽ�ĸ���������ʯͷ������Ϊ3��Ȼ���ϻ����Ӽ�ҲΪ3
		System.out.println(n);
		return n;
	}

	@Override
	void showMessage(int n) {
		// TODO Auto-generated method stub
		if(n==0)
			System.out.println("ƽ��");
		else if(n==1)
			System.out.println("����ȡ��ʤ��");
		else
			System.out.println("��ȡ��ʤ��");
	}

	@Override
	void showResult(int countPeo,int countCon) 
	{
		// TODO Auto-generated method stub
		if(countPeo>countCon)
			System.out.println("��ϲ�㣬Ӯ��ʤ��");
		else if (countPeo<countCon)
			System.out.println("����ȡ������ʤ��");
		else
			System.out.println("ƽ��");
	}
	
	public void showGameName(int peoShow,int comShow,int n)
	{
		
	}

}
