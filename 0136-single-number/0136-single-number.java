class Solution {
    public int singleNumber(int[] nums) {

        //Better Approach
/*
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < nums.length; i ++)
        mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        for(Map.Entry<Integer, Integer> obj : mpp.entrySet()) 
        if(obj.getValue() == 1) return obj.getKey();


        return -1;

*/        
    //Optimal (XOR prop: identical elements will cancel each othr out!..)

    int xor = 0;
    for(int i = 0 ; i < nums.length; i ++)
    xor = xor ^ nums[i];

    return xor;

    }
}