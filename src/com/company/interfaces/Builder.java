package com.company.interfaces;

public abstract class Builder<T> {

    private T object = (T)new Object();

    public T build(){
        return object;
    }

    protected T getObject() {
        return object;
    }

    protected void setObject(T object) {
        this.object = object;
    }
}
