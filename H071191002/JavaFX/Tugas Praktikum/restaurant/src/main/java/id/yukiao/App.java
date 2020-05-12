package id.yukiao;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application{
    private CheckBox cbox1, cbox2, cbox3, cbox4, cbox5;
    private TextField tf1, tf2, tf3, tf4, tf5;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Surreal Resto");
        Label heading = new Label("Resto Menu");
        heading.setFont(Font.font("Quicksand", 20));

        Map <String,Integer> menu = new HashMap<>();
        menu.put("Hamburger", 20000);
        menu.put("Cola", 5000);
        menu.put("Fried Chicken", 15000);
        menu.put("Bakso", 10000);
        menu.put("Rendang", 25000);
        
        GridPane gPane = new GridPane();
        
        cbox1 = new CheckBox("Hamburger");
        cbox2 = new CheckBox("Cola");
        cbox3 = new CheckBox("Fried Chicken");
        cbox4 = new CheckBox("Bakso");
        cbox5 = new CheckBox("Rendang");

        gPane.add(cbox1, 0, 0);
        gPane.add(cbox2, 0, 1);
        gPane.add(cbox3, 0, 2);
        gPane.add(cbox4, 0, 3);
        gPane.add(cbox5, 0, 4);

        
        tf1 = new TextField("0");
        tf1.setEditable(false);

        tf2 = new TextField("0");
        tf2.setEditable(false);

        tf3 = new TextField("0");
        tf3.setEditable(false);

        tf4 = new TextField("0");
        tf4.setEditable(false);
        
        tf5 = new TextField("0");
        tf5.setEditable(false);
        
        gPane.add(tf1, 1, 0);
        gPane.add(tf2, 1, 1);
        gPane.add(tf3, 1, 2);
        gPane.add(tf4, 1, 3);
        gPane.add(tf5, 1, 4);

        

        Button checkout = new Button("Bayar");
        checkout.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                String name;
                int amount;
                int pay = 0;
                if(cbox1.isSelected()){
                    
                    name = cbox1.getText();
                    amount = Integer.valueOf(tf1.getText());

                    pay += menu.get(name)*amount;
                }
                if(cbox2.isSelected()){
                    name = cbox2.getText();
                    amount = Integer.valueOf(tf2.getText());

                    pay += menu.get(name)*amount;
                }
                if(cbox3.isSelected()){
                    name = cbox3.getText();
                    amount = Integer.valueOf(tf3.getText());

                    pay += menu.get(name)*amount;
                }
                if(cbox4.isSelected()){
                    name = cbox4.getText();
                    amount = Integer.valueOf(tf4.getText());

                    pay += menu.get(name)*amount;
                }
                if(cbox5.isSelected()){
                    name = cbox5.getText();
                    amount = Integer.valueOf(tf5.getText());
                    pay += menu.get(name)*amount;
                }

                Stage alert = new Stage();
                
                Label purchased = new Label();
                purchased.setText("Total bayar : "+pay);

                alert.setScene(new Scene(purchased,200,300));
                alert.show();
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(heading, gPane, checkout);

        primaryStage.setScene(new Scene(vBox, 400, 600));
        primaryStage.show();
        setEditable();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void setEditable(){
        cbox1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cbox1.isSelected()){
                    tf1.setEditable(true);
                }else{
                    tf1.setEditable(false);
                }
            }
        });

        cbox2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cbox2.isSelected()){
                    tf2.setEditable(true);
                }else{
                    tf2.setEditable(false);
                }
            }
        });

        cbox3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cbox3.isSelected()){
                    tf3.setEditable(true);
                }else{
                    tf3.setEditable(false);
                }
            }
        });

        cbox4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cbox4.isSelected()){
                    tf4.setEditable(true);
                }else{
                    tf4.setEditable(false);
                }
            }
        });

        cbox5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(cbox5.isSelected()){
                    tf5.setEditable(true);
                }else{
                    tf5.setEditable(false);
                }
            }
        });
    }
}