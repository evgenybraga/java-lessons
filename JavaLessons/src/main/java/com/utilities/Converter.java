/**
 * Created by vkostyna on 14/12/2015.
 */
public class Converter {
    public static int parseInt(String value) throws NumberFormatException{
        int result = 0;
        char firstChar = value.charAt(0);
        boolean negative = ('-' == firstChar ? true:false);
        int length = value.length();
        char symbol;
        int digit = 0;
        for (int position = ('-' == firstChar || '+' == firstChar ? 1:0); position < length; position++){
            symbol = value.charAt(position);
            digit = Character.digit(symbol, 10);
            if (digit < 0) {
                throw new NumberFormatException("Given value = [" + value + "] contains non digit characters" );
            }
            //System.out.println("digit = [" + digit + "]");
            result *= 10;
            result += digit;
        }
        return negative ? -result : result;
    }

    public static String toString(double value) throws NumberFormatException {
        Double.toString(123);
        return null;
    }

    public static double parseDouble(String value) throws NumberFormatException {
        Double.parseDouble("987564");
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(parseInt("1"));
        System.out.println(parseInt("+1"));
        System.out.println(parseInt("-1"));
        System.out.println(parseInt("-98256"));
        System.out.println(parseInt("98256"));
        System.out.println(parseInt("-000098256"));
        System.out.println(parseInt("+000098256"));
        System.out.println(parseInt("-98256000"));
         System.out.println(parseInt("98256000"));
        System.out.println(parseInt("-000000"));
        System.out.println(parseInt("+000000"));

        System.out.println(parseInt("sdf"));
        System.out.println(parseInt("sdfg"));



    }
}
