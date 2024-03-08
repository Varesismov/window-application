package com.example.aoim_22_11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load((getClass().getResource("/com/example/aoim_22_11/hello-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ClassEmployee klasa =  new ClassEmployee(7, "pracownicy");
        klasa.addEmployee(new Employee("Krzysztof", "Stajniak", EmployeeCondition.obecny, 2002, 10000.0));
        klasa.addEmployee(new Employee("Krzyesztof", "Ślimak", EmployeeCondition.obecny, 2003, 5000.0));
        klasa.addEmployee(new Employee("Krzysztof", "Rura", EmployeeCondition.obecny, 2005, 6000.0));


        ClassEmployee klasa2 =  new ClassEmployee(10, "Sprzątacze");
        klasa2.addEmployee(new Employee("Andrzej", "Gołota", EmployeeCondition.obecny, 1996, 2000.0));
        klasa2.addEmployee(new Employee("Andrzej", "Golara", EmployeeCondition.obecny, 1996, 4000.0));
        klasa2.addEmployee(new Employee("Andrzej", "Goliat", EmployeeCondition.obecny, 1993, 3000.0));

        Data.classemployeeList.add(klasa);
        Data.classemployeeList.add(klasa2);


        launch(args);
    }
}