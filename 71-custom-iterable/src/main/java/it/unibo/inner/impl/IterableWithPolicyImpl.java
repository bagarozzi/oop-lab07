package it.unibo.inner.impl;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;
import java.util.Iterator;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    public IterableWithPolicyImpl(){
        
    }

    public void setIterationPolicy(Predicate<T> filter){}

    public IteratorImpl iterator(){
        IteratorImpl it = this.new IteratorImpl();
        // it.index = this.?;
        return it;
    }

    class IteratorImpl implements Iterator<T>{
        private int index;
        private int maxSize;

        public boolean hasNext(){
            return false;
        }
        
        public T next(){
            
        }
    }
}
