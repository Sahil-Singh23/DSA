class Solution {
    public double minPrice(int[] prices, int[] discounts) {

        sortDescending(prices);
        sortDescending(discounts);

        int n = prices.length;
        int m = discounts.length;

        double sum = 0;
        int i=0;
        for( i=0 ; i<m && i<n ; i++){
            sum+= (prices[i]*((double)100-discounts[i]))/100;
        }
        for( i=m ; i<n ; i++) sum+= prices[i];

        return sum;
    }
    public static void sortDescending(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}