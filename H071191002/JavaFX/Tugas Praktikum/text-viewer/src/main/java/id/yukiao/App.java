package id.yukiao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button select = new Button("Select First File");
        TextArea value = new TextArea();
        value.setEditable(false);
        
        select.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                FileChooser chooser = new FileChooser();
                chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
                File selectedFile = chooser.showOpenDialog(primaryStage);

                FileReader fr;
                BufferedReader br;
                String fileText = "";
                try{
                    fr = new FileReader(selectedFile.getPath());
                    br = new BufferedReader(fr);

                    String s;
                    while((s = br.readLine())!=null){
                        fileText += s +"\n";
                    }
                    fr.close();
                    br.close();
                }catch(IOException io){
                    io.printStackTrace();
                }
                value.setText(fileText);
            }
        });
        
        VBox vbox = new VBox(select,value);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 10, 20, 10));
        vbox.setSpacing(5);
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}