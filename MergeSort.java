/*
Yikai Wang
APCS2 PD5
HW09 -- Mergers and Acquisitions
2016-03-05
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

The algorithm has the following base cases:

1) If the array it recieves has a length of 1, then it is sorted. This array is then returned.

2) If the array has more than 1 element:
    -it first splits the array into 2 arrays.
    -These 2 arrays should be sorted by the daughter methods.
    In the merge function: 
    -After receiving the 2 sorted arrays through sorted, the method would use a while loop.
    In the while loop:
    -sees if the first element of one array is less than the first element of the other
    array. 
    -It would then take the smaller element and put it in the bottom of the new array. This continues
    until all of the elements in one array are in the new array.
    After the while loop:
    -the new array will run a for loop to get the remaining elements. It would contain all of the elements of the 2 sorted arrays.
    -After that is done, return the newly created array. If done correctly, this array would also be sorted.
  
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
    int[] newA = sort( a ); //gets sorted arrays
    int[] newB = sort( b );

    int indexA = 0; //indexes for each array for use in while loop
    int indexB = 0;
    int i = 0;

    int[] bigArray = new int[a.length + b.length]; //one big array

    while( (indexA < newA.length) && (indexB < newB.length) ) { //untill all of one array's elements are included
        if( newA[indexA] < newB[indexB] ) //if one element is less than the other
            bigArray[i++] = newA[indexA++]; //puts in front

        else
            bigArray[i++] = newB[indexB++];
    }

    if(indexA < newA.length) {//gets remaining elements    
        for( int x = indexA; x < newA.length; x++ )
            bigArray[i++] = newA[x];
        return bigArray;
    }

        
    for( int x = indexB; x < newB.length; x++ )
        bigArray[i++] = newB[x];

    return bigArray;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
    if( arr.length <= 1 ) return arr; //definitely sorted

    else {

        int[] arr1 = new int[arr.length/2]; //for the first half
        for(int i = 0; i < arr1.length; i++) //gets elements
            arr1[i] = arr[i];

        int[] arr2 = new int[(arr.length/2) + (arr.length%2) ]; //second half + remainder
        
        int x = 0;
        for(int i = arr1.length; i < arr.length; i++) //gets elements
            arr2[x++] = arr[i];

        return merge( arr1, arr2 );
    }

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
        a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
        System.out.print( i + ",");
    System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


    int[] arr0 = {0};
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {3,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {4,3,2,1};
    int[] arr6 = {9,42,17,63,0,512,23};
    int[] arr7 = {9,42,17,63,0,9,512,23,9};

    System.out.println("\nTesting mess-with-array method...");
    printArray( arr3 );
    mess(arr3);
    printArray( arr3 );

    System.out.println("\nMerging arr1 and arr0: ");
    printArray( merge(arr1,arr0) );

    System.out.println("\nMerging arr4 and arr6: ");
    printArray( merge(arr4,arr6) );

    System.out.println("\nSorting arr4-7...");
    printArray( sort( arr4 ) );
    printArray( sort( arr5 ) );
    printArray( sort( arr6 ) );
    printArray( sort( arr7 ) );

    }//end main()

}//end class MergeSort