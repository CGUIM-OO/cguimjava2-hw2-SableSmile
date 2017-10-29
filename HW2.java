import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * B0544231 謝心瑀
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int deck=1;deck<=nDeck;deck++){  		//deck->至少要一副牌，nDeck->至多要幾副牌
			for(int suit=1;suit<=4;suit++){  		//一副牌有4種花色
				for(int rank=1;rank<=13;rank++){	//1種花色13張牌
					Card card=new Card(suit,rank);	//實體化卡片
					cards.add(card);				//新增卡片
				}
			}
		}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		 
		  for (int count=0;cards.size()>count;count++){	/*cards.size()為總卡片數量(長度)
		  												     每實體化、印出一張卡片，count(計數)+1
		  												  若總長度<計數，結束迴圈*/	  											  
		   Card card=new Card(cards.get(count).getSuit(),cards.get(count).getRank()); //依序實體化卡片
		   card.printCard();   //印出卡片
		  }
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		String suitname="",rankname="";	//花色名稱、牌號名稱
		//花色名稱轉換
		if(suit==1)		//若花色數字=1，則另花色名稱為Clubs
			suitname="Clubs";
		else if(suit==2)	//若花色數字=2，則另花色名稱為Diamonds
			suitname="Diamonds";
		else if(suit==3)	//若花色數字=3，則另花色名稱為Hearts
			suitname="Hearts";
		else 		//其他狀況(若花色數字=4)，則另花色名稱為Spades
			suitname="Spades";
		//數字名稱轉換
		if(rank==1){		//若牌號=1，則令牌號名稱為Ace
			rankname="Ace";
		}
		else if(rank==11){	//若牌號=11，則令牌號名稱為Jack
			rankname="Jack";
		}
		else if(rank==12){	//若牌號=12，則令牌號名稱為Queen
			rankname="Queen";
		}
		else if(rank==13){	//若牌號=13，則令牌號名稱為King
			rankname="King";
		}
		else	//其他狀況(2~10)，則牌號名稱=其原本數字
			rankname=String.valueOf(rank);
		System.out.println("Card("+suitname+","+rankname+")");	//印出所有卡片
			
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}

