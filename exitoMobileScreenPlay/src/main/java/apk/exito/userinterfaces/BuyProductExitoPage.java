package apk.exito.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuyProductExitoPage extends PageObject {
    public static final Target CLOSE_LOCATION_POP_UP = Target.the("location pop-up window").located(By.id("com.android.permissioncontroller:id/permission_deny_button"));
    public static final Target CLOSE_VIDEO_ICON = Target.the("Video close icon").located(By.id("com.exito.appcompania:id/imageview_close"));
    public static final Target PRODUCT_SEARCH_INPUT = Target.the("Text box for product search").located(By.id("com.exito.appcompania:id/appCompatEditText_search_bar"));
    public static final Target PRODUCT_SEARCH_TWO_INPUT = Target.the("Text box for product search").located(By.id("com.exito.appcompania:id/appCompatEditText_search_data_edit"));
    public static final Target RECEIVE_ORDER_POP_UP = Target.the("Pop-up window to select how to receive the product").located(By.id("com.exito.appcompania:id/appCompatTextView_buy_and_collect_title"));
    public static final Target SEND_TO_HOME = Target.the("").located(By.id("com.exito.appcompania:id/constraitLayout_user_address"));
    public static final Target CONTINUE_BUTTON = Target.the("Button to proceed to checkout and pickup").located(By.id("com.exito.appcompania:id/appCompatButton_continue"));
    public static final Target PRODUCT_NAME_LABEL = Target.the("Product name label").locatedBy("//android.widget.TextView[@text='{0}']");
    public static final Target SHOPPING_CART_ICON = Target.the("Icon to check the shopping cart").located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));
    public static final Target PRODUCT_NAME_CART_LABEL = Target.the("Product cart name  label").locatedBy("//android.view.View[@text='{0}']");
    public static final Target FIRST_BUTTON_AGREGAR_IN_LIST = Target.the("First Product in List").located(By.xpath("(//android.view.ViewGroup[@resource-id='com.exito.appcompania:id/constraitLayout_add_item'])[1]"));
    public static final Target FIRST_PRICE_IN_LIST = Target.the("First price in list").located(By.xpath("(//android.view.ViewGroup[@resource-id='com.exito.appcompania:id/constraintLayout_plp_item'])[1]//android.widget.TextView[@resource-id='com.exito.appcompania:id/appCompatTextView_other_price']"));
    public static final Target FIRST_NAME_IN_LIST = Target.the("First name in list").located(By.xpath(("(//android.view.ViewGroup[@resource-id='com.exito.appcompania:id/constraintLayout_plp_item'])[1]//android.widget.TextView[@resource-id='com.exito.appcompania:id/appCompatTextView_product_title']")));
    public static final Target CART_PRODUCT_NAME = Target.the("In cart product name").locatedBy("//android.view.View[contains(@text,'{0}')]/../android.view.View[4]");
    public static final Target CART_PRODUCT_PRICE = Target.the("In cart product price").locatedBy("//android.view.View[contains(@text,'{0}')]/../android.view.View[6]");
    public static final Target CART_PRODUCT_UNITS = Target.the("In cart product units").locatedBy("//android.view.View[contains(@text,'{0}')]/../android.view.View[7]");

}
