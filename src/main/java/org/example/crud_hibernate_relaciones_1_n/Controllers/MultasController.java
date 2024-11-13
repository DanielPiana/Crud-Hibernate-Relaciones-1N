package org.example.crud_hibernate_relaciones_1_n.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.crud_hibernate_relaciones_1_n.DAO.CocheDao;
import org.example.crud_hibernate_relaciones_1_n.DAO.CocheDaoImpl;
import org.example.crud_hibernate_relaciones_1_n.DAO.MultaDao;
import org.example.crud_hibernate_relaciones_1_n.DAO.MultaDaoImpl;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.example.crud_hibernate_relaciones_1_n.util.Alerts;
import org.example.crud_hibernate_relaciones_1_n.util.Comprobaciones;
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
    CocheDao dao = new CocheDaoImpl();

    @FXML
    void onButtonEliminarClick(ActionEvent event) {
        if (tableMultas.getSelectionModel().getSelectedItem() != null) {
            Multa multa = tableMultas.getSelectionModel().getSelectedItem();
            multaDao.eliminarMulta(multa,session);
            cargarTabla(multa.getMatricula(),session);
            limpiarTextFields();
            Alerts.alertaGeneral("Multa eliminada correctamente","INFORMATION");
        } else {
            Alerts.alertaGeneral("Debe seleccionar una multa para eliminar","INFORMATION");
        }
    }

    @FXML
    void onButtonGuardarClick(ActionEvent event) {
        if (Comprobaciones.stringosNoVacios(txtIdMulta.getText(),txtPrecio.toString()) || datePicker.getValue() != null) {
            Coche coche = dao.buscarCocheConMatricula(txtFieldMatricula.getText(),session);
            Multa multa = new Multa(0,txtFieldMatricula.getText(),Double.parseDouble(txtPrecio.getText()),datePicker.getValue(),coche);
            multaDao.insertarMulta(multa,session);
            cargarTabla(multa.getMatricula(),session);
            limpiarTextFields();
            Alerts.alertaGeneral("Multa insertada correctamente","INFORMATION");
        } else {
            Alerts.alertaGeneral("Debe rellenar todos los campos", "INFORMATION");
        }
    }

    @FXML
    void onButtonModificarClick(ActionEvent event) {
        Multa multaReferencia = tableMultas.getSelectionModel().getSelectedItem();
        if (multaReferencia != null) {
            if (tableMultas.isEditable()) {
                tableMultas.setEditable(false);
                tableMultas.setDisable(true);
                buttonEliminar.setDisable(true);
                buttonGuardar.setDisable(true);
                buttonLimpiar.setDisable(true);
                Alerts.alertaGeneral("Escribe en los campos habilitados, lo que deseas modificar de la multa seleccionada","INFORMATION");
            } else {
                String fecha = datePicker.getValue().toString();
                if (Comprobaciones.stringosNoVacios(txtPrecio.getText(),fecha)) {
                    Multa multaMod = new Multa (datePicker.getValue(),Double.parseDouble(txtPrecio.getText()),txtFieldMatricula.getText(), multaReferencia.getId_multa());
                    multaDao.modificarMulta(multaMod,session);
                    habilitar();
                    Alerts.alertaGeneral("Multa modificada correctamente","INFORMATION");
                    cargarTabla(multaMod.getMatricula(),session);
                } else {
                    Alerts.alertaGeneral("Debe rellenar todos los campos", "INFORMATION");
                }
            }
        }
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

    @FXML
    void onButtonLimpiarClick(ActionEvent event) {
        limpiarTextFields();
    }

    public void onButtonCochesClick() {
        Scenes.mostrarEscena(buttonCoches,"ui/Main.fxml");
    }
    void cargarTabla(String matricula, Session session) {
        ObservableList<Multa> listaMultas = multaDao.listarMultasCoche(matricula, session);
        tableMultas.setItems(listaMultas);
    }
    void cargarTablaInitialize(Coche coche) {
        ObservableList<Multa> listaMultas = multaDao.listarMultasCoche(coche.getMatricula(),session);
        tableMultas.setItems(listaMultas);
    }
    void limpiarTextFields() {
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
        cargarTablaInitialize(coche);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Hay que declarar explicitamente que la tabla es editable para que el metodo de modificar pueda devolver true si es editable
        tableMultas.setEditable(true);
    }
    public void habilitar() {
        tableMultas.setEditable(true);
        tableMultas.setDisable(false);
        buttonEliminar.setDisable(false);
        buttonGuardar.setDisable(false);
        buttonLimpiar.setDisable(false);
    }

}
