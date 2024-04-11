import java.io.*

class PayrollSystem {
    private val employees = mutableListOf<Employee>()
    private val filename = "employees.dat"

    init {
        loadFromFile()
    }

    fun addEmployee(employee: Employee) {
        employees.add(employee)
        saveToFile()
    }

    private fun saveToFile() {
        ObjectOutputStream(FileOutputStream(filename)).use { it.writeObject(employees) }
    }

    private fun loadFromFile() {
        if (File(filename).exists()) {
            ObjectInputStream(FileInputStream(filename)).use { employees.addAll(it.readObject() as List<Employee>) }
        }
    }

    fun displayEmployees() {
        println("%-15s | %-20s | %-20s | %-15s | %-15s | %-15s".format("Department", "Full Name", "Position", "Qualification", "Hours Worked", "Hourly Rate"))
        employees.forEach { println("%-15s | %-20s | %-20s | %-15s | %-15d | %-15.2f".format(it.department, it.fullName, it.position, it.qualification, it.hoursWorked, it.hourlyRate)) }
    }

    fun generatePayroll() {
        println("Payroll Information:")
        employees.forEach { println("Employee: ${it.fullName}, Payment: ${it.hoursWorked * it.hourlyRate}") }
    }

    fun searchByPosition(position: String) {
        val searchResult = employees.filter { it.position.equals(position, ignoreCase = true) }
        if (searchResult.isNotEmpty()) {
            println("Search Result for Position \"$position\":")
            displaySearchResult(searchResult)
        } else {
            println("No employees found with position \"$position\".")
        }
    }

    fun searchByQualification(qualification: String) {
        val searchResult = employees.filter { it.qualification.equals(qualification, ignoreCase = true) }
        if (searchResult.isNotEmpty()) {
            println("Search Result for Qualification \"$qualification\":")
            displaySearchResult(searchResult)
        } else {
            println("No employees found with qualification \"$qualification\".")
        }
    }

    private fun displaySearchResult(searchResult: List<Employee>) {
        println("%-15s | %-20s | %-20s | %-15s | %-15s | %-15s".format("Department", "Full Name", "Position", "Qualification", "Hours Worked", "Hourly Rate"))
        searchResult.forEach { println("%-15s | %-20s | %-20s | %-15s | %-15d | %-15.2f".format(it.department, it.fullName, it.position, it.qualification, it.hoursWorked, it.hourlyRate)) }
    }
}