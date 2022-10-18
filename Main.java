//Samantha Reese
//CSC 222 IDE Project 1
//Compares gas vs. electric cars
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
    //declare variables needed for input

//create a new decimal formatter
        DecimalFormat df = new DecimalFormat("0.00");
    //Constants - Project specs required constants and these are great matches for them

final double WEEKS_PER_MONTH = 4.3;
final int MONTHS_IN_YEAR = 12;
        String gasCarName = new String();

        double gasMonthlyPayment;
        double gasPerGallonCosts;
        double gasAvgMilesRating;

        //variables for electric car;

        String eCarName = new String();

        double eMonthlyPayment;
        double electricityPerMile;


        //input variables needed for both cars;

        double averageWeeklyMiles;

        //print out the header
            System.out.println("***************");
            System.out.println("Let's begin by getting the details for your weekly miles.");

            //created a scanner object named input that I can use to get keyboard input from user
            Scanner input = new Scanner (System.in);

            //Get the information from the user about average weekly miles
            System.out.println("How many average weekly miles do you drive per week?");
            averageWeeklyMiles = input.nextDouble();
            //we need to clear the buffer (enter key)
            input.nextLine();
            System.out.println("Here is what the user entered for weekly miles: " + averageWeeklyMiles);

            // Get the information from the user about the gas car name
            System.out.println("Enter the name for your gas car (example, Toyota Camry): ");
            gasCarName = input.nextLine();
            System.out.println("Here is what the user entered for car name: " +gasCarName);

// get information from the user about the monthly payment of your car
            System.out.println("Enter the monthly finance payment for your car: ");
            gasMonthlyPayment = input.nextDouble();
            System.out.println("Here is what the user entered for monthly payment: " + gasMonthlyPayment);

            //get the cost of gas per gallon from the user about their car
            System.out.println("Enter the cost of gas per gallon: ");
            gasPerGallonCosts = input.nextDouble();
            System.out.println("Here is what the user entered for gas cost per gallon: " + gasPerGallonCosts);

            //get the Average MPG from the user
            System.out.println("Enter the average miles per gallon: ");
            gasAvgMilesRating = input.nextDouble();
            System.out.println("Here is what the user entered for average miles per gallon: " +gasAvgMilesRating);

            double weeklyGasCosts = calculateWeeklyConsumptionCosts(averageWeeklyMiles, gasAvgMilesRating, gasPerGallonCosts);
        System.out.println("Here is the data we received back from the method for weekly gas costs: " + weeklyGasCosts);
//*******************
    //electric vehicle information


        // Get the information from the user about the electric car name
        input.nextLine();
        System.out.println("Enter the name for your electric car (example, Tesla model S): ");
        eCarName = input.nextLine();
        System.out.println("Here is what the user entered for Electric car name: " +eCarName);

// get information from the user about the monthly payment of your electric car
        System.out.println("Enter the monthly finance payment for your electric car: ");
        eMonthlyPayment = input.nextDouble();
        System.out.println("Here is what the user entered for electric car monthly payment: " + eMonthlyPayment);

//get the cost of electricity per mile from the user about their electric car
        System.out.println("Enter the cost of electricity per mile: ");
        electricityPerMile = input.nextDouble();
        System.out.println("Here is what the user entered for the cost of electricity per mile: " + electricityPerMile);

        System.out.println("***************");
        System.out.println("We have all the data needed, here are our results: ");

        System.out.println("GAS CAR DATA: ");
        System.out.println("Car name: " +gasCarName);
        System.out.println("Average cost/week for gas: $ " + df.format(weeklyGasCosts));
        //calculate the Average Cost/Month for payment and gas
        double gasCarMonthlyCosts = (weeklyGasCosts * WEEKS_PER_MONTH) + gasMonthlyPayment;
        System.out.println("Average cost/month for Payment and Gas: $" + df.format(gasCarMonthlyCosts) + "(base on average of 4.3 weeks per month.)");
        //calculate the Average Cost/Year for payment and gas
        double gasYearlyCosts = gasCarMonthlyCosts * MONTHS_IN_YEAR;
        System.out.println("Average cost/year for Payment and Gas: $" +df.format(gasYearlyCosts) + "(monthly cost * 12)");


        System.out.println("ELECTRIC CAR DATA: ");
        System.out.println("Car name: " +eCarName);
        double avgElectricWeeklyCosts = calculateWeeklyElectricConsumptionCosts(averageWeeklyMiles, electricityPerMile);
        System.out.println("Average cost/week for electricity: $ " + df.format(avgElectricWeeklyCosts));
        //calculate electric monthly costs
        double electricMonthlyCosts = (avgElectricWeeklyCosts *  WEEKS_PER_MONTH) + eMonthlyPayment;
        System.out.println("Average cost/month for Payment and electricity: $" +df.format(electricMonthlyCosts) + "(base on average of 4.3 weeks per month.)");
        //calculate electric yearly costs
        double electricYearly = electricMonthlyCosts * MONTHS_IN_YEAR;
        System.out.println("Average cost/year for Payment and electricity: $" +df.format(electricYearly) + "(monthly cost * 12)");

        System.out.println("***************");
        System.out.println("COMPARISON RESULTS: ");
        System.out.println("Based on comparisons, if you bought the electric car, you would save or lose the following amount of money: ");
        System.out.println("Negative means savings, positive means loss / you are paying more.");
        //savings cost per month
        double savingsCostMonth = electricMonthlyCosts - gasCarMonthlyCosts;
        double savingsYear = electricYearly - gasYearlyCosts;
        System.out.println("Savings/costs per month: $" + df.format(savingsCostMonth) + "(electric monthly car costs - gas monthly car costs)");
        System.out.println("Savings/costs per year: $" + df.format(savingsYear) + "(savings per month * 12)");






        //some calculations;

        //**********Begin electric car formulas***********

        //how to calculate the avg cost per week electricity;
        // avg WeeklyECosts = cost of electricityPerMile * how many miles we drive in a week (averageWeeklyMiles);
        //average costs month for payment and electricity
        //avgWeeklyECosts * WEEK_PER_MONTH

        // year costs

        //eCarYearCosts = avgEmonthCosts * MONTHS_IN_YEAR

        //********end electric car formulas***********

//*********Begin gas car formulas***********
        //how to calculate the avg per week cost for gas;
        //how many miles we drive in a week / miles per gallon * cost per gallon;

// how to calculate avg cost per month for payment and gas;
        //avgGasMonthlyCosts = weekly gas cost * WEEKS_PER_MONTH * gasMonthlyPayment;

        //use 4.3 as an average of weeks per month for our calculations (OUR CONSTANT);

        //formula for avg cost/year for payment and gas ;
        //avgGasCarMonthlyCosts * MONTHS_IN_YEAR;
        //**********End gas car formulas***********

        //************COMPARISON RESULTS***************
        //saving/costs per month = electric monthly costs - gas monthly costs
        //savings/costs per year = electric monthly costs - gas monthly costs














    } //end main method
public static double calculateWeeklyConsumptionCosts(double weeklyMiles, double avgMilesRating, double gasGallonCosts){
        //calculation to return the weekly gas costs
    double weeklyGallons = weeklyMiles / avgMilesRating;
    double weeklyGasCosts = weeklyGallons * gasGallonCosts;
    //this will return the calculation back to the user
    return weeklyGasCosts;






}//ends our calculateWeeklyConsumptionCosts

    public static double calculateWeeklyElectricConsumptionCosts(double weeklyMiles, double avgElectricMilesRating){
        //calculation to return the weekly electric costs
        double weeklyElectricCosts = weeklyMiles * avgElectricMilesRating;
        //this will return the calculation back to the user
        return weeklyElectricCosts;






    }//ends our calculateWeeklyElectricConsumptionCosts



} //end main class