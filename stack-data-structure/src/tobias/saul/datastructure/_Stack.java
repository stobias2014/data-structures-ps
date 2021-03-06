package tobias.saul.datastructure;

//LIFO
public class _Stack<X> {
	
	// to hold data
	private X[] data;
	// increment or decrement where I am in stack
	private int stackPointer;
	
	// initialize size of container
	@SuppressWarnings("unchecked")
	public _Stack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
	}
	
	//add item to top of stack
	public void push(X item) {
		// place item at current stackPointer, then increment position
		data[stackPointer++] = item;
	}
	
	//retrieves and removes item from top of stack
	public X pop() {
		// can not remove item since no items to remove
		// can not have a negative stackPointer
		if(stackPointer == 0) {
			throw new IllegalStateException("No more items in stack");
		}
		// decrement stackPointer, then return value
		return data[--stackPointer];
	}
	
	public boolean contains(X item) {
		boolean doesContainItem = false;
		
		// loop through items to check existence of item
		for(int index = 0; index < stackPointer; index++) {
			if(data[index].equals(item)) {
				doesContainItem = true;
				break;
			} 
		}
		
		return doesContainItem;
	}
	
	public X access(X item) {
		X itemToAccess = null;
		
		for(int index = stackPointer; index > 0; index--) {
			itemToAccess = pop();
			if(itemToAccess.equals(item)) {
				return itemToAccess;
			}
		}
		
		throw new IllegalStateException("Item not found. ");
	}
	
	public int size() {
		return stackPointer;
	}
	
}
