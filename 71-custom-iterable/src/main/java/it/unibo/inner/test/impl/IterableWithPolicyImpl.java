package it.unibo.inner.test.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

/**
 * This class creates a simple implementation of the IterableWithPolicy interface, it includes
 * an inner class ArrayIterator wich helps with Iterating operations of the IterableWithPolicy
 * 
 */

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{

    ArrayList<T> iterableElement;
 
    /**
     * Constructor of IterablePolicyImpl
     * @param array The T array passed as a parameter is copied, so that the original one cannot be changed 
     */
    public IterableWithPolicyImpl(final T[] array){
        iterableElement = new ArrayList<T>(Arrays.asList(array));
    }

    public IterableWithPolicyImpl(final T[] array, Predicate<T> filter){
        iterableElement = new ArrayList<T>(Arrays.asList(array));
    }

    /**
     * {inheritDoc}
     */
    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    /**
     * {inheritDoc}
     */
    @Override
    public void setIterationPolicy(Predicate filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    /**
     * Inner class ArrayIterator implementing Iterator
     */
    private class ArrayIterator implements Iterator<T>{

        /**
         * Current element of the iteration
         */
        private int current;

        /**
         * Constructor with no args, initializes the file currente to 0
         */
        public ArrayIterator(){
            current = 0;
        }

        /**
         * {inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return(current < iterableElement.size());
        }

        /**
        * {inheritDoc}
        */
        @Override
        public T next() {
            return(iterableElement.get(current++));
        }
    }
}
