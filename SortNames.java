import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortNames {
	public static void main(String[] args) {
		/*
		 * ���o�������ְ�����ĸ��С����������һ����ĸ��ͬ�t����ڶ�����ĸ���Դ����
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
				
				 // s1.compareTo(s2)�Ǳ��^�ɂ��ַ������ֵ��� ��>0 s1�����棬���0 s1��ǰ��
				return s1.compareTo(s2);
			}
		});
		
		result = (ArrayList<String>)l_names;
		
		// WRITE YOU CODE HERE -END-
		return result;
	}
}
