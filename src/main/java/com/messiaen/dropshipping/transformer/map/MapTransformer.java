package com.messiaen.dropshipping.transformer.map;

import com.sun.istack.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class MapTransformer<E, K, V>  {

    @Nullable
    public Map<K, V> transformToMap(@Nullable Collection<E> entities) {
        if (entities == null)
            return null;
        
        final Map<K, V> map = new HashMap<>();
        entities.forEach((e -> map.put(extractKey(e), extractValue(e))));
        return map;
    }

    @Nullable
    public abstract K extractKey(@Nullable E entity);

    @Nullable
    public abstract V extractValue(@Nullable E entity);

    @Nullable
    public abstract E transformToEntity(@NotNull K key, @NotNull V value);

    @Nullable
    public final Collection<E> transformToEntity(@Nullable Map<@NotNull K, @NotNull V> map) {
        return map == null ? null :
                map.keySet().stream().map(k -> transformToEntity(k, map.get(k))).collect(Collectors.toList());
    }
}
