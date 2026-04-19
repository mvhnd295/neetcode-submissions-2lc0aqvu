class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Stack<Double> stack = new Stack<>();
        double[][] combined = new double[position.length][2];
        for (int i = 0; i < combined.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(combined, (a, b) -> Double.compare(a[0], b[0]));
        int n = combined.length - 1;
        double prevtime = 0;
        int count = 0;
        for (int i = n; i >= 0; i--) {
            if (prevtime < combined[i][1]) {
                count++;
                prevtime = combined[i][1];
            }
        }
        return count;
    }
}
