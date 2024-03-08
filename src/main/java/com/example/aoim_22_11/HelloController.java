package com.example.aoim_22_11;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class HelloController implements Initializable {

    protected Stage stage;
    protected Scene scene;
    public ObservableList<ClassEmployee> klasa_list = Data.classemployeeList;
    @FXML
    private TableView<Employee> Tabela_pracownikow;

    @FXML
    private TableColumn<Employee, String> Tabela_pracownikow_imie;

    @FXML
    private TableColumn<Employee, String> Tabela_pracownikow_nazwisko;

    @FXML
    private TableColumn<Employee, String> Tabela_pracownikow_salary;

    @FXML
    private TextField Wyszukiwanie;

    @FXML
    private Button dodaj_grupa;

    @FXML
    private Button dodaj_pracownik;

    @FXML
    private Button edytuj_grupa;

    @FXML
    private Button edytuj_pracownik;

    @FXML
    private ListView<ClassEmployee> grupaPracowniczaListView;

    @FXML
    private Text grupa_pracownicza_ilosc_osob;

    @FXML
    private Text grupa_pracownicza_nazwa;

    @FXML
    private Text grupa_pracownicza_zapelnienie;

    @FXML
    private Button usun_grupa;

    @FXML
    private Button usun_pracownik;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grupaPracowniczaListView.setItems(klasa_list);
        Tabela_pracownikow_imie.setCellValueFactory(new PropertyValueFactory<>("Imię"));
        Tabela_pracownikow_nazwisko.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        Tabela_pracownikow_salary.setCellValueFactory(new PropertyValueFactory<>("Wynagrodzenie"));

        grupaPracowniczaListView.setOnMouseClicked(event->{
            ObservableList<Employee> result = FXCollections.observableArrayList();
            ObservableList<ClassEmployee> selected = FXCollections.observableArrayList();
            selected = grupaPracowniczaListView.getSelectionModel().getSelectedItems();
            result.addAll(selected.get(0).getPracownicy());
            Tabela_pracownikow.setItems(result);

            grupa_pracownicza_nazwa.setText(selected.get(0).getNazwa_grupy());
            grupa_pracownicza_ilosc_osob.setText(String.valueOf(selected.get(0).getPracownicy().size()));
            double procnet = (double)(selected.get(0).getPracownicy().size())/selected.get(0).getPojemnosc();
            String zapelnienie = String.format("%.2f%%",procnet*100);
            grupa_pracownicza_zapelnienie.setText(zapelnienie);

        });

        Wyszukiwanie.setOnAction(event->{
            String fragment = Wyszukiwanie.getText();
            ObservableList<ClassEmployee> selected = FXCollections.observableArrayList();
            for (ClassEmployee classEmployee : klasa_list) {
                if(classEmployee.getNazwa_grupy().contains(fragment)) {
                    selected.add(classEmployee);
                }
            }
            grupaPracowniczaListView.setItems(selected);
        });


    }

    @FXML
    protected void addgroup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/aoim_22_11/dodawanie_grupy.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void removegroup(ActionEvent event) throws IOException{
        ObservableList<ClassEmployee> allGroups, singleGroup;
        allGroups = grupaPracowniczaListView.getItems();
        singleGroup =grupaPracowniczaListView.getSelectionModel().getSelectedItems();
        singleGroup.forEach(allGroups::remove);
    }

    @FXML
    protected void editgroup(ActionEvent event) throws IOException {
        try{
            ObservableList<ClassEmployee> singleGroup;
            singleGroup = grupaPracowniczaListView.getSelectionModel().getSelectedItems();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aoim_22_11/edytowanie_grupy.fxml"));
            Parent root = loader.load();

            EditGroupController editGroupController = loader.getController();
            editGroupController.setPrzekazana_grupa(singleGroup);


            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
        }
    }

    @FXML
    protected void addEmployee(ActionEvent event) throws IOException {
        try{
            ObservableList<ClassEmployee> singleGroup;
            singleGroup = grupaPracowniczaListView.getSelectionModel().getSelectedItems();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aoim_22_11/dodawanie_pracownika.fxml"));
            Parent root = loader.load();

            AddEmployeeController addEmployeeController = loader.getController();
            addEmployeeController.setGrupa(singleGroup);


            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
        }

    }
    @FXML
    protected  void removeEmployee(ActionEvent event) throws IOException{
        ObservableList<ClassEmployee> singleGroup;
        singleGroup = grupaPracowniczaListView.getSelectionModel().getSelectedItems();
        ObservableList<Employee> singleEmployee;
        ObservableList<Employee> result = FXCollections.observableArrayList();;
        singleEmployee =Tabela_pracownikow.getSelectionModel().getSelectedItems();
        singleGroup.get(0).getPracownicy().remove(singleEmployee.get(0));
        result.addAll(singleGroup.get(0).getPracownicy());
        Tabela_pracownikow.setItems(result);
    }


    @FXML
    protected void editEmployee(ActionEvent event) throws IOException {
        try {
            ObservableList<Employee> singleEmployee;
            singleEmployee = Tabela_pracownikow.getSelectionModel().getSelectedItems();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/aoim_22_11/edytowanie_pracownika.fxml"));
            Parent root = loader.load();

            EditEmployeeController editEmployeeController = loader.getController();
            editEmployeeController.setSelected_Employee(singleEmployee);


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
        }
    }





    }
