package A01_Stack;


public class Stack<T>
{
	 private Node<T> first;
	 private int counter;	//initialisieren oder nicht? also Enden mit: "=0;"
	  
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
    	T returnValue = null;
   
    	if(first == null){
    		throw new StackEmptyException();
    	}
    	returnValue = first.getData();

    	first = first.getNext();
    	counter --;
    	
    	return returnValue;
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
    	Node<T> nodeNew = new Node<T>(i);
    	Node<T> tempNode = first;
    	
    	if(first == null){
    		first = nodeNew;
    	}
    	else{
    		first = nodeNew;
    		first.setNext(tempNode);
    	}
    	counter++;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	int actualCount = counter;
    	return actualCount;
    }
}
