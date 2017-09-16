package A02_Queue;

public class Queue<T>
{
    private Node<T> first;
    private Node<T> last;
    private int counter;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {
    	T returnValue = null;
    	
    	if(first == null){
    		throw new QueueEmptyException();
    	}
    	returnValue = first.getData();
    	first = first.getNext();
    	counter--;
    	
    	return returnValue;
    }
    
    
    
    /**
     * �bergebenen Integer am Ende der Queue anh�ngen.
     * @param i Zahl
     */
    public void enqueue(T i) {
    	Node<T> nodeNew = new Node<T>(i);
    	
    	if(first == null){
    		first = nodeNew;
    		last = first;
    	}
    	else{
        	last.setNext(nodeNew);
        	last = nodeNew;	
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
