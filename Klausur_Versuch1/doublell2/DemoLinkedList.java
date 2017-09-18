package doublell2;

public class DemoLinkedList {

	public static void main(String[] args) {
		
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.insertSorted(5);
		dll.insertSorted(4);
		dll.insertSorted(3);
		dll.insertSorted(2);
		dll.insertSorted(1);
		
		
		dll.moveFirst();
		do
		{
			System.out.println(dll.getCurrent());
			
		} while(dll.moveNext());
		
	}

}
