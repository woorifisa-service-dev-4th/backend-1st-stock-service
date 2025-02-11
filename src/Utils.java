import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String formatMoney(int amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount);
    }
}
