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
    public void insertarMulta(Multa multa, Session session) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(multa);
            transaction.commit();
            session.clear();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void eliminarMulta(Multa multa, Session session) {
        Transaction transaction = null; //Inicializamos la transacción a null, servirá para hacer rollback a los cambios si se ha producido un error
        try {
            transaction = session.beginTransaction(); //Empezamos la transacción y la guardamos en la variable transaction
            Multa multa1 = session.get(Multa.class, multa.getId_multa()); //Conseguimos el usuario con el id de la multa seleccionada
            session.delete(multa1); // Si existe una multa con ese id, la eliminamos
            transaction.commit(); //Confirmamos la transacción
            session.clear(); //Limpia la sesión
        }catch (Exception e) {
            if (transaction != null) { //Comprobamos si la transacción se ha iniciado
                transaction.rollback(); //Si se ha iniciado y ha generado un error, hacemos rollback. O hacemos todos los cambios o ninguno
                System.out.println(e.getMessage()); //Imprimimos el mensaje de error para identificarlo mas fácilmente
            }
        }
    }

    @Override
    public void modificarMulta() {

    }

    @Override
    public ObservableList<Multa> listarMultasCoche(String matricula,Session session) {
        Transaction transaction = null; //Inicializamos la transacción a null, servirá para hacer rollback a los cambios si se ha producido un error
        List listaMultas = new ArrayList<>(); //Creamos una lista vacía
        try{
            transaction = session.beginTransaction(); //Empezamos la transacción y la guardamos en la variable transaction
            //COMO QUEREMOS LAS MULTAS CONCRETAS DE UN COCHE TENDREMOS QUE USAR UNA CONSULTA HQL PERSONALIZADA
            listaMultas = session.createQuery("from Multa where matricula = '" + matricula+"'").list();

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

    public String buscarMatricula(Multa multa, Session session) {
        Transaction transaction = null;
        String matricula = "";
        try {
            transaction = session.beginTransaction();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return "";
    }
}
