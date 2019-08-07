package javafxapplication1;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BlackJack extends Application {
    static int maxAmount=500;
    static int currentCard = 0;
    static int sum1;
    static int sum = 0;
    static int deal=0;
    ArrayList<Card> deck = new ArrayList();//deck of cards
    ArrayList<Card> playerCards = new ArrayList();//arraylist of player cards
    ArrayList<Card> dealerCards = new ArrayList();//arraylist of dealer cards
    //setting up the fx module
    BorderPane root = new BorderPane();
    FlowPane dealPanel = new FlowPane();
    FlowPane newPanel = new FlowPane();
    FlowPane buttonPanel = new FlowPane();
    FlowPane playerPanel = new FlowPane();
    FlowPane dealerPanel = new FlowPane();
    Label l1 = new Label("Player's side");
    Label l2 = new Label("Dealer's side");
    Label l3 = new Label("set Bet");
    Label l4 = new Label("the Bet is : ");
    TextField tf = new TextField();
    Button button4 = new Button("Deal?");
    @Override
    public void start(Stage primaryStage) {

        try {
            for (int i = 0; i < 13; i++) {
                Card c = new Card("Hearts", i + 1);
                deck.add(c);
            }
            for (int i = 0; i < 13; i++) {
                Card c = new Card("Diamonds", i + 1);
                deck.add(c);
            }
            for (int i = 0; i < 13; i++) {
                Card c = new Card("Spades", i + 1);
                deck.add(c);
            }
            for (int i = 0; i < 13; i++) {
                Card c = new Card("Clubs", i + 1);
                deck.add(c);
            }
            Collections.shuffle(deck);//shuffling the deck of cards
            primaryStage.setTitle("Blackjack");

            buttonPanel.setAlignment(Pos.CENTER);
            playerPanel.getChildren().add(l1);
            dealerPanel.getChildren().add(l2);
            playerPanel.setAlignment(Pos.CENTER);
            dealerPanel.setAlignment(Pos.CENTER);

            root.setBottom(newPanel);
            root.setCenter(playerPanel);
            root.setTop(dealerPanel);
            newPanel.getChildren().add(buttonPanel);
            newPanel.getChildren().add(dealPanel);
            
            Button btn1 = new Button("Hit");
            Button btn2 = new Button("Stand");
            Button btn3= new Button("Play Again");
            buttonPanel.getChildren().add(btn1);
            buttonPanel.getChildren().add(btn2);
            buttonPanel.getChildren().add(btn3);
            dealPanel.getChildren().add(l3);
            dealPanel.getChildren().add(tf);
            dealPanel.getChildren().add(l4);
            dealPanel.getChildren().add(button4);
            //for the turn of player
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                
                public void handle(ActionEvent event) {
                l1.setText("Player's side");
                    dealToPlayer();

                    sum1 = calcSum();
                    if (sum1 <= 21) {
                        l1.setText(sum1+"");
                    } else {
                        l1.setText("dealer win's");
                        
                    }
                }
            });
            
            btn2.setOnAction((ActionEvent event) -> {
                int michael =0 ;
                l2.setText("Dealer's side");
                while(michael>=0)
                {
                    dealToDealer();
                    michael = (calc1Sum());
                    l2.setText("dealer's value "+michael);
                    if(michael<21 && michael>sum1)
                    {
                        l2.setText("Dealer's value "+michael+" dealer wins ");
                        l4.setText("Player lose : "+deal);
                        break;
                    }
                    else if(michael>21){
                        l2.setText("Dealer's value "+michael+" Player wins ");
                        l4.setText("Player got : " + (2*deal));
                        break;
                            }
                }
            });
            //for the dealer
            btn3.setOnAction((ActionEvent event) -> {
                playerPanel.getChildren().clear();
                dealerPanel.getChildren().clear();
                playerPanel.getChildren().add(l1);
                dealerPanel.getChildren().add(l2);
                tf.clear();;
               sum1=0;
               playerCards.clear();
               dealerCards.clear();
               sum1=0;
               sum=0;
               l1.setText("player's side");
               l2.setText("dealer's side");
               l4.setText("the bet is");
               
            });
            button4.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent event)
                {
                    deal = Integer.parseInt(tf.getText());
                    String tf1 = tf.getText();
                    boolean x = newDeal(tf1);
                    if(x)
                    {
                        l4.setText("The deal is : "+tf1);
                    }
                    else
                        l4.setText("check lesser amount");
                }
            });
            Scene scene = new Scene(root, 700, 500);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void dealToPlayer() {


        Card c = deck.remove(0);
        playerCards.add(c);
        
        Image img = new Image("JPEG/" + c.getImageName() + ".jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);
        playerPanel.getChildren().add(imgView);
        
        
    }
    //for the dealer
    public void dealToDealer() {


        Card c = deck.remove(0);
        playerCards.add(c);

        Image img = new Image("JPEG/" + c.getImageName() + ".jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);
        dealerPanel.getChildren().add(imgView);

    }

    //to calculate the sum of player
    public int calcSum() {
        int sum = 0;

        for (Card c : playerCards) {
            int value = c.getBlackjackValue();
            sum += (value);
        }
        return sum;

    }
//for the sum of dealer's cards
    public int calc1Sum() {
        int sum2 = 0;

        for (Card c : playerCards) {
            int value1 = c.getBlackjackValue1();
            sum2 += (value1);
        }
        return (sum2-sum1);
    }
    public static boolean newDeal(String tf1)
    {
        if(Integer.parseInt(tf1)<=maxAmount){
        return true;
    }
        else {
                return false;
           
        }
    }
// the main method
    public static void main(String[] args) {
        System.out.println(args);
        launch(args);
        
    }
}
