/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.gdse41.thogakadefx.view;

import ijse.gdse41.thogakadefx.controller.CustomerController;
import ijse.gdse41.thogakadefx.model.Customer;
import ijse.gdse41.thogakadefx.tablemodel.CustomerTableModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ramindu Nethmina
 */
public class ManageCustomerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableColumn tblid;
    @FXML
    TableColumn tblname;
    @FXML
    TableColumn tbladdress;
    @FXML
    TableColumn tblsalary;
    @FXML
    TableView tblCustomer;
    @FXML
    Button btnAddCus;
    @FXML
    Button btnDelCus;
    @FXML
    Button btnUpCus;
    @FXML
    Button btnSeaCus;
    @FXML
    TextField txtId;
    @FXML
    TextField txtName;
    @FXML
    TextField txtAddress;
    @FXML
    TextField txtSalary;
    
    /*@FXML
    public void addCustomer(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            double salary = Double.parseDouble(txtSalary.getText());
            Customer c = new Customer(id, name, address, salary);
            int i = CustomerController.addCustomer(c);
            if (i > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added sucessfully!!");
                alert.showAndWait();
                refresh();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   /* @FXML
    public void deleteCustomer(ActionEvent actionEvent) {
        try {
            String code = txtId.getText();
            int deleteCustomer = CustomerController.deleteCustomer(code);
            if (deleteCustomer > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added sucessfully!!");
                alert.showAndWait();
                refresh();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void updateCustomer(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            double salary = Double.parseDouble(txtSalary.getText());
            Customer c = new Customer(id, name, address, salary);
            int i = CustomerController.updateCustomer(c);
            if (i > 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an infomation dialog");
                alert.setContentText("Customer has being added sucessfully!!");
                alert.showAndWait();
                refresh();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Customer Add");
                alert.setHeaderText("This is an error dialog");
                alert.setContentText("OOPs there is an error adding customer");
                alert.showAndWait();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    @FXML
    public void searchCustomer(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            Customer searchCustomer = CustomerController.searchCustomer(id);
            if (searchCustomer != null) {
                txtId.setText(searchCustomer.getId());
                txtName.setText(searchCustomer.getName());
                txtAddress.setText(searchCustomer.getAddress());
                txtSalary.setText(searchCustomer.getSalary()+"");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private final ObservableList<CustomerTableModel> data
            = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tblid.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("id"));
            tblname.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("name"));
            tbladdress.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("address"));
            tblsalary.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Double>("salary"));
            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers = CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setId(customer.getId());
                ctm.setName(customer.getName());
                ctm.setAddress(customer.getAddress());
                ctm.setSalary(customer.getSalary());
                data.add(ctm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void refresh() {
        try {
            tblid.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("id"));
            tblname.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("name"));
            tbladdress.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, String>("address"));
            tblsalary.setCellValueFactory(new PropertyValueFactory<CustomerTableModel, Double>("salary"));
            tblCustomer.setItems(data);
            ArrayList<Customer> customers = null;
            customers = CustomerController.getAllCustomer();
            for (Customer customer : customers) {
                CustomerTableModel ctm = new CustomerTableModel();
                ctm.setId(customer.getId());
                ctm.setName(customer.getName());
                ctm.setAddress(customer.getAddress());
                ctm.setSalary(customer.getSalary());
                data.add(ctm);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
