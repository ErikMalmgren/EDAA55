package rekrytering;

public class Applicant implements Comparable<Applicant> {
	// Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal
		for (int i = 0; i < g.length; i++) {
			if (g[i].equals("U")) {
				// Om underkänd så räknar vi det som en nolla
				grades[i] = 0;
			}
			else if (g[i].equals("A")) {
				grades[i] = 5;
			}
			else if (g[i].equals("B")) {
				grades[i] = 4;
			}
			else if (g[i].equals("C")) {
				grades[i] = 3;
			}
			else if (g[i].equals("D")) {
				grades[i] = 2;
			}
			else if (g[i].equals("E")) {
				grades[i] = 1;
			}
			else if (g[i].equals("F")) {
				grades[i] = 0;
			}
			
			else {
				grades[i] = Integer.parseInt(g[i]);
			}

		}
	}

	public double getAvgGrade() {
		double total = 0;
		for (int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		return total / grades.length;
	}

	public String toString() {
		String gradesAsString = "[";
		for (int i = 0; i < grades.length; i++) {
			gradesAsString += grades[i] + ", ";
		}
		gradesAsString += grades[grades.length - 1] + "]";
		return name + gradesAsString + "(avg: " + getAvgGrade() + ")";
	}

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar
	 * något < 0 om other är störst och returnerar 0 om objekten är lika. Används av
	 * javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
