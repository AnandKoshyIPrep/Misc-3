// Time Complexity : O(N(log(M))) M is difference between max weight and total weight
// Space Complexity : O(1)
// Passed Leetcode
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        int min = 0, max = 0;
        
        for(int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        int mid = 0;
        
        while(min < max) {
            mid = min + (max - min) / 2;

            int days = 1;
            int currW = 0;
            for(int i = 0; i < weights.length; i++) {
                
                currW += weights[i];
                if (currW > mid) {
                    days++;
                    currW = weights[i];
                }
                
            }
            
            if (days > D) {
                min = mid + 1;
            } else {
                max = mid;
            }
            
        }
        
        return min;
        
    }
}