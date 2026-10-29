class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int s=1, e=0,k=0;
        for(int max:piles){
            e = Math.max(e, max);
        }

        while(s<=e){
            int mid = s+ (e-s)/2;

            if(isValid(mid, piles, h)){
                k = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
        
    }

    private boolean isValid(int speed, int[] arr, int h){
        long totalHour = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % speed == 0){
                totalHour += arr[i]/speed;
            }else{
                totalHour += (arr[i]/speed)+1;
            }
        }
        return h>= totalHour; 
    } 
}
