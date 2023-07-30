package e.commerce.application.project;

public class Order {

    private User receiver;
    private Product product;
    private CreditCard creditCard;
    private String address;

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.equals("Home Address")) {
            this.address = receiver.getHomeAddress();
        } else if (address.equals("Work Address")) {
            this.address = receiver.getWorkAddress();
        }
    }

    public void increaseStock(int number) {
        this.product.increaseStock(number);
    }

    public void decreaseStock(int number) {
        this.product.decreaseStock(number);
    }

}
