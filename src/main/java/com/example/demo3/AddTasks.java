package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.Status;
import logic.Tags;
import logic.Task;

import java.io.IOException;
import java.util.Date;



public class AddTasks {
    private final HelloApplication helloApplication = HelloApplication.getInstance();
    @FXML
    private Button CreateTask_button;

    @FXML
    private DatePicker DueDate;

    @FXML
    private Button Exist_button;

    @FXML
    private Text Pomodoro_Quntity;

    @FXML
    private TextField TasksDuration;

    @FXML
    private TextField TasksName;

    @FXML
    void Btn_2ME(MouseEvent event) {

    }

    @FXML
    void CreateTask_button_action(ActionEvent event) throws IOException {
        java.time.LocalDate deadine = DueDate.getValue();
        String durationText = TasksDuration.getText();
        //get it from the DB
        int PomodoroDuraion = 25;

        //creating a task instance ();

        this.Pomodoro_Quntity.setText(String.valueOf(Integer.parseInt(durationText)  / PomodoroDuraion));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskItem.fxml"));
        Pane taskItemPane = loader.load();
        TaskItem controller = loader.getController();

        // Modify attributes using methods in the controller
        controller.updateTitle(TasksName.getText());
        MainTimer mainTimer = MainTimer.getMaininstance();
        if (mainTimer != null) {
            // Now you can access methods or fields in the MainTimer controller
            mainTimer.update(taskItemPane);
            Task task = new Task(1, TasksName.getText(),null,null , Tags.DEFAULT, 4,
                    "", Status.TODO, null, 2);
        }
         else {
            System.out.println("MainTimer controller not initialized.");
        }


        helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

        // Add the LoginPane to MainAnchor
        AnchorPane.setRightAnchor(helloApplication.initailPane, 0.0);
        helloApplication.MainAnchor.getChildren().add(helloApplication.initailPane);
        System.out.println("new Main Pane has opened");
//        mainTimer.reload();
    }

    @FXML
    void Exist_button_action(ActionEvent event) {
        helloApplication.MainAnchor.getChildren().remove(helloApplication.getChildPane(helloApplication.MainAnchor,1));

        // Add the LoginPane to MainAnchor
        AnchorPane.setRightAnchor(helloApplication.initailPane, 0.0);
        helloApplication.MainAnchor.getChildren().add(helloApplication.initailPane);
        System.out.println("new Main Pane has opened");
    }

    @FXML
    void btn_2Hover(MouseEvent event) {

    }

}
