class Solution {
    public int bitwiseComplement(int n) {
        String bin=Integer.toBinaryString(n);
        String ans="";
        for(int i=0;i<bin.length();i++){
            ans+=bin.charAt(i)=='1'?'0':'1';
        }
        return Integer.parseInt(ans,2);
    }
    
}