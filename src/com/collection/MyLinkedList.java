package com.collection;

import java.util.Collection;

public class MyLinkedList<E> {
	public transient int size = 0;
	transient Node<E> first;
	transient Node<E> last;
	int modCount = 0;

	public MyLinkedList() {

	}

	private void linkFirst(E e) {
		final Node<E> f = first;
		final Node<E> newNode = new Node<E>(null, e, f);
		first = newNode;
		if (f == null) {
			last = newNode;
		} else {
			f.prev = newNode;
		}
		size++;
		modCount++;
	}

	private void linkLast(E e) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<E>(l, e, null);
		last = newNode;

		if (l == null) {
			first = newNode;
		} else {
			l.next = last;
		}
		size++;
		modCount++;
	}

	private void linkBefore(E e, Node<E> succ) {
		final Node<E> preNode = succ.prev;
		final Node<E> newNode = new Node<E>(preNode, e, succ);
		succ.prev = newNode;

		if (preNode == null) {
			first = newNode;
		} else {
			preNode.next = newNode;
		}
		size++;
		modCount++;
	}

	public boolean add(E e) {
		linkLast(e);
		return true;
	}

	public boolean add(int index, E e) {
		checkRange(index);
		if (index == size) {
			linkLast(e);
		} else {
			linkBefore(e, node(index));
		}
		return true;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		checkRange(index);

		Object[] array = c.toArray();
		if (array.length == 0)
			return false;
		// 前向节点，后向节点
		Node<E> prev, succ;
		if (index == size) {
			succ = null;
			prev = last;
		} else {
			succ = node(index);
			prev = succ.prev;
		}
		// 遍历array，插入
		for (Object o : array) {
			@SuppressWarnings("unchecked")
			E e = (E) o;
			Node<E> newNode = new Node<E>(prev, e, null);
			if (prev == null) {
				first = newNode;
			} else {
				prev.next = newNode;
			}
			prev = newNode;
		}
		// 如果插入位置在尾部，重置last
		if (succ == null) {
			last = prev;
		}
		// 否则，将插入的链表与之前的链表关联
		else {
			prev.next = succ;
			succ.prev = prev;
		}
		size = size + array.length;
		modCount++;
		return true;
	}

	public E get(int index) {
		return node(index).item;
	}

	public int indexOf(Object o) {
		Node f = first;
		int index = 0;
		if (o == null) {
			for (Node<E> x = f; x != null; x = x.next) {
				if (x.item == null)
					return index;
				index++;
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item.equals(o))
					return index;
				index++;
			}
		}
		return -1;
	}

	// 按照元素删除
	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item.equals(o)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}
	//按照索引删除
	/*public void remove(int index){
		checkRange(index);
		unlink(node(index));
	}*/
	
	private void unlink(Node<E> x) {
		final Node<E> prev = x.prev;
		final Node<E> next = x.next;
		// 删除前驱指针
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}
		// 删除后向指针
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		modCount++;
	}

	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node<E> xNode = last;
			for (int i = size - 1; i > index; i--) {
				xNode = xNode.prev;
			}
			return xNode;
		}
	}

	private void checkRange(int index) {
		if (index < 0 || index > size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<E> x = first; x != null; x = x.next)
			result[i++] = x.item;
		return result;
	}

	private static class Node<E> {
		E item;
		Node<E> prev;
		Node<E> next;

		public Node(Node<E> prev, E item, Node<E> next) {
			super();
			this.item = item;
			this.prev = prev;
			this.next = next;
		}

	}
}
