package test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static String frequencySort(String s) {
        Map<Character, Integer> mp = getCharCount(s);
        return Arrays.asList(s.toCharArray()).stream().sorted(Comparator.comparingInt(mp::get).reversed()).collect(Collectors.toList()).stream().map(String::valueOf).collect(Collectors.joining());
    }

    static Map<Character, Integer> getCharCount(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        String res=frequencySort("abbccc");
        System.out.println(res);
    }
//    public static boolean cmp()
}
