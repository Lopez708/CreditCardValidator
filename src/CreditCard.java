/**
 * The CreditCard class is designed to create a CreditCard object and contains methods pertaining to
 * the validation of the number entered by the user.
 * 
 *  @author Juan Lopez
 */
public class CreditCard {
	
	//These constant int variable hold the numerical length of each credit card type.
	final private int AC_LENGTH = 15;
	final private int MC_LENGTH = 16;
	final private int V_LENGTH = 13;
	
	private int cardLength = 0;
	private String cardNumber, cardNumReverse = "";
	private String cardType = "";
	private String ac = "American Express";
	private String mc = "Master Card";
	private String v = "Visa";
	private String sub = "";
	private int currNum, totalSum = 0;
	private String totalNums = "", currNumString = "";
	StringBuffer buf = new StringBuffer();	
	
	/**
	 * Getter method
	 * @return Credit card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * Setter method 
	 * @param Credit card number
	 */
	public void setCardNumber(String x) {
		cardNumber = x;
	}
	
	/**
	 * Checks if the card number entered by the user is equal to either the MasterCard, Amex, or Visa card lengths.
	 * If a match is found, if checks to see if there is a prefix match as well.  If both tests match, then the
	 * corresponding credit card type is returned as a type String. (e.g. "Master Card").
	 * @return Credit card type
	 */
	public String getCardType() {
		if (cardNumber.length() == AC_LENGTH) {
			if(cardNumber.startsWith("34") == true || cardNumber.startsWith("35") == true) {
				return ac;
			}
		} else if ((cardNumber.length() == V_LENGTH && cardNumber.startsWith("4") == true) ||
				   (cardNumber.length() == MC_LENGTH && cardNumber.startsWith("4") == true)) {
			return v;
		} else if (cardNumber.length() == MC_LENGTH) {
			if(cardNumber.startsWith("51") == true || cardNumber.startsWith("52") == true ||
			   cardNumber.startsWith("53") == true || cardNumber.startsWith("54") == true ||
			   cardNumber.startsWith("55") == true) {
			return mc;
			}
		}
		return null; 
	}
	
	/**
	 * Checks if the credit card number entered is a valid length by matching expected lengths.
	 * @return true ; false
	 */
	public boolean isLengthValid() {
		
		if (cardNumber.length() == AC_LENGTH || cardNumber.length() == MC_LENGTH ||
			cardNumber.length() == V_LENGTH) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * If isLengthValid and isPrefixValid are both true.  This method checks the validity of the 
	 * credit card number entered by using the check sum algorithm.  Returns true if the resulting
	 * number is divisible by ten.
	 * @return true ; false
	 */
	public boolean isNumberValid() {
		StringBuffer buf = new StringBuffer(cardNumber);
		cardNumReverse = buf.reverse().toString();
		
		for (int i = 0; i < cardNumReverse.length(); i = i + 2) {
			sub = cardNumReverse.substring(i, i + 1);
			totalNums += sub;
		}
		
		for (int i = 1; i < cardNumReverse.length(); i = i + 2) {
			sub = cardNumReverse.substring(i, i + 1);
			currNum = Integer.parseInt(sub);
			currNum *= 2;
			currNumString = Integer.toString(currNum);
			totalNums += currNumString;
		}
		
		for (int i = 0; i < totalNums.length(); i++) {
			sub = totalNums.substring(i, i + 1);
			currNum = Integer.parseInt(sub);
			totalSum += currNum;
		}
		
		if (totalSum % 10 == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the credit card number entered has a valid prefix number by matching expected prefix numbers.
	 * @return true ; false
	 */
	public boolean isPrefixValid() {
		if (cardNumber.length() == AC_LENGTH) {
			if(cardNumber.startsWith("34") == true || cardNumber.startsWith("35") == true) {
				return true;
			}
		} else if ((cardNumber.length() == V_LENGTH && cardNumber.startsWith("4") == true) ||
				   (cardNumber.length() == MC_LENGTH && cardNumber.startsWith("4") == true)) {
			return true;
		} else if (cardNumber.length() == MC_LENGTH) {
			if(cardNumber.startsWith("51") == true || cardNumber.startsWith("52") == true ||
			   cardNumber.startsWith("53") == true || cardNumber.startsWith("54") == true ||
			   cardNumber.startsWith("55") == true) {
			return true;
			}
		}
		return false;
	}
}
