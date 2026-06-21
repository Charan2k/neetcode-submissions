class Solution {
    public boolean isAnagram(String s, String t) {
        char str[] = s.toCharArray();
        char ttr[] = t.toCharArray();

        Arrays.sort(str);
        Arrays.sort(ttr);

        return new String(str).equals(new String(ttr));
    }
}
