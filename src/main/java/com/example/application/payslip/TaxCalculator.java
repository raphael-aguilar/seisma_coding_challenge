package com.example.application.payslip;

import java.util.List;

public class TaxCalculator {

    private static final int firstBracket = 18200;
    private static final int secondBracket = 37000;
    private static final int thirdBracket = 87000;
    private static final int fourthBracket = 180000;

    private static final int thirdBracketBase = 3572;
    private static final int fourthBracketBase = 19822;
    private static final int fifthBracketBase = 54232;

    public static Price calculateTax(int salary) {

        Price incomeTax = new Price();

        List<TaxBracket> brackets = TaxBrackets.getInstance().getBrackets();

        for (int i = brackets.size() - 1; i >= 0; i--) {
            if (salary >= brackets.get(i).getMinIncome()) {
                int minIncome = brackets.get(i).getMinIncome();
                int baseTax = brackets.get(i).getBaseTax();
                double additionalTax = brackets.get(i).getAdditionalTax();

                int taxableIncome = salary - minIncome;
                incomeTax.addDollars(baseTax);
                incomeTax.addCents((int)additionalTax*taxableIncome);
                return incomeTax;
            }
        }
        return incomeTax;
//        if (salary > firstBracket) {
//            if (salary <= secondBracket) {
//                int taxableSalary = salary - firstBracket;
//                incomeTax.addCents(19*taxableSalary);
//            } else if (salary <= thirdBracket) {
//                incomeTax.addDollars(TaxCalculator.thirdBracketBase);
//                int taxableSalary = salary - secondBracket;
//                incomeTax.addCents((int) (taxableSalary*32.5));
//            } else if (salary <= fourthBracket) {
//                incomeTax.addDollars(TaxCalculator.fourthBracketBase);
//                int taxableSalary = salary - thirdBracket;
//                incomeTax.addCents((taxableSalary*37));
//            } else {
//                incomeTax.addDollars(TaxCalculator.fifthBracketBase);
//                int taxableSalary = salary - fourthBracket;
//                incomeTax.addCents((taxableSalary*45));
//            }
//        }
//        return incomeTax;
    }


}
