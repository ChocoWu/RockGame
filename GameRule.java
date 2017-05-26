package game1;


interface GameRule {
	public int rockRule(int peoShow , int conShow);
	//end
}

//这个接口就定义结束了，下面是三个实现
//石头、剪刀、布的游戏规则
class RockRule1 implements GameRule
{
	@Override	
	 public int rockRule(int peoShow , int conShow)
	{
		int[][] a=new int[][]{{0,1,2},{2,0,1},{1,2,0}};
		return a[peoShow][conShow];
	}
}
	//石头、剪子、布、蜥蜴、史波克的游戏规则
	class RockRule2  implements GameRule
	{
		@Override
		public  int rockRule(int peoShow,int conShow)
		{
			int[][] a=new int[][]{{0,1,2,1,2},{2,0,1,1,2},{1,2,0,2,1},{2,2,1,0,1},{1,1,2,2,0}};
			return a[peoShow][conShow];
		}
	}
//老虎、棒子、鸡的游戏规则
	class TigerRule implements GameRule
	{
		@Override
		public int rockRule(int peoShow,int conShow)
		{
			int[][] a=new int[][]{{0,1,2},{2,0,1},{1,2,0}};
			return a[peoShow][conShow];
		}
	}



