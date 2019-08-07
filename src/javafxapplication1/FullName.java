/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

/**
 *
 * @author kashi
 */
public class FullName {
        String suit;
	int rank; //1 means Ace, .. 11 means J, 12 means Q, 13 means K 
        public FullName(String suit,int rank)
        {
            this.suit=suit;
            this.rank=rank;
        }
    	
	public String getFullName(){
		if (rank == 11){
			return "Jack of " + suit;
		}
		if (rank == 12){
			return "Queen of " + suit;
		}
		if (rank == 13)
			return "King of " + suit;
		
		return rank + " of " + suit;
	}
}
