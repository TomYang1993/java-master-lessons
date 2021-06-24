package yxy.tom.yang;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//formula for EMI = [P x R x (1+R)^N]/[(1+R)^N-1], where R is monthly interest and N is number of months
public class BigDecimalTest {
    int years;
    long principal;
    double interestRate;
    BigDecimalTest bigInterestRate;

    //complete this method
    public double calcEMI() {
        int n = years * 12;
        double r = interestRate / 12;
        double emi = principal * r * Math.pow(1+r, n)/(Math.pow(1+r, n) - 1);
        return emi;
    }

    //complete this method
    public BigDecimal calcBigEMI() {
        int n = years * 12;
        double r = interestRate / 12;
        String p = Long.toString(principal);

        BigDecimal emi = new BigDecimal(p);
        emi = emi.multiply(BigDecimal.valueOf(r)).multiply(BigDecimal.valueOf(Math.pow(1+r, n)));
        //emi = emi.divide(BigDecimal.valueOf(Math.pow(1+r, n) - 1)).setScale(20, RoundingMode.HALF_UP);
        emi = emi.divide(BigDecimal.valueOf(Math.pow(1+r, n) - 1), 20, RoundingMode.HALF_UP);
        return emi;
    }

    //complete this method
    public void getInputs() {
        Scanner input = new Scanner (System.in);
        // insert your code here
        System.out.println("Enter principal amount");
        principal = input.nextLong();

        System.out.println("Enter number of years");
        years = input.nextInt();

        System.out.println("Enter annual interest rate. 5% to be entered as 0.05");
        interestRate = input.nextDouble();

        input.close();
    }

    //don't change this method
    public static void main(String[] args) {
        BigDecimalTest l = new BigDecimalTest();
        l.getInputs();     							//initialize all variables

        double doubleEMI = l.calcEMI();				//calculate EMI with double interest rate
        BigDecimal bigEMI = l.calcBigEMI();			//calculate EMI with BigDecimal interest rate

        System.out.println("********** Results ************");
        System.out.printf("Principal: $%,d%n", l.principal);
        System.out.printf("Interest rate: %.2f%%%n", l.interestRate*100);

        System.out.println("Monthly EMI using double: " + doubleEMI);

        //following statement rounds up 20 digits after decimal place. Otherwise throws Arithmetic Exception if number cannot be represented
        System.out.println("Monthly EMI using BigDecimal: " + bigEMI.setScale(20, RoundingMode.HALF_UP));

        double difference = (bigEMI.setScale(20, RoundingMode.HALF_UP).doubleValue() - doubleEMI)*12*l.years;

        System.out.printf("Difference bigEMI - doubleEMI = %.15f%n", (bigEMI.subtract(BigDecimal.valueOf(doubleEMI))));
        System.out.printf("Total difference = %.15f%n", difference);
    }
}
