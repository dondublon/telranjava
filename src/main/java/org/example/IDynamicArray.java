package org.example;

public interface IDynamicArray {
    boolean add(Object obj);
    boolean add(Object obj,int index);
    Object get(int index);
    int size();
    int indexOf(Object obj);
    int lastIndexOf(Object odj);
    Object removeByIndex(int index);
    boolean removeItem(Object obj);
    boolean contains(Object obj);
    Object[] toArray();
}
