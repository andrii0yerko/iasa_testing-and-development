package src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab1 {
	
	/** 
	 * Task №1
	 * a function that filters input list integers
	 * @param list of objects
	 * @return list of non-negative integers from the input
	 */
	public static List<Integer> getIntegersFromList(List<Object> list) {
		ArrayList<Integer> integers = new ArrayList<Integer>(); // this will be a resulting List
		for (Object item : list) {
			if ((item instanceof Integer) && ((Integer)item >= 0)) {
				integers.add((Integer)item);
			}
		}
		return integers;
	}
	
	/**
	 * Task №2
	 * returns the first non-repeating character (case-insensitive for letters) of the input string
	 * @param string 
	 * @return the first character that is not repeated anywhere in this string.
	 */
	public static char getFirstNonRepeatingLetter(String input) {
		String lowercase = input.toLowerCase(); // used to compare letters in same case
		for (int i=0; i < input.length(); i++) {
			boolean repeating = false;
			for (int j=0; j < input.length(); j++) { //searching for same character
				if (i == j) continue; // except itself
				if (lowercase.charAt(i) == (lowercase.charAt(j))) {
					repeating = true;
					break;
				}
			}
			if (!repeating) return input.charAt(i);
		}
		return (Character) null;
	}
	
	/**
	 * Task №3
	 * counts the digital root - recursive sum of all the digits in a number
	 * @param number 
	 * @return its digital root
	 */
	public static int digitalRoot(int number) {
		int sum = number;
		while (sum > 10) {
			number = sum;
			sum = 0;
			while (number > 0) {
				sum += number % 10; // add the last digit to current sum
				number /= 10; //cut the last digit of the number 
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// Tests for task 1
		assertTrue(getIntegersFromList(Arrays.asList(1, 2, "a", "b")).equals(Arrays.asList(1, 2)));
		assertTrue(getIntegersFromList(Arrays.asList(1, 2, "a", "b", 0, 15)).equals(Arrays.asList(1, 2, 0, 15)));
		assertTrue(getIntegersFromList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)).equals(Arrays.asList(1, 2, 231)));
		
		// Tests for task 2
		assertEquals(getFirstNonRepeatingLetter("stress"), 't');
		assertEquals(getFirstNonRepeatingLetter("sTreSS"), 'T');
		
		// Tests for task 3
		assertEquals(digitalRoot(16), 7);
		assertEquals(digitalRoot(942), 6);
		assertEquals(digitalRoot(132189), 6);
		assertEquals(digitalRoot(493193), 2);
	}

}
