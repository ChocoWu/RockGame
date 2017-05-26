package game1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import file.FileOpSon;

public class GameSon extends GameFa implements GameRule{
	GameFa gameFa=new GameFa();
	private String n="y";
	private int peopleShow,computerShow;
	private int result;
	private int peopleScore;
	private int countp,countc;
	private Scanner in;
	private File file;
	
	//ʯͷ����������Ϸ
	public void Rock1()
	{
		System.out.println("���ȭ��0-ʯͷ��1-������2-��");
		peopleScore=startGame(new RockRule1(),0,0,3);
	}
	
	//ʯͷ�����ӡ��������桢ʷ���˵���Ϸ
	public void Rock2()
	{
		System.out.println("���ȭ��0-������1-����2-ʯͷ��3-���棬4-ʷ����");
		peopleScore=startGame(new RockRule2(),0,0,5);
	}
	
	//�ϻ����Ӽ�����Ϸ
	public void Tiger()
	{
		System.out.println("���ȭ��0-�ϻ���1-���ӣ�2-��");
		peopleScore=startGame(new TigerRule(),0,0,3);
	}
	
	public int startGame(GameRule gameRule,int countp,int countc,int m)
	{
		//�������Դ��ļ��ж�ȡ��Ȼ����Լ�����Ϸ��Ҳ�������¿�ʼ��Ϸ
		while(n.equalsIgnoreCase("y"))
		{
			peopleShow=gameFa.peoShow();
			computerShow=gameFa.conShow(m);//��Ϸ��ģʽ��һ��������Ĳ�����һ��
			result=gameRule.rockRule(peopleShow, computerShow);
			showMessage(result);
			if(result==1)
				countc++;
			else if(result==2)
				countp++;
			System.out.println("Continue......(Y/N)");
			in = new Scanner(System.in);
			n=in.next();
		}
		showResult(countp,countc);
		return countp;
		//������Ϸ��������
		
	}
	
	@SuppressWarnings("unchecked")
	public void Game() throws IOException
	{
		 Map<String, String> map=new HashMap<String, String>();
		 FileOpSon fileOpSon=new FileOpSon();
		 File file = fileOpSon.getFile();//�ļ����ִ�������
		 map=fileOpSon.jsonToMap(file); 
		 System.out.println("Input your gameID:");
		 BufferedReader buf1 = new BufferedReader (new InputStreamReader(System.in));  
		 String str1 = buf1.readLine();
		 System.out.println(str1+" oldScore is "+map.get(str1));
		 
		 System.out.println("Please give your computer a name:");
		 BufferedReader buf2 = new BufferedReader (new InputStreamReader(System.in));  
		 String str2 = buf2.readLine();
		 System.out.println(str1+" VS "+str2);
		 String n;
		 n=gameFa.startGame();
		 switch(n)
		 {
		 case "0":Rock1();break;
		 case "1":Rock2();break;
		 case "2":Tiger();break;
		 default :System.out.println("�������"); break;
		 }
		 String score;
		 score=String.valueOf(peopleScore);
		 map.put(str1,score);
		 fileOpSon.mapToJson(map,file);
	}

	@Override
	public int rockRule(int peoShow, int conShow) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
