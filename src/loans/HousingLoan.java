package loans;

import installments.Installment;
import java.util.List;
import plans.InstallmentPlanType;
import plans.PeriodType;

public class HousingLoan implements LoanType {
    private double interest;
    private InstallmentPlanType paymentPlan;
    private List<Installment> schedule;

    public HousingLoan(double interest, InstallmentPlanType paymentPlan) {
        this.interest = interest;
        this.paymentPlan = paymentPlan;
    }

    @Override
    public void prepareInstallmentSchedule(int principalAmount, int duration) {
        schedule = paymentPlan.createInstallmentSchedule(principalAmount, duration, interest, PeriodType.YEARS);
    }

    @Override
    public void printScheduleCompact() {
        if (schedule == null || schedule.size() < 2) {
            System.out.println("Please prapare a proper installment plan first.");
            return;
        }
        var scale = 2;
        System.out.println("********** INSTALLMENT PLAN ***********");
        System.out.println(String.format(
            "First payment - %s : %sEUR",
            schedule.get(0).getDate(),
            schedule.get(0).getAmount().setScale(scale)
            ));
        System.out.println(String.format(
            "Second payment - %s : %sEUR",
            schedule.get(1).getDate(),
            schedule.get(1).getAmount().setScale(scale)
        ));
        System.out.println("-----------");
        System.out.println(String.format(
            "Last payment - %s : %sEUR",
            schedule.get(schedule.size()-1).getDate(),
            schedule.get(schedule.size()-1).getAmount().setScale(scale)
        ));
    }
}
