class CirculatingBook extends ReferenceBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String a,String t, String i, String c){
	super(a,t,i,c);
	currentHolder = "";
	dueDate = "";
    }
    public String getDueDate(){
	return dueDate;
    }
    public String getCurrentHolder(){
	return currentHolder;
    }
    public void setDueDate(String s){
	dueDate = s;
    }
    public void setCurrentHolder(String s){
	currentHolder = s;
    }
    public void checkout(String n, String d){
	setDueDate(d);
	setCurrentHolder(n);
    }
    public void returned(){
	setDueDate("");
	setCurrentHolder("");
    }
    public String toString(){
	String s = super.toString();
	if(!(currentHolder.equals(""))){
	    return s +", " + getCurrentHolder();
	}
	if(!(dueDate.equals(""))){
	    return s +", " + getDueDate();
	}
	else {
	    return s;
	}
    }
}
