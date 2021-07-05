package alg.heap_topk;

import java.util.PriorityQueue;

public class TopK_PriorityQueue {
    public static void main(String[] args) {
//        test1();

        int[] arr = {9, 3, 2, 6, 4};
        int k = 3;
        for (int i : topKEx(arr, k)) {
            System.out.println(i);
        }
    }

    /**
     * 内存中只保留前k个元素，如果数据量太大，不能把所有元素都放进去
     *
     * @param arr
     * @param k
     * @return
     */
    private static int[] topKEx(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (arr.length < k) {
            return arr;
        }

        //此处是最大堆（堆顶元素最大），可变成最大堆或者最小堆 看你提供的比较器
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (queue.isEmpty() || queue.size() < k || i < queue.peek()) {
                queue.offer(i);
            }

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll();
        }

        return topK;
    }

    private static int[] topK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        if (arr.length < k) {
            return arr;
        }

        //可变成最大堆或者最小堆 看你提供的比较器
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            queue.offer(i);
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = queue.poll();
        }

        return topK;
    }
}
