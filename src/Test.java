import java.util.*;

public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;

            // 三元组对a进行去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 左指针指向nums[i]的下一个数，右指针指向数组末尾
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                // 由于数组是排过序的，若此时和大于0，说明需要减小右指针所指的数，故右指针左移
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    // 当前元素已经不合适了，故一直左移直到出现新的元素
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {// 若和小于0，则左指针右移，增大数字
                    left++;
                    // 当前元素已经不合适了，故一直右移直到出现新的元素
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[left]);
                    tuple.add(nums[right]);
                    res.add(tuple);
                    // 当前左右指针所指的数字均符合要求
                    // 此时需要去掉左指针右侧与当前左指针所指数字相同的数字，同理去掉右指针左侧与当前右指针所指数字相同的数字
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // 找到一个三元组后，双指针同时收缩
                    right--;
                    left++;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

    }

}
