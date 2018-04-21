package souhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MoveFile {
	
	
	/*
	 * 移动文件
	 */
	public static boolean MoveFi(String filename,String path){
		
		try {  
            File afile = new File(filename);  
            if (afile.renameTo(new File(path + afile.getName()))) {  
                System.out.println(filename+"File is moved successful!");  
                return true;
            } else {  
                System.out.println("File is failed to move!");  
                return false;
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		
		return false;
	}
	/*
	 * 读取文件
	 */
	public static String ReadFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String str="";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               // System.out.println("line " + line + ": " + tempString);
            	System.out.println(tempString);
            	str += tempString;
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
        return str;
    }

	
	public static void ClassRead(String fileName,String[] str) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               if(str[0].contains(tempString)) {    
            	   MoveFi("G:\\搜狐比赛数据集\\Pic_info_train.part1\\"+tempString,"0\\");   
            	   continue;
               }
               if(str[1].contains(tempString)) {
            	   MoveFi("G:\\搜狐比赛数据集\\Pic_info_train.part1\\"+tempString,"1\\");
            	   continue;
               }
               if(str[2].contains(tempString)) {
            	   MoveFi("G:\\搜狐比赛数据集\\Pic_info_train.part1\\"+tempString,"2\\");
               }
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
	
	 public static void main(String[] args) {  
		 /*
		  * 主要思想：
		  * 对应类别的文字信息中如果包含这个图片的名字，则该图片与这段文字属于同一个类别
		  */
		 String[] str = new String[3];  
		 str[0] = ReadFile("0.txt");   //读取0类的文字信息
		 str[1] = ReadFile("1.txt");   //读取1类的文字信息
		 str[2] = ReadFile("2.txt");   //读取2类的文字信息
		 ClassRead("name.txt",str);    //name.txt包含所有图片的名字
		 System.out.println("hello world!!");
	 }  
	
}
