// Online stock span

class StockSpanner {
    Stack<Stock> stack;
    int time;
    public StockSpanner() {
        stack = new Stack<>();
        time = 0;
        stack.push(new Stock(time,Integer.MAX_VALUE));
    }
    
    public int next(int price) {
        time++;
        while(stack.peek().price <= price) {
            stack.pop();
        }
        int result = time - stack.peek().time;
        // System.out.println(time+", "+ price);
        // System.out.println(stack);
        stack.push(new Stock(time,price));
        return result;
        
    }
}

class Stock {
    int time;
    int price;
    
    public Stock(int time, int price) {
        this.time = time;
        this.price = price;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 //Minimum size Subarray Sum

 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int pointer = 0;
        int sum = 0;
        
        for(int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            
            while(sum >= target) {
                result = Math.min(result, i-pointer + 1);
                sum -= nums[pointer];
                pointer++;
            }
        }
        if(result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }
}