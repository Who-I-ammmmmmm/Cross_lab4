import java.util.*

fun main() {
    val payrollSystem = PayrollSystem()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Меню:")
        println("1. Додати працівника")
        println("2. Показати працівників")
        println("3. Сформувати відомості для оплати праці")
        println("4. Пошук працівника за посадою")
        println("5. Пошук працівника за кваліфікацією")
        println("6. Вийти з програми")

        print("Оберіть опцію: ")

        // Перевірка, чи введено ціле число
        if (scanner.hasNextInt()) {
            val choice = scanner.nextInt()
            when (choice) {
                1 -> {
                    scanner.nextLine() // очистка буфера
                    print("Введіть відділ: ")
                    val department = scanner.nextLine().trim()
                    print("Введіть прізвище та ініціали: ")
                    val fullName = scanner.nextLine().trim()
                    print("Введіть посаду: ")
                    val position = scanner.nextLine().trim()
                    print("Введіть кваліфікацію: ")
                    val qualification = scanner.nextLine().trim()
                    print("Введіть кількість відпрацьованих годин: ")
                    val hoursWorked = scanner.nextInt()
                    print("Введіть оплату за годину: ")
                    val hourlyRate = scanner.nextDouble()
                    payrollSystem.addEmployee(Employee(department, fullName, position, qualification, hoursWorked, hourlyRate))
                }
                2 -> payrollSystem.displayEmployees()
                3 -> payrollSystem.generatePayroll()
                4 -> {
                    scanner.nextLine() // очистка буфера
                    print("Введіть посаду для пошуку: ")
                    val position = scanner.nextLine().trim()
                    payrollSystem.searchByPosition(position)
                }
                5 -> {
                    scanner.nextLine() // очистка буфера
                    print("Введіть кваліфікацію для пошуку: ")
                    val qualification = scanner.nextLine().trim()
                    payrollSystem.searchByQualification(qualification)
                }
                6 -> {
                    println("До побачення!")
                    return
                }
                else -> println("Неправильний вибір опції. Будь ласка, виберіть знову.")
            }
        } else {
            println("Неправильний ввід. Будь ласка, введіть ціле число.")
            scanner.next() // очистка буфера
        }
    }
}
