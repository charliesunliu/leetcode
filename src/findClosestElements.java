import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class findClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if (x <= arr[0]) {

            return Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().collect(Collectors.toList());
        } else if (arr[n - 1] <= x) {

            return Arrays.stream(Arrays.copyOfRange(arr, n - k, n)).boxed().collect(Collectors.toList());
        }

        int left = 0; int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        left = right - 1;

        if( k == 1){
            if(arr[left] - x <= arr[right] - x){

                return Arrays.stream(Arrays.copyOfRange(arr, left, left+1)).boxed().collect(Collectors.toList());
            } else{

                return Arrays.stream(Arrays.copyOfRange(arr, right, right + 1)).boxed().collect(Collectors.toList());
            }
        }
        while(right - left + 1 < k){
            if(arr[left] - x <= arr[right] - x){
                left--;
            } else{
                right++;
            }
        }

        return Arrays.stream(Arrays.copyOfRange(arr, left, right + 1)).boxed().collect(Collectors.toList());
    }
}