package view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.util.AlertsUtil;

import java.io.IOException;

public class HomeController extends BaseController {

    @FXML
    public void showFueling() {
        show("Carga de combustible", "/view/fueling.fxml");
    }

    @FXML
    public void showList() {
        show("Listado de ventas", "/view/sales.fxml");
    }

    private void show(String title, String view) {
        try {

            Stage stage = new Stage();

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(view)
            );

            stage.setTitle(title);
            stage.setScene(
                    new Scene(loader.load())
            );

            BaseController controller = loader.getController();
            controller.setFuelStation(fuelStation);

            stage.show();

        } catch (IOException e) {
            AlertsUtil.showErrorMessage("Error", "No se pudo cargar la vista");
        }
    }

}
