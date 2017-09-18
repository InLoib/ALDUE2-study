package doublell;

public class DoubleLinkedList {

	private Node first = null;
	private Node last = null;
	private int count = 0;
	
	private Node current = null;
	
	public int getCount() {
		return count;
	}
	
	public void moveFirst() {
		current = first;
	}
	
	public void moveLast() {
		current = last;
	}
	
	public boolean moveNext() {
		if (current == last) {
		// if (current.getNext() == null) {
			return false;
		}
		current = current.getNext();
		return true;
	}

	public void deleteCurrent() {
		
		if (count == 0) return;
		
		if (count == 1) { 
			first = null;
			last = null;
			current = null;
		}
		else if (current == first) {
			current = first.getNext();
			current.setPrevious(null);
			first = current;
		}
		else if (current == last) {
			current = last.getPrevious();
			current.setNext(null);
			last = current;
		}
		else {
			Node a = current.getPrevious();
			Node b = current.getNext();
			
			a.setNext(b);
			b.setPrevious(a);
			current = b;
		}
		count--;
		
		
		
	}
	
	
	public boolean movePrevious() {
		if (current == first) {
		//if (current.getPrevious() == null) {
			return false;
		}
		current = current.getPrevious();
		return true;
	}
	
	public int getCurrent() {
		if (current == null) {
			System.err.println("Liste ist leer!");
			return -1;
		}
		return current.getData();
	}
	
	// TODO
	private void insert(int item) {
		Node n = new Node();
		n.setData(item);
		
		// TODO: Schreiben Sie hier ihren Code
		// n soll nach current eingef�gt werden und n wird das neue current
	}
	
	// TODO
	public void insertSorted(int item) {
		
		// TODO: Schreiben Sie hier ihren Code
		
	}
	
	
	public int getAt(int pos) {
		if (!(pos >= 0 && pos < count)) {
			System.err.println("Position ist nicht vorhanden: " + pos);
			return -1;
		}
		
		Node current = first;
		
		for(int i=0; i<pos; i++) {
			current = current.getNext();
		}
		
		return current.getData();
	}
	
}