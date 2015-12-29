/*
Yikai Wang
APCS1 pd9
2015-12-28
*/

import java.util.ArrayList;

//This programs gets the average runtime of 
public class MySorts {
	//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
        //     offset + rand int on interval [lo,hi]
        retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
        size--;
    }
    return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
    int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
        //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
        //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static void main( String[] args ) {
		ArrayList coco = populate( 100, 1, 500 );

		System.out.println( "~~~~~~~~BubbleSort~~~~~~~~");
		
		double avg = 0.0;
		for(int i = 0; i < 100; i++) {
			long current = System.nanoTime();
			BubbleSort.bubbleSortV(coco);
			avg += System.nanoTime() - current; //sums the time
			shuffle(coco); //re-arrange
		}

		System.out.println( "For size 100:" );
		System.out.println( "Took an average of " + avg/100 + " nanoseconds." );

		System.out.println( "~~~~~~~~SelectionSort~~~~~~~~");

		avg = 0.0;
		for(int i = 0; i < 100; i++) {
			long current = System.nanoTime();
			SelectionSort.selectionSortV(coco);
			avg += System.nanoTime() - current; //sums the time
			shuffle(coco); //re-arrange
		}

		System.out.println( "For size 100:" );
		System.out.println( "Took an average of " + avg/100 + " nanoseconds." );

		System.out.println( "~~~~~~~~BogoSort~~~~~~~~");

		ArrayList cena = populate( 10, 1, 500 );

		avg = 0.0;
		for(int i = 0; i < 2; i++) {
			long current = System.nanoTime();
			BogoSort.bogoSortV(cena);
			avg += System.nanoTime() - current; //sums the time
			shuffle(cena); //re-arrange
		}

		System.out.println( "For size 10:" );
		System.out.println( "Took an average of " + avg/2 + " nanoseconds. (Only 2 trials because it took very long.)" );
	}
}