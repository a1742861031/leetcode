package com.bobo.leetcode347;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by bobo
 * @Description leetcode 347. 前 K 个高频元素
 * @Date 2022/11/7 10:23
 */
public class Solution {
    public <K extends Comparable,V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> map) {
        //需要用LinkedHashMap排序
        HashMap<K, V> finalMap = new LinkedHashMap<K, V>();
        //取出map键值对Entry<K,V>，然后按照值排序，最后组成一个新的列表集合
        List<Map.Entry<K, V>> list = map.entrySet()
                .stream()
                //sorted((p2,p1)   表示由大到小排序   ||  sorted((p1,p2)   表示由小到大排序
                .sorted((p2, p1) -> p1.getValue().compareTo(p2.getValue()))
                .collect(Collectors.toList());
        //遍历集合，将排好序的键值对Entry<K,V>放入新的map并返回。
        list.forEach(ele -> finalMap.put(ele.getKey(), ele.getValue()));
        return finalMap;

    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                map.put(num, count + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map<Integer, Integer> sortMapByValues = sortMapByValues(map);
        Set<Integer> set = sortMapByValues.keySet();
        int[] ans = new int[k];
        int count = 0;
        for (Integer key : set) {
            ans[count] = key;
            count++;
            if(count==k){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        solution.topKFrequent(nums,2);
    }
}
