package acal.commons;

public class Coalesce {

    private Coalesce() {
        /** static use only */
    }

    @SafeVarargs
    public static <T> T coalesce(T... values) {
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}
