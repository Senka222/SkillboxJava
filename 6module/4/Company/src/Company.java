import java.util.ArrayList;

public class Company
{
    private static int sales;
    private ArrayList<Employee> staff = new ArrayList<>();

    public void getTopSalaryStaff(int count)
    {
        staff.sort(new EmployeeComparator()); //не понимаю почему не работает вне метода
        ArrayList<Employee> topSalaryStaff = new ArrayList<>();

        System.out.println("Самые большие зарплаты:");

        for (int i = 0 ; i < count ; i++){
            topSalaryStaff.add(i, getStaff().get(getStaff().size()-i-1));
            System.out.println(topSalaryStaff.get(i).getMonthSalary());
        }
    }

    public void getLowestSalaryStaff(int count)
    {
        staff.sort(new EmployeeComparator()); //не понимаю почему не работает вне метода
        ArrayList<Employee> topSalaryStaff = new ArrayList<>();

        System.out.println("Самые маленькие зарплаты:");

        for (int i = 0 ; i < count ; i++){
            topSalaryStaff.add(i, getStaff().get(i));
            System.out.println(topSalaryStaff.get(i).getMonthSalary());
        }
    }

    public void hireStaff(int number, Employee person)
    {
        this.staff.add(number, person);
    }

    public void layOffStaff(int number)
    {
        this.staff.remove(number);
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public static int getSales() {
        return sales;
    }

    protected static void setSales(int sales) {
        Company.sales = sales;
    }
}
