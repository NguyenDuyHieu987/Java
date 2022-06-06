import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Data data = new Data();
        ArrayList<Product> list = data.getData();

        Service s = new Service();

        boolean isCheck = false;
        while (!isCheck){
            menu();
            System.out.print("Nhập lựa chọn của bạn : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Nhập thông tin sản phẩm : ");
                    list.add(s.insertProduct());
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm : ");
                    printlist(list);
                    break;
                case 3:
                    System.out.print("Nhập danh mục muốn tìm kiếm : ");
                    String search = sc.nextLine();

                    s.searchByCategory(list,search);

                    break;
                default:
                    isCheck = true;
                    System.out.println("\n--Kết thúc chương trình !--");
                    System.exit(1);
            }
        }
    }

    public static void printlist(ArrayList<Product> list){
        for (Product product : list){
            System.out.println(product);
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("--MENU--");
        System.out.println("1 - Thêm 1 sản phẩm");
        System.out.println("2 - Danh sách sản phẩm");
        System.out.println("3 - Tìm kiếm sản phẩm");
        System.out.println("Nhập bất kì để thoát chương trình");
    }
}
