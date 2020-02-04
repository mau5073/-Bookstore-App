package edu.psu.bd.cs.mau5073;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



import java.io.FileInputStream;
import java.util.ArrayList;

import static edu.psu.bd.cs.mau5073.hw13.stage2;

public class login extends Application{
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private TextField username = new TextField();
    private TextField password = new TextField();
    private Label user = new Label();
    private Label pass = new Label();
    private Button login = new Button();
    private Stage stage = new Stage();
    private Label passFail = new Label();
    private boolean sucUser = false;


    @Override
    public void start(Stage stages) throws Exception {
        stage.setTitle("User Login");
        stage.show();
        user.setText("User Name");
        pass.setText("Password");
        login.setText("Login");
        Image logpic = new Image(new FileInputStream("C:\\Users\\marshall\\Pictures\\login.jpg"));
        ImageView image = new ImageView(logpic);


        userNames.add("marshall");
        passwords.add("password");
        Circle load = new Circle();
        load.setFill(Color.RED);
        load.setRadius(40);

        Rectangle loadBox = new Rectangle();
        loadBox.setFill(Color.BLACK);
        loadBox.setHeight(75);
        loadBox.setWidth(1000);



        VBox userinput = new VBox(10,image,user,username,pass,password,passFail,login,load,loadBox);
        Scene scene = new Scene(userinput);
        stage.setScene(scene);



        userNames.add("ad");
        userNames.add("sd");
        userNames.add("aadasdd");
        userNames.add("aasdasdd");
        userNames.add("name");
        passwords.add("password");
    }

    public static void main(String[] args){Application.launch( args );}
    {
       login.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {

               for(int i = 0; i < userNames.size();i++) {
                   if (username.getText().equals(userNames.get(i)) ) {
                            sucUser = true;

                   }
               }
               if(sucUser == true){
                   for(int p = 0; p < passwords.size(); p++){
                           if (password.getText().equals(passwords.get(p))){
                           stage.hide();
                           hw13 test = new hw13();
                           try {
                               test.start(stage2);
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                       }

                   }
               }
               if(sucUser== false){
                   passFail.setText("Incorrect Login Try again");
               }
           }
       });
    }
}
