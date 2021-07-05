package alg.slide_window;

import java.util.*;

/**
 * 632.最小区间
 */
public class Leet_632_smallest_range_covering_elements_from_k_ordered_lists {

    /**
     * 方法一：堆
     * 给定 kk 个列表，需要找到最小区间，使得每个列表都至少有一个数在该区间中。该问题可以转化为，
     * 从 kk 个列表中各取一个数，使得这 kk 个数中的最大值与最小值的差最小。
     *
     * 假设这 kk 个数中的最小值是第 ii 个列表中的 xx，对于任意 j \ne ij
     * 
     * ​
     *  =i，设第 jj 个列表中被选为 kk 个数之一的数是 yy，则为了找到最小区间，yy 应该取第 jj 个列表中大于等于 xx 的最小的数。
     *  简单证明如下：假设 zz 也是第 jj 个列表中的数，且 z>yz>y，则有 z-x>y-xz−x>y−x，
     *  同时包含 xx 和 zz 的区间一定不会小于同时包含 xx 和 yy 的区间。因此，其余 k-1k−1 个列表中应该取大于等于 xx 的最小的数。
     *
     * 由于 kk 个列表都是升序排列的，因此对每个列表维护一个指针，通过指针得到列表中的元素，
     * 指针右移之后指向的元素一定大于或等于之前的元素。
     *
     * 使用最小堆维护 kk 个指针指向的元素中的最小值，同时维护堆中元素的最大值。初始时，kk 个指针都指向下标 00，
     * 最大元素即为所有列表的下标 00 位置的元素中的最大值。每次从堆中取出最小值，根据最大值和最小值计算当前区间，
     * 如果当前区间小于最小区间则用当前区间更新最小区间，然后将对应列表的指针右移，将新元素加入堆中，并更新堆中元素的最大值。
     *
     * 如果一个列表的指针超出该列表的下标范围，则说明该列表中的所有元素都被遍历过，堆中不会再有该列表中的元素，因此退出循环。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * 方法二：哈希表 + 滑动窗口
     * 思路
     *  }，请找出一个 BB 中的一个最小的区间，使得在这个区间中 AA 序列的每个数字至少出现一次，请注意 AA 中的元素可能重复，
     *  也就是说如果 AA 中有 pp 个 uu，那么你选择的这个区间中 uu 的个数一定不少于 pp。
     *  没错，这就是我们五月份的一道打卡题：「76. 最小覆盖子串」。官方题解使用了一种双指针的方法，
     *  遍历整个 BB 序列并用一个哈希表表示当前窗口中的元素：
     *
     * 右边界在每次遍历到新元素的时候右移，同时将拓展到的新元素加入哈希表
     * 左边界右移当且仅当当前区间为一个合法的答案区间，即当前窗口内的元素包含 AA 中所有的元素，
     * 同时将原来左边界指向的元素从哈希表中移除
     * 答案更新当且仅当当前窗口内的元素包含 AA 中所有的元素
     * 如果这个地方不太理解，可以参考「76. 最小覆盖子串 - LeetCode 官方题解」。
     *
     * 回到这道题，我们发现这两道题的相似之处在于都要求我们找到某个符合条件的最小区间，我们可以借鉴「76.
     * 最小覆盖子串」的做法：这里序列 \{ 0, 1, \cdots , k - 1 \}{0,1,⋯,k−1} 就是上面描述的 AA 序列，即 kk 个列表，
     * 我们需要在一个 BB 序列当中找到一个区间，可以覆盖 AA 序列。这里的 BB 序列是什么？我们可以用一个哈希映射来表示
     * BB 序列—— B[i]B[i] 表示 ii 在哪些列表当中出现过，这里哈希映射的键是一个整数，表示列表中的某个数值，哈希映射的值是一个数组，
     * 这个数组里的元素代表当前的键出现在哪些列表里。也许文字表述比较抽象，大家可以结合下面这个例子来理解。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static int[] smallestRange2(List<List<Integer>> nums) {
        int size = nums.size();
        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            for (int x : nums.get(i)) {
                List<Integer> list = indices.getOrDefault(x, new ArrayList<Integer>());
                list.add(i);
                indices.put(x, list);
                xMin = Math.min(xMin, x);
                xMax = Math.max(xMax, x);
            }
        }

        int[] freq = new int[size];
        int inside = 0;
        int left = xMin, right = xMin - 1;
        int bestLeft = xMin, bestRight = xMax;

        while (right < xMax) {
            right++;
            if (indices.containsKey(right)) {
                for (int x : indices.get(right)) {
                    freq[x]++;
                    if (freq[x] == 1) {
                        inside++;
                    }
                }
                while (inside == size) {
                    if (right - left < bestRight - bestLeft) {
                        bestLeft = left;
                        bestRight = right;
                    }
                    if (indices.containsKey(left)) {
                        for (int x: indices.get(left)) {
                            freq[x]--;
                            if (freq[x] == 0) {
                                inside--;
                            }
                        }
                    }
                    left++;
                }
            }
        }

        return new int[]{bestLeft, bestRight};
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
