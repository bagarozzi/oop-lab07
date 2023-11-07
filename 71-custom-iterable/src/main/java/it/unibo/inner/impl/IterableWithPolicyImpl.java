package it.unibo.inner.impl;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

import java.util.Arrays;
import java.util.Iterator;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private final T[] elements;

    public IterableWithPolicyImpl(final T[] arr){
        elements = Arrays.copyOf(arr, arr.length);
    }

    public void setIterationPolicy(Predicate<T> filter){}

    public IteratorImpl iterator(){
        return this.new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T>{
        private int index;

        public IteratorImpl(){
            index = 0;
        }

        public boolean hasNext(){
            return index < elements.length;
        }
        
        public T next(){
            return elements[index++];
        }
    }
}
