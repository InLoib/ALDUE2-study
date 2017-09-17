package A07_BubbleSort;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
			
		boolean abbruchbedingung = false;
		int vergleich;
		Person thisPerson = null;
		
		while (abbruchbedingung == false){
			abbruchbedingung = true;
			for (int i = 0; i < personen.length -1; i++) {
				vergleich = personen[i].compareTo(personen[i+1]);
				
				if(vergleich >= -1){
					thisPerson = personen[i];
					personen[i] = personen[i+1];
					personen[i+1] = thisPerson;
					abbruchbedingung = false;
				}
			}
			
		}
		
	}
	
}
