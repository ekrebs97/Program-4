// Author:           Ellen Krebs
// Email:            ekrebs@wisc.edu
// CS Login:         ekrebs
// Lecturer's Name:  Gary Dahl
// Lab Section:      345

// Partner Name:     Alice Rusnak
// Partner Email:    arusnak2@wisc.edu
// Partner CS Login: arusnak
// Lecturer's Name:  Gary Dahl
// Lab Section:      344
// 

//    _X_ Write-up states that Pair Programming is allowed for this assignment.
//    _X_ We have both read the CS302 Pair Programming policy.
//    _X_ We have registered our team prior to the team registration deadline.
//

// Persons:          CSLC Tutors
// Online Sources:   Piazza

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class handles the file input and output, and which action to take
 * depending on the user's input.
 * 
 * @author Ellen Krebs
 */

public class MyPlacesApp {

	// Object of the places array list
	static PlaceList placeListObj = new PlaceList();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		// Stores the value of the user's valid input
		char action = validInput(scnr);

		// As long as the user does not input 'q', then one of these statements
		// will run
		while (action != 'q') {
			if (action == 'a') {
				actionA(scnr);
			}
			if (action == 's') {
				actionS(scnr);
			}
			if (action == 'd') {
				actionD(scnr);
			}
			if (action == 'r') {
				actionR(scnr);
			}
			if (action == 'w') {
				actionW(scnr);
			}

			// Checks again to see that the user's input is valid
			action = validInput(scnr);
		}

		// Closing statement
		System.out.println("Thank you for using My Places 2016!");
		scnr.close();
	}

	/**
	 * Checks to see whether or not the user's input is a valid choice
	 */
	public static char validInput(Scanner scnr) {
		while (true) {

			// Stores the valid options that the user can input
			String validOptions = printList();

			// User's input
			String userChoice = scnr.nextLine();

			// If the user presses the enter key, then the program will continue
			if (userChoice.equals("")) {
				continue;
			}

			// Checking if the user input a character
			if (userChoice.length() == 1) {

				// Going through the string returned from printList() and seeing
				// if the user's input matches one of the valid options
				if (validOptions.contains(userChoice.toLowerCase())) {
					return userChoice.toLowerCase().charAt(0);
				}
			}

			// This only prints if the user's input is not valid
			System.out.println("Unrecognized choice: " + userChoice);

			System.out.print("Press Enter to continue.");
			scnr.nextLine();
		}
	}

	/**
	 * Returns a string that contains the valid options
	 */
	public static String printList() {

		// Checks to see if the placeListObj has any places in memory (first
		// menu)
		if (!(placeListObj.hasPlaces())) {
			System.out.println();
			System.out.println("My Places 2016");
			System.out.println("--------------------------");
			System.out.println("No places in memory.");
			System.out.println("--------------------------");
			System.out.print("A)dd R)ead Q)uit: ");

			// String of valid inputs for the first menu
			return "arq";

		} else {
			// Runs when there are places in memory (second menu)
			System.out.println();
			System.out.println("My Places 2016");
			System.out.println("--------------------------");

			for (int i = 0; i < placeListObj.size(); i++) {
				System.out
						.println(i + 1 + ") " + placeListObj.get(i).getName());
			}
			System.out.println("--------------------------");
			System.out.print("A)dd S)how D)elete R)ead W)rite Q)uit: ");

			// String of valid inputs for the second menu
			return "asdrwq";
		}
	}

	/**
	 * This method handles adding a new place to the array list of places, or
	 * when the user enters 'a'.
	 */
	public static void actionA(Scanner scnr) {

		// Prompts the user to enter the name of a place
		System.out.print("Enter the name: ");

		// Stores the name of the place that the user inputs
		String nameOfPlace = scnr.nextLine();

		// Prompts the user to enter the address of a place
		System.out.print("Enter the address: ");

		// Stores the address of the place that the user inputs
		String addressOfPlace = scnr.nextLine();

		// Creates the new object of place
		Place newPlace = new Place(nameOfPlace, addressOfPlace);

		// Checks to see if the same place already exists in memory
		if (placeListObj.contains(newPlace)) {
			System.out.println(nameOfPlace + " already in list.");

		} else {
			// Adds a new place to the list
			System.out.println("Adding: " + nameOfPlace);
			placeListObj.add(newPlace);
		}
		System.out.print("Press Enter to continue.");
		scnr.nextLine();
	}

	/**
	 * This method handles the case where the user wants to show a place that is
	 * already in the places array list.
	 */
	public static void actionS(Scanner scnr) {

		// Checks to see if there are places in the array list
		if (placeListObj.hasPlaces()) {
			System.out.print("Enter number of place to Show: ");

			// Stores the number of the place in the array list
			int numberOfPlacesShow;

			// User inputs a number
			numberOfPlacesShow = scnr.nextInt();
			scnr.nextLine();

			// If the number does not exist in the array list (ex: only 2 places
			// exist and the user wants to show a 3rd place), and error message
			// will be shown
			if (numberOfPlacesShow > placeListObj.size()
					|| numberOfPlacesShow == 0) {
				System.out.println("Expected a number between 1" + " and "
						+ placeListObj.size() + ".");

					System.out.print("Press Enter to continue.");
					scnr.nextLine();
				
				// Otherwise, if the user asked for a place that was in the
				// array list, then the name and address of the place will be
				// printed. Then, the user will be asked to press the Enter key
				// and the program will go back to the main menu
			} else {
				System.out.println(
						placeListObj.get(numberOfPlacesShow - 1).getName());
				System.out.println(
						placeListObj.get(numberOfPlacesShow - 1).getAddress());
				String enter = scnr.nextLine();
				if (enter.equals("")) {
					System.out.print("Press Enter to continue.");
					scnr.nextLine();
				}
			}
		}
	}

	/**
	 * This method handles the case where a user wants to delete a place
	 */
	public static void actionD(Scanner scnr) {

		// Checks if the place list array list has places in memory. If there
		// are places in memory, then the user is asked to delete a place.
		if (placeListObj.hasPlaces()) {
			System.out.print("Enter number of place to Delete: ");

			// Stores whatever number the user has input
			int numberOfPlacesDelete;

			// User inputs the number of the place listed in the main menu 
			// ex): 1) Union South, the user will input "1"
			numberOfPlacesDelete = scnr.nextInt();
			scnr.nextLine();

			// If the user enters in a number larger than the array list, or
			// they enter in 0, then an error message appears.
			if (numberOfPlacesDelete > placeListObj.size()
					|| numberOfPlacesDelete == 0) {
				System.out.println("Expected a number between 1" + " and "
						+ placeListObj.size() + ".");

					System.out.print("Press Enter to continue.");
					scnr.nextLine();
				

				// Otherwise, if the user has entered a valid number, then the
				// place will be deleted
			} else {
				System.out.print("Deleting: ");
				System.out.println(
						placeListObj.get(numberOfPlacesDelete - 1).getName());
				
					System.out.print("Press Enter to continue.");
					scnr.nextLine();

					// The place is removed from the array list
					placeListObj.remove(numberOfPlacesDelete - 1);
			}
		}
	}

	/**
	 * This method handles the case where the user wants to read a file
	 */
	public static void actionR(Scanner scnr) {
		System.out.println("My Places Files: ");
		showFileName();
		readPlaces(scnr);

	}
	
/**
 * This method handles the case where the user wants to read a file
 */
	public static void actionW(Scanner scnr) {
		System.out.println("My Places Files: ");
		showFileName();
		writePlaces(scnr);
	}

	/**
	 * I've decided to handle file input and output in MyPlaceApp class because
	 * then the PlaceList class can be reserved for only handling the array list
	 */

	/**
	 * This method reads in a file name
	 */
	public static void showFileName() {
		File folder = new File(".");
		for (File file : folder.listFiles()) {
			if (file.getName().endsWith(".mp")) {
				System.out.print("    ");
				System.out.println(file.toString().substring(2));
			}
		}
	}

	/**
	 * This method allows the user to read in places that are stored in a file
	 */
	public static void readPlaces(Scanner scnr) {
		System.out.println();
		System.out.print("Enter filename: ");
		String input = null;

		// As long as the file still has a line to print, then the scanner will
		// keep reading the file
		if (scnr.hasNextLine())
			// Scanner inputs the file name
			input = scnr.nextLine();

		System.out.println("Reading file: " + input);

		// This new scanner goes through the actual file
		Scanner fileInput = null;

		// If the file cannot be found, then a FileNotFoundException will be
		// caught
		try {
			fileInput = new Scanner(new File(input));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read from file: " + input);
			System.out.print("Press Enter to continue.");
			scnr.nextLine();
			return;
		}

		// Stores the file's contents
		String fileString;

		// Stores the part of the file that contains a place's address
		String addressString;

		// Stores the part of the file that contains a place's name
		String nameString;

		// As long as the file contains another line, this will continue to run
		while (fileInput.hasNextLine()) {

			// Contains the contents of the file
			fileString = fileInput.nextLine();

			// Contains the index where ";" is located in the string
			int index = fileString.indexOf(";");

			// Contains a string from the beginning to where ";" is located
			// (name of file)
			nameString = fileString.substring(0, index);

			// Contains a string from where ";" is located to the end of the
			// string
			addressString = fileString.substring(index + 1).trim();

			// Creates the new object of place
			Place newPlaceFromFile = new Place(nameString, addressString);

			// Checks to see if the same place already exists in memory
			if (placeListObj.contains(newPlaceFromFile)) {
				System.out.println(nameString + " already in list.");
			} else {

				// If the place does not already exist, then a place is added to
				// the array list
				placeListObj.add(newPlaceFromFile);
			}

		}

		System.out.print("Press Enter to continue.");
		scnr.nextLine();
		fileInput.close();
	}

	/**
	 * This method allows the user to write a file
	 */
	public static void writePlaces(Scanner scnr) {
		System.out.println();

		System.out.print("Enter filename: ");

		// User inputs the file's name
		String input = scnr.nextLine();

		// A file called newFile is created if the user inputs a valid file name
		File newFile = new File(input);

		// A PrintWriter called writer is created
		PrintWriter writer = null;

		// The program asks the PrintWriter to write the name and address of the
		// place to the array list. However, if the file cannot be found, then a
		// FileNotFoundException will be caught
		try {
			// If the file ends with ".mp" then it will write the file
			if (input.endsWith(".mp"))
				System.out.println("Writing file: " + input);

			// If the user inputs a bad file name or a file name that doesn't exist,
			// then an error message prints out. Then the user is asked to press the
			// enter key, then the program will return to the main menu
			
			writer = new PrintWriter(newFile);
			for (int i = 0; i < placeListObj.size(); i++) {
				writer.println(placeListObj.get(i).getName() + ";"
						+ placeListObj.get(i).getAddress());
			}

		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to file: " + input);
			System.out.print("Press Enter to continue.");
			scnr.nextLine();
			return;
		}

		System.out.print("Press Enter to continue.");
		scnr.nextLine();
		writer.close();
	}
}
