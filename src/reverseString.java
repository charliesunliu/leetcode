class reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++; right--;
        }
    }
}