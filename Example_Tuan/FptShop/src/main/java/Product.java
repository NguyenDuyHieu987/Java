import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Product {
    private String id;
    private String name;
    private String description;
    private String[] category;
    private int count;
    private long price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + Arrays.toString(category) +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}


