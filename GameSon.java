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
	
	//石头剪刀布的游戏
	public void Rock1()
	{
		System.out.println("请出拳：0-石头，1-剪刀，2-布");
		peopleScore=startGame(new RockRule1(),0,0,3);
	}
	
	//石头、剪子、布、蜥蜴、史波克的游戏
	public void Rock2()
	{
		System.out.println("请出拳：0-剪刀，1-布，2-石头，3-蜥蜴，4-史波克");
		peopleScore=startGame(new RockRule2(),0,0,5);
	}
	
	//老虎棒子鸡的游戏
	public void Tiger()
	{
		System.out.println("请出拳：0-老虎，1-棒子，2-鸡");
		peopleScore=startGame(new TigerRule(),0,0,3);
	}
	
	public int startGame(GameRule gameRule,int countp,int countc,int m)
	{
		//分数可以从文件中读取，然后可以继续游戏，也可以重新开始游戏
		while(n.equalsIgnoreCase("y"))
		{
			peopleShow=gameFa.peoShow();
			computerShow=gameFa.conShow(m);//游戏的模式不一样，里面的参数不一样
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
		//结束游戏保存数据
		
	}
	
	@SuppressWarnings("unchecked")
	public void Game() throws IOException
	{
		 Map<String, String> map=new HashMap<String, String>();
		 FileOpSon fileOpSon=new FileOpSon();
		 File file = fileOpSon.getFile();//文件部分存在问题
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
		 default :System.out.println("输入错误！"); break;
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
