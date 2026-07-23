class Solution {
    public int[] searchRange(int[] nums, int target) {
       ArrayList<Integer> list=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        if(nums[i]==target){
            list.add(i);
        }
       }
       if(list.size()==0){
        return new int[]{-1,-1};
       }
       return new int[]{
        list.get(0),
        list.get(list.size()-1)
       };
    }
}