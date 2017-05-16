package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FileOpSon extends FileOp {
	
	//读文件
	public String readFile(File file) {
		// TODO Auto-generated method stubc
		String str="";
		char []a=new char[1024];
		int n;
		if(!file.exists())
		{
			return null;
		}
		try {
			FileReader reader=new FileReader(file);
			try {
				if((n=reader.read())!=-1)
				{
					str+=new String(a,0,n);
					return str;
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//写文件
	public boolean writeFile(File file, String str){
		// TODO Auto-generated method stub
		try {
			if(!file.exists())
			{
				createFile("result.txt");
			}
			FileWriter writer=new FileWriter(file);
			writer.write(str);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	 
	//将JSON转化为Map
	public Map jsonToMap(File file)
	{
		String s;
		s=readFile(file);
		if (s==null) s="{}";
		Map<String, String> mapread=JSON.parseObject(s, new TypeReference<Map<String,String>>(){});
		return mapread;
	}
	
	//将Map转化为JSON
	public void mapToJson(Map<String,String> map,File file) {
        String s = JSON.toJSONString(map);
        writeFile(file,s);
//        System.out.println(s);
//        Map<String, String> mapRead = JSON.parseObject(s,new TypeReference< Map<String, String>>() {});
//        System.out.println(mapRead.get("1"));
    }
	
	
	
	public String queryFile(File file,String s)//根据用户的ID号查询数据
	{
		Map<String, String> map=new HashMap<String, String>();
		//把读到的数据放到Map中
		map=jsonToMap(file);
		for(Map.Entry<String, String>entry:map.entrySet())
		{
			if(entry.getKey().equals(s))
			{
				System.out.println("ID= "+entry.getKey()+",score= "+entry.getValue());
				return entry.getKey();
			}
		}
		return null;
	}
	
	public boolean updateFile(File file,String id,String score,Map<String, String>map)
	{
		map.put(id, score);
		String s=JSON.toJSONString(map);
		if(writeFile(file,s))
			return true;
		return false;
	}
	
	
	
	
//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//        map.put("1", "100");
//        map.put("2", "99");
//        map.put("3", "98");
//		FileOpSon son = new FileOpSon();
//		//son.mapToJson(map);
//	}
	/*
	 * loadInfo(Map<object obj,object obj> map)
	 *  String s=Jason.toJasonString(map)
	 *  write (file ,s)
	 *  
	 *  read (file,s )
	 *  map=Json.parsoobject(s,new TypeFerence Map<int,string>)
	 */
}
