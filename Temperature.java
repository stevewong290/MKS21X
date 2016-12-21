public class Temperature{
    public static double CtoF(double celsius) {
	return celsius * 9 / 5 + 32;
    }
    public static double FtoC(double fahren) {
	return (fahren - 32) * 5 / 9;
    }
    public static void main(String[] args) {
	System.out.println(CtoF(100.0));
	System.out.println(CtoF(0.0));
	System.out.println(FtoC(32.0));
	System.out.println(FtoC(212.0));

    }
}
