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

    
    /*

      public static void selectionSort(int[] data){
	int indexCurrentLowestElement = 0;
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data.length; j++) {
		if (data[j] < data[indexCurrentLowestElement]){
		    indexCurrentLowestElement = j;
		}
	    
		data[j] = data[i];
	    }
	    data[i] = data[indexCurrentLowestElement];
	}
    }
*/
     public static void selectionSort(int[] data){
      for(int i = 0; i < data.length; i++) {
	  int init = data[i];
	  int current = data[i];
	  int place = i;
	  for(int j = i + 1; j < data.length; j++) {
	      if(data[j] < init) {
		  init = data[j];
		  place = j;
	      }
	  }
	  data[i] = minnie;
	  data[place] = current;	  
      }
  }
    
    public static void insertionSort(int[] data){
	for (int i = 1; i < data.length; i++) {
	    int j = i + 1;
	    int current = data[j];
	    int relativemin = j;
	    for(int index = i; index >= 0; index--) {
		if (current < data[index]) {
		    relativemin = index;
		    data[index + 1] = data[index]
		}
	    }
	    
	    data[relativemin] = current;
	}
    }

    public static void bubbleSort(int[] data) {
	boolean done = false;
	for (int times = 0; times < data.length && !done ; times++) {
	    int swapcount  = 0;
	    for (int current = 0; current < data.length-times-1; current++) {
		if (data[current] > data[current + 1]){
		    int temp = data[current + 1];
		    data[current + 1] = data[current];
		    data[current] = temp;
		    swapcount++;
		}
	    }
	    if (swapcount == 0){
		done = true;
	    }
	}

    
    }
    /*
    public static void print(int[] data) {
	String ans = "";
	for (int i = 0; i < data.length; i++) {
	    ans = ans + data[i] + ", ";
	}
	System.out.println("[ " + ans + "]");
    }
    public static void main(String args) {
	int[] Test = {5, 4, 3, 2, 1};
	print Test;
	insertionSort(Test);
	print Test;
    }
    */
		    
		    
}



		    
		    


