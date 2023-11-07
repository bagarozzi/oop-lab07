package it.unibo.inner.impl;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;
import java.util.Iterator;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {
    private int maxSize;

    public IterableWithPolicyImpl(T[] arr){
        maxSize = arr.length;
    }

    public void setIterationPolicy(Predicate<T> filter){}

    public IteratorImpl iterator(){
        IteratorImpl it = this.new IteratorImpl();
        it.index = 0;
        return it;
    }

    class IteratorImpl implements Iterator<T>{
        private int index;

        public boolean hasNext(){
            return index <= Outer.maxSize;
        }
        
        public T next(){
            return ;
        }
    }
}
