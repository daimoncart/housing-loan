package loans;

import plans.PeriodType;

public interface LoanType {
    void prepareInstallmentSchedule(int principalAmount, int duration);
    void printScheduleCompact();
}
