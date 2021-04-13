public class NextDayCalculator {

    public static final int firstOfDay = 1;
    public static int lastOfDay = 31;
    public static final int firstOfMonth = 1;
    public static final int lastOfMonth = 12;

    public static String nextDayCalculator(int dayTest, int monthTest, int yearTest) {
        checkMonth(monthTest, yearTest);
        if (dayTest == lastOfDay && monthTest == lastOfMonth) {
            dayTest = firstOfDay;
            monthTest = firstOfMonth;
            yearTest++;
        } else if (dayTest == lastOfDay) {
            dayTest = firstOfDay;
            monthTest++;
        } else dayTest++;
        String result = dayTest + "-" + monthTest + "-" + yearTest;
        return result;
    }

    //kiem tra so ngay trong thang
    private static void checkMonth(int monthTest, int yearTest) {
        switch (monthTest) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastOfDay = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastOfDay = 30;
                break;
            case 2:
                if (checkYear(yearTest)) {
                    lastOfDay = 29;
                    break;
                } else {
                    lastOfDay = 28;
                    break;
                }
        }
    }

    //kiem tra nam nhuan
    private static boolean checkYear(int year) {
        boolean isLeapYear = false;
        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        if (isLeapYear) return true;
        else return false;
    }
}


