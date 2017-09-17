package A07_BubbleSort;

public class Person {
	
	private final String nachname;
	
	private final String vorname;

	public Person(String vorname, String nachname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Vergleicht zwei Personen miteinander
	 * @return <0, wenn a<b || =0, wenn a=b || >0, wenn a>b
	 */
	public int compareTo(Person p) {

		for (int i = 0; i < p.nachname.length(); i++) {
			char otherName = p.nachname.charAt(i);
			char thisName = nachname.charAt(i);
			
			if(otherName < thisName){
				return -1;
			}
			if(otherName > thisName){
				return 1;
			}	
		}
		for (int i = 0; i < p.vorname.length(); i++) {
			char otherName = p.vorname.charAt(i);
			char thisName = vorname.charAt(i);
			
			if(otherName < thisName){
				return -1;
			}
			if(otherName > thisName){
				return 1;
			}		
		}		
		return 0;
	}
}
