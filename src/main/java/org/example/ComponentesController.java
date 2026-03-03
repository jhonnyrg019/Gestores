package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ComponentesController {

    @FXML
    private StackPane contenedorPrincipal;

    @FXML
    public void initialize() {
        System.out.println("Ventana Componentes cargada");
    }

    public void cambiarLayout(String tipo) {

        if (contenedorPrincipal == null) return;

        Pane nuevoLayout;

        switch (tipo) {

            case "HBox":
                nuevoLayout = new HBox(10);
                break;

            case "FlowPane":
                nuevoLayout = new FlowPane(10, 10);
                break;

            case "GridPane":
                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);

                grid.add(new Label("Ejemplo"), 0, 0);
                grid.add(new TextField("Texto"), 1, 0);
                grid.add(new Button("Botón"), 0, 1);
                grid.add(new CheckBox("Opción"), 1, 1);

                contenedorPrincipal.getChildren().setAll(grid);
                return;

            default:
                nuevoLayout = new VBox(10);
        }

        nuevoLayout.getChildren().addAll(
                new Label("Ejemplo"),
                new TextField("Texto"),
                new Button("Botón"),
                new CheckBox("Opción")
        );

        contenedorPrincipal.getChildren().setAll(nuevoLayout);
    }
}