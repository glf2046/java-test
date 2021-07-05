package alg.heap_topk;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet_347_topk_frequent_elements {


    /**
     * ����һ����
     * ˼·���㷨
     *
     * ���ȱ����������飬��ʹ�ù�ϣ���¼ÿ�����ֳ��ֵĴ��������γ�һ�������ִ������项���ҳ�ԭ�����ǰ kk ����ƵԪ�أ����൱���ҳ������ִ������项��ǰ kk ���ֵ��
     *
     * ��򵥵������Ǹ������ִ������项���򡣵����ڿ����� O(N)O(N) ����ͬ�ĳ��ִ��������� NN Ϊԭ���鳤�ȣ������ܵ��㷨���ӶȻ�ﵽ O(N\log N)O(NlogN)����������Ŀ��Ҫ��
     *
     * ��������ǿ������öѵ�˼�룺����һ��С���ѣ�Ȼ����������ִ������项��
     *
     * ����ѵ�Ԫ�ظ���С�� kk���Ϳ���ֱ�Ӳ�����С�
     * ����ѵ�Ԫ�ظ������� kk������Ѷ��뵱ǰ���ִ����Ĵ�С������Ѷ�����˵�������� kk �����ֵĳ��ִ����ȵ�ǰֵ�󣬹�������ǰֵ�����򣬾͵����Ѷ���������ǰֵ������С�
     * ������ɺ󣬶��е�Ԫ�ؾʹ����ˡ����ִ������项��ǰ kk ���ֵ��
     *
     * ���ߣ�LeetCode-Solution
     * ���ӣ�https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
     * ��Դ�����ۣ�LeetCode��
     * ����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
     */

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] �ĵ�һ��Ԫ�ش��������ֵ���ڶ���Ԫ�ش����˸�ֵ���ֵĴ���
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
