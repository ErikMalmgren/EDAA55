package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). 
	 * Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		Applicant[] applicants;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}
		//Här kan du använda Scannern för att läsa från filen fileName.
		//Varje rad motsvarar en Applicant. Kontrollera vad Applicants konstruktor kräver
		//Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en Applicant-vektor och returneras på slutet
		
		applicants = new Applicant[nbrOfRows];
		int i = 0;
		String[] line;
		String name;
		String grades;
		
		while(i < nbrOfRows && scan.hasNextLine()) {
			line = scan.nextLine().split(" ");
			if (line.length < 2) {continue; }
			name = line[0] + " " +line[1];
			grades = line[2];
			applicants[i] = new Applicant(name, grades);
			i++;
		}
		
		if (i < nbrOfRows) {
			Applicant[] tempApplicants = new Applicant[i];
			for (int j = 0; j < tempApplicants.length; j++) {
				tempApplicants[j] = applicants[j];
			}
			applicants = tempApplicants;
		}
		
		return applicants;
		
	}
}
