package com.example.javaaidietician;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private Button button_login;
    @FXML
    private Button button_sign_up;
    @FXML
    private Button button_guestUser;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_password;
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.LogInUser(event,txt_username.getText(),txt_password.getText());
            }
        });
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"signup.fxml","Sign Up",null);
            }
        });
        button_guestUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              DBUtils.guestScene1(event,"Logged-in.fxml","User","Guest");
            }
        });
    }
}