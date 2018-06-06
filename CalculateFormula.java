import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class CalculateFormula {
	public static void main(String[] args) {
		/*
		 * Ӌ��һ����ʽ��ֻ�мӜp�˳���Ӌ���̖��߅����ʽ�����������g�пհ�
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
			formula = formula.replaceAll(" ", ""); //ȥ�հ�
			formula = formula.replaceAll("=", ""); //ȥ��̖
			
			String _num = "";
			//������Ё팦�\����M�н�ģ
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
