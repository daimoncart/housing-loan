package plans;

import installments.Installment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RegularPlanEmi implements InstallmentPlanType {
    private List<Installment> plan = new ArrayList<>();
    private LocalDate firstInstallmentDate = LocalDate.now().plusMonths(1);

    @Override
    public List<Installment> createInstallmentSchedule(
        double principalAmount, int duration, double interest, PeriodType period
    ) {
        var durationInMonths = period == PeriodType.MONTHS ? duration : duration * 12;
        var montlyInstallment = Utils.calculateEmi(principalAmount, durationInMonths, interest);
        IntStream.range(0, durationInMonths)
            .forEach( i -> plan.add(new Installment(firstInstallmentDate.plusMonths(i), montlyInstallment)));
        return plan;
    }
}
