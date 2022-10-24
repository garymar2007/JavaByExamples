package problemSolving;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.toUpperCase();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            } else if (s.charAt(i) == 'D') {
                result += 500;
            } else if (s.charAt(i) == 'C') {
                if (i + 1 != s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                }else {
                    result += 100;
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 != s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'L') {
                result += 50;
            } else if (s.charAt(i) == 'V') {
                result += 5;
            } else if (s.charAt(i) == 'I') {
                if (i + 1 != s.length()) {
                    if (s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                    } else if(s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        RomanToInteger roi = new RomanToInteger();

        System.out.println(roi.romanToInt("LVIII"));
        System.out.println(roi.romanToInt("MCMXCIV"));
    }
}
