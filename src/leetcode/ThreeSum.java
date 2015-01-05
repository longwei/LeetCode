package leetcode;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Created by longwei on 1/4/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length <= 2) {
            return res;
        }

        Arrays.sort(num);
        int iValue = num[0];
        int jValue, kValue;

        List<Integer> sol = new ArrayList<Integer>(3);
        for (int i = 0; i < 3; i++) {
            sol.add(Integer.MIN_VALUE);
        }

        for (int i = 0; i < num.length - 2; i++) {
            //avoid aa_ duplicate
            if (i != 0 && num[i] == iValue) {
                continue;
            }

            sol.set(0, num[i]);
            // two sum
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                jValue = num[j];
                kValue = num[k];
                int twoSum = jValue + kValue;
                if (sol.get(0) + twoSum == 0) {
                    sol.set(1, jValue);
                    sol.set(2, kValue);
                    res.add(new ArrayList<Integer>(sol));
                    // sol.clear();
                    //todo duplicate
                    while (j < k && num[j] == jValue) {
                        ++j;
                    }
                    while (k > j && num[k] == kValue) {
                        --k
                        ;
                    }
                } else {
                    //not a hit, shrink the array of looking
                    //todo duplicate
                    if (twoSum + sol.get(0) < 0) {
                        while (j < k && num[j] == jValue) {
                            ++j;
                        }

                    } else {
                        while (k > j && num[k] == kValue) {
                            --k;
                        }
                    }
                }
            }
            //
            iValue = num[i];
        }
        return res;
    }
}