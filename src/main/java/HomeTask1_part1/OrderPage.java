package HomeTask1_part1;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage {

    public void clickOnProceedOrderBtn(){
        $(".button-next").click();
    }
    public void fillInGuestEmail(String email){
        $("#guest_email").val(email).pressEnter();
    }
    public void fillInFirstName(String firstName){
        $("#addressFirstName-").val(firstName);
    }
    public void fillInLastName(String lastName){
        $("#addressLastName-").val(lastName);
    }
    public void fillInAddress(String address){
        $("#addressLine1-").val(address);
    }
    public void fillInCity(String city){
        $("#address-townCity-").val(city);
    }
    public void fillInPostalCode(String postal){
        $("#addressPostalCode-").val(postal);
    }
    public void fillInPhoneNumber(String phone){
        $("#address-phone-").val(phone);
    }
    public void clickOnSaveAddressButton(){
        $(".button--save").click();
    }

    public void clickOnPayByGuestBtn(){
        $("#guestForm bottom").click();
    }
    public void clickOnAddAddressBtn(){
        $(".js-add__address").click();
    }
    public void clickOnContinueOrderBtn(){
        $("#submmit-first-step").click();
    }
}
