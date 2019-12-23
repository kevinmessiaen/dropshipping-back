package com.messiaen.dropshipping.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;

public class MapUtils {

    public static <K> Map<K, Short> countShortValues(Map<K, Short>... maps) {
        return Arrays.stream(maps).map(Map::entrySet).flatMap(Collection::stream)
                .collect(toMap((l, r) -> (short) (l + r)));
    }

    public static <K> Map<K, Short> minusShortValues(Map<K, Short> left, Map<K, Short> right) {
        Map<K, Short> result = left.entrySet().stream().collect(toMap());
        putAll(MapUtils.<K, Short>accumulator((l, r) -> (short) (l - r), (r) -> (short) -r)).apply(result, right);
        return result;
    }

    public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toMap(final BinaryOperator<V> fuseValues) {
        BiConsumer<Map<K, V>, Map.Entry<K, V>> accumulator = accumulator(fuseValues, (r) -> r);
        return Collector.of(HashMap::new, accumulator, putAll(accumulator));
    }

    public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toMap(final BinaryOperator<V> fuseValues, UnaryOperator<V> putValue) {
        BiConsumer<Map<K, V>, Map.Entry<K, V>> accumulator = accumulator(fuseValues, putValue);
        return Collector.of(HashMap::new, accumulator, putAll(accumulator));
    }

    public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toMap() {
        return toMap((l, r) -> r);
    }

    public static <K, V> BinaryOperator<Map<K, V>> putAll(final BiConsumer<Map<K, V>, Map.Entry<K, V>> consumer) {
        return (left, right) -> {
            right.entrySet().forEach((entry -> consumer.accept(left, entry)));
            return left;
        };
    }

    public static <K, V> BiConsumer<Map<K, V>, Map.Entry<K, V>> accumulator(final BinaryOperator<V> fuseValues,
                                                                            UnaryOperator<V> putValue) {
        return (map, entry) -> {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), fuseValues.apply(map.get(entry.getKey()), entry.getValue()));
            } else {
                map.put(entry.getKey(), putValue.apply(entry.getValue()));
            }
        };
    }
}
