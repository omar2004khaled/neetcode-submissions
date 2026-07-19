class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;int j=0;
        int[] expectedNums=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){}
            else{
                expectedNums[j]=nums[i];
                j++;
                k++;
            }
        }
                for (int i = 0; i < k; i++) {
            nums[i] = expectedNums[i];
        }
    return k;   
    }
}