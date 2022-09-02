package HomeTask1_part1;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {
    private static SelenideElement findProductById(String productId) {
        return $(by("data-product-id", productId));
    }

    @BeforeEach
    void openHomePage() {
        open("https://www.technopolis.bg");
    }

    @Test
    void searchProductAndAddToCardTest() {

        var productName = "nintendo switch oled white 64gb";
        var productId = "546786";

        $("#cookiemessage .wrapper a").click();

        $("#search").val(productName).pressEnter();
        $(".highlight").shouldHave(text(productName));
        findProductById(productId).shouldHave(text(productName));
        findProductById(productId).$(".button-buy").click();

        $(".h2").shouldHave(text("Преглед на количката"));
        $$(".container-checkout .checkout-box").shouldHave(size(1));
        $(".checkout-product__title").shouldHave(text(productName));

    }

    @Test
    void searchProductByTitleTest(){
        var productName = "nintendo switch oled white 64gb";
        new HomePage().searchFor(productName);
        var actualResultTitle = new SearchResultPage().searchResultTitle();
        Assertions.assertEquals(productName,actualResultTitle);
    }
}
