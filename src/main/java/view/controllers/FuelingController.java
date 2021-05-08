package view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.util.converter.IntegerStringConverter;
import model.Fuel;
import model.Fuels;

import java.net.URL;
import java.util.ResourceBundle;

import static view.util.AlertsUtil.showErrorMessage;
import static view.util.AlertsUtil.showInfoMessage;

public class FuelingController extends BaseController implements Initializable {

    private ToggleGroup group;

    @FXML
    private TextField litersField;

    @FXML
    private RadioButton normalButton;

    @FXML
    private RadioButton superButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        group = new ToggleGroup();

        normalButton.setToggleGroup(group);
        normalButton.setUserData(Fuels.COMUN);

        superButton.setToggleGroup(group);
        superButton.setUserData(Fuels.SUPER);

        litersField.setTextFormatter(
                new TextFormatter<>(
                        new IntegerStringConverter()
                )
        );

    }

    @FXML
    void calculate() {
        try {
            double finalCost = fuelStation.getFinalCost(
                    (Fuel) group.getSelectedToggle().getUserData(),
                    (Integer) litersField.getTextFormatter().getValue()
            );
            showInfoMessage("Costo final", "El costo final es de " + finalCost);
        } catch (Exception e) {
            showErrorMessage("Error", e.getMessage());
        }
    }

    @FXML
    void pay() {
        try {
            fuelStation.pay(
                    (Fuel) group.getSelectedToggle().getUserData(),
                    (Integer) litersField.getTextFormatter().getValue()
            );
            showInfoMessage("Éxito", "El pago fue procesado con éxito");
        } catch (Exception e) {
            showErrorMessage("Error", e.getMessage());
        }
    }

}
