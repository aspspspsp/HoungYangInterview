import java.util.ArrayList;

public class Combinations {
	public static void main(String[] args) {
		/*
		 * Ó¡³ö½MºÏ ex: A,B,C,D
		 * ¼´žéA,B,AB,C,AC,BC,ABC,D,AD,BD,ABD,CD,ACD,BCD,ABCD
		*/
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("A");
		strings.add("B");
		strings.add("C");
		strings.add("D");
		
		ArrayList<String> result = execute(strings);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<String> execute(ArrayList<String> strings) {
		ArrayList<String> result = new ArrayList<String>();
		// WRITE YOU CODE HERE -START-
		int strings_size = strings.size();
		
		int n = (int) (Math.pow(2, strings_size) - 1);	
		for(int i = 1; i <= n; i ++) {
			String binaryNum = Integer.toBinaryString(i);			
			StringBuilder cover = new StringBuilder(binaryNum);

			if(binaryNum.length() < strings_size) {
				for(int j = 0; j < strings_size - binaryNum.length(); j ++) {
					cover.insert(0, "0");
				}
			}
			
			cover.reverse();

			String sub_res = "";
			for(int j = 0; j < cover.length(); j ++) {
				if(cover.substring(j, j + 1).equals("1")) {
					sub_res = sub_res + strings.get(j);
				}
			}
			// WRITE YOU CODE HERE -END-
			
			result.add(sub_res);
		}
		
		return result;
	}

}
