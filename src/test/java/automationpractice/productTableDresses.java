package automationpractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class productTableDresses extends BaseTest {

    @Test
    void should_verify_all_prices_are_above_15_dollars() {
      List<tablePrintedDresses> products = getProducts();

      System.out.println(products);

      List<Integer> prices = new ArrayList<>();
      products.forEach(p -> prices.add(p.getPrice()));
        Assertions.assertTrue(prices.stream().allMatch(p -> p>15));

    }

    @Test
    void should_verify_all_products_names_contain_word_Printed() {
        List<tablePrintedDresses> products = getProducts();

        List<String> names = new ArrayList<>();
        products.forEach(p -> names.add(p.getName()));

        System.out.println(names);
        Assertions.assertTrue(names.stream().allMatch(n-> n.contains("Printed")));


    }
    private List<tablePrintedDresses> getProducts() {
        page.navigate("http://www.automationpractice.pl/index.php");
        Locator topMenu = page.locator("#block_top_menu");
        topMenu.locator(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DRESSES"))).click();

        List<Locator> productLocators = page.locator(".product_list .ajax_block_product").all();

        List<tablePrintedDresses> products = new ArrayList<>();

        productLocators.forEach(p -> {
            Integer price = Integer.valueOf(p.locator(".right-block .content_price .price").innerText().replace("$", ""));
            String name = p.locator(".right-block .product-name").innerText();
            products.add(new tablePrintedDresses(name, price));
        });

        return products;
    }
}


