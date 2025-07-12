// class StockSpanner {
//     List<Integer> list = new ArrayList<>() ; 
//     public StockSpanner() {
//         List<Integer> list = new ArrayList<>();
//     }

//     public int next(int price) {
//         int ct = 1;
//         for(int i = list.size() - 1; i >= 0; i --) {
//             if(list.get(i) <= price) ct++;
//             else break;
//         }
//         list.add(price);
//         return ct;
//     }
// }

class StockSpanner {
    //Optimal : I ve to keep track of PGE element at evry instant, so store it in stk in terms of pairs[] where pairs[0] -> currVal and pairs[1] -> currIndex

    class Pair {
        int val = 0;
        int ct = 0;

        public Pair(int val, int ct) {
            this.val = val;
            this.ct = ct;
        }
    }

    Stack<Pair> stk = new Stack<>();
    int index = -1;

    public StockSpanner() {
        stk = new Stack<>();
    }

    public int next(int price) {
        index = index + 1;
        while (!stk.isEmpty() && stk.peek().val <= price)
            stk.pop();
        int ans = index - ((stk.isEmpty()) ? -1 : stk.peek().ct);
        stk.push(new Pair(price, index));
        return ans;
    }
}