package com.forma.inventory.ui.utils.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class WarningAlert {
        private final String contextText;
        private final String headerText;
        private final Alert alert;

        public WarningAlert(String contextText){
            alert = new Alert(Alert.AlertType.WARNING);
            this.contextText = contextText;
            this.headerText = "Avertizare";
            initAlert();
        }

        public Alert getAlert() {
            return alert;
        }

        private void initAlert(){

            alert.setContentText(contextText);
            alert.setHeaderText(headerText);

//        alertCloseApplication.initOwner(stage);

//        alert.initStyle(StageStyle.TRANSPARENT);

//        DialogPane dialogPane = alert.getDialogPane();
//        dialogPane.getStylesheets().add("com/forma/inventory/ui/controllers/utils/alerts/Confirmation.css");
//        dialogPane.getStyleClass().add("body");
//        dialogPane.getScene().setFill(Color.TRANSPARENT);
        }

        public void showInformation(){
            Optional<ButtonType> optionalButtonType = alert.showAndWait();
            ButtonType buttonType = optionalButtonType.orElse(ButtonType.OK);
            if(buttonType.equals(ButtonType.OK)){
                try {
                    Thread.sleep(500);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        }
    }
