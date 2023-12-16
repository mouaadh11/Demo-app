package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloApplication extends Application {
    public AnchorPane MainAnchor = loadPaneFromFXML("hello-view.fxml");

    public AnchorPane AnchorBar = loadPaneFromFXML( "Sidbar.fxml");

    public Pane SideBar = getChildPane(AnchorBar,0);

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sidbar.fxml"));
        AnchorPane initialAnchorPane = loadPaneFromFXML("MainTimer.fxml");
        Pane initailPane= getChildPane(initialAnchorPane,0);
        AnchorPane.setRightAnchor(initailPane, 0.0);
        MainAnchor.getChildren().add(SideBar);
        MainAnchor.getChildren().add(initailPane);
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(MainAnchor);
        stage.setTitle("PomoTask");
        stage.setScene(scene);
        stage.show();
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
    public static void main(String[] args) {
    launch();

    }
}