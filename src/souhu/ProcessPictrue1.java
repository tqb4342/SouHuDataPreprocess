package souhu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProcessPictrue1 {

	
	public static void ClassRead(String fileName,String str) {   //传入包含图片名字的txt文件名和News_pic_label_train.txt内容
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               if(str.contains(tempString)) {   //如果str包含某个图片，则该图片有营销意图，移动2文件夹
            	   MoveFile.MoveFi("D:\\训练图片\\1\\"+tempString,"D:\\训练图片\\2\\");
            	   Tools.writeToFile1("1中有营销意图的图片.txt", tempString+"\n");  //记录移动了哪些图片
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
	
	/*
	 * 将label为1的文字信息中包含营销意图的文字挑选出来
	 */
	public static String SelectFile1(String fileName) {
		File file = new File(fileName);
        BufferedReader reader = null;
        String str="";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               if(tempString.split("	")[1].equals("1")) {
            	   Tools.writeToFile1("1中有营销意图的文字.txt", tempString+"\n");
               }
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
	
	public static void main(String[] args) {
		String str = SelectFile1("News_pic_label_train.txt");
		//String filename = "name";
		for(int i=1;i<=3;i++)
		ClassRead("name"+i+".txt",str);
	}
	
	
	
}
