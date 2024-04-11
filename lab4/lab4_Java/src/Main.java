import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Додати працівника");
            System.out.println("2. Показати працівників");
            System.out.println("3. Сформувати відомості для оплати праці");
            System.out.println("4. Пошук працівника за посадою");
            System.out.println("5. Пошук працівника за кваліфікацією");
            System.out.println("6. Вийти з програми");

            System.out.print("Оберіть опцію: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        scanner.nextLine();
                        System.out.print("Введіть відділ: ");
                        String department = scanner.nextLine().trim();
                        System.out.print("Введіть прізвище та ініціали: ");
                        String fullName = scanner.nextLine().trim();
                        System.out.print("Введіть посаду: ");
                        String position = scanner.nextLine().trim();
                        System.out.print("Введіть кваліфікацію: ");
                        String qualification = scanner.nextLine().trim();
                        System.out.print("Введіть кількість відпрацьованих годин: ");
                        int hoursWorked = scanner.nextInt();
                        System.out.print("Введіть оплату за годину: ");
                        double hourlyRate = scanner.nextDouble();
                        payrollSystem.addEmployee(new Employee(department, fullName, position, qualification, hoursWorked, hourlyRate));
                        break;
                    case 2:
                        payrollSystem.displayEmployees();
                        break;
                    case 3:
                        payrollSystem.generatePayroll();
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.print("Введіть посаду для пошуку: ");
                        String searchPosition = scanner.nextLine().trim();
                        payrollSystem.searchByPosition(searchPosition);
                        break;
                    case 5:
                        scanner.nextLine();
                        System.out.print("Введіть кваліфікацію для пошуку: ");
                        String searchQualification = scanner.nextLine().trim();
                        payrollSystem.searchByQualification(searchQualification);
                        break;
                    case 6:
                        System.out.println("До побачення!");
                        return;
                    default:
                        System.out.println("Неправильний вибір опції. Будь ласка, виберіть знову.");
                        break;
                }
            } else {
                System.out.println("Неправильний ввід. Будь ласка, введіть ціле число.");
                scanner.next();
            }
        }
    }
}
