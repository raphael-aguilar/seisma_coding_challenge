import com.payslip.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void toOutputLine() {

        Employee test1 = new Employee("Monica", "Tan", 60050, 9d, "01 March – 31 March");
        test1.calculateValues();
        String output1 = "Monica Tan,01 March – 31 March,5004,922,4082,450";

        Employee test2 = new Employee("Brend", "Tulu", 120000, 10d, "01 March – 31 March");
        test2.calculateValues();
        String output2 = "Brend Tulu,01 March – 31 March,10000,2669,7331,1000";

        assertAll(
                () -> assertEquals(output1, test1.toOutputLine()),
                () -> assertEquals(output2, test2.toOutputLine())
        );

    }
}