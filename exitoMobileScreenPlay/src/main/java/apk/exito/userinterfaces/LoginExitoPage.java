package apk.exito.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginExitoPage {
    public static final Target LOGIN_BUTTON = Target.the("Button to log in to the app").located(By.id("AppCompatButton_ingresar"));
    public static final Target EMAIL_INPUT = Target.the("Text field to enter the user's email address").located(By.id("TextInputEditText_email"));
    public static final Target PASSWORD_INPUT = Target.the("Text field to enter the user's password").locatedBy("(//android.widget.EditText[@class='android.widget.EditText'])[2]");
    public static final Target ENTER_BUTTON = Target.the("Button to enter the application").located(By.id("AppCompatButton_ingresar"));
}
