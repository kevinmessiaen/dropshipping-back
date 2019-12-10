package com.messiaen.dropshipping.transformer;

import com.sun.istack.Nullable;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class Transformer<E, D, K> {

    @Nullable
    public abstract D transformToDto(@Nullable E entity);

    @Nullable
    public abstract K extractKey(@Nullable E entity);

    @Nullable
    public abstract E transformToEntity(@Nullable D dto);

    @Nullable
    public abstract E holdKey(@Nullable K key);

    @Nullable
    public final Collection<D> transformToDto(@Nullable Collection<@NotNull E> entities) {
        return entities == null ? null :
                entities.stream()
                        .map(this::transformToDto)
                        .collect(Collectors.toList());
    }

    @Nullable
    public final Collection<K> extractKey(@Nullable Collection<@NotNull E> entities) {
        return entities == null ? null :
                entities.stream()
                        .map(this::extractKey)
                        .collect(Collectors.toList());
    }

    @Nullable
    public final Collection<E> transformToEntity(@Nullable Collection<@NotNull D> dto) {
        return dto == null ? null :
                dto.stream()
                        .map(this::transformToEntity)
                        .collect(Collectors.toList());
    }

    @Nullable
    public final Collection<E> holdKey(@Nullable Collection<@NotNull K> keys) {
        return keys == null ? null :
                keys.stream()
                        .map(this::holdKey)
                        .collect(Collectors.toList());
    }
}
