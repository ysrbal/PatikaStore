import java.util.HashSet;
import java.util.Scanner;

public abstract class Product {
    static HashSet<Brand> brands = new HashSet<>();
    protected Scanner scan = new Scanner(System.in);
    private int productID;
    private String productName;
    private double price;
    private int discountRate;
    private int amount;
    private Brand brand;
    private double screenSize;
    private int ram;
    private int memory;

    public abstract void menu();

    public abstract void addItem();

    public abstract void removeItem();

    public abstract void getProduct();

    public Product(int productID, String productName, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.discountRate = discountRate;
        this.amount = amount;
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.memory = memory;
    }

    public Product() {

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
