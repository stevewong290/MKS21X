import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
     // default constructor - empty SuperArray, size 0 capactiy 10
     public SuperArray() {
	 size = 0;
	 data = new String[10];
	     }
    // constructor - empty SuperArray, size 0 capacity int
    public SuperArray(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new String[initialCapacity];
    }
     // returns size
    public int size(){
	return size;
    }

     
    // returns the element at the specified position
    public String get(int index){
	if((index < 0) || (index >= size())){ 
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
     // clears the array
    public void clear(){
	String[] temp = new String[data.length];
	data = temp;
	size = 0;
    }
     // checks whether the array is empty
    public boolean isEmpty(){
	if(size == 0) return true;
	else return false;
    }
     // sets an element to a certain index
    public String set(int index, String str){
        if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	data[index] = str;
	return data[index];
    }
    
    // resize data, new array & copying over elements
    private void grow(){
	String[] temp = new String[data.length * 2];
	for(int i = 0; i < data.length; i++){
	    temp[i] = data[i];
	}
	data = temp;
    }
     
    // add value n to next available slot, return true
    public boolean add(String n){
	if(size == data.length){
	    this.grow();
	}
	data[size] = n;
	size++;
	return true;
    }

    // inserts element at index, shifts everything after that element to the right
    public void add(int index, String str){
	if(size == data.length){
	    this.grow();
	}
	for(int i = size; i > index; i--){
	    data[i] = data[i - 1];
	}
	data[index] = str;
	size++;
    }
     // removes element at index, shifts everything after that element to the left
    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String removedValue = data[index];
	for(int i = index; i < size; i++){
	    data[i] = data[i + 1];
	}
	size--;
	return removedValue;
    }
     // shows the array
    public String[] toArray(){
	String[] presentArray = new String[size];
	for(int i = 0; i < size; i++){
	    presentArray[i] = data[i];
	}
	return presentArray;
    }
     // finds the index of a certain string
     public int indexOf(String n){
	for(int i = 0; i < size; i++){
	    if(n == data[i]){
		return i;
	    }
	}
	return -1;
    }
     // finds the last occurence of a certain string
    public int lastIndexOf(String n){
	for(int i = size-1; i >= 0; i--){
	    if(n == data[i]){
		return i;
	    }
	}
	return -1;
    }
    
    public Iterator<String> iterator() {
	return new SuperArrayIterator(this);
    }
    
    public String toString(){
	String temp = "[";
	for(int i = 0; i < size; i++){
	    if(i == (size-1)){
		temp += data[i];
	    }
	    else {
		temp += data[i] + ", ";
	    }
	}
	return temp + "]";
    }
    
    public String toStringDebug(){
	String temp = "[";
	for(int i = 0; i < size; i++){
	    if(i == (data.length-1)){
		temp += data[i];
	    }
	    else{
		temp += data[i] + ", ";
	    }
	}
	for(int i = size; i < data.length; i++){
	    if(i == (data.length-1)){
		temp += "_";
	    }
	    else{
		temp += "_, ";
	    }
	}
	return temp + "]";
    }
}
