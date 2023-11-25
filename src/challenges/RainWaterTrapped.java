package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println(trapRainwaterPrefixAndSuffixLogic(Arrays.asList(3, 1, 2, 0, 10, 0, 0, 1)));
        //System.out.println(trapRainwaterTwoPointerLogic(Arrays.asList(3, 1, 2, 0, 10, 0, 0, 1)));
    }

    public static int trapRainwaterTwoPointerLogic(final List<Integer> A) {
        int ans = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;
        int right = A.size() -1;
        while(left < right){
            maxLeft = Math.max(maxLeft,A.get(left));
            maxRight = Math.max(maxRight, A.get(right));
            if(maxLeft < maxRight){
                ans += maxLeft - A.get(left);
                left++;
            } else {
                ans += maxRight - A.get(right);
                right--;
            }
        }
        return ans;
    }

    public static int trapRainwaterPrefixAndSuffixLogic(final List<Integer> A) {
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int[] maxFromRight = new int[A.size()];
        int[] maxFromLeft = new int[A.size()];
        for (int i = 0; i < A.size(); i++){
            maxLeft = Math.max(maxLeft,A.get(i));
            maxFromLeft[i] = maxLeft;
        }
        for (int i = A.size()-1; i >= 0; i--){
            maxRight = Math.max(maxRight,A.get(i));
            maxFromRight[i] = maxRight;
        }
        for (int i = 0; i < A.size(); i++){
            res += Math.min(maxFromLeft[i],maxFromRight[i]) - A.get(i);
        }
        return  res;
    }

    /*public static int trap(final List<Integer> A) {
        int ans = 0;
        for(int k = 0; k < A.size() ; k++){
            int left_maximum= A.get(k);
            for(int l = k - 1; l >= 0; l--){
                left_maximum = Math.max(left_maximum, A.get(l));
                System.out.printf("     Left Iteration:%d Value:%d left_maximum:%d \n ",l,A.get(l), left_maximum);
            }
            int right_maximum = A.get(k);
            for(int l = k + 1; l < A.size(); l++){
                right_maximum = Math.max(right_maximum, A.get(l));
                System.out.printf("     Right Iteration:%d Value:%d right_maximum:%d \n ",l,A.get(l), right_maximum);
            }
            System.out.printf("Iteration:%d Value:%d left_maximum:%d right_maximum:%d \n ",k,A.get(k), left_maximum, right_maximum);
            ans += Math.min(left_maximum, right_maximum) - A.get(k);
        }
        return ans;
    }*/

    //Two Pointer method
    /*public static int trapRainwaterTwoPointerLogic(final List<Integer> A) {
        int ans =0;
        int left_maximum = 0;
        int right_maximum = 0;
        int l = 0;
        int r = A.size() -1;
        // 3, 1, 2, 0, 10, 0, 10
        // 0, 1, 2, 3,  4, 5,  6
        while(l<r){
            left_maximum = Math.max(left_maximum, A.get(l));
            right_maximum = Math.max(right_maximum, A.get(r));
            if(left_maximum < right_maximum){
                ans += left_maximum - A.get(l);
                l++;
            }
            else{
                ans += right_maximum - A.get(r);
                r--;
            }
        }
        return ans;
    }*/




}
