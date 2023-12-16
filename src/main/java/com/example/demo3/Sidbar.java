package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class Sidbar {
    // Get a reference to the HelloApplication instance
    private final HelloApplication helloApplication = HelloApplication.getInstance();
    AnchorPane AnchorloginPane;
    Pane loginPane;
    AnchorPane AnchorStatPane;
    Pane StatPane;
    AnchorPane AnchorMainPane = helloApplication.initialAnchorPane;
    Pane MainPane = helloApplication.initailPane;
    @FXML
    private Button MainPomodoro_button;

    @FXML
    private Button Profile_button;

    @FXML
    private Button Stats_button;

    @FXML
    private Button settings_button;

    @FXML
    void Btn_1ME(MouseEvent event) {

    }

    @FXML
    void Btn_2ME(MouseEvent event) {

    }

    @FXML
    public void MainP_button_action(ActionEvent event) {
        if (!helloApplication.MainAnchor.getChildren().contains(helloApplication.initailPane) && !helloApplication.MainAnchor.getChildren().contains(MainPane)) {
            // Load the LoginPane
            AnchorMainPane = helloApplication.loadPaneFromFXML("MainTimer.fxml");
            MainPane = helloApplication.getChildPane(AnchorMainPane,0);
            System.out.println("rah yadkhol");
            // Remove the initialPane from MainAnchor
            helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

            // Add the LoginPane to MainAnchor
            AnchorPane.setRightAnchor(MainPane, 0.0);
            helloApplication.MainAnchor.getChildren().add(MainPane);
        }
    }

    @FXML
    void Profile_buttonAction(ActionEvent event) {
        if (!helloApplication.MainAnchor.getChildren().contains(loginPane)) {
            // Load the LoginPane
            AnchorloginPane = helloApplication.loadPaneFromFXML("LoginPane.fxml");
            loginPane = helloApplication.getChildPane(AnchorloginPane,0);
            System.out.println("rah yadkhol");
            // Remove the initialPane from MainAnchor
            helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

            // Add the LoginPane to MainAnchor
            AnchorPane.setRightAnchor(loginPane, 0.0);
            helloApplication.MainAnchor.getChildren().add(loginPane);
        }
    }


    @FXML
    void Stats_button_action(ActionEvent event) {
        if (!helloApplication.MainAnchor.getChildren().contains(StatPane)) {
            // Load the LoginPane
            AnchorStatPane = helloApplication.loadPaneFromFXML("StatsPane.fxml");
            StatPane = helloApplication.getChildPane(AnchorStatPane,0);
            System.out.println("rah yadkhol");
            // Remove the initialPane from MainAnchor
            helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

            // Add the LoginPane to MainAnchor
            AnchorPane.setRightAnchor(StatPane, 0.0);
            helloApplication.MainAnchor.getChildren().add(StatPane);
        }

    }

    @FXML
    void StdBtnME(MouseEvent event) {

    }

    @FXML
    void btn_1Hover(MouseEvent event) {

    }

    @FXML
    void btn_2Hover(MouseEvent event) {

    }

    @FXML
    void hover(MouseEvent event) {

    }

}
