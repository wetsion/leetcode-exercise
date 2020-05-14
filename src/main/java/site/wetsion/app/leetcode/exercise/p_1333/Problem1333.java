package site.wetsion.app.leetcode.exercise.p_1333;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1333. 餐厅过滤器
 * https://leetcode-cn.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 *
 * @author weixin
 * @version 1.0
 * @date 2020/5/13 4:44 PM
 */
public class Problem1333 {

    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Stream.of(restaurants).filter(restaurant -> {
                if (veganFriendly == 1) {
                    return restaurant[2] == 1;
                } else {
                    return true;
                }
            }).filter(restaurant -> restaurant[3] <= maxPrice)
            .filter(restaurant -> restaurant[4] <= maxDistance)
            .sorted((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            }).map(restaurant -> restaurant[0])
            .collect(Collectors.toList());
        }
    }
}
