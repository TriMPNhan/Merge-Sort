import java.util.*;

public class testMergeSort {
	
	/**
	 * Parent method to be called to sort the array
	 * @param sortee
	 */
	public static void mergeSort(String[] sortee) {
		int lngth = sortee.length;
		if (lngth < 2) {
			return;
		}
		else {
			//Create two arrays by splitting the first
			String[] a1 = Arrays.copyOfRange(sortee, 0, lngth / 2);
			String[] a2 = Arrays.copyOfRange(sortee, lngth / 2, lngth);
			
			// Recursively calls mergesort to sort the arrays
			mergeSort(a1);
			mergeSort(a2);
			
			String[] finalArray = merge(a1, a2); // Holder for the finished array
			
			for (int i = 0; i < sortee.length; i++) { // change the array into the new order it is supposed to be after sorting
				sortee[i] = finalArray[i];
			}
		}
		
	}
	
	/**
	 * Takes two arrays and merges them while sorting their proper order relative to each other
	 * @param a1 First array half to be merged
	 * @param a2 Second array half to be merged
	 * @return The resultant array
	 */
	public static String[] merge(String[] a1, String[] a2) {
		String[] finale = new String[a1.length + a2.length]; // Finished array and set it's length
		int temp1 = 0; // a1 Tracker
		int temp2 = 0; // a2 Tracker
		for (int i = 0; i < finale.length; i++) {
			
			if (a1.length <= temp1) { // If array 1 has been added completely add the rest of array 2 
				finale[i] = a2[temp2];
				temp2++;
			}
			
			else if (a2.length <= temp2) { // Same as above but switch which array
				finale[i] = a1[temp1];
				temp1++;
			}
			
			else if (a1[temp1].charAt(0) == a2[temp2].charAt(0)) { // Check for if the strings start with the same character
				
				int count = 0; // Holder for which character we are on
				
				// Make sure count never increments past string length, and increment count while going through the strings
				while (count < a1[temp1].length() - 1 && count < a2[temp2].length() - 1
						&& a1[temp1].charAt(count) == a2[temp2].charAt(count)) {
					
					count++;
					}
				
				if (a1[temp1].charAt(count) < a2[temp2].charAt(count)) { // Check if the character at count is before or after alphabetically
					finale[i] = a1[temp1];								 // Add accordingly
					temp1++;
				}
				else if (a1[temp1].charAt(count) > a2[temp2].charAt(count)) { // Check if the character at count is before or after alphabetically
					finale[i] = a2[temp2];									  // Add accordingly
					temp2++;
				}
				else { // If all characters are the same and the end of on string is reached, add the shorter name to the array first
					if (a1.length > a2.length) {
						finale[i] = a2[temp2];
						temp2++;
					}
					else {
						finale[i] = a1[temp1];
						temp1++;
					}
				}
				
			}
			// Check if the character at count is before or after alphabetically, add accordingly
			else if (a1[temp1].charAt(0) < a2[temp2].charAt(0)) {
				finale[i] = a1[temp1];
				temp1++;
			}
			// Check if the character at count is before or after alphabetically, add accordingly
			else {
				finale[i] = a2[temp2];
				temp2++;
			}
		}
		return finale;
		
		
	}
	
	public static void main(String[] args) {
		String[] test = {"Lisa", "Adam", "John", "Vicky", "George", "Beth", "Kate", "Aaron", "Jimmy", "Adele", "Adeleline"};
		
		mergeSort(test);
		System.out.println("Final Array is: " + Arrays.toString(test));
	}
	
}
