package edu.psu.bd.cs.mau5073;
import com.sun.xml.internal.bind.v2.runtime.Name;
import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class hw13 extends Application{
    private Label searchN = new Label();
    private Label searchC = new Label();
    private Button run = new Button();
    private TextField sN = new TextField();
    private TextField cN = new TextField();
    private Button next = new Button();
    private Button previous =  new Button();
    private boolean searchingName = false;
    private boolean searchingCode = false;
    private String nameSearch;
    private String codeSearch;
    private String url;
    private Label runResult = new Label();
    private ScrollPane langResults = new ScrollPane();
    private ScrollPane citResults = new ScrollPane();
    private TextField nameText = new TextField();
    private TextField codetext = new TextField();
    private TextField headText = new TextField();
    private ArrayList<String> NAMES = new ArrayList<>();
    private int N = 0;
    private String Name;
    private String needCode;
    private Label langResultsLabel = new Label();
    private Label citResultsLabel = new Label();
    private Button updateName = new Button();
    private Button updateCode = new Button();
    private Button updateHead = new Button();
    private Label Languages = new Label("Languages");
    private Label Cities = new Label("Cities");
    private String oldName;
    private String oldCode;
    private String oldhead;
    public  static Stage stage2 = new Stage();


    @Override
    public void start(Stage stage2) throws Exception {



        stage2.setTitle("Countries DataBase GUI");
        stage2.show();
        searchC.setText("Search by Code");
        searchN.setText("Serach by Name");

        HBox searches = new HBox(105, searchN,searchC);
        searches.setAlignment(Pos.TOP_LEFT);
        langResults.setHmax(10);
        citResults.setHmax(10);
        HBox texts = new HBox(10, sN,cN,run);
        run.setText("Run");
        HBox langCit = new HBox(70, Languages,Cities);
        HBox textsWlc = new HBox(150,texts,langCit);
        VBox Top = new VBox(10, searches,textsWlc);
        runResult.setWrapText(true);
        updateName.setText("Update Country Name");
        updateCode.setText("Update Country Code");
        updateHead.setText("Update Country Head of State");


        HBox countryfields = new HBox(10, nameText,codetext,headText);
        HBox updates = new HBox(15, updateName,updateCode,updateHead);
        HBox langCitresults = new HBox(10,langResults,citResults);
        VBox fieldsUpdate = new VBox(10, countryfields,updates);
        HBox connect = new HBox(10, fieldsUpdate,langCitresults);
        VBox top = new VBox(10,Top, connect,next,previous);


        next.setText("Next");
        previous.setText("Previous");

        Scene scene = new Scene(top);

        stage2.setScene(scene);

    }

    public static void main(String[] args){
        Application.launch(args);

    }



    {


        url = "jdbc:sqlite:/Users\\marshall\\Desktop\\cmspc 221\\hw13\\src\\main\\resources\\world";
        run.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                NAMES.clear();
                N= 0;
                if ((sN.getText() != null && !sN.getText().isEmpty())) {
                    nameSearch = sN.getText();
                    String sql = "SELECT * FROM Country WHERE Name  like ?";
                    try {

                        Connection connection = DriverManager.getConnection(url);


                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, '%'+nameSearch+'%');

                        ResultSet rSet = statement.executeQuery();

                        while (rSet.next()) {

                            NAMES.add(rSet.getString("Name"));
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if ((cN.getText() != null && !cN.getText().isEmpty())) {
                    codeSearch = cN.getText();
                    String sql = "SELECT * FROM Country WHERE Code  like ?";
                    try {

                        Connection connection = DriverManager.getConnection(url);


                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1,codeSearch);

                        ResultSet rSet = statement.executeQuery();

                        while (rSet.next()) {
                            NAMES.add(rSet.getString("Name"));
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



         next.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 if (  N < NAMES.size()) {
                     String sqlCode = "SELECT * FROM Country WHERE Name  like  ?";
                     try {

                         Connection connection = DriverManager.getConnection(url);

                         Name = NAMES.get(N);
                         PreparedStatement statement = connection.prepareStatement(sqlCode);
                         statement.setString(1, Name);


                         ResultSet rSet = statement.executeQuery();
                         while (rSet.next()) {
                             needCode = rSet.getString("Code");
                         }
                     } catch (SQLException e) {
                         e.printStackTrace();
                     }

                     String sql = "SELECT * FROM Country WHERE Name  like  ?";


                     try {

                         Connection connection = DriverManager.getConnection(url);

                         Name = NAMES.get(N);

                         PreparedStatement statement = connection.prepareStatement(sql);
                         statement.setString(1, Name);
                         ResultSet rSet = statement.executeQuery();


                         while (rSet.next()) {
                             nameText.setText(rSet.getString("Name"));
                             codetext.setText(rSet.getString("Code"));
                             headText.setText(rSet.getString("HeadOfState"));
                         }
                        oldName = nameText.getText();
                         oldCode = codetext.getText();
                         oldhead = headText.getText();

                     } catch (SQLException e) {
                         e.printStackTrace();
                     }

                     String sqlLang = "SELECT * from CountryLanguage where CountryCode like ?";
                     try {

                         Connection connection = DriverManager.getConnection(url);

                         PreparedStatement statement = connection.prepareStatement(sqlLang);
                         statement.setString(1, '%' + needCode + '%');
                         ResultSet rSet = statement.executeQuery();

                         StringJoiner resultjoin = new StringJoiner(System.lineSeparator());
                         while (rSet.next()) {
                             resultjoin.add(rSet.getString("Language"));
                         }
                         langResultsLabel.setText(resultjoin.toString());
                         langResults.setContent(langResultsLabel);

                     } catch (SQLException e) {
                         e.printStackTrace();
                     }

                     String sqlCit = "Select * FROM City WHERE CountryCode like ?";
                     try {

                         Connection connection = DriverManager.getConnection(url);

                         PreparedStatement statement = connection.prepareStatement(sqlCit);
                         statement.setString(1, '%' + needCode + '%');
                         ResultSet rSet = statement.executeQuery();

                         StringJoiner resultjoin = new StringJoiner(System.lineSeparator());
                         while (rSet.next()) {
                             resultjoin.add(rSet.getString("Name"));
                         }
                         citResultsLabel.setText(resultjoin.toString());
                         citResults.setContent(citResultsLabel);

                     } catch (SQLException e) {
                         e.printStackTrace();
                     }
                     N++;
                 }

             } });



            previous.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    if (N < NAMES.size() && N>0) {
                        String sqlCode = "SELECT * FROM Country WHERE Name  like  ?";
                        try {

                            Connection connection = DriverManager.getConnection(url);

                            Name = NAMES.get(N-1);
                            PreparedStatement statement = connection.prepareStatement(sqlCode);
                            statement.setString(1, Name);


                            ResultSet rSet = statement.executeQuery();
                            while (rSet.next()) {
                                needCode = rSet.getString("Code");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        String sql = "SELECT * FROM Country WHERE Name  like  ?";


                        try {

                            Connection connection = DriverManager.getConnection(url);

                            Name = NAMES.get(N-1);

                            PreparedStatement statement = connection.prepareStatement(sql);
                            statement.setString(1, Name);
                            ResultSet rSet = statement.executeQuery();


                            while (rSet.next()) {
                                nameText.setText(rSet.getString("Name"));
                                codetext.setText(rSet.getString("Code"));
                                headText.setText(rSet.getString("HeadOfState"));
                            }
                            oldName = nameText.getText();
                            oldCode = codetext.getText();
                            oldhead = headText.getText();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        String sqlLang = "SELECT * from CountryLanguage where CountryCode like ?";
                        try {

                            Connection connection = DriverManager.getConnection(url);

                            PreparedStatement statement = connection.prepareStatement(sqlLang);
                            statement.setString(1, '%' + needCode + '%');
                            ResultSet rSet = statement.executeQuery();

                            StringJoiner resultjoin = new StringJoiner(System.lineSeparator());
                            while (rSet.next()) {
                                resultjoin.add(rSet.getString("Language"));
                            }
                            langResultsLabel.setText(resultjoin.toString());
                            langResults.setContent(langResultsLabel);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        String sqlCit = "Select * FROM City WHERE CountryCode like ?";
                        try {

                            Connection connection = DriverManager.getConnection(url);

                            PreparedStatement statement = connection.prepareStatement(sqlCit);
                            statement.setString(1, '%' + needCode + '%');
                            ResultSet rSet = statement.executeQuery();

                            StringJoiner resultjoin = new StringJoiner(System.lineSeparator());
                            while (rSet.next()) {
                                resultjoin.add(rSet.getString("Name"));
                            }
                            citResultsLabel.setText(resultjoin.toString());
                            citResults.setContent(citResultsLabel);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                    N--;
                }
            });

            updateName.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        String nameChange = nameText.getText();
                        String sqlnameChange = "update Country SET Name = ? WHERE Name = ?";
                        try {

                            Connection connection = DriverManager.getConnection(url);


                            PreparedStatement statement = connection.prepareStatement(sqlnameChange);
                            statement.setString(1, nameChange);
                            statement.setString(2, oldName);

                          statement.execute();
                          statement.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                }
            });

        updateCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String codeChange = codetext.getText();
                String sqlnameChangeTCount = "update Country SET Code = ? WHERE Code= ?";

                try {

                    Connection connection = DriverManager.getConnection(url);


                    PreparedStatement statement = connection.prepareStatement(sqlnameChangeTCount);
                    statement.setString(1, codeChange);
                    statement.setString(2, oldCode);

                    statement.execute();
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String sqlnameChangeTCit = "update City SET CountryCode = ? WHERE CountrmnxznyCode= ?";

                try {

                    Connection connection = DriverManager.getConnection(url);


                    PreparedStatement statement = connection.prepareStatement(sqlnameChangeTCit);
                    statement.setString(1, codeChange);
                    statement.setString(2, oldCode);

                    statement.execute();
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String sqlnameChangeTLang = "update CountryLanguage SET CountryCode = ? WHERE CountryCode= ?";

                try {

                    Connection connection = DriverManager.getConnection(url);


                    PreparedStatement statement = connection.prepareStatement(sqlnameChangeTLang);
                    statement.setString(1, codeChange);
                    statement.setString(2, oldCode);

                    statement.execute();
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        updateHead.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String headChange = headText.getText();
                String sqlnameChange = "update Country SET HeadOfState = ? WHERE HeadOfState= ?";
                try {

                    Connection connection = DriverManager.getConnection(url);


                    PreparedStatement statement = connection.prepareStatement(sqlnameChange);
                    statement.setString(1, headChange);
                    statement.setString(2, oldhead);

                    statement.execute();
                    statement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        }
    }





