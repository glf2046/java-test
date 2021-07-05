package alg.slide_window;

import java.util.*;

/**
 * 632.��С����
 */
public class Leet_632_smallest_range_covering_elements_from_k_ordered_lists {

    /**
     * ����һ����
     * ���� kk ���б���Ҫ�ҵ���С���䣬ʹ��ÿ���б�������һ�����ڸ������С����������ת��Ϊ��
     * �� kk ���б��и�ȡһ������ʹ���� kk �����е����ֵ����Сֵ�Ĳ���С��
     *
     * ������ kk �����е���Сֵ�ǵ� ii ���б��е� xx���������� j \ne ij
     * ��
     * �6�7
     *  =i����� jj ���б��б�ѡΪ kk ����֮һ������ yy����Ϊ���ҵ���С���䣬yy Ӧ��ȡ�� jj ���б��д��ڵ��� xx ����С������
     *  ��֤�����£����� zz Ҳ�ǵ� jj ���б��е������� z>yz>y������ z-x>y-xz�6�1x>y�6�1x��
     *  ͬʱ���� xx �� zz ������һ������С��ͬʱ���� xx �� yy �����䡣��ˣ����� k-1k�6�11 ���б���Ӧ��ȡ���ڵ��� xx ����С������
     *
     * ���� kk ���б����������еģ���˶�ÿ���б�ά��һ��ָ�룬ͨ��ָ��õ��б��е�Ԫ�أ�
     * ָ������֮��ָ���Ԫ��һ�����ڻ����֮ǰ��Ԫ�ء�
     *
     * ʹ����С��ά�� kk ��ָ��ָ���Ԫ���е���Сֵ��ͬʱά������Ԫ�ص����ֵ����ʼʱ��kk ��ָ�붼ָ���±� 00��
     * ���Ԫ�ؼ�Ϊ�����б���±� 00 λ�õ�Ԫ���е����ֵ��ÿ�δӶ���ȡ����Сֵ���������ֵ����Сֵ���㵱ǰ���䣬
     * �����ǰ����С����С�������õ�ǰ���������С���䣬Ȼ�󽫶�Ӧ�б��ָ�����ƣ�����Ԫ�ؼ�����У������¶���Ԫ�ص����ֵ��
     *
     * ���һ���б��ָ�볬�����б���±귶Χ����˵�����б��е�����Ԫ�ض��������������в������и��б��е�Ԫ�أ�����˳�ѭ����
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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

//    ���ߣ�LeetCode-Solution
//    ���ӣ�https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

    /**
     * ����������ϣ�� + ��������
     * ˼·
     *  }�����ҳ�һ�� BB �е�һ����С�����䣬ʹ������������� AA ���е�ÿ���������ٳ���һ�Σ���ע�� AA �е�Ԫ�ؿ����ظ���
     *  Ҳ����˵��� AA ���� pp �� uu����ô��ѡ������������ uu �ĸ���һ�������� pp��
     *  û��������������·ݵ�һ�����⣺��76. ��С�����Ӵ������ٷ����ʹ����һ��˫ָ��ķ�����
     *  �������� BB ���в���һ����ϣ���ʾ��ǰ�����е�Ԫ�أ�
     *
     * �ұ߽���ÿ�α�������Ԫ�ص�ʱ�����ƣ�ͬʱ����չ������Ԫ�ؼ����ϣ��
     * ��߽����Ƶ��ҽ�����ǰ����Ϊһ���Ϸ��Ĵ����䣬����ǰ�����ڵ�Ԫ�ذ��� AA �����е�Ԫ�أ�
     * ͬʱ��ԭ����߽�ָ���Ԫ�شӹ�ϣ�����Ƴ�
     * �𰸸��µ��ҽ�����ǰ�����ڵ�Ԫ�ذ��� AA �����е�Ԫ��
     * �������ط���̫��⣬���Բο���76. ��С�����Ӵ� - LeetCode �ٷ���⡹��
     *
     * �ص�����⣬���Ƿ����������������֮�����ڶ�Ҫ�������ҵ�ĳ��������������С���䣬���ǿ��Խ����76.
     * ��С�����Ӵ������������������� \{ 0, 1, \cdots , k - 1 \}{0,1,�6�8,k�6�11} �������������� AA ���У��� kk ���б�
     * ������Ҫ��һ�� BB ���е����ҵ�һ�����䣬���Ը��� AA ���С������ BB ������ʲô�����ǿ�����һ����ϣӳ������ʾ
     * BB ���С��� B[i]B[i] ��ʾ ii ����Щ�б��г��ֹ��������ϣӳ��ļ���һ����������ʾ�б��е�ĳ����ֵ����ϣӳ���ֵ��һ�����飬
     * ����������Ԫ�ش���ǰ�ļ���������Щ�б��Ҳ�����ֱ����Ƚϳ��󣬴�ҿ��Խ�����������������⡣
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
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

//    ���ߣ�LeetCode-Solution
//    ���ӣ�https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/zui-xiao-qu-jian-by-leetcode-solution/
//    ��Դ�����ۣ�LeetCode��
//    ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
}
