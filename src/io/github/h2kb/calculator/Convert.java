package io.github.h2kb.calculator;

class Convert {
    static int romeToInt(String romeValue) {
        if (romeValue.equals("I")) {
            return 1;
        }

        if (romeValue.equals("II")) {
            return 2;
        }

        if (romeValue.equals("III")) {
            return 3;
        }

        if (romeValue.equals("IV")) {
            return 4;
        }

        if (romeValue.equals("V")) {
            return 5;
        }

        if (romeValue.equals("VI")) {
            return 6;
        }

        if (romeValue.equals("VII")) {
            return 7;
        }

        if (romeValue.equals("VIII")) {
            return 8;
        }

        if (romeValue.equals("IX")) {
            return 9;
        }

        if (romeValue.equals("X")) {
            return 10;
        }

        throw new UnsupportedOperationException("Одновременная работа с римскиеми и арабскими цифрами не поддерживается.");
    }

    static String intToRome(int intValue) {
        String result = "";

        while (intValue > 0) {
            if ((intValue / 1000) >= 1) {
                result += "M";
                intValue -= 1000;
            } else if ((intValue / 500) >= 1) {
                result += "D";
                intValue -= 500;
            } else if ((intValue / 100) >= 1) {
                result += "C";
                intValue -= 100;
            } else if ((intValue / 50) >= 1) {
                result += "L";
                intValue -= 50;
            } else if ((intValue / 10) >= 1) {
                result += "X";
                intValue -= 10;
            } else if (intValue >= 1) {
                switch (intValue) {
                    case 9:
                        result = result + "IX";
                        intValue -= 9;
                        break;
                    case 8:
                        result = result + "VIII";
                        intValue -= 8;
                        break;
                    case 7:
                        result = result + "VII";
                        intValue -= 7;
                        break;
                    case 6:
                        result = result + "VI";
                        intValue -= 6;
                        break;
                    case 5:
                        result = result + "V";
                        intValue -= 5;
                        break;
                    case 4:
                        result = result + "IV";
                        intValue -= 4;
                        break;
                    case 3:
                        result = result + "III";
                        intValue -= 3;
                        break;
                    case 2:
                        result = result + "II";
                        intValue -= 2;
                        break;
                    case 1:
                        result = result + "I";
                        intValue -= 1;
                        break;
                }
            }
        }

        return result;
    }
}
