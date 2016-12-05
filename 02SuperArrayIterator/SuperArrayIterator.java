import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    int element = 0;
    SuperArray a = new SuperArray();
    
  public SuperArrayIterator(SuperArray b){
    this.a = b;
  }

  public String next(){
    if(hasNext()){
      element++;
      return a.get(element -1);
    }
    else{
      throw new NoSuchElementException();
    }
  }

  public boolean hasNext(){
      return element < a.size();
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

}
