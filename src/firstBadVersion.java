/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class firstBadVersion    {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = (right - left)/2;
            if (isBadVersion(mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }
    private boolean isBadVersion(int v){
        return false;
    }
}