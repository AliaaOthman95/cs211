package eg.edu.alexu.csd.oop.game;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements java.util.List<Integer> {
	private ListNode head = null;
	private int size = 0;
	
	@Override
	public boolean add(Integer e) {
		ListNode newNode = new ListNode(e);
		newNode.next = null;
		ListNode i = getHead();
		if (getHead() != null && size() != 0) {
			while (i.next != null) {
				i = i.next;
			}
			i.next = newNode;
		} else {
			setHead(newNode);
		}
		setSize(size() + 1);
		
		return true;
	}

	@Override
	public void add(int index, Integer element)throws IndexOutOfBoundsException {
		ListNode newNode = new ListNode(element);
		if (index <= size() && index >= 0) {
			if (index == 0) {
				newNode.next = getHead();
				setHead(newNode);
				setSize(size() + 1);
			} else {
				ListNode i = getHead();
				for (int j = 0; j < index - 1; j++) {
					i = i.next;
				}
				newNode.next = i.next;
				i.next = newNode;
				setSize(size() + 1);
			}
		} else {
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Integer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {

		setHead(null);
		setSize(0);
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer get(int index) throws IndexOutOfBoundsException{
		if (index <= size() && index >= 0) {
			ListNode i = getHead();
			for (int j = 0; j < index; j++) {

				i = i.next;
			}
			return (Integer) i.value;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if (getHead() == null && size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Integer> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Integer> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer set(int index, Integer element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public List<Integer> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
