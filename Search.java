/**
 * @author Brian Ha
 * @version 1.0
 */
public class Search {

	/**
	 * Modified binary search that finds location in A where all elements A[0], ..., A[j-1]
	 * are strictly less than x and all elements A[j], ..., A[n-1] are greater than or 
	 * equal to x.
	 * @param A array mentioned above with ascending integers; not guaranteed to be unique
	 * @param x target integer
	 * @return  the location at which the condition above is satisfied; -1 if the location does not exist
	 */
	int search(int[] A, int x){
		int end = A.length - 1;
		
		if (x <= A[0] || x > A[end]) { // condition cannot be satisfied with given x; no valid location j exists
			return -1;
		}
		
		int begin = 0;
		
		while (end > begin) { // in other words, while the current range considered includes more than one element
			int middle = (begin + end) / 2;
			if (A[middle] == x) {				
				/* If x exists in A must return lowest index j such that A[j] = A[middle]. */
				while (middle > 0 && A[middle - 1] == A[middle]){
					middle--;
				}
				return middle;
			}
			if (A[middle] < x) {
				begin = middle + 1;		
			}
			if (A[middle] > x) {
				end = middle - 1;
			}
		}

		if (A[end] == x || A[end] > x) {
			return end;			
		} else {
			return end + 1;
		}
	}
}
