import java.util.ArrayList;
import java.lang.Comparable;

public class Heap<T extends Comparable<T>>{
	private ArrayList<T> heap;
	public Heap(){
		heap = new ArrayList<T>();
	}
	public int getSize(){
		return heap.size();
	}
	public boolean isEmpty(){
		return heap.isEmpty();
	}
	public int getPLoc(int i){
		return (i-1)/2;
	}
	public int getLCLoc(int i){
		return 2*i+1;
	}
	public int getRCLoc(int i){
		return 2*i+2;
	}

	public T getAt(int i){
		if(heap.get(i)==null){
			System. out .println("Item does not exist.");
			return null;
		}else{
		return heap.get(i);
		}
	}

	public void add(T n){
		heap.add(null);
		int index = heap.size()-1;
		while(index > 0 && getAt(getPLoc(index)).compareTo(n) > 0){
			heap.set(index, getAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}
	public T removeMin(){
		if(!isEmpty()){
			T min = heap.get(0);
			int index = heap.size()-1;
			T last = heap.remove(index);
			if(index > 0){
				heap.set(0, last);
				T root = heap.get(0);
				int end = heap.size()-1;
				index = 0;
				boolean done = false;
				while(!done){
					if(getLCLoc(index)<=end){//left exists
						T child = getAt(getLCLoc(index));
						int childLoc = getLCLoc(index);
						if(getRCLoc(index)<=end){//rt exists
							if(getAt(getRCLoc(index)).compareTo(child) < 0){
								child = getAt(getRCLoc(index));
								childLoc = getRCLoc(index);
							}
						}
						if(child.compareTo(root) < 0){
							heap.set(index, child);
							index = childLoc;
						}else{
							done = true;
						}
					}else{//no children
						done = true;
					}
				}	
				heap.set(index, root);
			}
			return min;
		}
		return null;
	}

	public void printHeap(){
		for(int i = 0; i < heap.size(); i++){
			System.out.println(heap.get(i).toString());
			System.out.println("");
		}
		System.out.println("");
	}

}