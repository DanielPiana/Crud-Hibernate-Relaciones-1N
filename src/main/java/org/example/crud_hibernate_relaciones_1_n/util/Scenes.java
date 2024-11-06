package org.example.crud_hibernate_relaciones_1_n.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.crud_hibernate_relaciones_1_n.Controllers.MultasController;
import org.example.crud_hibernate_relaciones_1_n.MainApp;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;

import java.io.IOException;


public class Scenes {
    public static void mostrarEscena (Button boton, String fxml){
        try {
            //Cargamos fxml
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
            Parent root = fxmlLoader.load();
            //Obtenemos el controlador del fxml cargado
            Object controller = fxmlLoader.getController();
            //Creamos nueva escena con el root
            Scene scene = new Scene(root);
            //Obtenemos el stage del botón que ha causado el evento
            Stage stage = (Stage) boton.getScene().getWindow();
            //Seteamos el stage con la escena actual.
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Aparte del evento y el fxml necesario para cargar el fxml, le paso los datos que quiero del otro controlador
    public static void mostrarEscenaConParametros(ActionEvent event, Coche coche, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        //Creamos instancia del controlador al que queremos pasar datos
        MultasController multasController = fxmlLoader.getController();
        //Y ya tenemos acceso a los metodos del controller
        multasController.displayCoche(coche);
        //Y por ultimo cargamos nuestro nuevo fxml con los datos establecidos correctamente
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
    public static void mostrarEscenaConParametrosX(ActionEvent event,String nombre,String contraseña,String correo,String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
        Parent root = fxmlLoader.load();
        //Creamos instancia del controlador del que pasamos datos
        ActualizarController actualizarController = fxmlLoader.getController();
        //Y ya tenemos acceso a los metodos del controller
        actualizarController.displayUsuario(nombre,correo,contraseña);
        //Y por ultimo cargamos nuestro nuevo fxml con los datos establecidos correctamente
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */

}