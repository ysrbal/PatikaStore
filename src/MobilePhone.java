import java.util.ArrayList;

public class MobilePhone extends Product {
    private static int mobilePhoneID = 1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> mobilePhones = new ArrayList<>();

    public MobilePhone() {

    }

    public MobilePhone(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory, int battery, String color, int camResolution) {
        super(mobilePhoneID, name, price, discountRate, amount, brand, screenSize, ram, memory);
        mobilePhoneID++;
        this.battery = battery;
        this.camResolution = camResolution;
        this.color = color;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }

    public static int getMobilePhoneID() {
        return mobilePhoneID;
    }

    @Override
    public void menu() {
        System.out.println("""
                1 - Add New Mobile Phone
                2 - View Mobile Phone List
                3 - Remover Mobile Phone
                4 - Sort Mobile Phones by ID Numbers
                5 - Filter Mobile Phones by Brand \s""");
        System.out.print("Please choose one : ");
        int choose = scan.nextInt();
        if (choose == 1) {
            addItem();
        } else if (choose == 2 || choose == 4) {
            getProduct();
        } else if (choose == 3) {
            removeItem();
        } else if (choose == 5) {
            brandFilter();
        }
    }

    @Override
    public void addItem() {
        System.out.print("Price of the Product : ");
        double price = scan.nextDouble();
        System.out.print("Name of the Product : ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print("Product Discount Rate : ");
        int discountRate = scan.nextInt();
        System.out.print("Product Stock : ");
        int productStock = scan.nextInt();
        System.out.print("RAM of the Product : ");
        int ram = scan.nextInt();
        System.out.print("Screen of the Product : ");
        double screenSize = scan.nextDouble();
        System.out.print("Memory of the Product :");
        int memory = scan.nextInt();
        System.out.print("Battery of the Product : ");
        int battery = scan.nextInt();
        scan.nextLine();
        System.out.print("Color of the Product : ");
        String color = scan.nextLine();
        System.out.print("Camera Resolution : ");
        int camResolution = scan.nextInt();
        Brand.printBrands();
        System.out.print("Please choose Brand : ");
        Brand brand = Brand.getBrand(scan.nextInt());
        MobilePhone mobilePhone = new MobilePhone(name, price, discountRate, productStock, brand, screenSize, ram, memory, battery, color, camResolution);
        this.mobilePhones.add(mobilePhone);
        System.out.println("The ID of the added Mobile Phone :" + mobilePhone.getProductID());
    }

    @Override
    public void removeItem() {
        getProduct();
        System.out.print("Silinmesini istediğiniz telefonun Id numarasını giriniz : ");
        int id = scan.nextInt();
        mobilePhones.remove(id - 1);
        System.out.println("Güncel telefon listesi ");
        getProduct();
    }

    @Override
    public void getProduct() {
        print(null);
    }

    public void print(ArrayList<MobilePhone> mobilePhoneList) {
        if (mobilePhoneList == null) mobilePhoneList = this.mobilePhones;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                 | Price          | Brand         | Stock        | Discount Rate      | RAM    | Screen Size      | Memory   | Battery  | Color           | Camera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone mobilePhone : mobilePhoneList) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    mobilePhone.getProductID(), mobilePhone.getProductName(), mobilePhone.getPrice(), mobilePhone.getBrand().getBrandName(), mobilePhone.getAmount(),
                    mobilePhone.getDiscountRate(), mobilePhone.getRam(), mobilePhone.getScreenSize(), mobilePhone.getMemory(), mobilePhone.getBattery(), mobilePhone.getColor(), mobilePhone.getCamResolution());
        }
    }

    public void brandFilter() {
        scan.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = scan.nextLine();
        ArrayList<MobilePhone> filterPhones = new ArrayList<>();
        for (MobilePhone mobilePhone : mobilePhones) {
            if (filter.equals(mobilePhone.getBrand().getBrandName())) {
                filterPhones.add(mobilePhone);
            }
        }
        print(filterPhones);
    }
}
