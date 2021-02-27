import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntegerToEnglishWords {

    public String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String two(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return one(num);
        else if (num < 20)
            return twoLessThan20(num);
        else {
            int tenner = num / 10;
            int rest = num - tenner * 10;
            if (rest != 0)
                return ten(tenner) + " " + one(rest);
            else
                return ten(tenner);
        }
    }

    public String three(int num) {
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String res = "";
        if (hundred*rest != 0)
            res = one(hundred) + " Hundred " + two(rest);
        else if ((hundred == 0) && (rest != 0))
            res = two(rest);
        else if ((hundred != 0) && (rest == 0))
            res = one(hundred) + " Hundred";
        return res;
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int billion = num / 1000000000;
        int million = (num - billion * 1000000000) / 1000000;
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = three(billion) + " Billion";
        if (million != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(million) + " Million";
        }
        if (thousand != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(thousand) + " Thousand";
        }
        if (rest != 0) {
            if (! result.isEmpty())
                result += " ";
            result += three(rest);
        }
        return result;
    }

    /*
    // My solution. Passes, but is very complex
    static String getSuffix(int part) {
        return switch (part) {
            case 0 -> "";
            case 1 -> "Hundred";
            case 2 -> "Thousand";
            case 3 -> "Million";
            case 4 -> "Billion";
            case 5 -> "Quadrillion";
            default -> "Quintillion";
        };
    }

    static String interpretUnits(int num) {
        return switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            default -> "Zero";
        };
    }

    static String interpretElevens(int num) {
        return switch (num) {
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            default -> "aaa";
        };
    }

    static String interpretTens (int num) {
        StringBuilder res = new StringBuilder();
        String conv = Integer.toString(num);
        switch (conv.charAt(0)) {
            case '2' -> res.append("Twenty ");
            case '3' -> res.append("Thirty ");
            case '4' -> res.append("Fourty ");
            case '5' -> res.append("Fifty ");
            case '6' -> res.append("Sixty ");
            case '7' -> res.append("Seventy ");
            case '8' -> res.append("Eighty ");
            case '9' -> res.append("Ninety ");
        }
        if (conv.charAt(1) != '0') {
            res.append(interpretUnits(conv.charAt(1) - '0'));
        }
        return res.toString();
    }

    static String interpretHundreds (int num) {
        String conv = Integer.toString(num);
        StringBuilder res = new StringBuilder();

        res.append(interpretUnits(conv.charAt(0) - '0'));
        res.append(' ');
        res.append(getSuffix(1));

        int tens = num % 100;

        if (tens != 0) res.append(' ');

        if (tens >= 1 && tens <= 10) {
            res.append(interpretUnits(tens));
        } else if (tens >= 11 && tens <= 19) {
            res.append(interpretElevens(tens));
        } else if (tens >= 20) {
            res.append(interpretTens(tens));
        }

        return res.toString();
    }



    static String interpret(StringBuilder num, int part) {

        List<String> list = new ArrayList<>();
        int res = Integer.parseInt(num.toString());
        if (res == 0) return "";
        if (res >= 1 && res <= 10) {
            list.add(0, interpretUnits(res));
        } else if (res >= 11 && res <= 19) {
            list.add(0, interpretElevens(res));
        } else if (res >= 20 && res <= 99){
            list.add(0, interpretTens(res));
        } else {
            list.add(0, interpretHundreds(res));
        }

        if (part >= 2) {
            list.add(getSuffix(part));
        }

        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s).append(' ');
        }

        return result.toString();
    }

    static public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<StringBuilder> list = new LinkedList<>();

        String s = Integer.toString(num);

        int count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (count == 0) {
                list.add(new StringBuilder());
            }
            int n = list.size();
            list.get(n-1).insert(0, s.charAt(i));
            count = (count+1) % 3;
        }

        StringBuilder answer = new StringBuilder();

        int part = 1;
        for (StringBuilder string : list) {
            if(answer.length() > 0 && answer.charAt(0) != ' ')answer.insert(0, ' ');
            answer.insert(0, interpret(string, part++).trim());
        }

        return answer.toString().trim();
    }*/

}
