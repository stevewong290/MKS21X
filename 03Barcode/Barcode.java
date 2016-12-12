

public class Barcode implements Comparable<Barcode>{
    // instance variables
    private String _zip;
    private int _checkDigit;
    
    // constructors
    //precondtion: _zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public Barcode(String zip) {
	if(zip.length() == 5) {
	    this._zip = zip;
	}
	else {
	    throw new IllegalArgumentException();
	}
      	try {
	    _checkDigit = checkSum(zip);
	} catch(NumberFormatException e) {
	    throw new IllegalArgumentException();
	}
    }
    // postcondition: computes and returns the check sum for _zip
    private static int checkSum(String zip){
	int sum = 0;
	for (int i = 0; i < zip.length(); i++) {
	    sum = sum + Integer.parseInt("" + zip.charAt(i));
	}
	return sum%10;

    }

    //postcondition: format zip + check digit + Barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return _zip + _checkDigit + "   " + toCode(_zip + _checkDigit);

    }
    // put the guardrails in at the return statement
    public static String toCode(String zip) {
	String barcode = "";
	String code = zip + checkSum(zip);
	for(int i = 0; i < 6; i++){
	    switch(code.charAt(i)) {
	    case '0': barcode += "||:::";
		break;
	    case '1': barcode += ":::||";
		break;
	    case '2': barcode += "::|:|";
		break;
	    case '3': barcode += "::||:";
		break;
	    case '4': barcode += ":|::|";
		break;
	    case '5': barcode += ":|:|:";
		break;
	    case '6': barcode += ":||::";
		break;
	    case '7': barcode += "|:::|";
		break;
	    case '8': barcode += "|::|:";
		break;
	    case '9': barcode += "|:|::";
		break;
	    }
	}
	return "|" + barcode + "|";
    }
    
    // code length is 32 because there should be 5 numbers from the zip code and 1 number from the checksum. All of this coded turns into 30 characters, but the guardrail on either side pushes it to 32.

    
    public static String toZip(String code) {
	if(code.length() != 32) {
	    throw new IllegalArgumentException();
	}
	if(code.charAt(0) != '|' || code.charAt(31) != '|') {
	    throw new IllegalArgumentException();
	}
	String zipcode = "";
	try {
	    for(int i = 1; i < 31; i++){
		switch(code.substring(i,i+5)) {
		case "||:::": zipcode += "0";
		    break;
		case ":::||": zipcode += "1";
		    break;
		case "::|:|": zipcode += "2";
		    break;
		case "::||:": zipcode += "3";
		    break;
		case ":|::|": zipcode += "4";
		    break;
		case ":|:|:": zipcode += "5";
		    break;
		case ":||::": zipcode += "6";
		    break;
		case "|:::|": zipcode += "7";
		    break;
		case "|::|:": zipcode += "8";
		    break;
		case "|:|::": zipcode += "9";
		    break;
		}
	    }
	} catch(NumberFormatException e) {
	    throw new IllegalArgumentException();
	}
	String zip = zipcode.substring(0,6);
	String check = "" + zipcode.charAt(6);
	if(!zip.equals(check)) {
	    throw new IllegalArgumentException();
	}
	return zip;
    }
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){
	String thiszipcode = this._zip + this._checkDigit;
        String otherzipcode = other._zip + other._checkDigit;
	return thiszipcode.compareTo(otherzipcode);
    }

    public static void main(String args[]){
    //INITIAL TESTS
    System.out.println("\nINITIAL TESTS");
    Barcode a = new Barcode("08451");
    Barcode b = new Barcode("99999");
    Barcode c = new Barcode("11111");
    System.out.println(a); //084518 |||:::|::|::|::|:|:|::::|||::|:|
    System.out.println(a.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
    System.out.println(a.compareTo(a)); //0
    System.out.println(b.compareTo(a)); //9
    System.out.println(c.compareTo(a)); //1
		
    //more tests for second part of the lab:

    //
    //CONSTRUCTOR TESTS
    //
	
    System.out.println("\nCONSTRUCTOR TESTS");
    System.out.println(new Barcode("99999"));
    try{
	new Barcode("024df");
    }catch(IllegalArgumentException e){
	e.printStackTrace(); //zip contains a non digit
    }
	
    try{
	new Barcode("010101010");
    }catch(IllegalArgumentException e){
	e.printStackTrace(); //zip is not correct length
    }
	
    //
    //toCode TESTS
    //
	
    System.out.println("\ntoCode TESTS");
    System.out.println(Barcode.toCode("99999"));
    //Barcode b = new Barcode("99999"); //already done in init tests
    String zipOfB = (b.toString()).substring(7); // slices off begin zip part
    System.out.println(Barcode.toCode("99999").compareTo(zipOfB)); //0

    //exceptions for toCode()
    try{
	Barcode.toCode("222222");
    }catch(IllegalArgumentException e){
	e.printStackTrace(); //given zip is not correct length
    }
	
    try{
	Barcode.toCode("eeeef");
    }catch(IllegalArgumentException e){
	e.printStackTrace(); //given zip contains a non digit
    }

    //
    //toZip TESTS
    //
    System.out.println("\ntoZip TESTS");
    System.out.println(Barcode.toZip(Barcode.toCode("99999"))); //99999

    //exceptions for toZip()
    try{
	Barcode.toZip("|:|");
    }catch(IllegalArgumentException e){
	e.printStackTrace();//not correct length
    }

    try{
	Barcode.toZip("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }catch(IllegalArgumentException e){
	e.printStackTrace();//invalid guard rails
    }

    try{
	Barcode.toZip("|eeeeeeeeeeeeeeeeeeeeeeeeeeeeee|");
    }catch(IllegalArgumentException e){
	e.printStackTrace();//invalid barcode characters
    }

    try{
	Barcode.toZip("|||:::|::|::|::|:|:||||:|||::|:|");
    }catch(IllegalArgumentException e){
	e.printStackTrace();//encoded int invalid
    }

    try{
	Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|||");
    }catch(IllegalArgumentException e){
	e.printStackTrace();//invalid checkDigit
    }
	

}	

    
}


