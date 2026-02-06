package SmallProject;
//              June 2025
//          Su Mo Tu We Th Fr Sa
//          1  2  3  4  5  6  7
//          8  9 10 11 12 13 14
//          15 16 17 18 19 20 21
//          22 23 24 25 26 27 28
//          29 30

import java.util.Scanner;

public class MiniCalender
{
    int days = 0;
    int startingDay = 0;
    String monthName = "";

    public void miniCalendar(int month , int year)
    {
        switch (month)
        {
            case 1:

               days = 31;
               startingDay = 4;
               monthName = "January";
               break;

            case 2:

                startingDay = 7;
                monthName = "February";
                if (year % 4 == 0 || year % 100 != 0 || year % 400 == 0)
                {
                    days = 29;
                }else {
                    days = 28;
                }
                break;

            case 3:

                startingDay = 7;
                days = 31;
                monthName = "March";
                break;

            case 4:

                startingDay = 3;
                days = 30;
                monthName = "April";
                break;

            case 5:

                startingDay = 5;
                days = 31;
                monthName = "May";
                break;

            case 6:

                startingDay = 1;
                days = 30;
                monthName = "June";
                break;

            case 7:

                startingDay = 3;
                days = 31;
                monthName = "July";
                break;

            case 8:

                startingDay = 6;
                days = 31;
                monthName = "August";
                break;

            case 9:

                startingDay = 2;
                days = 30;
                monthName = "September";
                break;

            case 10:

                startingDay = 4;
                days = 31;
                monthName = "October";
                break;

            case 11:

                startingDay = 7;
                days = 30;
                monthName = "November";
                break;

            case 12:

                startingDay = 2;
                days = 31;
                monthName = "December";
                break;
            default:
                System.out.println("Invalid month..");
        }


        System.out.println("\n\n\t"+monthName+"  "+year);
        System.out.println("Sun Mon Tue Wed Thr Fri Stu");


        for (int i = 1; i < startingDay; i++) {
            System.out.print("    ");
        }


        for (int i = 1; i <= days; i++)
        {
            System.out.printf("%2d  ", i);

            if ((i + startingDay - 1) % 7 == 0)
            {
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Month:");
        int month = sc.nextInt();

        System.out.print("Enter Year:");
        int year = sc.nextInt();

        MiniCalender miniCalender = new MiniCalender();
        miniCalender.miniCalendar(month,year);
    }
}