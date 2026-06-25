class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        int n = position.length;
        for(int i=0; i<n; i++) {
            list.add(new Pair(position[i], speed[i]));
        }

        list.sort((a,b) -> b.pos - a.pos);
        Stack<Double> stk = new Stack<>();
        for(int i=0; i<n; i++) {
            stk.push((double) (target - list.get(i).pos) / list.get(i).speed);

            if(stk.size() >= 2 
                && stk.peek() <= stk.get(stk.size() - 2)) stk.pop();
        }

        return stk.size();
    }
}

class Pair {
    int pos;
    int speed;

    Pair(int pos, int speed) {
        this.pos = pos;
        this.speed = speed;
    }
}
