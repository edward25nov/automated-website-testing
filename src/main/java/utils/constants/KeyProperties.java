package utils.constants;

/**
 * @author Edward
 * @since 03/29/2022
 */
public enum KeyProperties implements Constant<String> {
    PROPERTIES_FILES("application.properties"),
    ENVIRONMENT("Environment"),
    ORANGE_LOGIN("Orange.login"),
    ORANGE_USER("Orange.user"),
    ORANGE_PASS("Orange.pass"),
    EXAMPLE_HOMEPAGE("Example.homePage"),
    DUCK_HOME("Duck.home");

    private String value;

    KeyProperties(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
