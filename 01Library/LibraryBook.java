abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber; 
    public LibraryBook(String a,String t, String i, String c){
	super(a,t,i);
	callNumber = c;
    }
    public String getCall(){
	return callNumber;
    }
    public void setCall(String s){
	callNumber = s;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook l){
	String n = callNumber;
	String n2 = l.getCall();
	return n.compareTo(n2);
    }
    public String toString(){
	return super.toString()+ ", " +circulationStatus() + ", " + callNumber;
    }
} 
