package com.tobias.saul.datastructure;

public class _HashTable<X, Y> {
	
	// to hold data structure of key value pairs
	private HashEntry[] data;
	private int capacity;
	private int size;
	
	public _HashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[this.capacity];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	private int calculateHash(X key) {
		// find a slot
		int hash = (key.hashCode() % this.capacity);
		
		// deals with collisions
		// find empty appropriate slot
		while(data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}
		
		return hash;
	}
	
	public Y get(X key) {
		int hash = calculateHash(key);
		
		// return null if nothing at key
		if(data[hash] == null) {
			return null;
		}
		//otherwise return value at hash
		else {
			return (Y) data[hash].getValue();
		}
	}
	
	public void put(X key, Y value) {
		// get a hash value
		int hash = calculateHash(key);
		// store key-value pair at hash
		data[hash] = new HashEntry<X, Y>(key, value);
		// increment size
		size++;
	}
	
	public Y delete(X key) {
		// get value at key 
		Y value = get(key);
		
		// clear out hashtable slot for key and return value
		if(value != null) {
			int hash = calculateHash(key);
			// null out value at hash
			data[hash] = null;
			size--;
			hash = (hash + 1) % this.capacity;
			
			// if next slot isn't empty, re add to keep hash algorithm clean
			while(data[hash] != null) {
				HashEntry hashEntry = data[hash];
				data[hash] = null;
				System.out.println("Rehashing");
				put((X) hashEntry.getKey(), (Y) hashEntry.getValue());
				size--;
				hash = (hash + 1) % this.capacity;
			}
		}
		
		return value;
	}
	
	public boolean hasKey(X key) {
		
		int hash = calculateHash(key);
		
		 // if nothing for the given key
		if(data[hash] == null) {
			return false;
		}
		// see if key for hash entry matches key given
		else {
			if(data[hash].getKey().equals(key)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasValue(Y value) {
		// loop through entries
		for(int i =0; i < this.capacity; i++) {
			HashEntry entry = data[i];
			
			// if hash entry isn't null and value equals the one passes, hash table has the value
			if(entry != null && entry.getValue().equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	// for key-value pairs 
	private class HashEntry<X, Y> {
		private X key;
		private Y value;
		
		public HashEntry(X key, Y value) {
			this.key = key;
			this.value = value;
		}
		public X getKey() {
			return key;
		}
		public void setKey(X key) {
			this.key = key;
		}
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
	}

}
