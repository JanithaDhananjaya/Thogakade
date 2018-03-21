/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ijse.gdse41.thogakadefx.tablemodel;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ramindu Nethmina
 */
public class CustomerTableModel {

    private SimpleStringProperty id = new SimpleStringProperty("");
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");
    private SimpleDoubleProperty salary = new SimpleDoubleProperty(0.0);

    public CustomerTableModel() {
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getAddress() {
        return address.get();
    }

    public Double getSalary() {
        return salary.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }
}
