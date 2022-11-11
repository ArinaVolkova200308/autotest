package sbpTests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    @Test
    @Description("Изменение аватара")
    void avatar(){
        baseStep.setNewAvatar();
        baseStep.errorMessage();
    }

    @Test
    @Description("Блокировка и разблокировка карты")
    void card(){
        baseStep.setInfoCard();
        baseStep.cardBlocked();
        baseStep.unlockCard();
        baseStep.cardUnlocked();
    }
}
