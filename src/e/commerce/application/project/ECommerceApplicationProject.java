package e.commerce.application.project;


public class ECommerceApplicationProject {
 
    public static void main(String[] args) {
        Data data = new Data();

        newUser("ErgFer", "Ergül", "Ferik", "21/04/2001", "password123", "ergulferik@gmail.com", "300 CENTRAL PARK W #7K (From 7K To 7L ), NEW YORK, NY 10024-7603, USA", "312  11TH NEW YORK NY 10001-1250 USA", data);
        newProduct("Micro Rubber", "Blue", "Rubber", 50, "25gr", "This is a rubber, for delet", data);
        newProduct("Faber Castel Pencil", "Transparent", "Pencil", 25, "20gr", "This is a pencil, for write ", data);
        newProduct("Can Ruler", "Red", "Ruller", 100, "10gr", "This is a ruler, for measure", data);
        data.getUser(0).login("ErgFer", "password123");
        data.getUser(0).setCards("321312321", data.getUser(0), 753, "20/01",5522 ,"MySister'sCard", data);
        data.getUser(0).setCards("123123123", data.getUser(0), 951, "12/09",4455 ,"MyCard", data);
        newUser("Ahmcn", "Ahmet Can", "Günaydın", "08/01/2000", "321password", "ahmcngnyd@hotmail.com", "3  HERALD NEW YORK NY 10001-3095 USA", "105 W 29TH NEW YORK NY 10001-5742 USA", data);
        data.getUser(1).login("Ahmcn", "321password");
        data.getUser(1).setCards("16160000525245458585", data.getUser(1), 741, "01/01",6565 ,"Ahmet's card", data);
        data.getUser(0).showAllProducts(data);
        data.getUser(0).order("Micro Rubber", "MyCard", "Home Address", 2, data);
        data.getUser(1).showAllProducts(data);
        data.getUser(1).order("Can Ruler", "Ahmet's card", "Work Address", data);
        data.getUser(0).showAllOrderedProducts();
        data.getUser(0).addFavoriteProduct("Faber Castel Pencil", data);
        data.getUser(0).showAllFavoriteProducts();
        data.getUser(0).deleteFavoriteProduct("Faber Castel Pencil", data);
        data.getUser(0).showAllFavoriteProducts();
        data.getUser(0).getProductStock("Micro Rubber", data);
        addNewStock("Micro Rubber", data, 50);
        data.getUser(0).getProductStock("Micro Rubber", data);

    }

    private static void newProduct(String name, String color, String catogery, int stock, String weight, String description, Data data) {
        Product product = new Product(name, color, catogery, stock, weight, description);
        data.newProduct(product);
    }

    private static void newUser(String userName, String name, String surname, String birthday, String password, String email, String homeAddress, String workAddress, Data data) {
        if (emailControl(email, data)) {
            User user = new User(userName, name, surname, birthday, password, email, homeAddress, workAddress, data);
            data.newUser(user);
        } else {
            System.out.println("Please try again with another e-mail acount");
        }
    }

    private static boolean emailControl(String email, Data data) {
        for (int i = 0; i < data.getUserSize(); i++) {
            if (data.getUser(i).getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    private static void addNewStock(String productName, Data data, int number) {
        for (int i = 0; i < data.getProductSize(); i++) {
            if (data.getProduct(i).getName().equals(productName)) {
                data.getProduct(i).increaseStock(number);
                break;
            }
        }
    }
}
