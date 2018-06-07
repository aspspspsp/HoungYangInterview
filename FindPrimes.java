import java.util.ArrayList;

public class FindPrimes {
	public static void main(String[] args) {
		/*
		 * 找到m~n範圍內的所有質數
		*/
		int m = 3;
		int n = 17;
		ArrayList<Integer> result = execute(m, n);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<Integer> execute(int m, int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// WRITE YOU CODE HERE -START-

		// 建立1 ~ n的質數表
		boolean[] isNotPrimes = new boolean[n + 1]; //假設所有的數都是質數
		isNotPrimes[1] = true; // 1不是質數
		isNotPrimes[2] = false; // 2是質數
		
		// 從2~n的範圍內尋找，若當前數是質數，則他的所有倍數都是非質數
		for(int i = 2; i <= n; i ++) {
			if(isNotPrimes[i] == false) {
				for(int j = i + i; j <= n; j = j + i) {
					isNotPrimes[j] = true;
				}
			}
		}
		
		// 顯示答案
		for(int i = m; i <= n; i ++) {
			if(isNotPrimes[i] == false)
				result.add(i);
		}
		// WRITE YOU CODE HERE -END-
		
		return result;
	}
}
