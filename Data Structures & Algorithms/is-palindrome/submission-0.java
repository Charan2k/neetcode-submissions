class Solution {
    private boolean isAlpha(char ch) {
        return (ch >= 'A' && ch <= 'Z' ||
                ch >= 'a' && ch <= 'z' ||
                ch >= '0' && ch <= '9');
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            while(left < right && !isAlpha(s.charAt(left))) {
                left++;
            }
            
            while(right > left && !isAlpha(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++; right--;
            
        }
        return true;
    }
}
