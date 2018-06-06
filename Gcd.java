public class Gcd {
	public static void main(String[] args) {
		/*
		 * 找到n個數的最大公因數
		*/
		
		int[] nums = {32, 8, 16};
		
		int result = execute(nums);
		System.out.println(result);
		
	}
	
	static int execute(int[] nums) {
		int result = 0;
		
		// WRITE YOU CODE HERE -START-
		result = gcd(nums[0], nums[1]);
		
		if(nums.length < 3)
			return result;
		
		for(int i = 2; i < nums.length; i ++) {
			result = gcd(result, nums[i]);
		}
				
		// WRITE YOU CODE HERE -END-
		return result;
	}
	
	static int gcd(int a, int b) {
		if(b > a)
			return gcd(b, a);
		
        if(b == 0) 
            return a; 
        else 
            return gcd(b, a % b); 
		
	}
}
