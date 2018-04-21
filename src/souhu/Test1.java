package souhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		int N;
		int n= 0;
		int a;
		Scanner read = new Scanner(System.in);
		N = read.nextInt();
		List<List> list1 = new ArrayList<List>();
		for(int b=0;b<N;b++) {
			n = read.nextInt();
			List<Integer> list2 = new ArrayList<Integer>();
			for(int bb = 0;bb<n;bb++) {
				a = read.nextInt();
				list2.add(a);
			}
			list1.add(list2);
		}
		
		for(int j=0;j<list1.size();j++) {
//			n = read.nextInt();
//			int [][] data = new int[N][n+1]; 
			List<Integer> list = new ArrayList<Integer>();
		list = list1.get(j);
			int m = 1;
			for(int x=0;x<list.size();x++) {
				String t = T(list,n,m);
				m++;
				int tt = Integer.parseInt(t.split(" ")[0]);
				String s = t.split(" ")[1]; 
				boolean f = true;
				if(tt!=0) {
					if((list.get(0)+tt) == list.get(list.size()-1)) {
						System.out.println(tt);
						break;
					}
					for(int y=x+1;y<list.size();y++) {
						if(list.contains(list.get(y)+tt) && s.equals("+")) {
							System.out.println(tt);
							f = !f;
							break;
						}else if(list.contains(list.get(y)-tt) && s.equals("-")) {
							System.out.println(tt);
							f = !f;
							break;
						}else {
							break;
						}
					}
				}
				if(!f) break;
			}
			
		}
	
	}
	
	public static String  T(List<Integer> list,int n,int m) {
		for(int i=m;i<list.get(n-1);i++) {
			for(int j=0;j<list.size();j++) {
			if(list.contains(list.get(j)+i)) {
				return i+" +";
			}
			if(list.contains(list.get(j)-i)) {
				return i+" -";
			}
				
		}
				
		}
		return "0 +";
	}
	
}
