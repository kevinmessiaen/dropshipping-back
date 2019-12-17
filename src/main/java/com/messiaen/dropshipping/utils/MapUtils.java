package com.messiaen.dropshipping.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapUtils {

    public static <K> Map<K, Short> countShortValues(Map<K, Short> ... maps) {
        return Arrays.stream(maps).map(m -> m.entrySet().stream()).flatMap(Function.identity())
                .collect(CountMapBuilder<K>::new, CountMapBuilder::entry, CountMapBuilder::addAll).build();
    }

    private static class CountMapBuilder<K> {

        private Map<K, Short> map = new HashMap<>();

        public CountMapBuilder<K> entry(Map.Entry<K, Short> entry) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), (short) (entry.getValue() + map.get(entry.getKey())));
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public CountMapBuilder<K> addAll(CountMapBuilder<K> mapper) {
            mapper.build().entrySet().forEach(this::entry);
            return this;
        }

        public Map<K, Short> build() {
            return map;
        }
    }

}
