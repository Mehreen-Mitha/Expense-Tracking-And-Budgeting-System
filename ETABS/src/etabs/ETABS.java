package etabs;
import java.util.*;
import java.io.*;
public class ETABS
{
    static final int MAX = 100; //specifying size
    /*arrays for storing data, 
    they are outside main method because these values need to be used in multiple methods*/
    static String[] description = new String[MAX];
    static double[] amount = new double[MAX];
    static String[] category = new String[MAX];
    static String[] date = new String[MAX];
    
    //number of expenses initialized
    static int count = 0;
    
    static double monthlyIncome;
    static double yearlyIncome;
    
    static Scanner input = new Scanner (System.in);
    
    public static void main(String[] args) 
    {
        
        //display welcome and user information
        System.out.println("\n================================\n       WELCOME TO ETABS");
        System.out.println("\n     turn chaos into cash\n================================");
        System.out.print("Enter Your Name: ");
            String N = input.nextLine();
        System.out.print("Enter Your Occupation: ");
            String O = input.nextLine();
        System.out.print("Input Your Monthly Income: ");
            monthlyIncome = input.nextDouble();
            yearlyIncome = monthlyIncome * 12;
        System.out.println("\n====================");
        System.out.println("     USER INFO");
        System.out.println("====================");
        System.out.println("Name: "+N);
        System.out.println("Occupation: "+O);
        System.out.println("Monthly Income: "+monthlyIncome);
        System.out.println("Yearly Income: "+yearlyIncome);

        int choice;
        do{
            
            //displaying main menu
            System.out.println("\n====================");
            System.out.println("     MAIN MENU");
            System.out.println("====================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Summary");
            System.out.println("4. Revenue");
            System.out.println("5. Necessary Expenses");
            System.out.println("6. Budgeting");
            System.out.println("7. Financial Advice");
            System.out.println("8. File Handling");
            System.out.println("9. Exit");
            System.out.print("\nSelect an option by its number: ");
                    
                while(true){
                    try{
                        choice=input.nextInt();
                        input.nextLine();
                        break;
                    } catch(InputMismatchException e){
                        System.out.println("\n** INVALID INPUT **");
                        System.out.println("Enter a number between 1 and 9.");
                        input.nextLine();
                    }
                }
                    
            //using switch to proccess the users choice 
            switch(choice){
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewSummary();
                    break;
                case 4:
                    revenue();
                    break;
                case 5:
                    necessaryExpenses();
                    break;
                case 6:
                    budgeting();
                    break;
                case 7:
                    financialAdvice();
                    break;
                case 8:
                    fileHandling();
                    break;
                case 9:
                    System.out.println("Be wise with your finances! Goodbye!");
                    break;
                default:
                    System.out.println("\n** INVALID CHOICE **");
                    System.out.println("Try Again...");
            }
        }while(choice!=9);
    }   
    
    
    //ADD EXPENSE CHOICE
    public static void addExpense(){
        
        if(count>=MAX) 
        {
            System.out.println("** MAXIMUM LIMIT REACHED **");
            return;
        }
        
        System.out.println("\n=====================");
        System.out.println("     ADD EXPENSE");
        System.out.println("=====================");
        
        input.nextLine();
        System.out.print("Enter Description: ");
                description[count] = input.nextLine();
                
        //exception handling for wrong input
        while(true){
            try{
                System.out.print("Enter Amount: ");
                    amount[count] = input.nextDouble();
                    input.nextLine();
                break;
            }
            catch(InputMismatchException ex){
                System.out.println("\n** INVALID INPUT **");
                System.out.println("Enter amount again...\n");
                input.nextLine();
            }
        }
        
        System.out.println("Enter Category (housing, utilities, groceries, healthcare, dining, entertainment, shopping, travel, miscellaneous): ");
                category[count] = input.nextLine().toLowerCase().trim();
                
        System.out.print("Enter the Date (DD-MM-YYYY): ");
                date[count] = input.nextLine();
                
        count++; //keeping track of how many expenses have been added so far
        System.out.println("** EXPENSE ADDED SUCCESSFULLY **");
    }
    
    
    //VIEW EXPENSE CHOICE
    public static void viewExpenses(){
        System.out.println("\n=======================");
        System.out.println("     VIEW EXPENSES");
        System.out.println("=======================");
        
        if(count==0){
            System.out.println("** NO EXPENSE RECORDED **");
            return;
        }
        
        System.out.println("1. Added Latest To Oldest");
        System.out.println("2. Added Oldest To Latest");
        System.out.println("Enter your pick to view (1 or 2): ");
            int pick=input.nextInt();
        switch(pick){
            case 1:
                System.out.println("\n");
                System.out.printf("%-20s %-10s %-16s %-14s%n", "Description", "Amount", "Category", "Date");
                System.out.println("\n---------------------------------------------------------------------");
                for(int i=count-1; i>=0; i--){
                    System.out.printf("%-20s %-10.2f %-16s %-14s%n",description[i],amount[i],category[i],date[i]);
                }
                break;
            case 2:
                System.out.println("\n");
                System.out.printf("%-20s %-10s %-16s %-14s%n", "Description", "Amount", "Category", "Date");
                System.out.println("\n----------------------------------------------------------------");
                for(int i=0; i<count; i++){
                   System.out.printf("%-20s %-10.2f %-16s %-14s%n",description[i],amount[i],category[i],date[i]);
                }
                break; 
            default:
                System.out.println("** INVALID PICK **");
        }
    }
    
    
    //VIEW SUMMARY CHOICE
    public static void viewSummary(){
        //checks if expenses were added or not
        if(count==0){
            System.out.println("** NO EXPENSES RECORDED **");
            return;//exits the method because theres nothing to summarize
        }
            System.out.println("\n=================");
            System.out.println("     SUMMARY");
            System.out.println("=================");
            System.out.println("1. Overall");
            System.out.println("2. Monthly");
            System.out.println("3. Yearly");
            System.out.println("Choose a number to proceed (1, 2 or 3): ");
                int op;
                while(true){
                    try{
                        op=input.nextInt();
                        input.nextLine();
                        break;
                    } catch(InputMismatchException e){
                        System.out.println("\n** INVALID INPUT **");
                        System.out.println("Enter a number between 1 and 3.");
                        input.nextLine();
                    }
                }
            
            //Overall Summary
            if(op==1){
                double total=0;
                double highest=amount[0];
                double lowest=amount[0];
                double housing=0, utilities=0, groceries=0, healthcare=0, dining=0, entertainment=0, shopping=0, travel=0, miscellaneous=0;
                
                for(int i=0; i<count; i++){
                    double a= amount[i];
                    total+=a;
                    if(a>highest)
                        highest=a;
                    if(a<lowest)
                        lowest=a;
                    switch(category[i]){
                        case "housing":
                            housing+=a;
                            break;
                        case "utilities":
                            utilities+=a;
                            break;
                        case "groceries":
                            groceries+=a;
                            break;
                        case "healthcare":
                            healthcare+=a;
                            break;
                        case "dining":
                            dining+=a;
                            break;
                        case "entertainment":
                            entertainment+=a;
                            break;
                        case "shopping":
                            shopping+=a;
                            break;
                        case "travel":
                            travel+=a;
                            break;
                        case "miscellaneous":
                            miscellaneous+=a;
                            break;
                    }
                }
            System.out.println("\n=========================");
            System.out.println("     OVERALL SUMMARY");
            System.out.println("=========================");
            System.out.println("Total Expenses: "+total);
            System.out.println("Highest Expense: "+highest);
            System.out.println("Lowest Expense: "+lowest);
            System.out.println("\n--- CATEGORY WISE ---");
                System.out.println("Housing: "+housing);
                System.out.println("Utilities: "+utilities);
                System.out.println("Groceries: "+groceries);
                System.out.println("Healthcare: "+healthcare);
                System.out.println("Dining: "+dining);
                System.out.println("Entertainment: "+entertainment);
                System.out.println("Shopping: "+shopping);
                System.out.println("Travel: "+travel);
                System.out.println("Miscellaneous: "+miscellaneous);
            }
            
            
            //monthly summary
            else if(op==2){
                System.out.println("Enter month (1 to 12): ");
                    int month=input.nextInt();
                    input.nextLine();
                if(month<1 || month>12){
                    System.out.println("\n** INVALID MONTH INPUT **");
                    return;
                }
                double total=0;
                double highest=0;
                double lowest=0;
                double housing=0, utilities=0, groceries=0, healthcare=0, dining=0, entertainment=0, shopping=0, travel=0, miscellaneous=0;
                boolean monthContainsExpenses=false; //to track if expense exists in the specified month
                for(int i=0; i<count; i++){
                    String[] parts=date[i].split("-");
                    int validMonth=Integer.parseInt(parts[1]); //takes the month part from the date and converts into integer
                    if(validMonth==month){
                        double a= amount[i];
                        total+=a;
                        //when a is the first and only expense in the specified month
                        if(!monthContainsExpenses){
                            highest=a;
                            lowest=a;
                            monthContainsExpenses=true;
                        }
                        //when there are multiple expenses
                        else{
                            if(a>highest)
                                highest=a;
                            if(a<lowest)
                                lowest=a;
                        }
                        switch(category[i]){
                            case "housing":
                                housing+=a;
                                break;
                            case "utilities":
                                utilities+=a;
                                break;
                            case "groceries":
                                groceries+=a;
                                break;
                            case "healthcare":
                                healthcare+=a;
                                break;
                            case "dining":
                                dining+=a;
                                break;
                            case "entertainment":
                                entertainment+=a;
                                break;
                            case "shopping":
                                shopping+=a;
                                break;
                            case "travel":
                                travel+=a;
                                break;
                            case "miscellaneous":
                                miscellaneous+=a;
                                break;
                        }
                    }    
                }
                System.out.println("\n=========================");
                System.out.println("     MONTHLY SUMMARY");
                System.out.println("=========================");
                String [] monthName = {"January", "February", "March", "April", "May", "June",
                                      "July", "August", "September", "October", "November", "December"};
                System.out.println("Month: "+monthName[month-1]);
                System.out.println("Total Expenses: "+total);
                System.out.println("Highest Expense: "+highest);
                System.out.println("Lowest Expense: "+lowest);
                System.out.println("\n--- CATEGORY WISE ---");
                System.out.println("Housing: "+housing);
                System.out.println("Utilities: "+utilities);
                System.out.println("Groceries: "+groceries);
                System.out.println("Healthcare: "+healthcare);
                System.out.println("Dining: "+dining);
                System.out.println("Entertainment: "+entertainment);
                System.out.println("Shopping: "+shopping);
                System.out.println("Travel: "+travel);
                System.out.println("Miscellaneous: "+miscellaneous);
                
                //when no expense exists in the specified month
                if(!monthContainsExpenses){
                        System.out.println("\n** NO EXPENSES RECORDED THIS MONTH **");
                    }
            }
   
            
            //yearly summary
            else if(op==3){
                System.out.println("Enter year: ");
                    int year=input.nextInt();
                    input.nextLine();
                double total=0;
                double highest=0;
                double lowest=0;
                double housing=0, utilities=0, groceries=0, healthcare=0, dining=0, entertainment=0, shopping=0, travel=0, miscellaneous=0;
                boolean yearContainsExpenses=false; //to track if expense exists in the specific year
                for(int i=0; i<count; i++){
                    String[] parts=date[i].split("-");
                    int validYear=Integer.parseInt(parts[2]); //takes the year part from the date and converts into integer
                    if(validYear==year){
                        double a= amount[i];
                        total+=a;
                        
                        //when a is the first and only expense in the specific year
                        if(!yearContainsExpenses){
                            highest=a;
                            lowest=a;
                            yearContainsExpenses=true;
                        }
                        
                        //when there are multiple expenses
                        else{
                            if(a>highest)
                                highest=a;
                            if(a<lowest)
                                lowest=a;
                        }
                        switch(category[i]){
                            case "housing":
                                housing+=a;
                                break;
                            case "utilities":
                                utilities+=a;
                                break;
                            case "groceries":
                                groceries+=a;
                                break;
                            case "healthcare":
                                healthcare+=a;
                                break;
                            case "dining":
                                dining+=a;
                                break;
                            case "entertainment":
                                entertainment+=a;
                                break;
                            case "shopping":
                                shopping+=a;
                                break;
                            case "travel":
                                travel+=a;
                                break;
                            case "miscellaneous":
                                miscellaneous+=a;
                                break;
                        }
                    }    
                }
                System.out.println("\n========================");
                System.out.println("     YEARLY SUMMARY");
                System.out.println("========================");
                System.out.println("Year: "+year);
                System.out.println("Total Expenses: "+total);
                System.out.println("Highest Expense: "+highest);
                System.out.println("Lowest Expense: "+lowest);
                System.out.println("\n--- CATEGORY WISE ---");
                System.out.println("Housing: "+housing);
                System.out.println("Utilities: "+utilities);
                System.out.println("Groceries: "+groceries);
                System.out.println("Healthcare: "+healthcare);
                System.out.println("Dining: "+dining);
                System.out.println("Entertainment: "+entertainment);
                System.out.println("Shopping: "+shopping);
                System.out.println("Travel: "+travel);
                System.out.println("Miscellaneous: "+miscellaneous);
                
                //when no expense exists in the specific year
                if(!yearContainsExpenses){
                        System.out.println("\n** NO EXPENSES RECORDED THIS YEAR **");
                    }
            }
            
            else{
                System.out.println("** INVALID CHOICE **");
            }
    }
    
    
    //REVENUE CHOICE
    public static void revenue(){
        System.out.println("\n=================");
        System.out.println("     REVENUE");
        System.out.println("=================");
        
        double totalExpenses=0;
        for(int i=0; i<count; i++){
            totalExpenses+=amount[i];
        }
        
        System.out.println("Enter month (1-12): ");
            int month=input.nextInt();
            
        double totalMonthlyExpenses=0;
        for(int i=0; i<count; i++){
            String[] parts=date[i].split("-");
            int expenseMonth = Integer.parseInt(parts[1]);
            if(expenseMonth==month){
                totalMonthlyExpenses+=amount[i];
            }
        }
        
        //calculating monthly income that remains after spending
        double remainingMonthlyIncome=monthlyIncome-totalMonthlyExpenses;
        //calculating yearly income that remains after spending
        double remainingYearlyIncome=yearlyIncome-totalExpenses;
        System.out.println("\nTotal Expenses This Month: " +totalMonthlyExpenses);
        System.out.println("Remaining Monthly Income: " +remainingMonthlyIncome);
        System.out.println("Total Expenses Overall: "+totalExpenses);
        System.out.println("Remaining Yearly Income: "+remainingYearlyIncome);
        
        if(remainingMonthlyIncome<0)
            System.out.println("\n** WARNING **\nYou are in loss, no profit is being made with your monthly income.");
        if(remainingYearlyIncome<0)
            System.out.println("\n** WARNING **\nYou are in loss, no profit is being made with your yearly income.");
    }
    
    
    //NECESSARY EXPENESES CHOICE
    public static void necessaryExpenses(){
        System.out.println("\n============================");
        System.out.println("     NECESSARY EXPENSES");
        System.out.println("============================");
        System.out.println("\n1. Taxes");
        System.out.println("2. Zakat");
        
        System.out.println("Pick an option (1 or 2): ");
        int op=input.nextInt();
        
        if(op==1){
            double taxRatePerMonth = 0.02; //2%
                    double monthlyTax = monthlyIncome*taxRatePerMonth;
                    double yearlyTax = monthlyTax*12;
            System.out.println("\nMonthly Tax : " + monthlyTax);
            System.out.println("Yearly Tax : " + yearlyTax);
        }
        
        else if(op==2){
            double zakat=yearlyIncome*0.025; //2.5%
            System.out.println("\nZakat Per Year: " +zakat);
        }
        
        else{
            System.out.println("** INVALID CHOICE **");
        } 
    }
    
    
    //BUDGETTING CHOICE
    public static void budgeting(){
        System.out.println("\n====================");
        System.out.println("     BUDGETING");
        System.out.println("====================");
    
        System.out.println("Set your Monthly Budget: ");
            double monthlyBudget = input.nextDouble();
            double dailyBudget = monthlyBudget/30;
        
        System.out.println("Enter month (1-12) to evaluate spending: ");
            int month = input.nextInt();
        if(month<1 || month>12){
            System.out.println("** INVALID MONTH** ");
            return;
        }
        
        //calculating total spendings for specific month
        double monthlySpending = 0;
        for(int i=0; i<count; i++){
            String[] parts = date[i].split("-");
            int expenseMonth = Integer.parseInt(parts[1]);
            if (expenseMonth==month){
                monthlySpending+=amount[i];
            }
        }
        double dailySpent = monthlySpending/30;
        
        System.out.println("\n=== Budget Summary ===");
        System.out.println("Monthly Budget: "+monthlyBudget);
        System.out.println("Actual Monthly Spending: "+monthlySpending);
        System.out.println("Ideal Daily Budget: "+String.format("%.2f", dailyBudget));
        System.out.println("Actual Daily Spending: "+String.format("%.2f", dailySpent));
    
        if(dailySpent>dailyBudget){
            System.out.println("\nCONCLUDING WORDS:\nYour budget called, it said its on life support.\nGet a grip on your spendings.");
        }
        
        else if(dailySpent<dailyBudget){
            System.out.println("\nCONCLUDING WORDS:\nGoodjob, you're saving. o-o");
        } 
        
        else {
            System.out.println("\nCONCLUDING WORDS:\nPerfect! You’re right on track today! \nBudget wizard status unlocked!");
        }
    }
    
    
    //FINANCIAL ADVICE
    static void financialAdvice(){
        if(count==0)
        {
            System.out.println("** NO EXPENSES RECORDED **");
            return;
        }
        
        //category totals
        double housing=0,
                utilities=0,
                groceries=0,
                healthcare=0,
                dining=0,
                entertainment=0,
                shopping=0,
                travel=0,
                miscellaneous=0;
        
        //calculate totals per category
        for(int i=0;i<count;i++)
        {
            double a= amount[i];
            switch(category[i])
            {
                case "housing": 
                {housing+=a;
                    break;}
                case "utilities": 
                {utilities+=a;
                    break;}
                case "groceries": 
                {groceries+=a;
                    break;}
                case "healthcare": 
                {healthcare+=a;
                    break;}
                case "dining": 
                {dining+=a;
                    break;}
                case "entertainment": 
                {entertainment+=a;
                    break;}
                case "shopping": 
                {shopping+=a;
                    break;}
                case "travel": 
                {travel+=a;
                    break;}
                case "miscellaneous": 
                {miscellaneous+=a;
                    break;}
            }
        }
        
        //finding highest spending category
        String highestCategory="housing"; //giving a default value
        double highestAmount= housing;
        
        if(utilities>highestAmount)
        {
            highestAmount=utilities; 
            highestCategory="utilities";
        }
        if(groceries>highestAmount)
        {
            highestAmount=groceries; 
            highestCategory="groceries";
        }
        if(healthcare>highestAmount)
        {
            highestAmount=healthcare; 
            highestCategory="healthcare";
        }
        if(dining>highestAmount)
        {
            highestAmount=dining; 
            highestCategory="dining";
        }
        if(entertainment>highestAmount)
        {
            highestAmount=entertainment; 
            highestCategory="entertainment";
        }
        if(shopping>highestAmount)
        {
            highestAmount=shopping; 
            highestCategory="shopping";
        }
        if(travel>highestAmount)
        {
            highestAmount=travel; 
            highestCategory="travel";
        }
        if(miscellaneous>highestAmount)
        {
            highestAmount=miscellaneous; 
            highestCategory="miscellaneous";
        }
        System.out.println("\n============================");
        System.out.println("     FINANCIAL ADVICE");
        System.out.println("============================");
        System.out.println("You spent most of your money(among all categories) on: " +highestCategory+" ("+highestAmount+")");
        
        //advice for each category
        switch(highestCategory)
        {
            case "housing": 
                System.out.println("Try negotiating rent or reducing utility usage to save more.");
                break;
            case "utilities": 
                System.out.println("Reduce electricity and water consumptions to cut down costs.");
                break;
            case "groceries": 
                System.out.println("Make a weekly shopping list and avoid unnecessary items.");
                break;
            case "healthcare": 
                System.out.println("Health comes first, but compare prices before treatment");
                break;
            case "dining": 
                System.out.println("Reduce dining out and eat home cooked meals");
                break;
            case "entertainment": 
                System.out.println("Limit unnecessary subscriptions and outings.");
                break;
            case "shopping": 
                System.out.println("Avoid impulse buying and ask yourself if you really need it.");
                break;
            case "travel": 
                System.out.println("Plan trips in advance and look for discount deals.");
                break;
            case "miscellaneous": 
                System.out.println("Track your small expenses they add up quickly!");
                break; 
        }
    }
    
    
    //FILE HANDLING
    static void fileHandling(){
        System.out.println("\n=======================");
        System.out.println("     FILE HANDLING");
        System.out.println("=======================");
        System.out.println("1. Save To File");
        System.out.println("2. Load From File");
        
        System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
        
        switch(choice){
            
            case 1:
                try{
                    OutputStream os = new FileOutputStream ("Expenses.txt");
                    PrintWriter writer = new PrintWriter (os);
                    for (int i=0; i<count; i++){
                        writer.write(date[i]+", "+amount[i]+", "+category[i]+", "+description[i]+"\n");
                    }
                    writer.close();
                    System.out.println("\n** SUCCESS : Expenses Have Been Saved To File **");
                }
                catch(IOException e){
                    System.out.println("** ERROR **");
                }
                break;
                
            case 2:
                try{
                    InputStream is = new FileInputStream ("Expenses.txt");
                    Scanner reader = new Scanner (is);
                    count=0;
                    while((reader.hasNextLine()) && (count<MAX)){
                        String line = reader.nextLine();
                        String [] data = line.split(", ");
                        if(data.length==4){
                            date[count]=data[0].trim();
                            amount[count]=Double.parseDouble(data[1].trim());
                            category[count]=data[2].trim();
                            description[count]=data[3].trim();
                            count++;
                        }
                    }
                    reader.close();
                    System.out.println("\n** SUCCESS : Expenses Have Been Loaded **");
                }
                catch(IOException e){
                    System.out.println("** ERROR **");
                }
                break;
            default:
                System.out.println("** INVALID CHOICE **");
        }
    }
}