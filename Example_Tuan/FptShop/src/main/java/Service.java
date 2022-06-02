import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Service {
    public Product insertProduct(){
        Scanner sc = new Scanner(System.in);
        String id = Util.generateId(5);
        System.out.print("- Nhập tên sản phẩm : ");
        String name = sc.nextLine();
        System.out.print("- Nhập mô tả sản phẩm : ");
        String description = sc.nextLine();
        System.out.println("Nhập danh mục cho sản phẩm : ");
        System.out.print("- Nhập số lượng danh mục cho danh mục : ");
        int n = Integer.parseInt(sc.nextLine());
        String a[] = new String[n];
        for (int i = 0 ; i < n ; i++){
            System.out.printf("\tNhập tên danh mục thứ %d : " , i+1);
            a[i] = sc.nextLine();
        }
        System.out.print("- Nhập số lượng sản phẩm : ");
        int count = sc.nextInt();
        System.out.print("- Nhập giá bán của sản phẩm : ");
        long price = sc.nextInt();

        Product p = new Product(id,name,description,a,count,price);
        return p;
    }

    public void searchByCategory(ArrayList<Product> list ,String search){
        int count = 0;
        for (int i = 0 ; i < list.size() ; i++){
            for (int j = 0 ; j < list.get(i).getCategory().length; j++){
                if (list.get(i).getCategory()[j].toLowerCase().contains(search.toLowerCase())){
                    System.out.println(list.get(i));
                    count++;
                }
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
}
