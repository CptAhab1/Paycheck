/*
Alex Habbart
0855541
2/3/24
CSC 512
Lab 2
 */

// This program will calculate a paycheck for a WCU employee, including factoring in overtime pay

import java.util.Scanner;

public class Paycheck {

    public static void main(String[] args) {

        // Intro message:
        System.out.println("Welcome to \"RAMS HUMAN RESOURCES\" \n");

        Scanner scanner = new Scanner(System.in);

        // Setting these values here helps avoid "magic numbers"
        // elsewhere in the code, and also simplifies updating the code
        // if capitalism gets worse or if unions come back later.
        int stdWorkWeek = 40;
        double OTPayRate = 1.5;


        double salary = 0; // Set to 0 just to initialize, we will read it in just below:

        /* Utilizing a do/while loop ensures that the code always runs once, but will loop if
        // the user types an invalid number.
        // NOTE: after carefully rereading instructions I saw this was unnecessary,
        // but I liked trying to implement it and thought I would leave it just commented out
         do{ */
            System.out.print("\t Enter Hourly Salary: ");
            salary = scanner.nextDouble(); // The hourly pay
        /*    if (salary <= 0) // We are assuming that WCU pays its workers
        //        System.out.println("\t Please call the NLRB, or enter a positive value!");
         } while (salary <= 0); */

        double workTime = 0; // The hours worked

        // do {
            System.out.print("\t Enter Weekly Time: ");
            workTime = scanner.nextDouble();
        /*    if (workTime <= 0) { // If someone works 0 hours, it is unlikely they are getting a check
        //        System.out.println("\t Looks like you didn't have any shifts this week, " +
        //                            "input hours from a week where you had some shifts!");
        //    }
        } while (workTime <= 0); */

        System.out.println("\n \t Hourly Salary: $" + salary);
        System.out.println(" \t Weekly Time: " +
                            workTime +
                            " hour(s)");

        double workTimeOT = 0; // This variable will be used to calculate the hours worked beyond full-time

        // If someone worked more than stdWorkWeek, we will update the overtime hours
        // If not, then this will not execute and workTimeOT will remain 0.
        if (workTime > stdWorkWeek)
            workTimeOT = workTime - stdWorkWeek;

        double payRegular; // the pay for any hours up to stdWorkWeek

        if (workTimeOT > 0)
            payRegular = stdWorkWeek*salary;
        else
            payRegular = workTime*salary;

        if (workTimeOT > 0){ // If someone worked OT, we just want to calculate the pay for regular hours here
            System.out.println("\t Regular pay for " +
                                stdWorkWeek +
                                " hour(s): $" +
                                payRegular);
        }
        else{ // If someone didn't work OT, then we can just use workTime here
            System.out.println("\t Regular pay for " +
                                workTime +
                                " hour(s): $" +
                                payRegular);

        }

        double payOT = salary*OTPayRate*workTimeOT; // The amount of income just from OT hours

        // Both of these values will be 0 if someone didn't work OT
        System.out.println("\t Overtime pay for " +
                            workTimeOT +
                            " hour(s): $" +
                            payOT);

        // The total pay including both regular and OT hours combined
        System.out.println("\t Net pay: $ " +
                String.format("%.2f",(payRegular + payOT))
                + "\n");

        System.out.println("Thank you for using \"RAMS HUMAN RESOURCES\"");




    }
}