class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            int currLeft = s.charAt(left);
            int currRight = s.charAt(right);

            if(!Character.isLetterOrDigit(currLeft)){
                left++;
            } else if(!Character.isLetterOrDigit(currRight)){
                right--;
            } else {
                if(Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)){
                    return false;
                }

                left++;
                right--;
            }
        }
        return true;
    }
}
