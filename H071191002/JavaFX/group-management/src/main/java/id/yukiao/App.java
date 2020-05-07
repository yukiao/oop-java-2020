package id.yukiao;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Group Management");

        Label groupHeader = new Label("Kelompok");
        GridPane groupPane = new GridPane();

        ToggleGroup group = new ToggleGroup();

        RadioButton group1 = new RadioButton("Kelompok 1");
        group1.setToggleGroup(group);
        group1.setUserData("Kelompok 1");
        groupPane.add(group1, 0, 0);
        
        RadioButton group2 = new RadioButton("Kelompok 2");
        group2.setToggleGroup(group);
        group2.setUserData("Kelompok 2");
        groupPane.add(group2, 1, 0);
        
        RadioButton group3 = new RadioButton("Kelompok 3");
        group3.setToggleGroup(group);
        group3.setUserData("Kelompok 3");
        groupPane.add(group3, 0, 1);
        
        RadioButton group4 = new RadioButton("Kelompok 4");
        group4.setToggleGroup(group);
        group4.setUserData("Kelompok 4");
        groupPane.add(group4, 1, 1);

        

        groupPane.setHgap(10);
        groupPane.setVgap(30);
        
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(groupHeader, groupPane);
        vBox1.setAlignment(Pos.TOP_CENTER);
        vBox1.setPadding(new Insets(20, 20, 20, 20));
        vBox1.setSpacing(15);
        vBox1.setBorder(new Border(new BorderStroke(Color.BLACK, 
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))) ;

        Label dataHeader = new Label("Data");
        GridPane dataPane = new GridPane();
        dataPane.setHgap(10);
        dataPane.setVgap(10);

        Label id = new Label("NIM");
        TextField tfId = new TextField();
        tfId.setPromptText("Masukkan NIM");

        Label name = new Label("Nama");
        TextField tfName = new TextField();
        tfName.setPromptText("Masukkan Nama");

        Label gender = new Label("Jenis Kelamin");

        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Laki-Laki");
        male.setToggleGroup(genderGroup);
        male.setUserData("Laki-laki");

        RadioButton female = new RadioButton("Perempuan");
        female.setUserData("Perempuan");
        female.setToggleGroup(genderGroup);
        dataPane.add(id, 0, 0);
        dataPane.add(tfId, 1, 0);
        dataPane.add(name, 0, 1);
        dataPane.add(tfName, 1, 1);
        dataPane.add(gender, 0, 2);
        dataPane.add(male, 1, 2);
        dataPane.add(female, 1, 3);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(dataHeader,dataPane);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setPadding(new Insets(20, 20, 20, 20));
        vBox2.setSpacing(15);
        vBox2.setBorder(new Border(new BorderStroke(Color.BLACK, 
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(vBox1,vBox2);
        hBox1.setSpacing(10);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.BASELINE_RIGHT);
        Button save = new Button("SAVE");
        save.setOnMouseClicked(new EventHandler<Event>() {
            public void handle(Event event) {
                Label [] userInfo = {
                    new Label(), new Label(), new Label(), new Label()
                };

                if(group.getSelectedToggle() != null){
                    userInfo[0].setText("Kelompok       : "+group.getSelectedToggle().getUserData());
                }
                if(id != null){
                    userInfo[1].setText("NIM                : "+tfId.getText());
                }
                if(name != null){
                    userInfo[2].setText("Nama             : "+tfName.getText());
                }
                if(genderGroup.getSelectedToggle() != null){
                    userInfo[3].setText("Jenis Kelamin :"+ genderGroup.getSelectedToggle().getUserData());
                }

                String info = "";

                for(Label text : userInfo){
                    info += text.getText() + "\n";
                }

                Alert alert = new Alert(AlertType.INFORMATION);

                alert.setTitle("Info");
                alert.setHeaderText("Data diterima");
                alert.setContentText(info);

                alert.showAndWait();
            }
            
        });
        hBox2.getChildren().add(save);

        VBox container = new VBox(10, hBox1,hBox2);
        container.setPadding(new Insets(10, 10, 10, 10));
        primaryStage.setScene(new Scene(container));
        primaryStage.show();
    }  

    public static void main(String[] args) {
        Application.launch(args);
    }
}