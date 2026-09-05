package oop.generic_wildCard;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

public class StoreImpl<K, V> implements StoreI<K, V> {
    //хранилище (файл, мапа .....)
    public void putAll(Map<? extends K, ? extends V> entry) {
    }

    public Collection<V> getAll(Predicate<? super V> predicate) {
        throw new UnsupportedOperationException();
    }

    public Map<K, V> getAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }
}
