package game1;

 public abstract class GameGra {
	 
	abstract String startGame();
	abstract void endGame();
	abstract int peoShow();//用户输入
	abstract int conShow(int x);//电脑输入
	abstract void showMessage(int n);//显示提示
	abstract void showResult(int a,int b);//显示结果,分数
}
