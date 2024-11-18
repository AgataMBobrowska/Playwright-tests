package automationpractice;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class tablePrintedDresses {
    private String name;

    private int price;

    public tablePrintedDresses (String name, int price) {
        this.name = name;
        this.price = price;
    }
}
