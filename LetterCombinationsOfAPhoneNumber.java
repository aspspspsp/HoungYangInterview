import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
	
	public static void main(String[] args) {
		/*
		 * 找到手機按鍵輸入的所有組合，類似LeetCode的第17題
		 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
		 */
		String input = "79";
		                               //0  1   2      3       4     5      6       7     8       9
		String [] combinationsInKeys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		ArrayList<String> result = execute(combinationsInKeys, input);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<String> execute(String[] combinationsInKeys, String input) {
		ArrayList<String> result = new ArrayList<String>();
		
		// WRITE YOU CODE HERE -START-
		ArrayList<Integer> input_keys = new ArrayList<Integer>();
		for(int i = 0; i < input.length(); i ++) {
			int cur_input= Integer.parseInt(input.substring(i, i + 1));
			input_keys.add(cur_input);
		}
		
		result = findCombinations(0, input_keys, combinationsInKeys, new StringBuilder(), new ArrayList<String>());
		// WRITE YOU CODE HERE -END-
		
		return result;
	}
	
	static ArrayList<String> findCombinations(int cur_key, ArrayList<Integer> input_keys, String[] combinationsInKeys, StringBuilder temp, ArrayList<String> result) {
		if(cur_key == input_keys.size()) {
			String sub_res = temp.toString();
			result.add(sub_res);
			return result;
		}
		
		int curKey = input_keys.get(cur_key);
		String combinationInKeys = combinationsInKeys[curKey];
		
		// 對按鍵組合進行歷遍，而每次進行先廣後深搜索時，記得一定要刪除最後的字符，以免重複
		for(int i = 0; i < combinationInKeys.length(); i ++) {
			String cur_letter = combinationInKeys.substring(i, i + 1);
			temp.append(cur_letter);
			findCombinations(cur_key + 1, input_keys, combinationsInKeys, temp, result);
			temp.delete(temp.length() - 1, temp.length());
		}
		
		return result;
	}
}


