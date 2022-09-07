import java.util.ArrayList;

public class NoteBook extends Product {
    private static int noteBookID = 1;
    private static ArrayList<NoteBook> noteBooks = new ArrayList<>();

    public NoteBook(String name, double price, int discountRate, int amount, Brand brand, double screenSize, int ram, int memory) {
        super(noteBookID, name, price, discountRate, amount, brand, screenSize, ram, memory);
        noteBookID++;
    }

    public NoteBook() {

    }


    @Override
    public void menu() {
        System.out.println("""
                1 - Add New Notebook
                2 - View Notebook List
                3 - Remover Notebook
                4 - Sort Notebooks by ID Numbers
                5 - Filter Notebooks by Brand \s""");
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

    public static int getNoteBookID() {
        return getNoteBookID();
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
        Brand.printBrands();
        System.out.print("Please choose Brand : ");
        Brand brand = Brand.getBrand(scan.nextInt());
        NoteBook notebook = new NoteBook(name, price, discountRate, productStock, brand, screenSize, ram, memory);
        this.noteBooks.add(notebook);
        System.out.println("The ID of the added Notebook :" + notebook.getProductID());
    }

    @Override
    public void removeItem() {
        getProduct();
        System.out.print("Please enter the Id number of the notebook you want to remove : ");
        int id = scan.nextInt();
        noteBooks.remove(id - 1);
        System.out.println("Current notebook list ");
        getProduct();
    }

    @Override
    public void getProduct() {
        print(null);
    }

    private void brandFilter() {
        scan.nextLine();
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        String filter = scan.nextLine();
        ArrayList<NoteBook> filterNotebooks = new ArrayList<>();
        for (NoteBook noteBook : noteBooks) {
            if (filter.equals(noteBook.getBrand().getBrandName())) {
                filterNotebooks.add(noteBook);
            }
        }
        print(filterNotebooks);
    }

    public void print(ArrayList<NoteBook> notebookList) {
        if (notebookList == null) notebookList = this.noteBooks;
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                  | Price          | Brand         | Stock        | Discount Rate      | RAM    | Screen Size      | Memory   |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (NoteBook noteBook : notebookList) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    noteBook.getProductID(), noteBook.getProductName(), noteBook.getPrice(), noteBook.getBrand().getBrandName(), noteBook.getAmount(),
                    noteBook.getDiscountRate(), noteBook.getRam(), noteBook.getScreenSize(), noteBook.getMemory());
        }
    }

}

