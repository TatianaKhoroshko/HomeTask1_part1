package HomeTask1_part1;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public void searchFor(String searchProduct) {
        $("#search").val(searchProduct).pressEnter();
    }
}
