import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Merchandise {
	public int amount;
	public int totalPrice;
	public Merchandise(int amount, int totalPrice) {
		this.amount = amount;
		this.totalPrice = totalPrice;
	}
}

public class CalcuateMerchandiseValue {
	public static void main(String[] args) {
		/* 名字	數量 單價
		 * "COMPUTER 2 1000; MEMORY 3 5000"
		 * 
		 * 輸出: 名字 總價 均價
		 * "COMPUTER 2000 1000"
		 * "MEMORY 15000 5000"
		 */
		String str = "COMPUTER 2 1000;MEMORY 3 5000";
		
		
		ArrayList<String> result = execute(str);
		for(int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
	}
	
	static ArrayList<String> execute(String str) {
		ArrayList<String> result = new ArrayList<String>();
		// WRITE YOU CODE HERE -START-
		
		// 讀取全部商品信息
		HashMap<String, Merchandise> map = new HashMap<String, Merchandise>();
		String[] split_1 = str.split(";");
		for(int i = 0; i < split_1.length; i ++) {
			String[] split_2 = split_1[i].trim().split(" ");
			String name = split_2[0];
			int amount = Integer.parseInt(split_2[1]);
			int price = Integer.parseInt(split_2[2]);

			if(map.containsKey(name) == true) {
				Merchandise m = map.get(name);
				m.totalPrice += price * amount;
				m.amount += amount;
				map.put(name, m);
			} else {
				Merchandise m = new Merchandise(amount, price);
				map.put(name, m);
			}
		}
		
		// 印出來
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext() == true) {
			String key = iter.next();
			Merchandise m = map.get(key);		
			String res = key + " " + m.totalPrice + " " + m.totalPrice / m.amount;
			result.add(res);
		}
		
		// WRITE YOU CODE HERE -END-
		return result;
	}
}
