class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
       // Pair each car's starting position with its unobstructed time to reach target
        double[][] cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i])/ speed[i];
        }
        // Sort cars from closest to target (largest position) to farthest
        Arrays.sort(cars, (a,b)-> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double bottleneckTime = 0.0;

        for(int i=0; i<n; i++){
            double arrivalTime = cars[i][1];
            // Strictly greater arrival time means this car cannot catch the fleet ahead
            if (arrivalTime > bottleneckTime) {
                fleets++;
                bottleneckTime = arrivalTime;
            }
        }
        return fleets;
    }
}