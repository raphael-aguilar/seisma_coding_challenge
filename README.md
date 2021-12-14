### Project Now Dockerised

Use the below commands to run the project using docker.

`docker build -t <image_name> .`
`docker run -p 8080:8080 <image_name>`

### **New Info After Refactor**

This project has been refactored to work with Spring Boot, and works by running the Spring Boot application and using a get request on this endpoint `http://localhost:8080/api/v1/payslip`

You will need to fill in the body to calculate the information of one payslip. To get a proper response, here is a sample body to use and manipulate:
`{
"firstname": "John",
"lastname": "Smith",
"annual salary": "18400",
"super rate": "50",
"payment start date": "01 March – 31 March"
}`

The old functionality of running the program with an input csv still exists but doesn't interfere with the Spring Boot application.

### **How to Run**

You will need Java 11 installed and maven (I used maven 3.8.1).

This program is run with an input CSV and generates and output csv, therefore an input CSV will be needed.
A sample file is in the root directory to use, and to base any other created CSVs off of.

In the root directory, build the package with command `mvn package`. This will run the test and compile to a JAR file allowing you to run.

Run the program from the root directory in a command line using `java -cp target\<created jar file> com.payslip.App <optional_input_name> <optional_output_name>`
(note your command line java will need to be version 11). 
The input name by default is input.csv, and the output by default is output.csv and both of these values are optional.

After running this will generate the output CSV of the payment slip information.

### **Assumptions**

* Assume all inputs are whole numbers

* Gross income is to always be rounded down

* Payment period is always one month

* All input data is valid

* Input super rate has % at end to remove

* Input csv always has a header row

* Assume csv input is delimited by a single "," with no spaces

### **Design Choices**

The main design choice was to create a Price class to be used instead of a double or float.
This was done to keep precision since both doubles or floats may lose precision after many operations are performed on them.

###### **Thanks for taking time to look at my submission!**

