package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
	private Node<T> first;
	private Node<T> last;
	private Node<T> current;
	
    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {
    	Node<T> nodeNew = new Node<T>(a);
    	
    	if(first == null){
    		first = nodeNew;
    		last = first;
    	}
    	else{
    		last.setNext(nodeNew);
    		nodeNew.setPrevious(last);
    		last = nodeNew;    		
    	}
    }

    /**
     * Internen Zeiger für next() zurücksetzen
     */
    public void reset() {
    	current = first;
    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {
    	current = last;
    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {
    	
    	return first;
    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {
    	
    	return last;
    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {
    	T returnValue = null;
    	if(current != null){
    		returnValue = current.getData();
    		current = current.getNext();
    	}
    	return returnValue;
    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {
    	T returnValue = null;
    	if(current != null){
    		returnValue = current.getData();
    		current = current.getPrevious();
    	}
    	return returnValue;
    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {
    	if(current != null){
    		current = current.getNext();
    	}
    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {
    	if(current != null){
    		current = current.getPrevious();
    	}
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {
    	T returnValue = null;
    	if(current == null){
    		throw new CurrentNotSetException();
    	}
    	returnValue = current.getData();
    	
    	return returnValue;
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {
    	Node<T> searchProcess = first;
    	int counter = 1;
    	T returnValue = null;
    	
    	while(counter < pos){
    		searchProcess = searchProcess.getNext();
    		counter++;
    	}
    	if(counter == pos){
    		returnValue = searchProcess.getData();
    	}	
        return returnValue;
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) {
    	T valueToRemove = get(pos);
    	Node<T> toRemove = new Node<T>(valueToRemove);
   
    	if(toRemove == first){
    		toRemove.getNext().setPrevious(null);
    		toRemove = toRemove.getNext();
    		first = toRemove;
    	}
    	else if(toRemove == last){
    		toRemove.getPrevious().setNext(null);
    		toRemove = toRemove.getPrevious();
    		last = toRemove;
    	}  	
    	else {
    		toRemove.getNext().setPrevious(toRemove.getPrevious());
    		toRemove.getPrevious().setNext(toRemove.getNext());
    		toRemove = toRemove.getNext();
    	}
    	
    	if(current == toRemove){
    		current = null;
    	}
    }
    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {
    	if(current == null){
    		throw new CurrentNotSetException();
    	}
    	else if(current == first){
    		current.getNext().setPrevious(null);
    		current = current.getNext();
    		first = current;
    	}
    	else if(current == last){
    		current.getPrevious().setNext(null);
    		current = current.getPrevious();
    		last = current;
    	}  	
    	else {
    		current.getNext().setPrevious(current.getPrevious());
    		current.getPrevious().setNext(current.getNext());
    		current = current.getNext();
    	}

    }
    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {
    	if(current == null){
    		throw new CurrentNotSetException();
    	}
    	if(current == last){
    		add(a);
    		current = current.getNext();
    	}
    	else{
	    	Node<T> nodeNew = new Node<T>(a);
	       	Node<T> curNext = current.getNext();
	    	
	    	current.setNext(nodeNew);
	    	curNext.setPrevious(nodeNew);
	    	nodeNew.setNext(curNext);
	    	nodeNew.setPrevious(current);
	    	current = nodeNew;    
    	}
    }
}
