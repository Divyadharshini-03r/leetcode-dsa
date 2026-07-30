class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int duplicate[]=new int[n];
        for(int i=0;i<n;i++)
            duplicate[i]=triangle.get(n-1).get(i);
        for(int row=n-2;row>=0;row--){
            for(int col=0;col<=row;col++){
                duplicate[col]=triangle.get(row).get(col) + Math.min(duplicate[col],duplicate[col+1]);
            }
        }
        return duplicate[0];
    }
}