package oop.generic_wildCard;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

public interface StoreI<K, V> {
    void putAll(Map<? extends K, ? extends V> entry);

    Collection<V> getAll(Predicate<? super V> predicate);

    Map<K, V> getAll(Collection<? extends K> collection);
}
