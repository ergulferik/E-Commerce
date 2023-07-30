package e.commerce.application.project;

import java.util.ArrayList;

public class User {

    private String username;
    private String name;
    private String surname;
    private String birthday;
    private String password;
    private String email;
    private String homeAddress;
    private String workAddress;
    private boolean isOnline;
    private ArrayList<Product> orderedProducts = new ArrayList<Product>();
    private ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
    private ArrayList<Product> favoriteProducts = new ArrayList<Product>();

    public User(String username, String name, String surname, String birthday, String password, String email, String homeAddress, String workAddress, Data data) {

        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.password = password;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.email = email;
        this.isOnline = false;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthDay) {
        this.birthday = birthDay;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeAddress(String homeAdress) {
        this.homeAddress = homeAddress;
    }

    public void setWorkAddress(String workdAddress) {
        this.workAddress = workAddress;
    }

    public void setOrderedProducts(Product orderedProducts) {
        this.orderedProducts.add(orderedProducts);
    }

    public CreditCard getCard(int index) {
        return this.cards.get(index);
    }

    public void setCards(String cardNumber, User user, int securityCode, String expirationDate, int password, String cardName, Data data) {
        boolean flag = false;
        if (data.getCardSize() != 0) {
            for (int i = 0; i < data.getUserSize(); i++) {
                for (int j = 0; j < data.getUser(i).cards.size(); j++) {
                    if (data.getUser(i).getCard(j).getCardNumber().equals(cardNumber)) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (this.isOnline && !flag) {
            CreditCard card = new CreditCard(cardNumber, user, securityCode, expirationDate, password, cardName, data);
            this.cards.add(card);
            data.setCard(card);
            System.out.println("Your card numbered " + cardNumber + " has been registered in the system with the name of , " + cardName);
        } else if (this.isOnline && flag) {
            System.out.println("Your " + cardNumber + " card is already registered in the system");
        } else if (!this.isOnline && !flag) {
            System.out.println("Please login to the system first");
        } else {
            System.out.println("Please login to the system first");
        }
    }

    public void login(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            this.isOnline = true;
            System.out.println("Logged into the system");
        } else {
            System.out.println("Please try again ");
        }
    }

    public void order(String productName, String cardName, String Address, int number, Data data) {
        if (isOnline) {
            Order order = new Order();
            order.setReceiver(this);
            order.setProduct(findProduct(productName, data));
            order.setCreditCard(this.findCard(cardName));
            this.setOrderedProducts(findProduct(productName, data));
            order.setAddress(Address);
            order.decreaseStock(number);
            if (Address.equals("Home Address")) {
                System.out.println("Your order of " + number + " " + findProduct(productName, data).getName() + " will be delivered via " + this.findCard(cardName).getCardName() + "to " + this.getHomeAddress());
            } else if (Address.equals("Work Address")) {
                System.out.println("Your order of " + number + " " + findProduct(productName, data).getName() + " will be delivered via " + this.findCard(cardName).getCardName() + "to " + this.getWorkAddress());
            }
        }
    }

    public void order(String productName, String cardName, String Address, Data data) {
        order(productName, cardName, Address, 1, data);
    }

    public void showAllOrderedProducts() {
        if (isOnline) {
            for (int i = 0; i < this.orderedProducts.size(); i++) {
                System.out.println(this.orderedProducts.get(i).getName());
            }
        }
    }

    private CreditCard findCard(String cardName) {
        int flag = 0;
        for (int i = 0; i < this.cards.size(); i++) {
            if (this.cards.get(i).getCardName().equals(cardName)) {
                flag = i;
                return this.cards.get(i);
            }
        }
        return this.cards.get(flag);
    }

    private Product findProduct(String productName, Data data) {
        int flag = 0;
        for (int i = 0; i < data.getProductSize(); i++) {
            if (productName.equals(data.getProduct(i).getName())) {
                flag = i;
                return data.getProduct(i);
            }
        }
        return data.getProduct(flag);
    }

    public void showAllProducts(Data data) {
        if (this.isOnline) {
            for (int i = 0; i < data.getProductSize(); i++) {
                System.out.println(data.getProduct(i).getName() + " (" + data.getProduct(i).getStock() + ")");
            }
        }
    }

    public void addFavoriteProduct(String productName, Data data) {
        this.favoriteProducts.add(findProduct(productName, data));
    }

    public void deleteFavoriteProduct(String productName, Data data) {
        this.favoriteProducts.remove(findProduct(productName, data));
    }

    public void showAllFavoriteProducts() {
        for (int i = 0; i < this.favoriteProducts.size(); i++) {
            System.out.println(this.favoriteProducts.get(i).getName());
        }
    }

    public void getProductStock(String productName, Data data) {
        System.out.println(findProduct(productName, data).getStock());
    }
}
