package tobias.saul.datastructure;

//FIFO
//enqueue, dequeue, search, access
public class _Queue<X> {
	
	private X[] data;
	
	//array pointer locations
	//where is the beginning and end
	private int front;
	private int end;
	
	public _Queue() {
		this(1000);
	}
	
	@SuppressWarnings("unchecked")
	public _Queue (int size) {
		this.front = -1;
		this.end = -1;
		data= (X[]) new Object[size];
	}
	
	public int size() {
		
		//no items in structure yet so empty
		if(front == -1 && end == -1) {
			return 0;
		}
		// otherwise add one to get inclusive subtraction value 
		else {
			return end - front + 1; 
		}
	}
	
	public void enQueue(X item) {
		//check if queue is full
		if((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		
		//check if any item has been added to queue yet/if empty
		else if(size() == 0) {
			front++;
			end++;
			data[end] = item;
		}
		//otherwise add item to end of queue
		else {
			end++;
			data[end] = item;
		}
	}
	
	public X deQueue() {
		//placeholder for item that might be returned
		X item = null;
		
		if(size() == 0) {
			throw new IllegalStateException("No items in queue");
		}
		//if last item on queue
		else if(front == end) {
			//grab the item from the front
			item = data[front];
			//for GC purposes
			//since grabbed the front item, no more item at the front
			data[front] = null;
			//reset queue positions
			front = -1;
			end = -1;
		}
		//otherwise grab the front item of stack, adjust pointer
		else {
			item = data[front];
			data[front] = null;
			front++;
		}
		
		return item;
	}
	
	public boolean contains(X item) {
		boolean found = false;
		
		//if queue empty, no items so return false
		if(size() == 0) {
			return found;
		}
		
		//loop the array to see if item exists in structure
		for(int index = front; index < end; index++) {
			if(data[index].equals(item)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	// access item at an index given
	public X access(int position) {
		//check for any position mishaps
		if(size() == 0 || position > size()) {
			throw new IllegalStateException("No items in the queue or posisition exceeds size of queue");
		}
		
		//set true index because front of queue might not be at position 0
		//position moves around
		int trueIndex = 0;
		//loop through to try and find item
		for(int index = front; index < end; index++) {
			//if a match occurs for position given and true index, return item at current index in iteration of array
			if(trueIndex == position) {
				return data[index];
			}
			//increase to keep with "front" index
			trueIndex++;
		}
		
		//if no item found at position throw exception
		throw new IllegalStateException("Could not retrieve queue item at position " + position);
	}

}
