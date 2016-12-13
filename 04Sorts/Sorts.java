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
      int ans[] = new int[data.length  ];
      int currentLowestElement = data[0];
      for (int i = 0; i < data.length; i++) {
	  for (int j = 0; j < data.length; j++) {
	      if (data[j] < currentLowestElement){
		  currentLowestElement = data[j];
	      }
	  }
	  ans[i] = currentLowestElement;
      }
  }
}

