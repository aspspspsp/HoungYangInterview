import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortNames {
	public static void main(String[] args) {
		/*
		 * 對給定的名字按照字母大小來排序，若第一個字母相同則排序第二個字母，以此類推
		*/
		
		String[] names = {"Ace", "Kitty", "David", "Alice"};
		
		ArrayList<String> result = execute(names);

		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<String> execute(String[] names) {
		ArrayList<String> result = new ArrayList<String>();
		
		// WRITE YOU CODE HERE -START-
		List<String> l_names = new ArrayList<String>();
		for(int i = 0; i < names.length; i ++) {
			l_names.add(names[i]);
		}
		
		Collections.sort(l_names, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String)o1;
				String s2 = (String)o2;
				
				 // s1.compareTo(s2)是比較兩個字符串的字典序 若>0 s1排後面，大於0 s1排前面
				return s1.compareTo(s2);
			}
		});
		
		result = (ArrayList<String>)l_names;
		
		// WRITE YOU CODE HERE -END-
		return result;
	}
}
