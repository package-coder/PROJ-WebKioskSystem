package com.company.interfaces;

public interface GetObjectDAO<T, K> {
    T get(K key);
}
