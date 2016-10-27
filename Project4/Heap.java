import java.util.ArrayList;
import java.lang.Comparable;

/**
 * Heap
 * custom generic min heap
 * @author Francisco Fierro
 */
public class Heap<T extends Comparable<T>>{
	/** Arraylist for storing heap elements */
	private ArrayList<T> heap;

	/**
	 * Heap()
	 * basic constructor
	 */
	public Heap(){
		heap = new ArrayList<T>();
	}

	/**
	 * getSize()
	 * @return the heap's size
	 */
	public int getSize(){
		return heap.size();
	}

	/**
	 * isEmpty
	 * @return true if empty, else false
	 */
	public boolean isEmpty(){
		return heap.isEmpty();
	}

	/**
	 * getPLoc
	 * gets index of parent
	 * @param  i the index of node
	 * @return   the index of parent node
	 */
	public int getPLoc(int i){
		return (i-1)/2;
	}

	/**
	 * getLCLoc()
	 * gets index of left child
	 * @param  i index of node
	 * @return   index of left child
	 */
	public int getLCLoc(int i){
		return 2*i+1;
	}

	/**
	 * getRCLoc()
	 * gets index of right child
	 * @param  i index of node
	 * @return   index of right child
	 */
	public int getRCLoc(int i){
		return 2*i+2;
	}

	/**
	 * getAt()
	 * gets node at given index
	 * @param  i the given index
	 * @return   the corresponding node
	 */
	public T getAt(int i){
		if(heap.get(i)==null){
			System. out .println("Item does not exist.");
			return null;
		}else{
		return heap.get(i);
		}
	}

	/**
	 * add()
	 * adds an element to the heap
	 * @param n the element to add
	 */
	public void add(T n){
		heap.add(null);
		int index = heap.size()-1;
		while(index > 0 && getAt(getPLoc(index)).compareTo(n) > 0){
			heap.set(index, getAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}


	/**
	 * removeMin()
	 * removes minimum element from heap
	 * @return the removed min
	 */
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

	/**
	 * printHeap()
	 * prints every element in the heaps
	 */
	public void printHeap(){
		for(int i = 0; i < heap.size(); i++){
			System.out.println(heap.get(i));
			System.out.println("");
		}
		System.out.println("");
	}

}