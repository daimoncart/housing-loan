package plans;

import installments.Installment;
import java.util.List;

public interface InstallmentPlanType {
    List<Installment> createInstallmentSchedule(
        double principalAmount, int duration, double interest, PeriodType periodType
    );
}
