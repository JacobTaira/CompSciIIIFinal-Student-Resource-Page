import java.util.LinkedList;

public class MySet<E> implements Set<E>{
    private LinkedList<E> list;
    
    public MySet(){
        list = new LinkedList<E>();
    }
    
    public boolean isEmpty(){
        if(list.isEmpty())
            return true;
        return false;
    }
    
    public int size(){
        return list.size();
    }
    
    public boolean contains(Object obj){
        if(list.contains(obj))
            return true;
        return false;
    }
    
    public boolean remove (Object obj){
        if(list.contains(obj)){
            list.remove(obj);
            return true;}
        return false;
    }
    
    public boolean add(E item){
        if(!list.contains(item)){
            list.add(item);
            return true;}
            return false;
    }
}
