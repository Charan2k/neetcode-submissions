class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        if(list.size() == 0) return "";

        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(timestamp == list.get(mid).timestamp) return list.get(mid).val;
            else if(timestamp < list.get(mid).timestamp) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        if(right < 0) return "";
        return list.get(right).val;
    }
}

class Pair {
    int timestamp;
    String val;

    Pair(int timestamp, String val) {
        this.timestamp = timestamp;
        this.val = val;
    }
}
