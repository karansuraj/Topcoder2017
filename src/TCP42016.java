import java.util.HashSet;

public class TCP42016 {
	private HashSet<Object> mySet = new HashSet<Object>();
	
	public synchronized void add(Object in){
		synchronized(mySet){
			mySet.add(in);
		}
	}
	
	private synchronized void doRemove(Object out){
		mySet.remove(out);
	}
	
	public void remove(Object out){
		synchronized(mySet){
			doRemove(out);
		}
	}
	/*public static void main(String[] args){
		Class Hello = new TCP4;
		remove("hi");
		
	}*/
}
