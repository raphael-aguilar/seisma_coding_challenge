package com.application.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/payslip")
public class PayslipController {

    @GetMapping
    public String getPayslip(@RequestBody Map<String, String> input) {

        String firstName = input.get("firstname");
        String lastname = input.get("lastname");
        int annualSalary = Integer.parseInt(input.get("annual salary"));
        double superRate = Double.parseDouble((input.get("super rate")));
        String paymentStartDate = input.get("payment start date");

        Employee employee =  new Employee(firstName, lastname, annualSalary, superRate, paymentStartDate);
        employee.calculateValues();
        return employee.toJson().toJSONString();
    }
}
