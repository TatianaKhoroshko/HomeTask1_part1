package HomeTask1_part1;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends BaseTest {

    @BeforeEach
    void openHomePage() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void searchProductAndAddToCardTest() {

        var productName = "nintendo switch oled white 64gb";
        var productId = "546786";
        SearchResultPage searchPageResult = new SearchResultPage();
        Faker faker = new Faker();
        var email = faker.internet().emailAddress();
        var firstName = faker.name().firstName();
        var lastName = faker.name().lastName();
        var address = faker.address().streetAddress();
        var city = faker.address().cityName();
        var postal = "1202";
        var phone = faker.phoneNumber().cellPhone();


        $("#cookiemessage .wrapper a").click();

        new HomePage().searchFor(productName);

        var actualSearchResultTitle = searchPageResult.searchResultTitle();
        Assertions.assertEquals(productName,actualSearchResultTitle);

        searchPageResult.getProductCard(productId).shouldHave(text(productName));
        searchPageResult.buyProductBtn(productId).click();

        $(".h2").shouldHave(text("Преглед на количката"));
        $$(".container-checkout .checkout-box").shouldHave(size(1));
        $(".checkout-product__title").shouldHave(text(productName));

        OrderPage fillOrder = new OrderPage();
        fillOrder.clickOnProceedOrderBtn();
        fillOrder.fillInGuestEmail(email);
        //fillOrder.clickOnPayByGuestBtn(); can't click on this button
        fillOrder.clickOnAddAddressBtn();
        fillOrder.fillInFirstName(firstName);
        fillOrder.fillInLastName(lastName);
        fillOrder.fillInAddress(address);
        fillOrder.fillInCity(city);
        fillOrder.fillInPostalCode(postal);
        fillOrder.fillInPhoneNumber(phone);
        fillOrder.clickOnSaveAddressButton();
        fillOrder.clickOnContinueOrderBtn();
    }

    @Test
    void searchProductByTitleTest(){
        var productName = "nintendo switch oled white 64gb";
        new HomePage().searchFor(productName);
        var actualResultTitle = new SearchResultPage().searchResultTitle();
        Assertions.assertEquals(productName,actualResultTitle);
    }
}
