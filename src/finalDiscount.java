import java.util.*;

public class finalDiscount {
    public void finalDiscount(List<Integer> prices) {
        int cost = 0;
        if (prices.size() < 2){
            for (Integer item: prices) {
                cost+=item;
            }
            System.out.println(cost);
            for (Integer item: prices) {
                System.out.print(item + " ");
            }
        }
        int[] res = new int[prices.size()];
        Stack<Integer> prev = new Stack<>();

        for (int i = 0; i < prices.size(); i++) {
            if (prev.empty()){
                prev.push(i);
            }
            while(!prev.isEmpty() && prices.get(prev.peek()) >= prices.get(i)) {
                res[prev.peek()] = prices.get(prev.peek()) - prices.get(i);
                cost += res[prev.peek()];
                prev.pop();
            }
            prev.push(i);
        }
        while (!prev.empty()) {
            res[prev.peek()] = prices.get(prev.peek());
            cost += res[prev.peek()];
            prev.pop();
        }
        System.out.println(cost);
        for (Integer item: res) {
            System.out.print(item + " ");
        }
    }
}
