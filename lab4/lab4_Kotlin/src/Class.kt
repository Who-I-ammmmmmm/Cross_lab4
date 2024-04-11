import java.io.Serializable

data class Employee(val department: String, val fullName: String, val position: String, val qualification: String, val hoursWorked: Int, val hourlyRate: Double) :
    Serializable
