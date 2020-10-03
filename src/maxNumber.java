import java.util.LinkedList;

class maxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] result = new int[k];
        int n1Index = 0; //n1 left = nums1.length - n1Index;
        int n2Index = 0; //n2 left = nums2.length - n2Index;
        // nums1.length - n1Index + nums2.length - n2Index >= k - i;
        for (int i = 0; i < k; i++){
            int n1Value = -1;
            int n1Indextemp = -1;
            for (int j = n1Index; j < nums1.length && nums1.length - j + nums2.length - n2Index >= k - i; j++){
                if (nums1[j] > n1Value){
                    n1Value = nums1[j];
                    n1Indextemp = j + 1;
                }
            }
            int n2Value = -1;
            int n2Indextemp = -1;
            for (int j = n2Index; j < nums2.length && nums1.length - n1Index + nums2.length - j >= k - i; j++){
                if (nums2[j] > n2Value){
                    n2Value = nums2[j];
                    n2Indextemp = j + 1;
                }
            }
            if (n1Value >= n2Value){
                 n1Index = n1Indextemp;
                 result[i] = n1Value;
            }else {
                n2Index = n2Indextemp;
                result[i] = n2Value;
            }

        }

        return result;
    }
}