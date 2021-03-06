package rekrytering;


import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 0.0;

	public static void main(String[] args) {
		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor
		Applicant[] applicants = FileReader.readFromFile("applications_x.txt", 231);
		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor
		
		// Printa resultatet från findBestCandidates
		Applicant[] bestCandidates = findBestCandidates(applicants);
		Arrays.sort(bestCandidates);
		System.out.println("Best Candidates:");
		PrintApplicants(bestCandidates);
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		
		int goodCandidateCount = 0;
		Applicant[] goodCandidates = new Applicant[applicants.length];
		
		for (int i = 0; i < applicants.length; i++ ) {
			if (applicants[i].getAvgGrade() > MIN_AVG_GRADE) {
				goodCandidates[goodCandidateCount] = applicants[i];
				goodCandidateCount++;
				
			}
		}
		
		Applicant[] returnCandidates = new Applicant[goodCandidateCount];
		for (int i = 0; i < goodCandidateCount; i++) {
			returnCandidates[i] = goodCandidates[i];
		}
		return returnCandidates;
	}
	
	private static void PrintApplicants (Applicant[] applicants) {
		for (int i= 0; i < applicants.length; i++) {
			System.out.println(applicants[i]);
		}
	}
}
