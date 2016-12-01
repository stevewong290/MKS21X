public class Book{
    private String author;
    private String title; 
    private String ISBN;
    public Book(){ } 
    public Book(String a,String t, String i){
	author = a;
	title = t;
	ISBN = i;
    }
    public String getAuthor(){
	return author;
    }
    public String getTitle(){
	return title;
    }
    public String getISBN(){
	return ISBN;
    } 
    public void setAuthor(String s){
	author = s;
    }
    public void setTitle(String s){
	title = s;
    } 
    public void setISBN(String s){
	ISBN = s;
    }
    public String toString(){
	return title + ", "+author +", "+ISBN;
    }
}
 
