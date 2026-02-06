package SmallProject;

import java.util.Scanner;
public class  SystemConversion {



//Decimal to Binary
    public static String decimalToBinary(int decimal)
    {
        StringBuilder sb = new StringBuilder();
        while (decimal > 0)
        {
            int rem = decimal % 2;
            sb.insert(0 , rem);
            decimal = decimal / 2;
        }
        return sb.toString();
    }




// Binary to Decimal
public static int binaryToDecimal(String binary)
{
    int decimal = 0;
    int power = 0;
    for (int i = binary.length() - 1; i >= 0 ; i--)
    {
        char bin = binary.charAt(i);
        if(bin == '1')
        {
            decimal += (int) Math.pow(2 , power);
        } else if (bin != '0') {
            System.out.println("Invalid binary number");
            break;
        }
        power++;
    }
    return decimal;
}




// Octal to Decimal
public static int octalToDecimal(int octal) {

        int decimal = 0;
        int power   = 0;

        while (octal != 0)
        {
            int lastDigit = octal % 10;
            if (lastDigit > 7)
            {
                System.out.println("Not octal number");
                return 0;
            }
            decimal += (int) (lastDigit * Math.pow(8 , power));
            power++;
            octal /= 10;
        }
        return decimal;
}




// Decimal to Octal
public static String decimalToOctal(int decimal)
{
    StringBuilder octal = new StringBuilder();
     while (decimal > 0)
     {
         int remainder = decimal % 8;
         octal.insert(0 , remainder);
         decimal = decimal / 8;
     }
     return octal.toString();
}




// Decimal to Hex-decimal1
    public static String decimalToHex_decimal(int decimalToHex)
    {
        StringBuilder sb = new StringBuilder();
        char[] hex_character = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        if(decimalToHex == 0)
        {
            return "0";
        }
        while (decimalToHex > 0)
        {
            int remainder = decimalToHex % 16;
            sb.insert(0 , hex_character[remainder]);
            decimalToHex = decimalToHex / 16;
        }
        return sb.toString();
    }



    // Hex-decimal to decimal
    public static int hexDecimalToDecimal(String hex)
    {
        hex = hex.toUpperCase();
        int decimal = 0;
        int power = 0;
        for (int i = hex.length() - 1; i >= 0 ; i--) {
            char ch = hex.charAt(i);
            int digitValue;
            if (ch >= 'A' && ch <= 'F')
            {
                digitValue = 10 + (ch - 'A');
            } else if (ch >= '0' && ch <= '9')
            {
                digitValue = ch - '0';
            }
            else {
                System.out.println("Invalid hex-decimal number:"+ch);
                return 0;
            }
            decimal += (int) (digitValue * Math.pow(16, power));
            power++;
        }
        return decimal;
    }

    //Hex-Decimal to Binary
    public static String hexDecimalToBinary(String hex)
    {
        String[] hexArray = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        hex = hex.toUpperCase();
        int decimal;
        StringBuilder bin = new StringBuilder();

        for (int i = 0; i < hex.length(); i++)
        {
            char ch = hex.charAt(i);
            if (ch >= '0' && ch <= '9')
            {
                decimal = ch - '0';
                bin.append(hexArray[decimal]);
            } else if (ch >= 'A' && ch <= 'F') {
                decimal = 10 + (ch - 'A');
                bin.append(hexArray[decimal]);
            }

        }
        return bin.toString();
    }

    //Octal to Binary
    public static String octalToBinary(String decimal)
    {
                      //  0       1     2     3     4     5     6     7
       String[] octal = {"000","001","010","011","100","101","110","111"};
       StringBuilder octalBinary = new StringBuilder();
       int digit;

        for (int i = 0; i < decimal.length(); i++) {
            char ch = decimal.charAt(i);
            if (ch >= '0' && ch <= '7')
            {
                digit = ch - '0';
                octalBinary.append(octal[digit]);
            }
        }
        return octalBinary.toString();
    }


public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int choice;
    int decimal;
    String str;

    do {
        System.out.println("1. Decimal to Binary");
        System.out.println("2. Binary  to Decimal");
        System.out.println("3. Octal to Decimal");
        System.out.println("4. Decimal to Octal");
        System.out.println("5. Decimal to Hex-decimal");
        System.out.println("6. Hex-decimal to decimal");
        System.out.println("7. Hex-decimal to binary");
        System.out.println("8. Octal to binary");
        System.out.print("Enter choice:");
        choice = sc.nextInt();

        switch (choice)
        {


            case 1:
                System.out.print("Enter Decimal to Binary:");
                decimal = sc.nextInt();
                String Decimal = decimalToBinary(decimal);
                System.out.println("Decimal to Binary:"+Decimal);
                break;


            case 2:
                System.out.print("Enter Binary to Decimal:");
                str = sc.next();
                 int binary = binaryToDecimal(str);
                System.out.println("Binary  to Decimal:"+ binary);
                break;

            case 3:
                System.out.print("Enter Octal to Decimal:");
                decimal = sc.nextInt();
                int octal = octalToDecimal(decimal);
                System.out.println("Octal to Decimal:"+ octal);
                break;

            case 4:
                System.out.print("Enter Decimal to Octal:");
                decimal = sc.nextInt();
                String octal1 = decimalToOctal(decimal);
                System.out.println("Decimal to Octal:"+ octal1);
                break;

            case 5:
                System.out.print("Enter Decimal to Hex-decimal:");
                int hex = sc.nextInt();
                String hexa = decimalToHex_decimal(hex);
                System.out.println("Decimal to Hex-decimal:"+hexa);
                break;

            case 6:
                System.out.print("Enter Hex-decimal to Decimal:");
                str = sc.next();
                decimal = hexDecimalToDecimal(str);
                System.out.println("Hex-decimal to decimal:"+decimal);
                break;
            case 7:
                System.out.print("Enter Hex-decimal to binary:");
                str = sc.next();
                String hexToBin = hexDecimalToBinary(str);
                System.out.println("Hex-decimal to binary:"+hexToBin);
                break;
            case 8:
                System.out.print("Enter Octal to binary:");
                str = sc.next();
                String octToBin = octalToBinary(str);
                System.out.println("Hex-decimal to binary:"+octToBin);
                break;

        }

    }while (choice != 0);
    }
}