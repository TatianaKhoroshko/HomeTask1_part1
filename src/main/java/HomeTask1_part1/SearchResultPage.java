package HomeTask1_part1;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    public String searchResultTitle() {
        return $(".highlight").getText();
    }
}
