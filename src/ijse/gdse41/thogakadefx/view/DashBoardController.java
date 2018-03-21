/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.gdse41.thogakadefx.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ramindu Nethmina
 */
public class DashBoardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnmanagecustomer;
    @FXML
    Button btnmanageitem;
    @FXML
    Button btnplaceorder;

    @FXML
    public void clickManageCustomer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageCustomer.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Manage Customer");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void clickManageItem(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Manage Item");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void clickPlaceOrder(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManagePlaceOrder.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Place Order");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
