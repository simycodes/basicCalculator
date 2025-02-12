// GET THE SCANNER FROM THE LIBRARY
import java.util.Scanner


fun main() {
    // Var variable is Mutable - variable can be changed later in the program
    // Var variable is Immutable - cannot be changed once the value is assigned
    var selectedOption: Int
    val welcomeMessage = WelcomeMessage()
    println(welcomeMessage.displayWelcomeMessage())

    // CONTINUOUS MENU WITH A LOOP
    do {
        // CREATE THE SCANNER TO ALLOW SELECTED OPTION INPUT
        val selectedOptionScanner = Scanner(System.`in`)

        // GET INPUT FROM THE USER
        displayMenu()
        selectedOption = selectedOptionScanner.nextInt()

        // VERIFY INCOMING DATA FOR OPTIONS RANGES
        selectedOption = when {
            selectedOption <= 0 || selectedOption > 100 -> 3
            else -> selectedOption
        }

        // MOVE/SWITCH BETWEEN THE OPTIONS
        when (selectedOption) {
            1 -> {
                // MAKE THE CALCULATION
                doTheCalculation()
            }

            2 -> {
                // CLOSE THE CALCULATOR APP
                println("Closing calculator.....")
                println("BASIC CALCULATOR CLOSED! - Run App Again To Use The BASIC CALCULATOR!")
                selectedOptionScanner.close()
            }

            3 -> println("####--- Invalid Option - Select a Valid Option Between 1 and 3, Thanks - Try Again.\n ---####")
            else -> println("####--- Invalid Option - Select a Valid Option Between 1 and 2, Thanks - Try Again.\n ---####")

        }

    } while (selectedOption != 2)
}

// FUNCTION TO DISPLAY THE MENU
fun displayMenu() {
    println("\nSelect an option:\n1. To Make a Calculation (Arithmetic)\n2. To Exit The Calculator\n")
}

class WelcomeMessage {
    fun displayWelcomeMessage () {
        println("\n####---| WELCOME TO THE ARITHMETIC BASIC CALCULATOR |---#####")
    }
}

// FUNCTION TO DO THE CALCULATION DEPENDING ON OPERATOR ENTERED
fun doTheCalculation() {
    // VARIABLES TO HOLD NUMBER INPUTS
    val firstNumber: Double // Number allows assigning both integer and floating-point value to the variable
    val secondNumber: Double
    var operator: String

    // CREATE THE SCANNER OBJECT VARIABLE
    val scanner = Scanner(System.`in`)

    // GET THE FIRST NUMBER OPERAND FROM THE USER
    println("\nEnter The First Operand Number(value): ")
    firstNumber = scanner.nextDouble()

    // GET THE CORRECT OPERATOR FROM THE USER
    do {
        println("\nEnter A Valid Operator. Choose Between The Following: ")
        println(" + Operator For Addition")
        println(" - Operator For Subtraction")
        println(" * Operator For Multiplication")
        println(" / Operator For Division")
        println(" % Operator For Addition \n")
        operator = readlnOrNull().toString()
    } while (operator.isEmpty() || operator[0] !in listOf('+', '-', '*', '/', '%'))

    // GET THE SECOND NUMBER OPERAND FROM THE USER
    println("\nEnter The Second Operand Number(value): ")
    secondNumber = scanner.nextDouble()

    // DO THE CALCULATION DEPENDING ON OPERATOR SELECTED BY THE USER
    when (operator) {
        "+" -> calculateTheSum(firstNumber, secondNumber)
        "-" -> calculateTheDifference(firstNumber, secondNumber)
        "*" -> calculateTheProduct(firstNumber, secondNumber)
        "/" -> calculateTheDividend(firstNumber, secondNumber)
        "%" -> calculateTheRemainder(firstNumber, secondNumber)
        else -> println("The entered $operator Operator is invalid - Select Among '+', '-', '*', '/', '%'")
    }

}

// FUNCTION TO CALCULATE THE SUM
fun calculateTheSum(firstNumber: Double, secondNumber: Double) {
    // CALCULATE THE SUM
    val solution: Double = firstNumber + secondNumber
    // GIVE FEEDBACK OF THE CALCULATION
    println("\nTHE SUM OF $firstNumber + $secondNumber = $solution \n")
}

// FUNCTION TO CALCULATE THE DIFFERENCE
fun calculateTheDifference(firstNumber: Double, secondNumber: Double) {
    // CALCULATE THE DIFFERENCE
    val solution: Double = firstNumber - secondNumber
    // GIVE FEEDBACK OF THE CALCULATION
    println("\nTHE DIFFERENCE BETWEEN $firstNumber - $secondNumber = $solution \n")
}

// FUNCTION TO CALCULATE THE PRODUCT
fun calculateTheProduct(firstNumber: Double, secondNumber: Double) {
    // CALCULATE THE PRODUCT
    val solution: Double = firstNumber * secondNumber
    // GIVE FEEDBACK OF THE CALCULATION
    println("\nTHE PRODUCT OF $firstNumber * $secondNumber = $solution \n")
}

// FUNCTION TO CALCULATE THE DIVIDEND
fun calculateTheDividend(firstNumber: Double, secondNumber: Double) {
    // CHECK IF SECOND OPERAND (DIVISOR) IS A ZERO
    if(secondNumber.toInt() == 0) {
        println("\nCAN NOT DIVIDE $firstNumber OR ANY NUMBER BY ZERO (0)")
    }
    else {
        // CALCULATE THE DIVIDEND
        val solution: Double = firstNumber / secondNumber
        // GIVE FEEDBACK OF THE CALCULATION
        println("\nTHE DIVIDEND OF $firstNumber / $secondNumber = $solution \n")
    }
}

// FUNCTION TO CALCULATE THE REMAINDER(MODULUS)
fun calculateTheRemainder(firstNumber: Double, secondNumber: Double) {
    if(secondNumber.toInt() == 0) {
        println("\nCAN NOT DO A MODULUS OPERATION WITH THE DIVISOR NUMBER BEING A ZERO(0)")
    }
    else {
        // CALCULATE THE REMAINDER
        val solution: Double = firstNumber % secondNumber
        // GIVE FEEDBACK OF THE CALCULATION
        println("\nTHE MODULUS OPERATION(REMAINDER) OF $firstNumber % $secondNumber = $solution \n")
    }
}