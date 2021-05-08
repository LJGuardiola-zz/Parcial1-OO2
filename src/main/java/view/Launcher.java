package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.FuelStation;
import model.ReceiptsRepository;
import view.controllers.HomeController;

public abstract class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource( "/view/home.fxml" )
        );

        stage.setTitle("YPZW");
        stage.setScene(
                new Scene(loader.load())
        );

        HomeController controller = loader.getController();
        controller.setFuelStation(
                new FuelStation(getRepository())
        );

        stage.show();

    }

    public abstract ReceiptsRepository getRepository();

}
