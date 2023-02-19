import java.util.Scanner;
import loans.HousingLoan;
import plans.RegularPlanEmi;

public class Main {
    public final static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the friendly housing loan calculation app!");
        System.out.println("Please enter the amount you need:");
        int amount = scanner.nextInt();
        System.out.println("Please enter the payback time in years:");
        int duration = scanner.nextInt();

        var housingloan = new HousingLoan(3.5, new RegularPlanEmi());
        housingloan.prepareInstallmentSchedule(amount, duration);
        housingloan.printScheduleCompact();
    }
}
