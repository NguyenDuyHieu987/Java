import java.util.ArrayList;

public class Data {
    public ArrayList<Product> getData(){
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(Util.generateId(5),"iphone 6","white",new String[]{"điện thoại","apple"},100,1700));
        list.add(new Product(Util.generateId(5),"xiaomi k20 pro","black",new String[]{"điện thoại"},100,6000));
        list.add(new Product(Util.generateId(5),"auas tuf gaming f17","black",new String[]{"laptop"},100,19000));
        list.add(new Product(Util.generateId(5),"sạc dự phòng","20000mah",new String[]{"phụ kiện"},100,500));
        list.add(new Product(Util.generateId(5),"iphone 11","xanh ngọc",new String[]{"điện thoại"},100,12000));

        return list;
    }
}
