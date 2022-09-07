import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Brand {
    private int brandID;
    private String brandName;
    private static Set<Brand> brandList = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getBrandName().compareTo(o2.getBrandName());
        }
    });

    public Brand(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

    static {
        createBrands();
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public static void createBrands() {
        brandList.add(new Brand(1, "Samsung"));
        brandList.add(new Brand(2, "Lenovo"));
        brandList.add(new Brand(3, "Apple"));
        brandList.add(new Brand(4, "Huawei"));
        brandList.add(new Brand(5, "Casper"));
        brandList.add(new Brand(6, "Asus"));
        brandList.add(new Brand(7, "HP"));
        brandList.add(new Brand(8, "Xiaomi"));
        brandList.add(new Brand(9, "Monster"));
    }

    public static void printBrands() {
        System.out.println("--------------------- Brand List ---------------------");
        for (Brand brand : brandList) {
            System.out.println(brand.getBrandID() + " " + brand.getBrandName());
        }
        System.out.println("------------------------------------------------------");
    }

    public static Brand getBrand(int brandID) {
        for (Brand brand : brandList) {
            if (brandID == brand.getBrandID()) {
                return brand;
            }
        }
        return null;
    }

}
