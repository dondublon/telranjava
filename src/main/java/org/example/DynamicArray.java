package org.example;

import java.util.Arrays;

public class DynamicArray implements IDynamicArray {
    private Object[] array;
    private  int size =0;
    private static final int INITIAL_SIZE = 16;

    public DynamicArray(int initialSize){
        if (initialSize>INITIAL_SIZE) array= new Object[initialSize];
        else array = new Object[INITIAL_SIZE];
    }

    public DynamicArray(){
        this(INITIAL_SIZE);
        System.out.println();
    }



    @Override
    public boolean add(Object obj) {
        if (obj==null) return false;

        if(array.length == size) allocateArray();
        array[size++]=obj;
        return true;
    }

    private void allocateArray() {
        array= Arrays.copyOf(array,array.length*2);
        System.out.println("Allocated");
    }

    @Override
    public boolean add(Object obj, int index) {
        if (index<0 || index>size || obj == null) return false;
        if (index==size) return add(obj);
        if (size == array.length) allocateArray();
        System.arraycopy(array,index,array,index+1,size-index);
        array[index]=obj;
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        Object res=null;
        if (index>=0 && index<size) res=array[index];
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object obj) {
        if(obj == null) return -1;
        for (int i=0; i<size;i++)
            if (array[i].equals(obj))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        if(obj == null) return -1;
        for (int i=size-1; i>=0;i--)
            if (array[i].equals(obj))
                return i;
        return -1;
    }

    @Override
    public Object remove(int index) {
        if(index<0 || index>=size) return null;
        Object res=array[index];
        if (index<size-1)
            System.arraycopy(array,index+1,array,index,size-index-1);
        size--;
        return res;
    }

    @Override
    public boolean remove(Object obj) {
        int index=indexOf(obj);
        return remove(index) !=null;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj)>=0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array,size);
    }
}
