package HomeTask1_part1;

import com.codeborne.selenide.Configuration;

public abstract class BaseTest {
    static {
            Configuration.baseUrl = "https://www.technopolis.bg";
        Configuration.pageLoadStrategy = "none";
        Configuration.timeout = 4000;
    }
}
