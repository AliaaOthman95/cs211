package eg.edu.alexu.csd.oop.game;

import java.util.List;

public class IteratorImplementation implements Iterator{
	
	private MyLinkedList list = new MyLinkedList();
	private int index;
	
	ListNode i=null;
	public IteratorImplementation(MyLinkedList list){
		this.list = list;
		 i =  list.getHead();
	}

	@Override
	public boolean hasNext() {
		
		if(index < list.size()-1)
			return true;
		return false;
	}

	@Override
	public Object next() {
		
		if(this.hasNext()){
			

			i = i.next;
			index++;
			return i.value;
			
		}
			
		return null;
	}

}
