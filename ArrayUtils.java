/*
Yikai Wang
APCS1 pd9
HW27 -- Objectify Your Array Tools
2015-11-9
*/

public class ArrayUtils {

   public static void populate( int[] array, int upper, int lower )
   {
      for( int i = 0; i < array.length; i++ )
      {
         double num = lower + ( ( upper - lower ) * Math.random() );//a number in the range

         array[ i ] = ( int ) num;//changes the value
      }
   }

   public static String Stringifier( Object[] array )
   {
      String stringrays = "";//creates an empty String

      for( int i = 0; i < array.length; i++ ) //iterates through the array
      {
         stringrays += (array[i] + " "); //converts the ints to String
      }

      return stringrays.substring( 0, stringrays.length() - 1 );
   }

   public static int linSearch( Object[] a, Object target )
    {
   for( int i = 0; i < a.length; i++ )
       {
         if ( ( a[i] + "" ).equals( target + "" )) {
            return i; //once it finds the first element, returns index
         }
       }
   return -1; //if none found
    }

    public static void helper( String[] newa, Object[] a, int index )
    { //helper function that creates a duplicate array without the 1st element
      if( index < a.length ) //if it reached the end
      {
         newa[ index - 1 ] = a[ index ] + ""; //copies
         helper( newa, a, ++index ); //goes to next element
      }
    }

    public static int linSearchR( Object[] a, Object target )
    {
      if( freqRec( a, target ) == 0 )//if the array doesn't have the target
      {
         return -1;
      }

      else if ( ( a[0] + "" ).equals( target + "" ))
      {
         return 0;
      }

      else //keeps going until it reaches index
      {
         String [] newa = new String[ a.length - 1 ];
         helper( newa, a, 1 );
         return 1 + linSearchR( newa, target );
      }
   }

   public static int freq( Object[] a, Object target )
   {
      int ctr = 0;

      for( int i = a.length - 1; i > -1; --i )
         {
            if ( ( a[i] + "" ).equals( target + "" ))
            {
               ++ctr; //increments whenever element matches
            }
         }

      return ctr;
   }

   public static int freqRec( Object[] a, Object target )
   {
      if ( ( a[0] + "" ).equals( target + "" ) && a.length == 1 )
      {
         return 1; //if the target is the first element and the last element of the array
      }

      else if ( a.length > 1 ) //if the array is longer
      {
         String [] newa = new String[ a.length - 1 ];
         helper( newa, a, 1 ); //creates duplicate without first element

         if ( ( a[0] + "" ).equals( target + "" )) //if target is the first element
         {
            return 1 + freqRec( newa, target ); //++frequency
         }

         else
         {
            return freqRec( newa, target ); //keeps going
         }
      }

      return 0; //if no matches were found
   }

   public static void main(String[] args) {
      Object[] array = { 1, "2", "3", 5.0, 8, '0' }; //an array of 10 Objects

      System.out.println("-----Stringifier-------");
      System.out.println( Stringifier( array ) ); //displays the array in a String

      Double[] arry = { 2.0, 2.1, -3.0, 2.5, 9.5 };
      String[] arrz = { "1", "0", "1", "4", "-9" };

      System.out.println("-----linSearch-------");
      System.out.println( linSearch( arry, 5.0 ) ); //-1
      System.out.println( linSearch( arry, 2.0 ) ); //0

      System.out.println("-----linSearchR------");
      System.out.println( linSearchR( arry, 5.0 ) ); //-1
      System.out.println( linSearchR( arry, 9.5 ) ); //4

      System.out.println("-----freq------------");
      System.out.println( freq( arrz, 5 ) ); //0
      System.out.println( freq( arrz, 1 ) ); //2

      System.out.println("------freqRec--------");
      System.out.println( freqRec( arrz, linSearch( arry, 2.5 ) + 1 )); //1 ( 2.5 appears once in arrz )
      System.out.println( freqRec( arrz, 1 )); //2
   }
}
