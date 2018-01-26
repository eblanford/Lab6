import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String userString;
		String cont = "y";
		String translation = "";

		System.out.println("Welcome to the Pig Latin Translor!");

		while (cont.equalsIgnoreCase("y")) {
			// Collects user sentence
			System.out.print("\nEnter a line to be translated: ");
			userString = scan.nextLine();

			// saving the string as an array separated by spaces
			String[] userStringArr = userString.split(" ");

			// Loop through array and add each translated word to a new string
			for (int i = 0; i < userStringArr.length; i++) {
				String something = userStringArr[i];
				translation += toPigLatin(something);

				// add a space if it is not the last word
				if (i != (userStringArr.length - 1)) {
					translation += " ";
				}
			}

			// return translation
			System.out.println("\n" + translation);

			// this is where your code should end
			System.out.print("\nTranslate another line? (y/n)");
			cont = scan.nextLine();
			translation = "";
		}

		System.out.println("\nGoodbye.");
		scan.close();

	}


	public static String toPigLatin(String word) {
		int vowelLocation = 0;

		// Find location of first vowel
		for (int i = 0; i < word.length(); i++) {
			if (checkAVowel(word.charAt(i))) {
				vowelLocation = i;
				break;
			} else
				vowelLocation = i;
		}

		// If first letter is vowel print "way" at end
		if (vowelLocation == 0) {
			return (word + "way");
		}
		// Converts to pig Latin from location of first vowel
		else {
			String first = word.substring(0, vowelLocation);
			String last = word.substring(vowelLocation);
			return (last + first + "ay");
		}
	}

	public static boolean checkAVowel(char vowel) {
		if (vowel == 'a' || vowel == 'A') {
			return true;
		} else if (vowel == 'e' || vowel == 'E') {
			return true;
		} else if (vowel == 'i' || vowel == 'I') {
			return true;
		} else if (vowel == 'o' || vowel == 'O') {
			return true;
		} else if (vowel == 'u' || vowel == 'U') {
			return true;
		}
		return false;
	}

	public static int checkChar(char letter) {
		// Capital Letter: Case 1
		if (letter >= 65 && letter <= 90) {
			return 1;
		}
		// Lowercase Letter: Case 2
		else if (letter >= 97 && letter <= 122) {
			return 2;
		}
		// Number: Case 3
		else if (letter >= 48 && letter <= 57) {
			return 3;
		}
		// Symbols & Punctuation: Case 4
		else
			return 4;
	}

}

