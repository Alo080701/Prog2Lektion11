package opgave01.gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import opgave01.controller.Controller;
import opgave01.models.Person;
import opgave01.models.Role;


public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    private final Controller controller = new Controller();
    private final ListView<Person> lvwP = new ListView<>();
    private final TextField txfNvn = new TextField();
    private final CheckBox checkBox = new CheckBox();


    @Override
    public void stop() {

    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblP = new Label("Personer");
        pane.add(lblP, 0, 0);
        pane.add(lvwP, 0, 1, 1, 3);
        lvwP.setPrefHeight(200);
        lvwP.setPrefWidth(400);
        lvwP.getItems().setAll(controller.getPeople());

        Label lblNvn = new Label("Navn: ");
        pane.add(lblNvn, 0, 5);

        pane.add(txfNvn, 0, 6);

        Label label = new Label("Lærer: ");
        pane.add(label, 0, 7);
        pane.add(checkBox, 1, 7);

        Button button1 = new Button("Create");
        pane.add(button1, 0, 8);
        button1.setOnAction(e -> create());

        Button button = new Button("Skift Rolle");
        pane.add(button, 3, 1);
        button.setOnAction(e -> skiftRolle());


    }

    public void skiftRolle() {
        Person person = lvwP.getSelectionModel().getSelectedItem();

        if (person.getRole() == Role.STUDENT) {
            person.setRole(Role.TEACHER);
        } else {
            person.setRole(Role.STUDENT);
        }


        lvwP.getItems().setAll(controller.getPeople());
    }

    public void create() {
        String navn = txfNvn.getText();
        Role role = null;
        if (checkBox.isSelected()){
            role = Role.TEACHER;
        }else {
            role = Role.STUDENT;
        }

        Person person = new Person(navn, role);
        controller.addPerson(person);

        lvwP.getItems().setAll(controller.getPeople());

    }
}
