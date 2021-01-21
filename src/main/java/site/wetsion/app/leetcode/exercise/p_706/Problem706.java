package site.wetsion.app.leetcode.exercise.p_706;

import lombok.extern.slf4j.Slf4j;
import site.wetsion.app.leetcode.exercise.common.Difficulty;

import java.util.Objects;

/**
 * 706.设计哈希映射 <br/>
 * https://leetcode-cn.com/problems/design-hashmap/solution/  <br/>
 *
 * 难度：{@link Difficulty#EASY}
 *
 * @author wetsion
 * @date 2021/1/21
 */
@Slf4j
public class Problem706 {

    public static void main(String[] args) {
        String[] input = new String[]{"MyHashMap","remove","put","remove","remove","get","remove","put","get","remove","put","put","put","put","put","put","put","put","put","put","put","remove","put","put","get","put","get","put","put","get","put","remove","remove","put","put","get","remove","put","put","put","get","put","put","remove","put","remove","remove","remove","put","remove","get","put","put","put","put","remove","put","get","put","put","get","put","remove","get","get","remove","put","put","put","put","put","put","get","get","remove","put","put","put","put","get","remove","put","put","put","put","put","put","put","put","put","put","remove","remove","get","remove","put","put","remove","get","put","put"};
        int[][] num = {{},{27},{65,65},{19},{0},{18},{3},{42,0},{19},{42},{17,90},{31,76},{48,71},{5,50},{7,68},{73,74},{85,18},{74,95},{84,82},{59,29},{71,71},{42},{51,40},{33,76},{17},{89,95},{95},{30,31},{37,99},{51},{95,35},{65},{81},{61,46},{50,33},{59},{5},{75,89},{80,17},{35,94},{80},{19,68},{13,17},{70},{28,35},{99},{37},{13},{90,83},{41},{50},{29,98},{54,72},{6,8},{51,88},{13},{8,22},{85},{31,22},{60,9},{96},{6,35},{54},{15},{28},{51},{80,69},{58,92},{13,12},{91,56},{83,52},{8,48},{62},{54},{25},{36,4},{67,68},{83,36},{47,58},{82},{36},{30,85},{33,87},{42,18},{68,83},{50,53},{32,78},{48,90},{97,95},{13,8},{15,7},{5},{42},{20},{65},{57,9},{2,41},{6},{33},{16,44},{95,30}};
        MyHashMap map = new MyHashMap();
        for (int i = 0; i < input.length; i++) {
            if (Objects.equals(input[i], "MyHashMap")) {
                continue;
            }
            if (Objects.equals(input[i], "remove")) {
                map.remove(num[i][0]);
            }
            if (Objects.equals(input[i], "put")) {
                map.put(num[i][0], num[i][1]);
            }
            if (Objects.equals(input[i], "get")) {
                log.info("get:{},{}", num[i][0], map.get(num[i][0]));
            }
        }
    }

    /**
     * 使用双向链表来存数据
     */
    static class MyHashMap {

        Node head;


        /** Initialize your data structure here. */
        public MyHashMap() {
            head = new Node();
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            Node e = head.getNext();
            boolean exist = false;
            while (true) {
                if (e != null) {
                    if (key == e.getKey()) {
                        e.setValue(value);
                        exist = true;
                        break;
                    }
                    e = e.getNext();
                } else {
                    break;
                }
            }
            if (!exist) {
                Node headNext = head.getNext();
                Node node = new Node();
                node.setKey(key);
                node.setValue(value);
                node.setNext(headNext);
                node.setPre(head);
                if (headNext != null) {
                    headNext.setPre(node);
                }
                head.setNext(node);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int result = -1;
            Node p = head;
            while (true) {
                Node e = p.getNext();
                if (e != null) {
                    if (key == e.getKey()) {
                        result = e.getValue();
                        break;
                    }
                    p = e;
                } else {
                    break;
                }
            }
            return result;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            Node e = head.getNext();
            while (true) {
                if (e != null) {
                    if (key == e.getKey()) {
                        Node pre = e.getPre();
                        Node next = e.getNext();
                        pre.setNext(next);
                        if (next != null) {
                            next.setPre(pre);
                        }
                        break;
                    }
                    e = e.getNext();
                } else {
                    break;
                }
            }
        }

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public void setKey(int key) {
                this.key = key;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public void setPre(Node pre) {
                this.pre = pre;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public Node getPre() {
                return pre;
            }

            public Node getNext() {
                return next;
            }
        }
    }
}
