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
	int jholder = 0;
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data.length; j++) {
		if (data[j] < data[indexCurrentLowestElement]){
		    indexCurrentLowestElement = j;
		}
		jholder = indexCurrentLowestElement;
	    
	    }
	    data[jholder] = data[i];
	    data[i] = data[indexCurrentLowestElement];
	}
    }
    public static void insertionSort(int[] data){
	int indexCurrentval = 0;
	for (int i = 1; i < data.length; i++) {
	    indexCurrentval = i;
	    for(int j = i; j >= 0; j--) {
		if (data[indexCurrentval] <= data[j-1]) {
		    indexCurrentval = j;
		    break;
		}
		data[j] = data[i];
	    }
	    
	    data[i] = data[indexCurrentval];
	}
    }

    public static void print(int[] data) {
	String ans = "";
	for (int i = 0; i < data.length; i++) {
	    ans = ans + data[i] + ", ";
	}
	System.out.println("[ " + ans + "]");
    }

    public static void main(String[] args){
	int[] a = {5, 3, 4, 2, 1};

	String initial = "{";
	for (int i = 0; i < a.length; i++) {
	    initial += a[i] + " ";
	}
	System.out.println(initial + "}");


	selectionSort(a);
	System.out.println(initial + "}");
    }
}

		    
		    


