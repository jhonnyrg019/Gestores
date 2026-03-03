package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {

    @FXML
    private ComboBox<String> comboLayouts;

    private ComponentesController componentesController;

    @FXML
    public void initialize() {

        comboLayouts.getItems().addAll(
                "VBox",
                "HBox",
                "FlowPane",
                "GridPane"
        );

        comboLayouts.setValue("VBox"); // valor por defecto
    }

    @FXML
    public void abrirVentana(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/componentes.fxml")
        );

        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Componentes");
        stage.show();

        componentesController = loader.getController();

        // Aplicar layout automáticamente
        componentesController.cambiarLayout(comboLayouts.getValue());
    }

    @FXML
    public void cambiarLayout() {

        if (componentesController != null) {
            componentesController.cambiarLayout(
                    comboLayouts.getValue()
            );
        }
    }
}