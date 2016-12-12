

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
    
    
}


