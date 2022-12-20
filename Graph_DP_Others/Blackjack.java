package second;

import java.util.*;

/*
Class: Blackjack.java
Name: Harry Liu
Date; Jan. 16, 2021
Description: This program is a simplified version of the game Blackjack. The player takes their turn to pick up cards first. After the player finishes their turn, the computer takes its turn. 
			 After both the player and the computer finish their turn, they compare their total score based on the rules of Blackjack, and the winner will get 1 point added to their total 
			 win count. The program then asks the user whether or not they want to continue playing, the game will continue if the user replies yes, and stop if the user replies no.
 */

public class Blackjack {

	//initialize static variables so they can be accessed in other methods 
	static Scanner sc = new Scanner (System.in);
	static ArrayList<String> playerHand = new ArrayList<>();	//Arraylist because it will copy and re-create an array every time a new value is entered and there is not enough space.
	static ArrayList<String> computerHand = new ArrayList<>();	//Used to store the cards at hand.
	static int[] cardsRemaining = new int[14];		//one more so that no +1 when adding to the score / -1 when storing into array is needed (index 0 is ignored)
	static int playerScore = 0;
	static int computerScore = 0; 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//initialize the total win counts, not in the do-while loop because no need to reset after each game
		int totalPlayerWinCount = 0;
		int totalComputerWinCount = 0;
		
		//Do-while loop to ensure that the game runs at least once.
		do {
			//initialize variable (mainly for resetting after each game)
			playerHand = new ArrayList<>();
			computerHand = new ArrayList<>();
			playerScore = 0;
			computerScore = 0;
			Arrays.fill(cardsRemaining, 4);		//filling the array every time a new game starts
			String continueDecision;			//Whether or not the player wants to continue receiving new cards. 
			
			
			//Player starts receiving cards
			//only exits when the player wants to, or when the player score exceeds 21
			do {
				playerReceiveCard();		//receive card
				displayPlayerHand();		//output current hand
				
				//checks if the player score is over 21 (if yes immediately exits)
				if (playerScore > 21) {
					break;
				}
				
				//user prompt for another card
				System.out.println("Do you wish to get another card, enter \"yes\" if you do and \"no\" if you do not");
				continueDecision = sc.nextLine().toUpperCase();			//Change to uppercase to make it not case sensitive
				
				//ensures that the input is valid
				while (!continueDecision.equals("YES") && !continueDecision.equals("NO")) {
					System.out.println("Invalid input. Enter \"yes\" if you want another card and \"no\" if you do not");
					continueDecision = sc.nextLine().toUpperCase();
				}
			}
			while (continueDecision.equals("YES"));
			
			
			if (playerScore > 21) {		//if score is over 21 end this game
				System.out.println("Your score is over 21 points, you lost!");
				totalComputerWinCount++;
				
				//output total score before the next game
				System.out.println("You have " + totalPlayerWinCount + " win(s)");
				System.out.println("The computer has " + totalComputerWinCount + " win(s)");
				continue;			//*Note: jump to line 125
			}
			
			if (playerScore == 21) {		//if score is 21 end this game
				System.out.println("You have 21 points, you won!");
				totalPlayerWinCount++;
				
				//output total score before the next game
				System.out.println("You have " + totalPlayerWinCount + " win(s)");
				System.out.println("The computer has " + totalComputerWinCount + " win(s)");
				continue;			//*Note: jump to line 125
			}
			
			
			//=================================================================================================================================
			//If player score is smaller than 21, game continues and computer takes its turn.
			//generating cards for computer
			//only exits when the score is over 16
			System.out.println("===========================================");
			do {
				computerReceiveCard();		//receive card
				displayComputerHand();		//output current hand
			}
			while (computerScore <= 16);
			
			
			//comparing the scores
			if (computerScore == 21) {
				System.out.println("You lost, the computer has 21 points.");
				totalComputerWinCount++;
			}
			else if (computerScore > 21) {
				System.out.println("The computer's score is over 21, you won!");
				totalPlayerWinCount++;
			}
			else if (computerScore < playerScore) {
				System.out.println("You have a score of " + playerScore + ", and the computer has a score of " + computerScore);
				System.out.println("You won!");
				totalPlayerWinCount++;
			}
			else {		//If computer > player OR computer == player
				System.out.println("You have a score of " + playerScore + ", and the computer has a score of " + computerScore);
				System.out.println("You lost.");
				totalComputerWinCount++;
			}
			
			//outputs the total win count at the end
			System.out.println("You have " + totalPlayerWinCount + " win(s)");
			System.out.println("The computer has " + totalComputerWinCount + " win(s)");
			
		}
		while (ifContinue());		//calling the ifContinue method, if true continue, if false break.

		
		System.out.println("Thank you for playing Blackjack.");
		System.out.println("Stay safe and have a nice day");
		
	}
	
	
	
	/*
	void displayPlayerHand ()
	This method takes values from the playerHand arraylist and prints them out on the same line
	 */
	public static void displayPlayerHand () {
		System.out.println("===========================================");
		System.out.println("Your cards:");
		for (String i : playerHand) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
	/*
	void displayComputerHand ()
	This method takes values from the computerHand arraylist and prints them out on the same line
	 */
	public static void displayComputerHand () {
		System.out.println("===========================================");
		System.out.println("Computer's cards:");
		for (String i : computerHand) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
	/*
	void playerReceiveCard ()
	This method generates cards for the player, ensures that no more than 4 of the same cards are used, and asks the user for their decision on the value of aces.
	 */
	public static void playerReceiveCard () {
		int card = -1;
		do {
			card = (int)(Math.random()*13) + 1;
		}
		while (cardsRemaining[card] <= 0);		//keep looping if no card is remaining in the deck
		cardsRemaining[card]--;					//take out one card from the deck
		
		//storing the card into arraylist
		//storing the card value into playerScore
		switch (card) {
			case 11: 
				playerHand.add("J");
				playerScore += 10;
				break;
			case 12:
				playerHand.add("Q");
				playerScore += 10;
				break;
			case 13:
				playerHand.add("K");
				playerScore += 10;
				break;
			case 1: 			//when card == Ace
				playerHand.add("A");
				
				int aceDecision;		//Used for ace value decision
				System.out.println("You got an Ace, do you want to use it as 1 or 11?");
				System.out.println("Enter 1 to use it as 1, and 11 to use it as 11");
				aceDecision = sc.nextInt();
				
				//ensures that the input is valid
				while (aceDecision != 1 && aceDecision != 11) {
					System.out.println("Invalid input. Enter 1 to use it as 1, and 11 to use it as 11");
					aceDecision = sc.nextInt();
				}
				sc.nextLine(); 		//next line
				
				//checks decision
				if (aceDecision == 1) {
					playerScore += 1;
				}
				else {
					playerScore += 11;
				}
				break;
			default:
				playerHand.add(card+"");
				playerScore += card;
				break;
		}
		
	}
	
	
	/*
	void computerReceiveCard ()
	This method generates cards for the computer, ensures that no more than 4 of the same cards are used, and allows the computer to decide which value of aces to use.
	 */
	public static void computerReceiveCard () {
		int card = -1;
		do {
			card = (int)(Math.random()*13) + 1;
		}
		while (cardsRemaining[card] <= 0);		//keep looping if no card is remaining in the deck
		cardsRemaining[card]--;					//take out one card from the deck
		
		//storing the card into arraylist
		//storing the card value into computerScore
		switch (card) {
			case 11:
				computerHand.add("J");
				computerScore += 10;
				break;
			case 12:
				computerHand.add("Q");
				computerScore += 10;
				break;
			case 13:
				computerHand.add("K");
				computerScore += 10;
				break;
			case 1:				//when card == Ace
				computerHand.add("A");
				
				//computer decision on the value of ace
				if (computerScore + 11 > 21) {
					computerScore += 1;
				}
				else {
					computerScore += 11;
				}
				break;
			default:
				computerHand.add(card+"");
				computerScore += card;
				break;
		}
	}
	
	
	
	/*
	boolean ifContinue ()
	returns boolean - Whether or not the user wants to play another game. (true - continue, false - stop)
	This method prompts the user to decide whether or not they want to play another game
	 */
	public static boolean ifContinue () {
		//divider
		System.out.println();
		System.out.println("*******************************************");
		
		String decision;	//decision variable for user decision to continue playing
		//user prompt
		System.out.println("Do you wish to play another game? Enter \"yes\" if you do and \"no\" if you do not");
		decision = sc.nextLine().toUpperCase();			//Makes it not case sensitive
		
		//ensures that the input is valid
		while (!decision.equals("YES") && !decision.equals("NO")) {
			System.out.println("Invalid input. Enter \"yes\" if you wish to play another game and \"no\" if you do not");
			decision = sc.nextLine().toUpperCase();
		}
		
		//if the player wishes to continue, return true for the do-while loop to keep running
		if (decision.equals("YES")) {
			return true;
		}
		
		//else return false;
		return false;
	}

}
