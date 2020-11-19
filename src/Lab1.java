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
	
	/**
	 * Task №4
	 * counts the number of pairs in the array, the sum of which will give target
	 * @param target number
	 * @param array of integers
	 * @return number of pairs, the sum of which will give target
	 */
	public static int numberOfTargetPairs(int target, int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i] + array[j] == target) counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Task №5
	 * Sorts guests by last names, if the last names are the same, sorts them by first name.
	 * Last name and first name of a guest come in the result between parentheses separated by a comma in uppercase.
	 * @param guests - string in format "name:surname;name:surname..."
	 * @return string in format "(NAME, SURNAME)(NAME, SURNAME)..."
	 */
	public static String meeting(String guests) {
		String[] guestsArr = guests.toUpperCase().split(";"); // split input string into a guests substrings, and change case to upper
		for (int i=0; i < guestsArr.length; i++) {
			String[] name = guestsArr[i].split(":", 2); // split into first and last name
			guestsArr[i] = String.format("(%s, %s)", name[1], name[0]); //and change guest format to expected
		}
		Arrays.sort(guestsArr); // sort guests
		guests = "";
		for (String guest : guestsArr) {
			guests += guest; // combine into result string
		}
		return guests;
	}
	
	/**
	 * Extra task №1
	 * Takes a positive integer and returns the next bigger number that can be formed by rearranging its digits.
	 * If the digits can't be rearranged to form a bigger number, return -1
	 * @param number
	 * @return next bigger integer according to these rules
	 */
	public static int nextBigger(int number) {
		char[] digits = String.valueOf(number).toCharArray(); // found converting to string the most simple way to get an array of number digits
		for (int i = digits.length - 1; i > 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				if (digits[j] < digits[i]) { // swap the exponent rank with the closest higher one
					char tmp = digits[j];
					digits[j] = digits[i];
					digits[i] = tmp;
					return Integer.parseInt(String.valueOf(digits)); // converting back to int
				}
			}
		}
		return -1;
	}
	
	/**
	 * Extra task №2
	 * Takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
	 * @param number - unsigned 32 int
	 * @return a string representation of its IPv4 address
	 */
	public static String numberToIPv4(long number) {
		String ip = "";
		// converting toBinaryString and expanding right with zeros to 32 chars
		String binary = String.format("%1$" + 32 + "s", Long.toBinaryString(number)).replace(' ', '0');
		for (String octet : binary.split("(?<=\\G.{8})")) { // split into substrings with length 8
			ip += Integer.parseInt(octet, 2) + "."; // convert each octet to integer
		}
		return ip.substring(0, ip.length()-1); // exclude last char, what is an unnecessary dot
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
		
		// Tests for task 4
		assertEquals(numberOfTargetPairs(5, new int[]{1,3,6,2,2,0,4,5}), 4);
		assertEquals(numberOfTargetPairs(6, new int[]{3,3,4,2,0,0,0}), 2);
		
		// Tests for task 5
		assertTrue(meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjorn:Tornbull;Raphael:Corwill;Alfred:Corwill")
				.equals("(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJORN)")
				);
		
		// Tests for extra task 1
		assertEquals(nextBigger(12), 21);
		assertEquals(nextBigger(513), 531);
		assertEquals(nextBigger(2017), 2071);
		assertEquals(nextBigger(9), -1);
		assertEquals(nextBigger(111), -1);
		assertEquals(nextBigger(531), -1);
		
		// Tests for extra task 2
		assertTrue(numberToIPv4(2149583361l).equals("128.32.10.1"));
		assertTrue(numberToIPv4(32).equals("0.0.0.32"));
		assertTrue(numberToIPv4(0).equals("0.0.0.0"));
		
		System.out.print("Finished successfully");
		
	}

}
