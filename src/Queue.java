import java.io.*;
import java.util.*;
public class Queue {
  List<Tree> head;
  int size;
  public Queue (){
    head = null;
  }

  public void add(Tree t){
    if(head == null){
      head = new ArrayList<Tree>();
      head.add(t);
      size = 1;
      return;
    }
    for(int counter = 0; counter < head.size(); counter++){
      if(head.get(counter).h <=t.h){
        head.add(counter,t);
        size = head.size();
        return;
      }
    }
    head.add(t);

  }

  public void traverse(){
    for(int counter = 0; counter < head.size(); counter++){
      if(head.get(counter) != null){
        System.out.print("" + head.get(counter).h+ "");
      }
    }
  }
  public Tree pop(){
    if(head == null){
      return null;
    }
    Tree res = head.get(0);
    head.remove(0);
    size--;
    if(size == 0){
      head = null;
    }
    return res;
  }
}
