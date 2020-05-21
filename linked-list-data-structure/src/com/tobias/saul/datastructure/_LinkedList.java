package com.tobias.saul.datastructure;

//node structure for a linked list

public class _LinkedList<X> {
	
	private Node first;
	private Node last;
	private int nodeCount;
	
	public _LinkedList() {
		this.first = null;
		this.last = null;
		this.nodeCount = 0;
	}
	
	public int size() {
		return nodeCount;
	}
	
	public void add(X item) {
		// adding something for the first time
		if(first == null) {
			first = new Node(item);
			last = first;
		}
		//otherwise grab the last node and update its value
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			// reinitialize last pointer to new last node
			last = newLastNode;
		}
		
		// increase the count of node since new node added
		nodeCount++;
	}
	
	public X remove() {
		if(first == null) {
			throw new IllegalStateException("No items in List");
		}
		
		//grab the item for first node;
		X nodeItem = first.getNodeItem();
		
		// update the first pointer
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;
	}
	
	public X get(int position) {
		if(first == null) {
			throw new IllegalStateException("No items in linked list");
		}
		
		Node currentNode = first;
		for(int i = 0; i < size() && currentNode != null; i++) {
			if(i == position) {
				return currentNode.getNodeItem();
			}
			
			currentNode = currentNode.getNextNode();
		}
		
		// if did not find 
		return null;
	}
	
	public int find(X item) {
		if(first == null) {
			throw new IllegalStateException("No items");
		}
		
		Node currentNode = first;
		for(int index = 0; index < size() && currentNode != null; index++) {
			if(currentNode.getNodeItem().equals(item)) {
				return index;
			}
			
			currentNode = currentNode.getNextNode();
		}
		
		return -1;
	} 
	
	@Override
	public String toString() {
		StringBuffer content = new StringBuffer();
		Node currentNode = first;
		
		while(currentNode != null) {
			content.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();
			
			if(currentNode == null) {
				content.append(", ");
			}
		}
		
		return content.toString();
	}

	public void insert(X item, int position) {
		if(position > size()) {
			throw new IllegalStateException("List is smalled than  position provided");
		}
		
		//start at the beginning of nodes
		Node currentNode = first;
		
		//iterate starting at 1 because we already have that node
		//go up to the position provided
		//keep getting the next node, that where you want to place item
		for(int index = 1;index < position && currentNode != null; index++) {
			currentNode = currentNode.getNextNode();
		}
		
		Node newNode = new Node(item);
		//assign a next node
		Node nextNode = currentNode.getNextNode();
		//for the current node set the next node to the new node
		currentNode.setNextNode(newNode);
		//for the new node set the next node
		newNode.setNextNode(nextNode);
		nodeCount++;
		
	}
	
	public X removeAt(int index) {
		if(first == null) {
			throw new IllegalStateException("Empty list");
		}
		
		//start at beginning of nodes
		Node currentNode = first;
		Node prevNode = first;
		
		//start at 1 because we have our first node
		for(int i = 0; i < index && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		//grab the item for the current node
		X item = currentNode.getNodeItem();
		// previous node'next node is set to the current node's next node
		prevNode.setNextNode(currentNode.getNextNode());
		//decrement node count since removed a node
		nodeCount--;
		return item;
	}
	
	
	
	private class Node {
		private Node nextNode;
		private X nodeItem;
		
		public Node(X nodeItem) {
			this.nextNode = null;
			this.nodeItem =nodeItem;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}		
		
	}
	

	
	
	
}
