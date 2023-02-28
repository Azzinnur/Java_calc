import java.util.*;

public class Calculator {
    public static void main(String[] args){
        System.out.println("Введите пример:");
        Scanner in= new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        if(input.length() == 0) {
            try {
                throw new Exception();
            } catch (Exception NullString) {
                System.out.println("Ошибка. Оставлена пустая строка");
                System.exit(0);
            }
        }
        System.out.println(Calc.calc(input));
  }
}
class Calc {
    static String calc(String input) {
        String str;
        str=input.replaceAll("\\s", "");
        int[] Nums = new int[2];
        int i = 0;
        int q = 0;
        String[] RNI= RomanNumber.RomanNumberIn;
        String[] RNO= RomanNumber.RomanNumberOut;
        if (str.indexOf("+") > 0) {q=1;}
        else if (str.indexOf("-") > 0) {q=2;}
        else if (str.indexOf("*") > 0) {q=3;}
        else if (str.indexOf("/") > 0) {q=4;}
        String[] parts = str.split("[+\\-*/]");
        if (parts.length<2){
            try{throw new Exception();}
            catch (Exception OperandError1){
                System.out.println("Cтрока не является математической операцией");
                System.exit(1);
            }
        }
        if (parts.length>2) {
            try {throw new Exception();}
            catch (Exception OperandError2) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
                System.exit(2);
            }
        }
        boolean isRomanNumber1 = false;
        boolean isRomanNumber2 = false;
        for (int k = 2; k <= RNI.length; k++) {
            isRomanNumber1 = parts[0].equals(RNI[k-1]);
            if (isRomanNumber1){
                Nums[0]=k-1;
                k = 100;
            }
        }
        for (int k = 2; k <= RNI.length; k++) {
            isRomanNumber2 = parts[1].equals(RNI[k-1]);
            if (isRomanNumber2){
                Nums[1]=k-1;
                k = 100;
            }
        }
        boolean ReverseRoman=isRomanNumber1&&isRomanNumber2;
        boolean CheckRoman=isRomanNumber1^isRomanNumber2;
        if (CheckRoman) {
            try {throw new Exception();}
            catch (Exception DifferentSystems) {
                System.out.println("Использованы разные системы счисления или используются римские числа вне диапазона от I до X!");
                System.exit(3);
            }
        }
        if (!ReverseRoman) {
            for (String part : parts) {
                try {
                    Nums[i] = Integer.parseInt(part);
                } catch (NumberFormatException ArabianNumberFail) {
                    System.out.println("Значения с одной или с обеих сторон операнда не являются целым арабским числом");
                    System.exit(4);
                }

                if (Nums[i] > 10 || Nums[i] <= 0) {
                    try {
                        throw new Exception();
                    } catch (Exception RangeExc) {
                        System.out.println("Оба числа должны быть в диапазоне от 1 до 10");
                        System.exit(5);
                    }
                }
                i++;
            }
        }
        switch (q) {
                case 1 -> str = String.valueOf(Operation.Sum(Nums[0], Nums[1]));
                case 2 -> str = String.valueOf(Operation.Substract(Nums[0], Nums[1]));
                case 3 -> str = String.valueOf(Operation.Multiply(Nums[0], Nums[1]));
                case 4 -> str = String.valueOf(Operation.Divide(Nums[0], Nums[1]));
                }
        if (ReverseRoman){
            if (Integer.parseInt(str)<=0){
                try{throw new Exception();
            }
                catch (Exception NegativeRoman){
                    System.out.println("В римской системе счисления отсутствуют отрицательные числа и ноль");
                    System.exit(6);
                }
            }
                str=RNO[Integer.parseInt(str)];
            }
        return str;
    }
}
class RomanNumber{
    public static String[] RomanNumberIn = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] RomanNumberOut = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
}




