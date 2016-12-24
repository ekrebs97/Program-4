// Author:           Ellen Krebs
// Email:            ekrebs@wisc.edu
// CS Login:         ekrebs
// Lecturer's Name:  Gary Dahl
// Lab Section:      335

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

import java.util.ArrayList;

/**
 * Manages a list of Places
 * 
 * @author Ellen Krebs
 *
 */
public class PlaceList {
	// ArrayList named places
	ArrayList<Place> places = new ArrayList<Place>();

	/**
	 * Defines add() method
	 * 
	 * @param newPlace
	 */
	public void add(Place newPlace) {
		places.add(newPlace);
	}

	/**
	 * Defines remove(index) method
	 */
	public void remove(int index) {
		places.remove(index);
	}

	/**
	 * Defines size() method
	 */
	public int size() {
		return places.size();

	}

	/**
	 * Defines hasPlaces() method
	 * 
	 * @return Checks to see whether or not the placeListObj has places in
	 *         memory
	 */
	public boolean hasPlaces() {
		if (places.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Defines get() method
	 * 
	 * @param name
	 * @param address
	 * @return
	 */
	public Place get(int index) {
		return places.get(index);
	}

	/**
	 * Defines contains() method
	 * 
	 * @return Checks to see if a place already exists in memory
	 */
	public boolean contains(Place placeListObj) {
		if (places.contains(placeListObj)) {
			return true;
		} else {
			return false;
		}
	}

}
