import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Brian Ha
 * @version 1.0
 */
public class SearchTests {

	@Test
	public void completeTest() {
		Search tester = new Search();
		
		/* Test arrays for A. */
		int[] A1 = {-5, -2, 0, 1, 1, 6, 10, 11, 11, 11, 22}; //length 11 array - odd
		int[] A2 = {-7, 2, 6, 8, 9, 9, 9, 100}; //length 8 array - even
		int[] A3 = {1, 1, 3, 3, 3, 3, 3, 5, 5}; //non-unique case #1
		int[] A4 = {1, 2, 2, 2, 2, 2, 3, 3, 3, 5, 5, 5}; //non-unique case #2
		
		/* Test cases for A1. */
		assertEquals("should be -1", -1, tester.search(A1, -5));
		assertEquals("should be 2", 2, tester.search(A1, -1));
		assertEquals("should be 3", 3, tester.search(A1, 1));
		assertEquals("should be 5", 5, tester.search(A1, 5));
		assertEquals("should be 5", 5, tester.search(A1, 6));
		assertEquals("should be 6", 6, tester.search(A1, 7));
		assertEquals("should be 6", 6, tester.search(A1, 10));
		assertEquals("should be 7", 7, tester.search(A1, 11));
		assertEquals("should be 10", 10, tester.search(A1, 20));
		assertEquals("should be 10", 10, tester.search(A1, 22));
		
		/* Test cases for A2. */
		assertEquals("should be -1", -1, tester.search(A2, -7));		
		assertEquals("should be 1", 1, tester.search(A2, -2));
		assertEquals("should be 1", 1, tester.search(A2, 2));
		assertEquals("should be 3", 3, tester.search(A2, 8));
		assertEquals("should be 4", 4, tester.search(A2, 9));
		assertEquals("should be 7", 7, tester.search(A2, 12));
		assertEquals("should be 7", 7, tester.search(A2, 100));
		assertEquals("should be -1", -1, tester.search(A2, 1000));
		
		/* Test cases for A3. */
		assertEquals("should be -1", -1, tester.search(A3, 0));
		assertEquals("should be -1", -1, tester.search(A3, 1));
		assertEquals("should be 2", 2, tester.search(A3, 3));
		assertEquals("should be 7", 7, tester.search(A3, 5));
		assertEquals("should be -1", -1, tester.search(A3, 6));
		
		/* Test cases for A4. */
		assertEquals("should be 1", 1, tester.search(A4, 2));
		assertEquals("should be 9", 9, tester.search(A4, 5));
	}
}
