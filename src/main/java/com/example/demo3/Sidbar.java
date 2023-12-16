package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Sidbar {
    public AnchorPane MainAnchor = loadPaneFromFXML("hello-view.fxml");
    public AnchorPane AnchorBar = loadPaneFromFXML( "Sidbar.fxml");
    public Pane SideBar = getChildPane(AnchorBar,0);

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
    void MainP_button_action(ActionEvent event) {

    }

    @FXML
    void Profile_buttonAction(ActionEvent event) {
        AnchorPane MainAnchor = loadPaneFromFXML("LoginPane.fxml");
        Pane loginPane = getChildPane(MainAnchor,0);
        setContentPane(loginPane);

    }


    @FXML
    void Stats_button_action(ActionEvent event) {

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
    private AnchorPane loadPaneFromFXML(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); // Return an empty pane in case of an exception
        }
    }
    public void setContentPane(Pane newContent) {
        // Clear existing content and add the new content
        MainAnchor.getChildren().clear();
        AnchorPane.setRightAnchor(newContent, 0.0);
        MainAnchor.getChildren().add(SideBar);
        MainAnchor.getChildren().add(newContent);
    }
    private Pane getChildPane(AnchorPane anchorPane, int index) {
        if (index >= 0 && index < anchorPane.getChildren().size()) {
            if (anchorPane.getChildren().get(index) instanceof Pane) {
                return (Pane) anchorPane.getChildren().get(index);
            }
        }
        return null;
    }

}
