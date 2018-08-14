package com.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

import javax.imageio.metadata.IIOInvalidTreeException;

public class MyArrayList<E> extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	private int size;
	
	public MyArrayList(){
		elementData = EMPTY_ELEMENTDATA;
	}
	
	public MyArrayList(int capacity){
		if (capacity < 0) {
			throw new IllegalArgumentException("index<0");
		} else {
			elementData = new Object[capacity];
		}
	}
	
	public MyArrayList(Collection<E> c){
		elementData = c.toArray();
	}
	
	
	
	private void ensureCapacity(int minCapacity){
		if (minCapacity > elementData.length) {
			grow(minCapacity);
		}
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}
	
	private void checkRangeAdd(int index){
		if (index < 0 || index > size)
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	private void checkRange(int index){
		if(index < 0 || index >= size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean add(E e) {
		ensureCapacity(size + 1);
		elementData[size ++] = e;
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkRangeAdd(index);
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index+1, size - index);
		elementData[index] = element;
		size --;
	}

	@Override
	public E get(int index) {
		checkRange(index);
		return (E) elementData[index];
	}
	
	public E set(int index, E e){
		checkRange(index);
		E oldValue = (E) elementData[index];
		elementData[index] = e;
		return oldValue;
	}
	
	public E remove(int index){
		checkRange(index);
		E oldValue = (E) elementData[index];
		System.arraycopy(elementData, index+1,elementData, index, size-index-1);
		elementData[--size] = null;
		return oldValue;
	}

	@Override
	public int size() {
		
		return size;
	}
}
