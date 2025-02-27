
---

# **Shahar Asher - Expression Evaluation Project**

This project provides a framework for handling basic mathematical operations on variables, supporting operations like addition, subtraction, multiplication, and division. It includes an expression evaluation system where users can define variables, set values, and perform calculations. The project is implemented in Java with unit tests for verifying the functionality of each component.

[![LICENSE](https://img.shields.io/badge/license-MIT-yellow.svg)](./LICENSE)

## **Table of Contents**

1. [About](#about)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Project Structure](#project-structure)
6. [Testing](#testing)
7. [License](#license)

## **About**

This project is designed to evaluate mathematical expressions involving variables and basic arithmetic operations. It includes the following features:
- Define variables with names and values.
- Perform arithmetic operations: addition, subtraction, multiplication, division, etc.
- Print the result of variable evaluations in a formatted output.
- Validate variable names and handle edge cases.
- A set of unit tests to verify the functionality of the system.

## **Features**

- **Basic Operations**: Supports addition, subtraction, multiplication, and division for variable expressions.
- **Variable Management**: Allows the creation, manipulation, and validation of variables (e.g., "x", "y").
- **Expression Evaluation**: Computes expressions involving variables and arithmetic operators.
- **Print Output**: Outputs the result of operations in a user-friendly format.
- **Edge Case Handling**: Validates variable names, handles large values, negative numbers, and more.

## **Installation**

This project uses Maven to handle dependencies. To build the project, make sure you have Maven installed. If you don't have Maven, you can follow the installation instructions on the [official website](https://maven.apache.org/install.html).

Once Maven is installed, you can use the following command to build the project:

```bash
mvn clean install
```

## **Usage**

### **Running the Project**

1. **Run the project** using the command line by passing input and output file arguments (optional):

    - Input file (`-in`): Specifies the input file path (e.g., contains variables and expressions).
    - Output file (`-out`): Specifies the output file path where results will be written.


**Example for arguments-vectors:** `-in <input-file-path> -out <output-file-path>`

**Note**: `If no input or output file is provided, the program defaults to reading from the console and writing to the console.`

---

### **Controller Workflow**

1. **VectorParser** processes the command-line arguments to retrieve the input and output paths.
2. **Controller** handles reading the input, processing calculations, and printing the results.
    - If an input file is provided, it will be read.
    - If no input file is provided, the program will prompt for console input.

### **Example Input/Output:**

- Input:
  ```text
  x = 5
  y = 10
  z = x + y
  ```

- Output:
  ```text
  (x = 5, y = 10, z = 15)
  ```

---

## **Project Structure**

```
├───
├── src/
│   ├── shaharas/
│   │   ├── Add.java
│   │   ├── AddEQL.java              
│   │   ├── AddOneLeft.java          
│   │   ├── AddOneRight.java
│   │   ├── BaseBinaryOperators.java
│   │   ├── BaseOperators.java
│   │   ├── BaseUnaryOperators.java
│   │   ├── CloseParen.java
│   │   ├── Controller.java
│   │   ├── Div.java
│   │   ├── DivEQL.java
│   │   ├── DivEQL.java
│   │   ├── Equal.java
│   │   ├── Expression.java
│   │   ├── InRead.java
│   │   ├── Main.java
│   │   ├── Mul.java
│   │   ├── MulEQL.java
│   │   ├── OpenParen.java
│   │   ├── OperatorInfo.java
│   │   ├── Operators.java
│   │   ├── OperatorsFactory.java
│   │   ├── OutPrint.java
│   │   ├── PatternUtils.java
│   │   ├── PrintOutputConsole.java
│   │   ├── PrintOutputFile.java
│   │   ├── ReadInputConsole.java
│   │   ├── ReadInputFile.java
│   │   ├── Sub.java
│   │   ├── SubEQL.java
│   │   ├── SubOneLeft.java
│   │   ├── SubOneRight.java
│   │   ├── Utilities.java
│   │   ├── VariableEXP.java
│   │   └── VectorParser.java
│   └── resources/
├── test/
│   └── shaharas/
│       ├── BoundaryTest.java
│       ├── CalculatorTest.java
│       ├── EdgeCasesTest.java
│       ├── FileOperationsTest.java
│       ├── IncrementDecrementTest.java
│       ├── IntegrationTest.java
│       ├── MainTest.java
│       ├── OperatorsFactoryTest.java
│       ├── OperatorsTest.java
│       ├── PerformanceTest.java
│       ├── PrintOutputConsoleTest.java
│       └── VariableEXPTest.java
├── pom.xml
```

---

## **Testing**

### **Unit Tests**

Unit tests are written using JUnit 5. To run the tests:

```bash
mvn test
```

### **Performance Testing**

A performance test is included to evaluate the handling of a large number of operations. The system should complete within a reasonable time frame (less than 2 seconds).

### **License**

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.

---
