//class Solution {
//    public boolean queryString(String S, int N) {
//        long adding = 1;
//        long result = 0;
//
//        for(int i = S.length() - 1; i >= 0; i--){
//            if(S.charAt(i) == '1'){
//                result += adding;
//            }
//            adding *= 2;
//        }
//        return result == N;
//    }
//}