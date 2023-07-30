package e.commerce.application.project;

public class Product {

    private String name;
    private String color;
    private String catogery;
    private String weight;
    private String description;
    private int stock;

    public Product(String name, String color, String catogery, int stock, String weight, String description) {
        this.name = name;
        this.color = color;
        this.catogery = catogery;
        this.stock = stock;
        this.weight = weight;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void increaseStock(int number) {
        this.stock += number;
    }

    public void decreaseStock(int number) {
        this.stock -= number;
    }

}
