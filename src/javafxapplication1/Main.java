package javafxapplication1;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    int currentCard = 0;
    int sum1;
    int sum = 0;
    ArrayList<Card> deck = new ArrayList();
    ArrayList<Card> playerCards = new ArrayList();
    ArrayList<Card> dealerCards = new ArrayList();
    BorderPane root = new BorderPane();
    FlowPane buttonPanel = new FlowPane();
    FlowPane playerPanel = new FlowPane();
    FlowPane dealerPanel = new FlowPane();

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
            Collections.shuffle(deck);
            primaryStage.setTitle("Blackjack");

            buttonPanel.setAlignment(Pos.CENTER);
            playerPanel.setAlignment(Pos.CENTER);
            dealerPanel.setAlignment(Pos.CENTER);

            root.setBottom(buttonPanel);
            root.setCenter(playerPanel);
            root.setTop(dealerPanel);

            Button btn1 = new Button("Hit");
            Button btn2 = new Button("Stand");
            Button btn3= new Button("Play Again");
            buttonPanel.getChildren().add(btn1);
            buttonPanel.getChildren().add(btn2);
            buttonPanel.getChildren().add(btn3);
            btn1.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    dealToPlayer();

                    sum1 = calcSum();
                    if (sum1 <= 21) {
                        System.out.println(sum1);
                    } else {
                        System.out.println("dealer wins");
                    }
                }
            });
            btn2.setOnAction((ActionEvent event) -> {
                int michael =0 ;
                while(michael>=0)
                {
                    dealToDealer();
                    michael = (calc1Sum());
                    System.out.println("dealer's value "+michael);
                    if(michael<21 && michael>sum1)
                    {
                        System.out.println("dealer wins");
                        break;
                    }
                    else if(michael>21){
                        System.out.println("Player wins");
                        break;
                            }
                }
            });
            btn3.setOnAction((ActionEvent event) -> {
                playerPanel.getChildren().clear();
                dealerPanel.getChildren().clear();
               sum1=0;
               playerCards.clear();
               dealerCards.clear();
               sum1=0;
               sum=0;
               
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

    public void dealToDealer() {


        Card c = deck.remove(0);
        playerCards.add(c);

        Image img = new Image("JPEG/" + c.getImageName() + ".jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);
        dealerPanel.getChildren().add(imgView);

    }


    public int calcSum() {
        int sum = 0;

        for (Card c : playerCards) {
            int value = c.getBlackjackValue();
            sum += (value);
        }
        return sum;
    }

    public int calc1Sum() {
        int sum2 = 0;

        for (Card c : playerCards) {
            int value1 = c.getBlackjackValue1();
            sum2 += (value1);
        }
        return (sum2-sum1);
    }

    public static void main(String[] args) {
        System.out.println(args);
        launch(args);
        
    }
}
