
public class Wallet {
	
	private int maxNumOfCreditCards = 10; //how many credit cards can you put in the wallet?
	
	//array of credit cards
	CreditCard[] creditCards = new CreditCard[maxNumOfCreditCards];

}

class CreditCard{
	private String type; //like mastercard, visa, etc
	private String number; //like the bank account number
	private String nameOnCard; //name on the card
	
	//getters and setters
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}
