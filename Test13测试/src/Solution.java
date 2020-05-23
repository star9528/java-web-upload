import java.util.LinkedList;

public class Solution {
    public int getResult(int n) {
        if (n < 1)
            return -1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int round = 2, i, curr = 0;
        for (i = 1; i <= n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            i = 0;
            while (list.size() > 1 && i < list.size()) {
                curr = (curr + 1) % round;
                if (curr != 1) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            round++;// 下一轮的最大报数
            curr = 0;// 表示还未开始报数
            if (list.size() > 1) {// 将最后报数的元素移动到链表首部，即确保每次报数从链表首部开始。
                int last = list.removeLast();
                list.addFirst(last);
            }
        }
        return list.pop();// 返回最后一个元素
    }
}
