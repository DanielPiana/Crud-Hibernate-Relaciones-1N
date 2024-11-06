package org.example.crud_hibernate_relaciones_1_n.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.crud_hibernate_relaciones_1_n.DAO.MultaDao;
import org.example.crud_hibernate_relaciones_1_n.DAO.MultaDaoImpl;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.example.crud_hibernate_relaciones_1_n.util.Alerts;
import org.example.crud_hibernate_relaciones_1_n.util.HibernateUtil;
import org.example.crud_hibernate_relaciones_1_n.util.Scenes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MultasController implements Initializable{
    @FXML
    private Button buttonCoches;
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
    private TableView<Multa> tableMultas;

    @FXML
    private TextField txtFieldMatricula;

    @FXML
    private TextField txtIdMulta;

    @FXML
    private TextField txtPrecio;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = HibernateUtil.getSession();
    MultaDao multaDao = new MultaDaoImpl();

    @FXML
    void onButtonEliminarClick(ActionEvent event) {

    }

    @FXML
    void onButtonGuardarClick(ActionEvent event) {

    }

    @FXML
    void onButtonLimpiarClick(ActionEvent event) {
        limpiarTextFields();
    }

    @FXML
    void onButtonModificarClick(ActionEvent event) {

    }

    @FXML
    void onTableClick(MouseEvent event) {
        Multa multa = tableMultas.getSelectionModel().getSelectedItem();
        if (multa != null) {
            txtPrecio.setText(String.valueOf(multa.getPrecio()));
            txtIdMulta.setText(String.valueOf(multa.getId_multa()));
            datePicker.setValue(multa.getFecha());
        }
    }

    public void onButtonCochesClick() {
        Scenes.mostrarEscena(buttonCoches,"ui/Main.fxml");
    }

    void cargarTabla(Coche coche) {
        ObservableList<Multa> listaMultas = multaDao.listarMultasCoche(coche,session);
        tableMultas.setItems(listaMultas);
    }
    void limpiarTextFields() {
        txtFieldMatricula.setText("");
        txtIdMulta.setText("");
        txtPrecio.setText("");
        datePicker.setValue(null);
        datePicker.getEditor().clear();
    }

    public void displayCoche(Coche coche) {
        //USO ESTO COMO INITIALIZE
        txtFieldMatricula.setText(coche.getMatricula());
        txtFieldMatricula.setEditable(false);
        columnaIdMulta.setCellValueFactory(new PropertyValueFactory<>("id_multa"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cargarTabla(coche);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
