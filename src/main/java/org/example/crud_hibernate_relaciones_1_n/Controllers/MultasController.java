package org.example.crud_hibernate_relaciones_1_n.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.example.crud_hibernate_relaciones_1_n.util.Scenes;

import java.util.Date;

public class MultasController {

    public Button buttonCoches;
    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonGuardar;

    @FXML
    private Button buttonLimpiar;

    @FXML
    private Button buttonModificar;

    @FXML
    private TableColumn<Date,DatePicker> columnaFecha;

    @FXML
    private TableColumn<Multa,Integer> columnaIdMulta;

    @FXML
    private TableColumn<Multa,Double> columnaPrecio;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<Multa> tableCoches;

    @FXML
    private TextField txtFieldMatricula;

    @FXML
    private TextField txtIdMulta;

    @FXML
    private TextField txtPrecio;

    @FXML
    void onButtonEliminarClick(ActionEvent event) {

    }

    @FXML
    void onButtonGuardarClick(ActionEvent event) {

    }

    @FXML
    void onButtonLimpiarClick(ActionEvent event) {

    }

    @FXML
    void onButtonModificarClick(ActionEvent event) {

    }

    @FXML
    void onTableClick(MouseEvent event) {

    }

    public void onButtonCochesClick() {
        Scenes.mostrarEscena(buttonCoches,"ui/Main.fxml");
    }
}
