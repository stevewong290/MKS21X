public class Tester{
    public static void main(Strings args[]){
	int[] a = {5, 3, 4, 2, 1};

	String initial = "{";
	for (int i = 0; i < a.length; i++) {
	    initial += a[i] + " ";
	}
	System.out.println(intial + "}");


	selectionSort(a);
}
