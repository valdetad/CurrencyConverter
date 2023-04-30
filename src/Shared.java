import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.MessageFormat;

public class Shared {
    public static Constants Constants = new Constants();
    public static final Scanner sc = new Scanner(System.in);
    public static double MKD, USD, CAD, GBP;
    public static int number = Constants.DEFAULT_VALUE_NUMBER;

    public static void GreetingMessages() {
        System.out.println(Constants.GREETING_MSG);
        System.out.println(Constants.CURRENCY_CODE_LIST);
    }

    /**
     Gets the currency name.
     @param currencyName - Expect currencyName to be passed.
     */
    public static void GetCurrencyName(CurrencyEnum.CurrencyName currencyName) {
        System.out.println(MessageFormat.format("Enter amount in {0}: " , currencyName));
    }

    /**
     Converts the currencies from (USD, CAD, GBP) to MKD.
     */
    public static void ConvertToDenar() {
        GetCurrencyName(CurrencyEnum.CurrencyName.DENAR);
        MKD = sc.nextFloat();
        USD = MKD / 75;
        System.out.println(MessageFormat.format("Dollar : {0} ", USD));
        CAD = MKD / 101;
        System.out.println(MessageFormat.format("Canadian Dollar : {0} ", CAD));
        GBP = MKD / 84;
        System.out.println(MessageFormat.format("Pound : {0} ", GBP));
    }

    /**
     Converts the currencies from(MKD, CAD, GBP) to USD
     */
    public static void ConvertToDollar() {
        GetCurrencyName(CurrencyEnum.CurrencyName.DOLLAR);

        USD = sc.nextFloat();
        MKD = USD * 0.017;
        System.out.println(MessageFormat.format("Denar : {0}", MKD));
        CAD = USD * 0.78;
        System.out.println(MessageFormat.format("Canadian dollar : {0} ", CAD));
        GBP = USD * 1.23;
        System.out.println(MessageFormat.format("Pound : {0}", GBP));
    }

    /**
     Converts the currencies from(MKD, USD, GBP) to CAD
     */
    public static void ConvertToCanadianDollar() {
        GetCurrencyName(CurrencyEnum.CurrencyName.CANADIAN_DOLLAR);

        CAD = sc.nextFloat();
        MKD = CAD * 0.022;
        System.out.println(MessageFormat.format("Denar : {0}", MKD));
        USD = CAD * 1.29;
        System.out.println(MessageFormat.format("Dollar :{0} ", USD));
        GBP = CAD * 1.58;
        System.out.println(MessageFormat.format("Pound : {0}", GBP));
    }

    /**
     Converts the currencies from(MKD, USD, CAD) to GBP
     */
    public static void ConvertToPound() {
        GetCurrencyName(CurrencyEnum.CurrencyName.POUND);

        GBP = sc.nextFloat();
        MKD = GBP * 0.014;
        System.out.println(MessageFormat.format("Denar {0}: ", MKD));
        USD = GBP * 0.82;
        System.out.println(MessageFormat.format("Dollar : ", USD));
        CAD = GBP * 0.63;
        System.out.println(MessageFormat.format("Canadian : ", CAD));
    }

    /**
     Expects input currency code (integer between 1-5)
     *  to proceed with calculation.
     @throws 'invalid' number in case the number is not
      *  between the expected range.
     */
    public static void GetConvertedCurrencies() {
        GreetingMessages();

        boolean isValid = false;
        try {
            while (isValid == false) {
                System.out.println(Constants.INPUT_NUMBER);
                if (sc.hasNextInt()) {
                    number = sc.nextInt();
                    isValid = true;
                    if (number == CurrencyEnum.CurrencyCode.MKD.getValue()) {
                        ConvertToDenar();
                    } else if (number == CurrencyEnum.CurrencyCode.USD.getValue()) {
                        ConvertToDollar();
                    } else if (number == CurrencyEnum.CurrencyCode.CAD.getValue()) {
                        ConvertToCanadianDollar();
                    } else if (number == CurrencyEnum.CurrencyCode.GBP.getValue()) {
                        ConvertToPound();
                    }
                } else {
                    System.out.println(Constants.ERROR_INVALID_NUMBER);
                    number = sc.nextInt();
                }
            }
        } catch (InputMismatchException exception) {
            System.out.println(MessageFormat.format("{0}", Constants.ERROR_INT_ONLY));
            sc.nextLine();
        }
        sc.close();
    }
}