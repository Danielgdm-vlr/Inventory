package com.forma.inventory.ui.utils.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class ConfirmationAlert{
    private final String contextText;
    private final String headerText;
    private final Alert alert;

    public ConfirmationAlert(String contextText){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        this.contextText = contextText;
        this.headerText = "Confirmare";
        initAlert();
    }

    public Alert getAlert() {
        return alert;
    }

    private void initAlert(){

        alert.setContentText(contextText);
        alert.setHeaderText(headerText);

//        alertCloseApplication.initOwner(stage);

        alert.initStyle(StageStyle.TRANSPARENT);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("com/forma/inventory/ui/controllers/utils/alerts/Confirmation.css");
        dialogPane.getStyleClass().add("body");
        dialogPane.getScene().setFill(Color.TRANSPARENT);
    }

    public void closeWindow(WindowEvent windowEvent){

//        alert.showAndWait().filter(buttonResponse -> buttonResponse != ButtonType.OK)
//                .ifPresent(buttonResponse->windowEvent.consume());

        Optional<ButtonType> alertButtonClicked = alert.showAndWait();
        ButtonType buttonClicked = alertButtonClicked.orElse(ButtonType.OK);

        if(buttonClicked != ButtonType.OK){
            windowEvent.consume();
        }
        else {
            try {
                Thread.sleep(500);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public boolean confirmAction(){

        Optional<ButtonType> alertButtonClicked = alert.showAndWait();
        ButtonType buttonClicked = alertButtonClicked.orElse(ButtonType.OK);

        return buttonClicked == ButtonType.OK;
    }
}
