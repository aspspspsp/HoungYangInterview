import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class WordCount {
	public static void main(String[] args) {
		/*
		 * 給定一段短文，印出在短文中出現第一多與第二多的文字 ex: I have a pen, I have a apple，但不包含特殊符號以及數字
		 * 大小寫視為相同
		 * 印出
		 * i(2)
		 * have(2)
		 * a(2)
		 * pen(1)
		 * apple(1)
		*/
		
		String paragraph = "Wikileaks began on Sunday November 28th publishing 251,287 leaked United States embassy cables, the largest set of confidential documents ever to be released into the public domain. The documents will give people around the world an unprecedented insight into US Government foreign activities."
				  + "The cables, which date from 1966 up until the end of February this year, contain confidential communications between 274 embassies in countries throughout the world and the State Department in Washington DC. 15,652 of the cables are classified Secret."
				  + "The embassy cables will be released in stages over the next few months. The subject matter of these cables is of such importance, and the geographical spread so broad, that to do otherwise would not do this material justice.";
		ArrayList<String> result = execute(paragraph);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<String> execute(String paragraph) {
		ArrayList<String> result = new ArrayList<String>();
		
		// WRITE YOU CODE HERE -START-
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

		String[] words = paragraph.split(" ");
		for(int i = 0; i < words.length; i ++) {
			String word = words[i];
			if(word.length() == 0)
				continue;
			
			if(map.containsKey(word) == true) {
				int word_count = map.get(word) + 1;
				map.put(word, word_count);
			} else {
				map.put(word, 1);
			}
		}
		
		Iterator cur_key = map.keySet().iterator();
		
		//找最大值
		int max = 0;
		while(cur_key.hasNext()) {
			String key = (String) cur_key.next();
			if(max < map.get(key)) {
				max = map.get(key);
			}
		}
		
		//印出最大
		cur_key = map.keySet().iterator();
		while(cur_key.hasNext()) {
			String key = (String) cur_key.next();
			if(max == map.get(key)) {
				result.add(key + "(" + max + ")");	
			}
		}
		
		//找第二大
		int second_max = 0;
		cur_key = map.keySet().iterator();
		
		while(cur_key.hasNext()) {
			String key = (String) cur_key.next();
			if(second_max < map.get(key) && map.get(key) < max) {
				second_max = map.get(key);
			}
		}
		
		//印出第二大
		cur_key = map.keySet().iterator();
		while(cur_key.hasNext()) {
			String key = (String) cur_key.next();
			if(second_max == map.get(key)) {
				result.add(key + "(" + second_max + ")");	
			}
		}
		
		// WRITE YOU CODE HERE -END-
		return result;
	}
}
