package problems;

class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        // 5, 2, 3, 4
        // prefix - * - suffix  
        int size = nums.length;
        int res[]= new int [size];

        // prefix, suffix 
        int prefix[]= new int [size];
        int suffix[] = new int[size];
        prefix[0]=1;
        suffix[size-1] = 1;
        for(int i =1, j=size-2;i< size ;i++,j--){
            prefix[i]=prefix[i-1] * nums[i-1];
            suffix[j]= suffix[j+1] * nums[j+1];
        }

        for ( int i =0;i<size; i++){
            res[i] = prefix[i]*suffix[i];
        }
        return res;

    }}