package HomeTask1_part1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    private static SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }

    public String searchResultTitle() {
        return $(".highlight").getText();
    }

    public SelenideElement getProductCard(String productId){
        return findProductById(productId);
    }
    public SelenideElement buyProductBtn(String productId){
        return findProductById(productId).$(".button-buy");
    }
}
