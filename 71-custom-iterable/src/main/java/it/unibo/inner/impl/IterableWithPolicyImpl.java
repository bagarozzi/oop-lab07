package it.unibo.inner.impl;
import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private final T[] elements;
    private Predicate<T> filter;

    public IterableWithPolicyImpl(final T[] arr , final Predicate<T> filter){
        elements = Arrays.copyOf(arr, arr.length);
        this.filter = filter;
    }

    public IterableWithPolicyImpl(final T[] arr){
        elements = Arrays.copyOf(arr, arr.length);
        this.filter = new Predicate<T>(){
            public boolean test(T elem){
                return true;
            }
        };
    }

    public void setIterationPolicy(Predicate<T> filter){
        this.filter = filter;
    }

    public IteratorImpl iterator(){
        return this.new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T>{
        private int index;

        public IteratorImpl(){
            index = 0;
        }

        public boolean hasNext(){
            while(index < elements.length){
                T elem = elements[index];
                if(filter.test(elem)){
                    return true;
                }
                index++;
            }
            return false;
        }

        public T next(){
            if(hasNext()){
                return elements[index++];
            }
            throw new NoSuchElementException();
        }
    }
}
