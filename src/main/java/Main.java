import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String OUTPUT_HEADER = "name, pay period, gross income, income tax, net income, super";

    public static void main(String[] args) {

        String inputFile;
        String outputFile;
        if (args.length == 0) {
            System.out.println("Choosing default input file");
            inputFile = "input.csv";
        } else {
            inputFile = args[0];
        }
        if (args.length > 1) {
            outputFile = args[1];
        } else {
            outputFile = "output.csv";
        }

//        Read in CSV
        List<Employee> employees = readInEmployees(inputFile);

//        Put line to output csv
        writeOutput(outputFile, employees);

    }

    private static List<Employee> readInEmployees(String inputFile) {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
            // CSV file delimiter
            String DELIMITER = ",";

//            Don't need to read CSV header
            br.readLine();

            // read the file line by line
            String line;
            while ((line = br.readLine()) != null) {

                // convert line into columns
                String[] columns = line.split(DELIMITER);

                String firstName = columns[0];
                String lastName = columns[1];
                int annualSalary = Integer.parseInt(columns[2]);
                double superRate = Double.parseDouble(columns[3].substring(0, columns[3].length() - 1));
                String paymentPeriod = columns[4];

                employees.add(new Employee(firstName, lastName, annualSalary, superRate, paymentPeriod));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public static void writeOutput(String outputFile, List<Employee> employees) {
        try {
            FileWriter myWriter = new FileWriter(outputFile);

            myWriter.write(OUTPUT_HEADER + '\n');

            for (Employee employee : employees) {
                employee.calculateValues();
                myWriter.write(employee.toOutputLine() + '\n');
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
