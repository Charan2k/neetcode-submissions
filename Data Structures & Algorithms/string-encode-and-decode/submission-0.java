class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public String encode(List<String> strs) {
        Random rand = new Random();
        int randomNumber = rand.nextInt();
        while(map.containsKey(randomNumber)) {
            randomNumber = rand.nextInt();
        }
        String randomString = Integer.toString(randomNumber);
        map.put(randomString, strs);
        return randomString;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
