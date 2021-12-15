package com.forma.inventory.ui.controllers.pages.add_or_edit;

import com.forma.inventory.backend.entities.Product;
import com.forma.inventory.backend.services.ProductServiceImpl;
import com.forma.inventory.ui.controllers.pages.inventory.Inventory;
import com.forma.inventory.ui.utils.alerts.ConfirmationAlert;
import com.forma.inventory.ui.utils.alerts.InformationAlert;
import com.forma.inventory.ui.utils.alerts.WarningAlert;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


// TODO: finish the class and dont forget about confirmations

public class AddOrEdit {
    @FXML
    private Label labelTitle, labelSubtitle;
    @FXML
    private TextField textFieldProductName, textFieldStockInSalon, textFieldStockPerWeek;
    @FXML
    private Button buttonSaveOrUpdate, buttonCancelAndGoBack;

    private Stage addOrEditStage, inventoryStage;
    private String addOrEditPage = "";
    private Product product;
    private ProductServiceImpl productService;
    private Inventory inventory;

    private static final String DIGITS = "0123456789";
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public AddOrEdit() {}

    public AddOrEdit(String addOrEditPage){ this.addOrEditPage = addOrEditPage;}

    public void setProduct(Product product){ this.product = product;}

    public void setProductServiceImpl(ProductServiceImpl productService){ this.productService = productService;}

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public void setAddOrEditStage(Stage addOrEditStage) { this.addOrEditStage = addOrEditStage;}

    public void setInventoryStage(Stage inventoryStage) { this.inventoryStage = inventoryStage;}

    @FXML
    private void initialize(){

        textFieldProductName.setFocusTraversable(false);
        textFieldStockInSalon.setFocusTraversable(false);
        textFieldStockPerWeek.setFocusTraversable(false);
    }

    public void init(){

        addOrEditStage.setOnCloseRequest(windowEvent -> {
            ConfirmationAlert confirmationAlert = new ConfirmationAlert("Inchidere fereastra");
            confirmationAlert.closeWindow(windowEvent);
        });

        buttonCancelAndGoBack.setOnMouseClicked(mouseEvent -> {
            ConfirmationAlert confirmationAlert = new ConfirmationAlert("Inchidere fereastra");
            if(confirmationAlert.confirmAction()){
                try {
                    Thread.sleep(500);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                addOrEditStage.hide();
            };
        });

        buttonSaveOrUpdate.setOnMouseClicked(mouseEvent -> {
            switch(addOrEditPage){
                case "add":
                    addProduct();
                    break;
                case "edit":
                    updateProduct();
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        });
    }

    public void setPage(String addOrEditPage){

        this.addOrEditPage = addOrEditPage;

        switch(addOrEditPage){
            case "add":
                addPage();
                break;
            case "edit":
                editPage();
                break;
            default:
                System.out.println("default");
                break;
        }
    }

    private void addPage(){

        labelTitle.setText("Adauga un produs nou in inventar");
        buttonSaveOrUpdate.setText("Salveaza produsul");
    }

    private void editPage(){

        labelTitle.setText(String.format("Editeaza produsul\n%s",
                product.getName()));
        buttonSaveOrUpdate.setText("Salveaza modificarile");

        textFieldProductName.setText(product.getName());
        textFieldStockInSalon.setText(product.getStockInSalon().toString());
        textFieldStockPerWeek.setText(product.getStockPerWeek().toString());
    }

    private void addProduct(){

        // TODO: add checks for input fields
        // TODO: add confirmation: successful or unsuccessful action

        if (checkUserInputFromTextFieldIsCorrect(textFieldProductName.getText(),
                textFieldStockInSalon.getText(),
                textFieldStockPerWeek.getText())) {
            product = new Product();

            setProductData();

            productService.saveOrUpdate(product);

            InformationAlert informationAlert = new InformationAlert("Produsul a fost adaugat cu success");
            informationAlert.showInformation(addOrEditStage);
        }else{
            WarningAlert warningAlert = new WarningAlert("Campurile nu sunt introduse corect");
            warningAlert.showInformation();
        }


    }

    private void updateProduct(){

        // TODO: add confirmation: successful or unsuccessful action
        if(checkUserInputFromTextFieldIsCorrect(textFieldProductName.getText(),
                textFieldStockInSalon.getText(),
                textFieldStockPerWeek.getText())) {
            setProductData();

            productService.update(product);

            InformationAlert informationAlert = new InformationAlert("Produsul a fost modificat cu success");
            informationAlert.showInformation(addOrEditStage);
        }else{
            WarningAlert warningAlert = new WarningAlert("Campurile nu sunt introduse corect");
            warningAlert.showInformation();
        }
    }

    private void setProductData(){
        product.setName(textFieldProductName.getText());
        product.setStockInSalon(Integer.parseInt(textFieldStockInSalon.getText()));
        product.setStockPerWeek(Integer.parseInt(textFieldStockPerWeek.getText()));
    }

    private boolean checkUserInputFromTextFieldIsCorrect(String productName, String stockInSalon, String stockPerWeek){
        return checkIsNotStringNullOrEmpty(productName,
                stockInSalon,
                stockPerWeek) &&
                checkStringTextFieldHasCorrectInput(productName) &&
                checkNumericTextFieldHasCorrectInput(stockInSalon,
                        stockPerWeek) &&
                checkNumericTextFieldValueForStockPerWeekIsGreaterThan0(stockPerWeek);
    }

    private static boolean checkIsNotStringNullOrEmpty(String... strings){

        for (String st : strings) {
            if (st == null || st.equals("")) {
                System.out.println(st);
                return false;

            }
        }
        return true;
    }

    private static boolean checkNumericTextFieldHasCorrectInput(String... strings){

        for (String st : strings) {
            for(Character c: st.toCharArray()) {
                if (!DIGITS.contains(c.toString())) {
                    System.out.println(DIGITS+ " " + c);
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkNumericTextFieldValueForStockPerWeekIsGreaterThan0(String... strings){

        for (String string: strings){
            if(Integer.parseInt(string) <= 0){
                System.out.println(Integer.parseInt(string));
                return false;
            }
        }
        return true;
    }

    private static boolean checkStringTextFieldHasCorrectInput(String... strings){

        for (String st : strings) {
            for(Character c: st.toCharArray()) {
                if (!LETTERS.contains(c.toString()) && !LETTERS.toLowerCase().contains(c.toString())) {
                    System.out.println(LETTERS + ", " + c);
                    return false;
                }
            }
        }
        return true;
    }
}
