package file;

import java.io.File;
import java.io.IOException;

public  abstract class FileOp {
	
	private  File file;
	
	public File getFile() {
		return new File("doubi.data");
	}
	
	public File createFile(String fileName) throws IOException
	{
		File file=new File(fileName);
		file.createNewFile();
		//todo 
		return file;
	}
	
	public abstract String readFile(File file);
	
	public abstract boolean writeFile(File file,String str);
	
	public void deleFile(File file)
	{
		if(!file.exists())
			System.out.println("Ҫɾ�����ļ�������");
		else
		{
			if(file.isFile())
			{
				file.delete();
				System.out.println("�ļ�ɾ���ɹ�");
			}
			else
				System.out.println("�ļ�ɾ���쳣");	
		}
	}
}
