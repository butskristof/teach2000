package teach2000.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import teach2000.view.mainMenu.MainMenuView;

/**
 * @author demacryx on 11.03.2018 3:58 PM.
 * @project teach20002
 */
public class DataSource {
    private String name;
    private double price;
    private int quantity;

    public DataSource(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
