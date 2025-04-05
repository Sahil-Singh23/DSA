package DSA.DSA.LeetCode.SlidingWindow;

// Time: O(k), Space: O(1)

public class LC1423 {
    public static void main(String[] args) {
        LC1423Solution solution = new LC1423Solution();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int result = solution.maxScore(cardPoints, k);
        System.out.println("Maximum points from " + k + " cards: " + result);
    }
}

class LC1423Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0;
        for (int i = 0; i < k; i++) lsum += cardPoints[i];
        int maxSum = lsum;
        k--;
        int n = cardPoints.length - 1;
        while (lsum != 0) {
            lsum -= cardPoints[k--];
            rsum += cardPoints[n--];
            maxSum = Math.max(maxSum, lsum + rsum);
        }
        return maxSum;
    }
}
