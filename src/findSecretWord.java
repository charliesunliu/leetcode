import java.lang.reflect.Array;
import java.util.*;

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class findSecretWord {
//    public void findSecretWord(String[] wordlist, Master master) {
//        int times = 1;
//        int numMatch = 0;
//
//        ArrayList<String> queue = new ArrayList<>(10);
//        Set<String> set = new HashSet<>();
//        for (String s : wordlist){
//            set.add(s);
//        }
//        //set.remove(currentString);
//        while(numMatch != 6){
//
//
//
//            Iterator<String> iter1 = set.iterator();
//            int leastZeroMatchCount = Integer.MAX_VALUE;
//            String leastZeroMatchStr = null;
//            while (iter1.hasNext()){
//                Iterator<String> iter2 = set.iterator();
//                String currentIterOne = iter1.next();
//
//                while(!iter2.next().equals(currentIterOne));
//
//                int currentZeroMatchCount = 0;
//                while (iter2.hasNext()){
//                    String currentIterTwo = iter2.next();
//                    if (match(currentIterTwo, currentIterOne) == 0){
//                        currentZeroMatchCount++;
//                    }
//                }
//                if (currentZeroMatchCount < leastZeroMatchCount){
//                    leastZeroMatchStr  = currentIterOne;
//                }
//            }
//
//            set.remove(leastZeroMatchStr);
//
//            numMatch = master.guess(leastZeroMatchStr);
//            if (numMatch!=6){
//                Iterator<String> iter = set.iterator();
//
//                while (iter.hasNext()){
//
//                    if (numMatch != match(iter.next(), leastZeroMatchStr)){
//                        iter.remove();
//                    }
//                }
//            }
//        }
//    }
//    private int match(String s1, String s2){
//        int count = 0;
//        for(int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) == s2.charAt(i)) {
//                count++;
//            }
//        }
//        return count;
//    }
}