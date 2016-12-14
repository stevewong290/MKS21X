public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "01.Wong.Steve"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      int indexCurrentLowestElement = 0;
      for (int i = 0; i < data.length; i++) {
	  for (int j = 0; j < data.length; j++) {
	      if (data[j] < data[indexCurrentLowestElement]){
		  indexCurrentLowestElement = j;
	      }
	  }
	  data[j] = data[i];
	  data[i] = data[indexCurrentLowestElement];
      }
  }
    public static void insertionSort(int[] data){
	int indexCurrentval = 0;
	for (int i = 1; i < data.length; i++) {
	    indexCurrentval = i;
	    for(int j = i; j >= 0; j--) {
		if (data[indexCurrentval] < data[j-1]) {
		    
		    
}

