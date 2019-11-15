import java.util.ArrayList;
import java.util.List;

public class Company
{
    private static int sales;
    private ArrayList<Employee> staff = new ArrayList<>();
//    staff.sort(new EmployeeComparator());  сюда хотел

    public void getTopSalaryStaff(int count)
    {
        staff.sort(new EmployeeComparator()); //не понимаю почему не работает вне метода

        List<Employee> topSalaryStaff = staff.subList(staff.size() - count, staff.size());
        System.out.println("Самые большие зарплаты:");

        for(int i = topSalaryStaff.size() - 1 ; i >= 0 ; i--){
            System.out.println(topSalaryStaff.get(i).getMonthSalary());
        }
    }

    public void getLowestSalaryStaff(int count)
    {
        staff.sort(new EmployeeComparator()); //не понимаю почему не работает вне метода

        List<Employee> lowestSalaryStaff = staff.subList(0, count);

        System.out.println("Самые маленькие зарплаты:");

        for(int i = 0 ; i < lowestSalaryStaff.size() ; i++){
            System.out.println(lowestSalaryStaff.get(i).getMonthSalary());
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
