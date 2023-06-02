import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int userCardValueOne = drawRandomCard();
        int userCardValueTwo = drawRandomCard();
        String userCardOne = cardString(userCardValueOne);
        String userCardTwo = cardString(userCardValueTwo);
        System.out.print("You get a \n" + userCardOne + "\n and a \n" + userCardTwo);

        int userTotal = isBlackJack(userCardValueOne, userCardValueTwo) ? 21 : scoreCards(userCardValueOne) + scoreCards(userCardValueTwo);
        if(isBlackJack(userCardValueOne, userCardValueTwo)){
            System.out.println("BlackJack! You won!");
            System.exit(0);
        } else System.out.print("Your total is: " + userTotal + " \n");

        int dealerRandomCardValueOne = drawRandomCard();
        int dealerRandomCardValueTwo = drawRandomCard();
        String dealerRandomCardOne = cardString(dealerRandomCardValueOne);
        String dealerRandomCardTwo = cardString(dealerRandomCardValueTwo);
        int dealerTotal = scoreCards(dealerRandomCardValueOne) + scoreCards(dealerRandomCardValueTwo);

        System.out.print("\nThe dealer shows \n" + dealerRandomCardOne + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");

        while(true){
            if(!isBlackJack(scoreCards(userCardValueOne), scoreCards(userCardValueTwo))){
                String choice = hitOrStay();
                if(choice.equals("hit")){
                    int cardValue = drawRandomCard();
                    String card = cardString(cardValue);
                    userTotal += scoreCards(cardValue);
                    System.out.println("You get \n" + card);
                    System.out.println("Your new total is: " + userTotal);
                    if(userTotal > 21){
                        System.out.println("Bust! Player loses");
                        break;
                    } else continue;
                } else{
                    System.out.println("Dealer's turn");
                    System.out.println("The dealer's cards are\n" +
                            dealerRandomCardOne + "\n and a \n" + dealerRandomCardTwo);
                    while(dealerTotal <= 17){
                        scan.nextLine();
                        int dealerCardValue = drawRandomCard();
                        String dealerCard = cardString(dealerCardValue);
                        dealerTotal += scoreCards(dealerCardValue);
                        System.out.println("Dealer gets a \n" + dealerCard);
                        System.out.println("Dealer's total is: " + dealerTotal);
                    }
                }
                break;
            } else break;
        }

        if(dealerTotal > 21){
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        } else if(userTotal > dealerTotal && userTotal <= 21){
            System.out.println("Player wins!");
        } else System.out.println("Dealer wins!");

        scan.close();

    }

    /**
     * Method name – drawRandomCard
     * @return int
     * Gets a random number between 1 and 13.
     * Returns a card.
     */

    public static int drawRandomCard(){
        int cardNumber = (int)(Math.random() * 13) + 1;
        return cardNumber;
    }

    /**
     * Method name – cardString
     * @param cardNumber int
     * @return String
     * Returns a String drawing of the card.
     */

    public static String cardString(int cardNumber){
        String card = "";
        switch(cardNumber){
            case 1 -> card = "   _____\n"+
                    "  |A _  |\n"+
                    "  | ( ) |\n"+
                    "  |(_'_)|\n"+
                    "  |  |  |\n"+
                    "  |____V|\n";
            case 2 -> card = "   _____\n"+
                    "  |2    |\n"+
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
            case 3 -> card = "   _____\n" +
                    "  |3    |\n"+
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____E|\n";
            case 4 -> card = "   _____\n" +
                    "  |4    |\n"+
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  | o o |\n"+
                    "  |____h|\n";
            case 5 -> card = "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";
            case 6 -> card = "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";
            case 7 -> card = "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
            case 8 -> card = "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9 -> card = "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
            case 10 -> card = "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11 -> card = "   _____\n" +
                    "  |J  ww|\n"+
                    "  | o {)|\n"+
                    "  |o o% |\n"+
                    "  | | % |\n"+
                    "  |__%%[|\n";
            case 12 -> card = "   _____\n" +
                    "  |Q  ww|\n"+
                    "  | o {(|\n"+
                    "  |o o%%|\n"+
                    "  | |%%%|\n"+
                    "  |_%%%O|\n";
            case 13 -> card = "   _____\n" +
                    "  |K  WW|\n"+
                    "  | o {)|\n"+
                    "  |o o%%|\n"+
                    "  | |%%%|\n"+
                    "  |_%%%>|\n";
        }

        return card;
    }

    /**
     * Method name: faceDown
     * @return String
     */
    public static String faceDown() {
        return
                "   _____\n"+
                        "  |     |\n"+
                        "  |  J  |\n"+
                        "  | JJJ |\n"+
                        "  |  J  |\n"+
                        "  |_____|\n";
    }

    /**
     * Method name: hitOrStay
     * @return String
     * Asks the user to hit or stay.
     * If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     * Please write 'hit' or 'stay'
     * Returns the user's option
     */

    public static String hitOrStay(){

        System.out.println("Hit or stay?");
        String answer = scan.nextLine();

        if(!answer.equals("hit") && !answer.equals("stay")){
            while(true){
                System.out.println("Please write 'hit or stay");
                answer = scan.nextLine();
                if(answer.equals("hit") || answer.equals("stay"))
                    break;
            }
        }
        return answer;
    }

    /**
     * Method name: scoreCards
     * @param value int
     * @return int
     * Checks if there are face cards(Jack, Queen and King) and assign the value of 10
     * Return the evaluated value
     */
    public static int scoreCards(int value){
        int newScore = 0;

        int limit = 10;
        if(value > limit){
            newScore = 10;
        } else newScore = value;

        return newScore;
    }

    /**
     * Method name: isBlackJack
     * @param one int
     * @param two int
     * @return boolean
     * Checks if the players has BlackJack from start
     */
    public static boolean isBlackJack(int one, int two){
        boolean isBlackJack = false;
        if((one == 11 && two == 1) || (one == 1 && two == 11)){
            isBlackJack = true;
        }
        return isBlackJack;
    }
}

