package org.example.crud_hibernate_relaciones_1_n.util;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Comprobaciones {
    public static boolean textosVacios(ComboBox<?> combobox, TextField... textFields) {
        for (TextField textFieldActual : textFields) {
            if (textFieldActual.getText().trim().isEmpty()) {
                return false;
            }
        }
        if (combobox.getSelectionModel().getSelectedItem() == null) {
            return false;
        }
        return true;
    }
    public static boolean stringosNoVacios(String... strings) {
        for (String stringActual : strings) {
            if (stringActual == null || stringActual.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
