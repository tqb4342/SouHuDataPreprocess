package souhu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Tools {

	/*
	 * 处理News_pic_label_train.txt
	 */
	public static HashMap<String, String> ProcessLabel(String fileName) {
		HashMap<String, String> map = new HashMap<String, String>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;

            while ((tempString = reader.readLine()) != null) {
                /*
                 * /每一条文字的序号作为map的key,label作为map的value。
                 * 这样在处理News_info_train_filter.txt时只需要知道该条记录的序号，
                 * 通过map键值对就能自动知道这条记录属于哪个label，省去了判断。
                 */
            	map.put(tempString.split("	")[0], tempString.split("	")[1]);   
             //   break;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		return map;
    }
	

	/*
	 * 处理News_info_train_filter.txt
	 */
	public static void Processinfo_train(String fileName,HashMap<String, String> map) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            String str;
            String filename;
            while ((tempString = reader.readLine()) != null) {
            	str = tempString.split("	")[0];   //提取记录的序号
            	filename = map.get(str)+".txt";      //将序号传给map得到属于的类别（label）
            	System.out.println(map.get(str)+"   "+ tempString);
            	writeToFile1(filename,tempString+"\n");   //写入对应类别的文件
             //   break;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
	/*
	 * 写入txt文件
	 */
	public static void writeToFile1(String fileName,String content){
	     
	    try {
	      //  String content = "测试使用字符串";
	        File file = new File(fileName);
	        if(file.exists()){
	            FileWriter fw = new FileWriter(file,true);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(content);
	            bw.close(); fw.close();
	           // System.out.println("test1 done!");
	        }
	         
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	}
	public static void main(String[] args) {
		HashMap<String, String> map = ProcessLabel("News_pic_label_train.txt");
		Processinfo_train("News_info_train_filter.txt",map);
	}
}
