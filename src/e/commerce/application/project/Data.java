package e.commerce.application.project;

import java.util.ArrayList;

public class Data {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<CreditCard> creditCard = new ArrayList<CreditCard>();

    public void newUser(User user) {
        this.users.add(user);
    }

    public void newProduct(Product product) {
        this.products.add(product);
    }
    
    public User getUser(int index) {
        return users.get(index);
    }

    public int getUserSize() {
        int size = this.users.size();
        return size;
    }

    public int getProductSize() {
        int size = this.products.size();
        return size;
    }

    public Product getProduct(int index) {
        return this.products.get(index);
    }

    public void setCard(CreditCard card) {
        this.creditCard.add(card);
    }

    public int getCardSize() {
        return this.creditCard.size();
    }

}
