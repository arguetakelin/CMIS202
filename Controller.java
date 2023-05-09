// **********************************************************************************
// Title: Major Project
// Author: Kelin Argueta
// Course Section: CMIS202-ONL1 (Seidel) Spring 2023
// **********************************************************************************

package gui;

import dst.MyLinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import weightloss.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Controller {

    private ComboBox difficultyComboBox;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputPw;

    private TextField username;
    private TextField age;
    private TextField weight;
    private TextField height;
    private TextField gender;
    private TextField fitness;
    private PasswordField pw;
    private TableView tableView;

    public Controller() {
    }


    public void exitApp() {
        System.exit(0);
    }

    private String validateInput() {
        String invalid = "";
        if (username.getText().equals(invalid))
            return "Username Required";
        else if (age.getText().equals(invalid))
            return "Age Required";
        else if (weight.getText().equals(invalid))
            return "Weight Required";
        else if (height.getText().equals(invalid))
            return "height Required";
        else if (gender.getText().equals(invalid))
            return "Gender Required";
        else if (fitness.getText().equals(invalid))
            return "Fitness Required";
        else if (pw.getText().equals(invalid))
            return "Password Required";
        else
            return invalid;
    }

    public void registerBtn() throws IOException {
        String valid = validateInput();
        if (!valid.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("User Registration");
            alert.setHeaderText(null);
            alert.setContentText(valid);
            alert.showAndWait();
            return;
        }

        User user = new User();
        user.setAge(Integer.parseInt(age.getText()));
        user.setFitnessLevel(fitness.getText());
        user.setGender(gender.getText());
        user.setHeight(Float.parseFloat(height.getText()));
        user.setWeight(Float.parseFloat(weight.getText()));
        user.setName(username.getText());
        user.setPassword(pw.getText());
        user.saveUserToFile("users.csv");

        username.setText("");
        age.setText("");
        fitness.setText("");
        gender.setText("");
        weight.setText("");
        height.setText("");
        pw.setText("");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Registration");
        alert.setHeaderText(null);
        alert.setContentText("User Registered Successfully!");
        alert.showAndWait();

    }

    public void checkWorkouts(ActionEvent actionEvent) {
        if(difficultyComboBox.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User Login");
            alert.setHeaderText(null);
            alert.setContentText("Please Select Difficult Level");
            alert.showAndWait();
            return;
        }

        ExerciseLibrary exl = new ExerciseLibrary();
        exl.addExercisesFromFile("gym.csv");
        WorkoutsCreation wc = new WorkoutsCreation(exl);
        Main.user.setFitnessLevel(difficultyComboBox.getValue().toString());
        Workout wk = wc.createWorkout(Main.user);
        LinkedList<Exercise> exer = wk.getExercises();
        List<Exercise> ex = (List<Exercise>) exer.getLast();
        tableView.getItems().clear();
        tableView.getColumns().clear();
        tableView.refresh();
        // Assuming you have a TableView and columns already defined
        TableColumn<Exercise, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Exercise, String> equipmentColumn = new TableColumn<>("Equipment");
        equipmentColumn.setCellValueFactory(new PropertyValueFactory<>("equipment"));

        TableColumn<Exercise, String> muscleGroupColumn = new TableColumn<>("Muscle Group");
        muscleGroupColumn.setCellValueFactory(new PropertyValueFactory<>("muscleGroup"));

        TableColumn<Exercise, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        tableView.getColumns().addAll(nameColumn, equipmentColumn, muscleGroupColumn, descriptionColumn);

// Create some example data
        ObservableList<Exercise> data = FXCollections.observableArrayList(ex);

// Load the data into the TableView
        tableView.setItems(data);



    }

    public void registerLink(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Main.copyStage.setTitle("User Registration");
        Main.copyStage.setScene(new Scene(root, 800, 575));
        Main.copyStage.show();
    }

    private String validatLogin(){
        String invalid = "";
        if(inputName.getText().equals(invalid))
            return "Name is required";
        else if(inputPw.getText().equals(invalid))
            return "Password is required";
        else
            return invalid;
    }
    public void loginUser(ActionEvent actionEvent) throws IOException {
        String invalid = validatLogin();
        if(!invalid.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("User Registration");
            alert.setHeaderText(null);
            alert.setContentText(invalid);
            alert.showAndWait();
            return;
        }
        List<User> users = readUsersFromFile("users.csv");
        boolean login = false;
        for (User user :users ) {
            if(user.getName().equalsIgnoreCase(inputName.getText()) &&
            user.getPassword().equalsIgnoreCase(inputPw.getText())){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Login");
                alert.setHeaderText(null);
                alert.setContentText("Logged in Successfully!");
                alert.showAndWait();
                Main.user = user;
                login = true;
                break;
            }
        }
        if(!login) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User Login");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Name or Password!");
            alert.showAndWait();
            return;
        }
        Parent root = FXMLLoader.load(getClass().getResource("workouts.fxml"));
        Main.copyStage.setTitle("User Workouts");
        Main.copyStage.setScene(new Scene(root, 800, 575));
        Main.copyStage.show();
    }

    private List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 7) {
                    System.err.println("Invalid user data: " + line);
                    continue;
                }
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                float weight = Float.parseFloat(parts[2]);
                float height = Float.parseFloat(parts[3]);
                String gender = parts[4];
                String level = parts[5];
                String pw = parts[6];
                User user = new User();
                user.setName(name);
                user.setAge(age);
                user.setWeight(weight);
                user.setHeight(height);
                user.setGender(gender);
                user.setFitnessLevel(level);
                user.setPassword(pw);
                users.add(user);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return users;
    }

    public abstract void start(Stage primaryStage) throws Exception;
}
