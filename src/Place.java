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

/**
 * This class contains the methods and data for a single place.
 * 
 * @author Ellen Krebs
 *
 */
public class Place {
	// Name of the place
	private String name;

	// Address of the place
	private String address;

	/**
	 * Constructor initializes name and address fields
	 * 
	 * @param name:
	 *            private field = name parameter
	 * @param address:
	 *            private field = address parameter
	 */
	public Place(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/**
	 * Getter method to return the name of the place
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter method to return address of the place
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Setter method to set the name of the place
	 * 
	 * @param name:
	 *            name is set by the user's input
	 */
	public void setName(String nameInput) {
		this.name = nameInput;
	}

	/**
	 * Setter method to set the address of the place
	 * 
	 * @param address:
	 *            address is set by the user's input
	 */
	public void setAddress(String addressInput) {
		this.address = addressInput;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} 
		
		if (obj instanceof Place) {
			Place objPlace = (Place) obj;
			return objPlace.getName().equals(this.getName());
		}
		return false;
	}

}
