package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Sorter {
    public static List<StringIntPair> split(String input) {
        var substrings = input.split(" ");
        var result = new ArrayList<StringIntPair>();
        var counts = new HashMap<String, Integer>();
        for (var substr: substrings) {
            counts.compute(substr, (k, v) -> v == null ? 1 : v + 1);
        }
        for (var kv: counts.entrySet()) {
            result.add(new StringIntPair(kv.getKey(), kv.getValue()));
        }
        return result;
    }

    public static void sort(List<StringIntPair> values) {
        Comparator<StringIntPair> cmp =
                Comparator.comparing(StringIntPair::second, Comparator.reverseOrder())
                        .thenComparing(StringIntPair::first);
        values.sort(cmp);
    }
}
