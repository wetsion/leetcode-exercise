package site.wetsion.app.leetcode.exercise.p_155;

import site.wetsion.app.leetcode.exercise.common.Difficulty;

/**
 * 155.最小栈 <br/>
 *
 * https://leetcode-cn.com/problems/min-stack/ <br/>
 *
 * 难度：{@link Difficulty#EASY}
 *
 * @author wetsion
 * @date 2021/1/21
 */
public class Problem155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
    }

    /**
     * 自定义Node类作为链表的节点，定义了一个单向链表用于存数据，又定义了一个双向链表来按照从小到大存数据。
     */
    static class MinStack {

        Node head;

        Node minNode;

        /** initialize your data structure here. */
        public MinStack() {
            head = new Node();
            minNode = new Node();
            minNode.setValue(Integer.MAX_VALUE);
        }

        public void push(int x) {
            Node node = new Node();
            node.setValue(x);
            node.setNext(head);
            head = node;

            Node cNode = new Node();
            cNode.setValue(x);
            boolean skip = false;
            Node temp = new Node();
            temp.setNext(minNode);
            minNode.setPre(temp);
            Node next = temp;
            while (!skip) {
                next = next.getNext();
                if (next == null) {
                    break;
                }
                if (next.getValue() >= cNode.getValue()) {
                    Node pre = next.getPre();
                    next.setPre(cNode);
                    cNode.setNext(next);
                    cNode.setPre(pre);
                    pre.setNext(cNode);
                    skip = true;
                }
            }
            minNode = temp.getNext();
        }

        public void pop() {
            int x = head.getValue();
            Node nextHead = head.getNext();
            head = nextHead;

            boolean skip = false;
            Node temp = new Node();
            temp.setNext(minNode);
            minNode.setPre(temp);
            Node next = temp;
            while (!skip) {
                next = next.getNext();
                if (next == null) {
                    break;
                }
                if (next.getValue() == x) {
                    Node pre = next.getPre();
                    Node nn = next.getNext();
                    nn.setPre(pre);
                    pre.setNext(nn);
                    skip = true;
                }
            }
            minNode = temp.getNext();
        }

        public int top() {
            return head.getValue();
        }

        public int getMin() {
            return minNode.getValue();
        }

        class Node {
            int value;

            Node next;

            Node pre;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public void setPre(Node pre) {
                this.pre = pre;
            }

            public Node getPre() {
                return pre;
            }
        }
    }
}
