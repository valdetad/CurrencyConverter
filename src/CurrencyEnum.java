public class CurrencyEnum {

    public enum CurrencyCode {
        MKD(1),
        USD(2),
        CAD(3),
        GBP(4);

        public final int value;

        CurrencyCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum CurrencyName{
        DENAR,
        DOLLAR,
        CANADIAN_DOLLAR,
        POUND
    }
}
