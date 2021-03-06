package tobias.saul.app;

import tobias.saul.datastructure._Stack;

public class CardStackApp {
	
	_Stack<String> stack = new _Stack<String>();
	
	public static void main(String[] args) {
		CardStackApp app = new CardStackApp();
		
		app.stackCards();
		//app.unstackCards();
		
		//retrieves and removes from stack
		app.goToCard("4 of spades");
		//at this point it will not exist in stack anymore if it was accessed
		app.containsCard("2 of spades");
		//displays size of card
		app.deckSize();
		
		
	}
	
	public void stackCards() {
		stack.push("Ace of spades");
		stack.push("2 of spades");
		stack.push("3 of spades");
		stack.push("4 of spades");
	}
	
	public void unstackCards() {
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	public void containsCard(String card) {
		System.out.println("Contains card " + card + ": " + stack.contains(card));
	}
	
	public void goToCard(String card) {
		System.out.println("Card: " + stack.access(card));
	}
	
	public void deckSize() {
		System.out.println("Deck Size: " + stack.size());
	}

}
