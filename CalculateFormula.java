import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CalculateFormula {
	public static void main(String[] args) {
		/*
		 * 計算一行算式，只有加減乘除，計算等號左邊的算式，但算是中間有空白
		 * input "2 3 + 1 + 2 - 3 =" output 23
		*/
		
		ArrayList<String> formulas = new ArrayList<String>();
		formulas.add("23 + 1 + 2 - 24 =");
		
		ArrayList<Integer> result = execute(formulas);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<Integer> execute(ArrayList<String> formulas) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// WRITE YOU CODE HERE -START-
		for(int i = 0; i < formulas.size(); i ++) {
			String formula = formulas.get(i);
			formula = formula.replaceAll(" ", ""); //去空白
			formula = formula.replaceAll("=", ""); //去等號
			
			String _num = "";
			//利用隊列來對運算符進行建模
			Queue<String> queue = new LinkedBlockingQueue<String>();
			for(int j = 0; j < formula.length(); j ++) {
				String next = formula.substring(j, j + 1);
				if(next.equals("+") == false && next.equals("-") == false) {
					_num = _num + next;
				} else {
					queue.add(_num);
					queue.add(next);

					_num = "";
				}
			}
			
			queue.add(_num);
			
			int res = Integer.parseInt(queue.poll());
			while(queue.isEmpty() == false) {
				String next = queue.poll();
				
				if(next.equals("+")) {
					int a = Integer.parseInt(queue.poll());

					res = res + a;
				} else if (next.equals("-")) {
					int a = Integer.parseInt(queue.poll());
					res = res - a;
				}
			}
			
			result.add(res);
		}
		
		// WRITE YOU CODE HERE -END-
		return result;
	}
}
