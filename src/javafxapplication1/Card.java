package javafxapplication1;

public class Card {
	String suit;
	int rank; //1 means Ace, .. 11 means J, 12 means Q, 13 means K 
	
	public Card(String suit, int rank){
		this.suit = suit; 
		this.rank = rank;
	}
        public String fName(){
            FullName fn = new FullName(suit, rank);
            return fn.getFullName();
        }
	public String getImageName()
        {
            if(rank==1)
            {
                return "A" +this.suit.charAt(0);
            }
            if(rank==11)
            {
                return "J"+this.suit.charAt(0);
            }
            if(rank==12)
            {
                return "Q"+this.suit.charAt(0);
            }
            if(rank==13)
            {
			return "K" + this.suit.charAt(0);
            }
            return ""+ rank +this.suit.charAt(0);
        }
	public int getBlackjackValue(){
		if (rank > 10){
			return 10;
		}
		return rank;
	}
	public int getBlackjackValue1(){
		if (rank > 10){
			return 10;
		}
		return rank;
	}
}
