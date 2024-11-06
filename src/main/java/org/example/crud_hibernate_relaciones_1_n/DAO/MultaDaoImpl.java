package org.example.crud_hibernate_relaciones_1_n.DAO;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.crud_hibernate_relaciones_1_n.domain.Coche;
import org.example.crud_hibernate_relaciones_1_n.domain.Multa;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MultaDaoImpl implements MultaDao {

    @Override
    public void insertarMulta() {

    }

    @Override
    public void eliminarMulta() {

    }

    @Override
    public void modificarMulta() {

    }

    @Override
    public ObservableList<Multa> listarMultasCoche(Coche coche,Session session) {
        Transaction transaction = null; //Inicializamos la transacción a null, servirá para hacer rollback a los cambios si se ha producido un error
        List listaMultas = new ArrayList<>(); //Creamos una lista vacía
        try{
            transaction = session.beginTransaction(); //Empezamos la transacción y la guardamos en la variable transaction
            //COMO QUEREMOS LAS MULTAS CONCRETAS DE UN COCHE TENDREMOS QUE USAR UNA CONSULTA HQL PERSONALIZADA
            listaMultas = session.createQuery("from Multa where matricula = '" + coche.getMatricula()+"'").list();

            transaction.commit(); //Confirmamos la transacción
            session.clear(); //Limpia la sesión
        }catch (Exception e) {
            if (transaction != null) { //Comprobamos si la transacción se ha iniciado
                transaction.rollback(); //Si se ha iniciado y ha generado un error, hacemos rollback. O hacemos todos los cambios o ninguno
                System.out.println(e.getMessage()); //Imprimimos el mensaje de error para identificarlo mas fácilmente
            }
        }
        return FXCollections.observableList(listaMultas); //Devolvemos la lista en formato ObservableList para cargarlo en la tabla
    }

    @Override
    public boolean existe() {
        return false;
    }
}
