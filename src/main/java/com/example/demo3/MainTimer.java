package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainTimer {
    public static MainTimer mainTimer;
    private final HelloApplication helloApplication = HelloApplication.getInstance();
    AnchorPane AnchorAddPane;
    Pane AddPane;
    List<Pane> TasksPane ;
    int index = 1;
    public MainTimer(){
        mainTimer = this;
        this.TasksPane = new ArrayList<Pane>();
    }
    @FXML
    private ImageView SPImG;

    @FXML
    private Pane TimerPan;

    @FXML
    private Text TimerText;

    @FXML
    private VBox VboxTasks;

    @FXML
    private ImageView addTask;

    @FXML
    private Button addTask_button;

    @FXML
    private Button play_button;

    @FXML
    private Button reset_button;

    @FXML
    private Button skip_button;

    @FXML
    private Pane textTasks;

    @FXML
    private Text textprogressbar;

    @FXML
    private ProgressBar timerProgressbar;

    @FXML
    void Stats_button_action(ActionEvent event) {

    }

    @FXML
    void StdBtnME(MouseEvent event) {

    }

    @FXML
    void addTaskButton(ActionEvent event) throws IOException {
        AnchorAddPane = helloApplication.loadPaneFromFXML("AddTasks.fxml");;
        AddPane = helloApplication.getChildPane(AnchorAddPane,0);
        helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

        // Add the LoginPane to MainAnchor
        AnchorPane.setRightAnchor(AddPane, 0.0);
        helloApplication.MainAnchor.getChildren().add(AddPane);
        System.out.println("new Add Pane has opened");
    }
    void update(Pane task){
        TasksPane.add(task);

        VBox vbox = VboxTasks;
        vbox.getChildren().add(index, task);
        index++;
    }

    void reload(int idToChange) {
        VBox vbox = VboxTasks;
        int panes = 1;
        System.out.println("id:" + idToChange);
        for (Pane pane : TasksPane) {
            System.out.println("panes"+panes);
            if (panes == idToChange+1){
                System.out.println("dkhalt");
                vbox.getChildren().remove(idToChange+1);
                System.out.println("removed");
                vbox.getChildren().add(idToChange+1, pane);
            }

            panes++;
        }
        FXMLLoader fxmlLoader = (FXMLLoader) (TasksPane.get(0).getScene().getUserData());
        TaskItem controllerTask = fxmlLoader.getController();
        controllerTask.print();
    }

    public void setTimerText(String timerText) {
        TimerText.setText(timerText);
    }

    public static MainTimer getMaininstance(){
        return mainTimer;
    }
    @FXML
    void hover(MouseEvent event) {

    }

}