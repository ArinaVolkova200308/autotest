package sbpTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class BaseStep {
    private final SelenideElement logInButton = $x("//button[@id='login-button']");
    private final SelenideElement userNameInput = $x("//input[@name='username']");
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement smsInput = $x("//input[@id='otp-code']");
    private final SelenideElement codeButton = $x("//button[@id='login-otp-button']");
    private final SelenideElement appName = $x("//div[@class='environment print-hidden']");

    private  final  SelenideElement curAvatar = $x("//a[@id='user-avatar']");
    private final SelenideElement Avatar = $x("//div[@id='avatars-form']/label");
    private final  SelenideElement avatar = $x("//img[@data-avatar='42.png']");
    private final SelenideElement submitButton = $x("//button[@id='submit-button']");

    private final SelenideElement errorAvatar = $x("//div[@class='alert alert-error']");


    private final SelenideElement cardsOverview = $x("//a[@id='cards-overview-index']");
    private final SelenideElement buttonBlock = $x("//a[@class='card-block']");
    private final SelenideElement timeBlock = $x("//input[@onclick=\"$('#card-block-disclaimer').slideUp()\"]");
    private final SelenideElement buttonBlock2 = $x("//button[@id='block-card']");
    private final SelenideElement codeBlock = $x("//input[@id='otp-input']");
    private final SelenideElement confirmBlock = $x("//button[@id='confirm']");

    private final SelenideElement cardBlocked = $x("//div[@class='card-visual-representation travel design-05 BLOCKED card-ref-']");

    private final SelenideElement buttonUnlock = $x("//a[@class='card-unblock']");
    private final SelenideElement codeUnlock = $x("//input[@id='otp-input']");
    private final SelenideElement confirmUnlock = $x("//button[@id='confirm']");

    private final SelenideElement cardUnlocked = $x("//div[@class='card-visual-representation travel design-05 ACTIVE card-ref-']");

    @Step("Авторизация в интернет банке БСБП")
    void authorization() {
        //baseStep = new BaseStep();
        //BaseStep.Authorization();
        userNameInput.shouldBe(visible).val("demo");
        passwordInput.shouldBe(visible).val("demo");
        logInButton.shouldBe(visible).click();
        smsInput.shouldBe(visible).val("0000");
        codeButton.shouldBe(visible).click();
        appName.shouldHave(text("Интернет-банк"));
    }

    @Step("Смена аватарки")
    void setNewAvatar(){
        curAvatar.shouldBe(visible).click();
        switchTo().frame($x("(//div[@id='contentbar']/iframe)"));
        Avatar.shouldHave(text(" Аватар "));
        avatar.shouldBe(visible).click();
        submitButton.shouldBe(visible).click();
    }

    @Step("Проверка сообщения о невозмоности изменения настроек")
    void errorMessage() {
        errorAvatar.shouldHave(text("Демо-пользователь не может менять настройки."));
    }


    @Step("Блокировка карты")
    void setInfoCard(){
        cardsOverview.shouldBe(visible).click();
        buttonBlock.shouldBe(visible).click();
        timeBlock.shouldBe(visible).click();
        buttonBlock2.shouldBe(visible).click();
        switchTo().frame($x("(//div[@class='modal-footer confirmation']/iframe)"));
        codeBlock.shouldBe(visible).val("0000");
        confirmBlock.shouldBe(visible).click();
        switchTo().defaultContent();
    }

    @Step("Проверка заблокирована ли карта")
    void cardBlocked() {
        cardBlocked.shouldBe(visible);
    }

    @Step("Разблокировка карты")
    void  unlockCard() {
        buttonUnlock.shouldBe(visible).click();
        switchTo().frame($x("(//div[@class='modal-footer']//iframe)"));
        codeUnlock.shouldBe(visible).val("0000");
        confirmUnlock.shouldBe(visible).click();
    }

    @Step("Проверка разблокирована ли карта")
    void cardUnlocked() {
        cardUnlocked.shouldBe(visible);
    }
}
