import java.util.Scanner;
/** 
 * The CardValidation class is the driver class for this project.  We use this class to communicate with the user,
 * in order to receive input and save it into memory.  This class will take the name and credit card number of a 
 * user and pass it through various validation methods that are part of the CreditCard class. 
 * 
 * @author Juan Lopez
 */
public class CardValidation {
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		//String name, cardType and ccNumber are variable used to store data such as the users name, credit card type and 
		//the credit card number respectively.
		String name, cardType = "";
		String ccNumber = "";
		String validateMore = "y";
		boolean cardLengthValid, prefixValid = false;
		
		CreditCard cc = new CreditCard();
		
		//Title of the program
		System.out.println("\t\t\t\t CREDIT CARD VALIDATION");
		System.out.println("");
		System.out.println("");
		
		//Prompts the user to input their name
		System.out.println("Enter the name of the card holder: ");
		name = sc.nextLine();
		
		//This while loop only runs once and continues to run as long as the user still wants to validate a card.
		while (validateMore.equals("y")) {
			//This do-while loop will prompt the user for a credit card number and run various test to validate that number.
			//If the card length is invalid or the prefix is invalid, it will handle the error by telling the user the card is invalid.
			do {
				System.out.println("Enter credit card number: ");
				ccNumber = sc.next();
				ccNumber = ccNumber.replaceAll(" ", "");
				cc.setCardNumber(ccNumber);
				cardLengthValid = cc.isLengthValid();
				prefixValid = cc.isPrefixValid();
				cc.isNumberValid();
				if (cardLengthValid == false || prefixValid == false) {
					System.out.println("Invalid card number,");
				}
			} while (cardLengthValid == false || prefixValid == false);
			
			//String variable that holds the name of the type of the card that was entered.
			cardType = cc.getCardType();
			
			System.out.println("Thank you! A " + cardType + " has been accepted for " + name);
			System.out.println("");
			
			System.out.println("Do you want to validate another card number: (y/n)");
			validateMore = sc.next();
		}		
			
		System.out.println("");
		System.out.print("Programmer: Juan Lopez");
	}
}
