
public class Converter {
    static String arabicToRoman(int number){
        String[] romanDigit ={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] romanDecimal = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        int arabicDigit = number%10;
        int arabicDecimal = number/10;
        return romanDecimal[arabicDecimal]+romanDigit[arabicDigit];
    }
    static int romanToArabic(String roman){
        RomanNumbers romanEnum = RomanNumbers.valueOf(roman);
        return romanEnum.getDescription();
    }
}