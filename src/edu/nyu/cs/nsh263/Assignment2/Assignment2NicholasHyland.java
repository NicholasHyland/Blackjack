package edu.nyu.cs.nsh263.Assignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment2NicholasHyland {

	public static int userTotal;
	public static int dealerTotal;
	public static String cardName1;
	public static String cardName2;
	public static int newCard;
	public static String userCardName;
	public static String dealerCards = "";

	public static void dealerDraw() {
		int dealerCard1 = (int)((Math.random() * 13) + 1);
		int dealerCard2 = (int)((Math.random() * 13) + 1);
		
		if (dealerCard1 == 1 && dealerCard2 == 1) {
			dealerTotal = 12;
		}
		else if ((dealerCard1 == 11 || dealerCard1 == 12 || dealerCard1 == 13) && (dealerCard2 == 11 || dealerCard2 == 12 || dealerCard2 == 13)) {
			dealerTotal = 20;
		}
		else if (((dealerCard1 == 11 || dealerCard1 == 12 || dealerCard1 == 13) && dealerCard2 == 1) || ((dealerCard2 == 11 || dealerCard2 == 12 || dealerCard2 == 13) && dealerCard1 == 1)){
			dealerTotal = 21;
		}
		else if ((dealerCard1 == 11 || dealerCard1 == 12 || dealerCard1 == 13)) {
			dealerTotal = 10 + dealerCard2;
		}
		else if ((dealerCard2 == 11 || dealerCard2 == 12 || dealerCard2 == 13)) {
			dealerTotal = 10 + dealerCard1;
		}
		else if (dealerCard1 == 1){
			dealerTotal = 11 + dealerCard2;
		}
		else if (dealerCard2 == 1){
			dealerTotal = 11 + dealerCard1;
		}
		else {
			dealerTotal = dealerCard1 + dealerCard2;
		}
		
		dealerCards += getCardName(dealerCard1);
		dealerCards += ", " + getCardName(dealerCard2);
	}
	public static void result() {

		System.out.println();
		System.out.println("The dealer drew " + dealerCards);
		System.out.println("The dealer's total is " + dealerTotal + "!");
        System.out.println();

        if (dealerTotal > 21 && userTotal > 21){ 
        	System.out.println("Both of you are over 21! You both lose.");
        }
        else if (dealerTotal > 21 && userTotal <= 21){
        	System.out.println("You win, dealer loses!");
        }
        else if (userTotal > 21 && dealerTotal <= 21){
        	System.out.println("Dealer wins, you lose!");
        }
        else if (dealerTotal == userTotal) {
            System.out.println("It's a draw!");
        }
        else if (dealerTotal > userTotal){
            System.out.println("Dealer wins, you lose!");
        } 
        else if (dealerTotal < userTotal){
            System.out.println("You win, dealer loses!");
        }
	}
	

	
	public static void dealerStayHit() {
	
	Scanner input = new Scanner(System.in);

	
	if (dealerTotal < 17) {
		int newCard = (int)((Math.random() * 13) + 1);
		if (newCard == 1) {
			dealerTotal = dealerTotal + 11;
			if (dealerTotal > 21) {
				dealerTotal = dealerTotal - 10;
			}
			dealerCards += ", " + getCardName(newCard);
			dealerStayHit();
		}
		else if (newCard == 11 || newCard == 12 || newCard == 13) {
			dealerTotal = dealerTotal + 10;
			dealerCards += ", " + getCardName(newCard);
			dealerStayHit();
		}
		else {
			dealerTotal = dealerTotal + newCard;
			dealerCards += ", " + getCardName(newCard);
			dealerStayHit();
		}

	}
	}
	
	
	public static String getCardName(int i) {
		String cardname;
		
		switch (i) {
		case 1:
			return "Ace";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return null;
		}
	}
	
	public static void userCardName(){
		switch (newCard) {
		case 1:
			userCardName = "Ace";
			break;
		case 2:
			userCardName = "Two";
			break;
		case 3:
			userCardName = "Three";
			break;
		case 4:
			userCardName = "Four";
			break;
		case 5:
			userCardName = "Five";
			break;
		case 6:
			userCardName = "Six";
			break;
		case 7:
			userCardName = "Seven";
			break;
		case 8:
			userCardName = "Eight";
			break;
		case 9:
			userCardName = "Nine";
			break;
		case 10:
			userCardName = "Ten";
			break;
		case 11:
			userCardName = "Jack";
			break;
		case 12:
			userCardName = "Queen";
			break;
		case 13:
			userCardName = "King";
			break;
		}
	}
	public static void userStayHit() {

	Scanner input = new Scanner(System.in);
		if (userTotal == 21) {
			userCardName();
			System.out.println("You drew " + userCardName + ". Your total is 21, you win!");
			dealerDraw();
			dealerStayHit();
			result();
		}
		else if (userTotal > 21) {
			userCardName();
			System.out.println("You drew " + userCardName + ".");
			System.out.println("Your total is " + userTotal + " which is greater than 21, you lose!");
			dealerDraw();
			dealerStayHit();
			result();
		}
		else {
			userCardName();
			System.out.println("You drew " + userCardName + ". Your total is " + userTotal + "!");
			System.out.print("Press 0 to stay or 1 to hit: ");
			int stayHit = input.nextInt();
				if (stayHit == 0) {
					System.out.println("You stay. Your total is " + userTotal + "!");
					dealerDraw();
					dealerStayHit();
					result();
				}
				else if (stayHit == 1) {
					int newCard = (int)((Math.random() * 13) + 1);
					if (newCard == 1) {
						userTotal = userTotal + 11;
						if (userTotal > 21) {
							userTotal = userTotal - 10;
						}
					}
					else if (newCard == 11 || newCard == 12 || newCard == 13) {
						userTotal = userTotal + 10;
					}
					else {
						userTotal = userTotal + newCard;
					}
					switch (newCard) {
					case 1:
						userCardName = "Ace";
						break;
					case 2:
						userCardName = "Two";
						break;
					case 3:
						userCardName = "Three";
						break;
					case 4:
						userCardName = "Four";
						break;
					case 5:
						userCardName = "Five";
						break;
					case 6:
						userCardName = "Six";
						break;
					case 7:
						userCardName = "Seven";
						break;
					case 8:
						userCardName = "Eight";
						break;
					case 9:
						userCardName = "Nine";
						break;
					case 10:
						userCardName = "Ten";
						break;
					case 11:
						userCardName = "Jack";
						break;
					case 12:
						userCardName = "Queen";
						break;
					case 13:
						userCardName = "King";
						break;
					}
					userStayHit();
				}
		}
	}

	public static void main(String[] args) {

		int userCard1 = (int)((Math.random() * 13) + 1);
		int userCard2 = (int)((Math.random() * 13) + 1);
		
		if (userCard1 == 1 && userCard2 == 1) {
			userTotal = 12;
		}
		else if ((userCard1 == 11 || userCard1 == 12 || userCard1 == 13) && (userCard2 == 11 || userCard2 == 12 || userCard2 == 13)) {
			userTotal = 20;
		}
		else if (((userCard1 == 11 || userCard1 == 12 || userCard1 == 13) && userCard2 == 1) || ((userCard2 == 11 || userCard2 == 12 || userCard2 == 13) && userCard1 == 1)){
			userTotal = 21;
		}
		else if ((userCard1 == 11 || userCard1 == 12 || userCard1 == 13)) {
			userTotal = 10 + userCard2;
		}
		else if ((userCard2 == 11 || userCard2 == 12 || userCard2 == 13)) {
			userTotal = 10 + userCard1;
		}
		else if (userCard1 == 1){
			userTotal = 11 + userCard2;
		}
		else if (userCard2 == 1){
			userTotal = 11 + userCard1;
		}
		else {
			userTotal = userCard1 + userCard2;
		}
		
		switch (userCard1) {
		case 1:
			cardName1 = "Ace";
			break;
		case 2:
			cardName1 = "Two";
			break;
		case 3:
			cardName1 = "Three";
			break;
		case 4:
			cardName1 = "Four";
			break;
		case 5:
			cardName1 = "Five";
			break;
		case 6:
			cardName1 = "Six";
			break;
		case 7:
			cardName1 = "Seven";
			break;
		case 8:
			cardName1 = "Eight";
			break;
		case 9:
			cardName1 = "Nine";
			break;
		case 10:
			cardName1 = "Ten";
			break;
		case 11:
			cardName1 = "Jack";
			break;
		case 12:
			cardName1 = "Queen";
			break;
		case 13:
			cardName1 = "King";
			break;
		}
		
		switch (userCard2) {
		case 1:
			cardName2 = "Ace";
			break;
		case 2:
			cardName2 = "Two";
			break;
		case 3:
			cardName2 = "Three";
			break;
		case 4:
			cardName2 = "Four";
			break;
		case 5:
			cardName2 = "Five";
			break;
		case 6:
			cardName2 = "Six";
			break;
		case 7:
			cardName2 = "Seven";
			break;
		case 8:
			cardName2 = "Eight";
			break;
		case 9:
			cardName2 = "Nine";
			break;
		case 10:
			cardName2 = "Ten";
			break;
		case 11:
			cardName2 = "Jack";
			break;
		case 12:
			cardName2 = "Queen";
			break;
		case 13:
			cardName2 = "King";
			break;
		}

		Scanner input = new Scanner(System.in);
		if (userTotal == 21) {
			System.out.println("You drew " + cardName1 + " and " + cardName2 + ". Your total is 21, you win!");
			dealerDraw();
			dealerStayHit();
			result();
		}
		else if (userTotal > 21) {
			System.out.println("You drew " + cardName1 + " and " + cardName2 + ".");
			System.out.println("Your total is " + userTotal + " which is greater than 21, you lose!");
			dealerDraw();
			dealerStayHit();
			result();
		}
		else {
			System.out.println("You drew " + cardName1 + " and " + cardName2 + ".");
			System.out.println("Your total is " + userTotal + "!");
			System.out.println();
			System.out.print("Press 0 to stay or 1 to hit: ");
			int stayHit = input.nextInt();
				if (stayHit == 0) {
					System.out.println("You stay. Your total is " + userTotal + "!");
					dealerDraw();
					dealerStayHit();
					result();
				}
				else if (stayHit == 1) {
					int newCard = (int)((Math.random() * 13) + 1);
					if (newCard == 1) {
						userTotal = userTotal + 11;
						if (userTotal > 21) {
							userTotal = userTotal - 10;
						}
					}
					else if (newCard == 11 || newCard == 12 || newCard == 13) {
						userTotal = userTotal + 10;
					}
					else {
						userTotal = userTotal + newCard;
					}
						
					switch (newCard) {
					case 1:
						userCardName = "Ace";
						break;
					case 2:
						userCardName = "Two";
						break;
					case 3:
						userCardName = "Three";
						break;
					case 4:
						userCardName = "Four";
						break;
					case 5:
						userCardName = "Five";
						break;
					case 6:
						userCardName = "Six";
						break;
					case 7:
						userCardName = "Seven";
						break;
					case 8:
						userCardName = "Eight";
						break;
					case 9:
						userCardName = "Nine";
						break;
					case 10:
						userCardName = "Ten";
						break;
					case 11:
						userCardName = "Jack";
						break;
					case 12:
						userCardName = "Queen";
						break;
					case 13:
						userCardName = "King";
						break;
					}
					userStayHit();
					}
				}

		}
	}