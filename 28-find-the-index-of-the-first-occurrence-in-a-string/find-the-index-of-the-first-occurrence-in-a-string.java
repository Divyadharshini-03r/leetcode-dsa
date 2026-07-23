class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        haystack=haystack.toLowerCase();
        needle=needle.toLowerCase();
        return haystack.indexOf(needle);
    }
}