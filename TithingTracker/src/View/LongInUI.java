/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Tyson And Jenn
 */
public class LongInUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // This is so that you have access to the screen properties
        Screen screen = Screen.getPrimary();
        Rectangle2D screenBounds = screen.getVisualBounds();
     
        // This is to set the screen size
        primaryStage.setX(screenBounds.getMinX());
        primaryStage.setY(screenBounds.getMinY());
        primaryStage.setHeight(screenBounds.getHeight());
        primaryStage.setWidth(screenBounds.getWidth());

        // Setting the title of the Stage
        primaryStage.setTitle("Sign In");

        // Creating the first element to be added to the Stage
        StackPane root = new StackPane();
        
        // Creating a grid to insert objects to it
        GridPane pane = new GridPane();     
        // setting the lines of the grids visible
        //pane.setGridLinesVisible(true);
        // Setting the grid to be center
        pane.setAlignment(Pos.CENTER);
        // Setting the vertical and horizontal gap
        pane.setVgap(5);
        pane.setHgap(5);
        
        // One text to display error messages
        Text errorMessageText = new Text();
        // setting the color to Red
        errorMessageText.setFill(Color.FIREBRICK);
        HBox boxForErrorMessage = new HBox();
        boxForErrorMessage.getChildren().add(errorMessageText);
        boxForErrorMessage.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(boxForErrorMessage, 1, 4);
        
        // Adding lables for the display
        Label userLabel = new Label("User Name:");
        TextField usernameField = new TextField();
        pane.add(userLabel, 0, 0);
        pane.add(usernameField, 1, 0);
        
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        pane.add(passwordLabel, 0, 1);
        pane.add(passwordField, 1, 1);
        
        //The user signs up by pressing this button
        Button signUpButton = new Button();
        signUpButton.setText("Sign Up");
        signUpButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Sign Up Pressed");
                  errorMessageText.setText("Sign Up Pressed");
            }
        });
        //          object, Column, Row
        /*
        *Sign up button isn't moving here!
        *
        ********/
        
        pane.add(signUpButton, 1, 3);
        
        // The box allows me to position the button left, center or right
        HBox boxForSignUpButton = new HBox();
        boxForSignUpButton.setAlignment(Pos.BASELINE_LEFT);
        boxForSignUpButton.getChildren().add(signUpButton);
        
        //pane.add(boxForSignUpButton, 0, 3);
        
        //The user logs in by pressing this button
        Button loginButton = new Button();
        loginButton.setText("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Login pressed");
                errorMessageText.setText("login Button Pressed");
            }
        });
        
        // It also allows me to place 2 objects center or sepate
        HBox mainBoxForButtons = new HBox();
        mainBoxForButtons.setAlignment(Pos.BASELINE_RIGHT);
        // setting padding
        mainBoxForButtons.setSpacing(20);
        
        HBox boxForLoginButton  = new HBox();
        boxForLoginButton.setAlignment(Pos.BASELINE_RIGHT);
        boxForLoginButton.getChildren().add(loginButton);
        
        // You can just add the button and you don't 
        // need the boxes to do the same
        // mainBoxForButtons.getChildren().addAll(signUpButton, loginButton);
        
        mainBoxForButtons.getChildren().addAll(boxForSignUpButton, boxForLoginButton);
        
        //          object, Column, Row
        pane.add(mainBoxForButtons, 0, 3);
        
        root.getChildren().add(pane);
        
        Scene scene = new Scene(root, 500, 250);
        
        // Final adding the scene to the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
