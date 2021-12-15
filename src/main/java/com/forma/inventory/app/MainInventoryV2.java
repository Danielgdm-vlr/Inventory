package com.forma.inventory.app;

import com.forma.inventory.backend.services.ProductServiceImpl;
import com.forma.inventory.ui.controllers.pages.inventory.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainInventoryV2 extends Application {

    private FXMLLoader fxmlLoader;
    private ProductServiceImpl productService;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage inventoryStage) {

        //init application objects
        try{
            fxmlLoader = new FXMLLoader();
            productService = new ProductServiceImpl();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        try {
            fxmlLoader.setLocation(Inventory.class.getResource("Inventory.fxml"));
            Parent window = fxmlLoader.load();

            Inventory inventory = fxmlLoader.getController();
            inventory.setProductService(productService);
            inventory.setInventoryStage(inventoryStage);
            inventory.setFxmlLoader(fxmlLoader);
            inventory.init();

            Scene inventoryScene = new Scene(window);
            inventoryScene.getStylesheets().add(
                    String.valueOf(Inventory.class.getResource("Inventory.css")));
            inventoryStage.setScene(inventoryScene);
            inventoryStage.getIcons().add(new Image("/com/forma/inventory/ui/images/inventoryLogo.png"));

            inventoryStage.setWidth(1280.0);
            inventoryStage.setHeight(720.0);
            inventoryScene.getWindow().centerOnScreen();
            inventoryStage.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
