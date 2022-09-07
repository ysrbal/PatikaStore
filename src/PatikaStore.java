import java.util.Scanner;

public class PatikaStore {

    public void entry() {
        Scanner scan = new Scanner(System.in);


        boolean isExit = true;
        while (isExit) {
            System.out.println("PatikaStore Product Management Panel !!");
            System.out.println("Please select one");
            System.out.println("""
                    1 - Notebook
                    2 - Mobile Phone
                    3 - Brand List
                    0 - Exit""");
            System.out.print("Your choose : ");
            int selected = scan.nextInt();
            switch (selected) {
                case 1:
                    NoteBook noteBook = new NoteBook();
                    noteBook.menu();
                    break;
                case 2:
                    MobilePhone mobilePhone = new MobilePhone();
                    mobilePhone.menu();
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 0:
                    System.out.println("Checking Out !!");
                    System.out.println(0);
                    isExit = true;
                    break;

                default:
                    isExit = true;


            }
        }
    }
}
