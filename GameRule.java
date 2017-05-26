package game1;


interface GameRule {
	public int rockRule(int peoShow , int conShow);
	//end
}

//����ӿھͶ�������ˣ�����������ʵ��
//ʯͷ��������������Ϸ����
class RockRule1 implements GameRule
{
	@Override	
	 public int rockRule(int peoShow , int conShow)
	{
		int[][] a=new int[][]{{0,1,2},{2,0,1},{1,2,0}};
		return a[peoShow][conShow];
	}
}
	//ʯͷ�����ӡ��������桢ʷ���˵���Ϸ����
	class RockRule2  implements GameRule
	{
		@Override
		public  int rockRule(int peoShow,int conShow)
		{
			int[][] a=new int[][]{{0,1,2,1,2},{2,0,1,1,2},{1,2,0,2,1},{2,2,1,0,1},{1,1,2,2,0}};
			return a[peoShow][conShow];
		}
	}
//�ϻ������ӡ�������Ϸ����
	class TigerRule implements GameRule
	{
		@Override
		public int rockRule(int peoShow,int conShow)
		{
			int[][] a=new int[][]{{0,1,2},{2,0,1},{1,2,0}};
			return a[peoShow][conShow];
		}
	}



