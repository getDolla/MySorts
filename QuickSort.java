/*
Yikai Wang
APCS2 pd5
HW31 -- Fast Selection
2016-04-13
*/

public class QuickSort {

	public static void QuickSort( int[] arr ) {
	    helpSort( arr, 0, arr.length-1 ); //uses helper function
	}

	private static void helpSort( int[] arr, int lo, int hi ) {
		if( lo >= hi ) return; //bounds are the same; one element remaining

		//display( arr ); debug

		int compare = partition( arr, hi/2 + 1, lo, hi ); //stores data

		if( lo == compare ) helpSort( arr, lo + 1, hi); //if element is the lowest

		else if( compare == hi ) helpSort( arr, lo, hi-1 ); //bigger element
		
		else {
		    helpSort( arr, lo, compare-1 ); //sorts through the remaining array (dont touch pivot again)
		    helpSort( arr, compare+1, hi );
		}
	}

	private static int partition( int[] arr, int pPos, int left, int right ) {
		int pvtVal = arr[pPos]; //get the pivot value
		swap( arr, pPos, right ); //moves pivot to end

		int savPos = left; //for moving smaller values
		for(int i = left; i < right; i++) {
			if( arr[i] < pvtVal ) { //if value is smaller
				swap( arr, savPos, i ); //move to relatively correct position
				savPos++;
			}
		}
		swap( arr, right, savPos ); //moves the pivot value to its relative position
		return savPos;
	}

    private static void swap( int[] arr, int index1, int index2 ) { //method to swap values in array
		int temp = arr[index1]; //temp to store value
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void display( int[] array ) { //method to display array
		System.out.print( "[ ");
		
		for( int n : array ) System.out.print( n + ", " );
		
		System.out.println( "]" );
	}

	public static void main( String[] args ) {
		int[] array1 = { 7, 5, 1, 12, 3 };
		int[] array2 = { 2, 3, 20, 1, 19 };

		QuickSort( array1 );
		QuickSort( array2 );

		System.out.println( "Sort array1: " ); //
		display( array1 ); //check "sorting"

		System.out.println( "Sort array2: " ); //
		display( array2 );
	}	
}