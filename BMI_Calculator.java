package SmallProject;

import java.util.Scanner;

public class BMI_Calculator
{

    double weight;
    double height;

    BMI_Calculator(double weight , double height)
    {
        this.weight = weight;
        this.height = height * 0.3048;
    }

    public double calculateBMI()
    {
        double bmi = weight / (height * height);
        bmi = Double.parseDouble(String.valueOf(String.format("%.2f" , bmi)));
        double finalValue = 0;

        if (bmi > 0 && bmi <= 18.5)
        {
            finalValue = bmi;
        }
        else if (bmi > 18.5 && bmi <= 24.9)
        {
            finalValue = bmi;
        }
        else if (bmi > 24.9 && bmi <= 29.9)
        {
            finalValue = bmi;
        }
        else
        {
            finalValue = bmi;
        }
        return finalValue;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double weight;
        double height;

        System.out.print("Enter weight:");
        weight = sc.nextDouble();
        System.out.print("Enter height:");
        height = sc.nextDouble();
        BMI_Calculator obj = new BMI_Calculator(weight , height);

        double finalValue = obj.calculateBMI();
        if (finalValue > 0 && finalValue <= 18.5)
        {
            System.out.println(finalValue+" you are underweight");
        } else if (finalValue > 18.5 && finalValue <= 24.9) {
            System.out.println(finalValue+" you are normal in weight");
        } else if (finalValue > 24.9 && finalValue <= 29.9) {
            System.out.println(finalValue+" you are overweight");
        }else {
            System.out.println(finalValue+" you are obese");
        }
    }
}
