public class Main
{
    public static void main(String[] args)
    {
/*        Employee employee = new Clerk();
        Employee employee1 = new Manager();
        Employee employee2 = new TopManager();

        System.out.println(employee.getMonthSalary());
        System.out.println(employee1.getMonthSalary());
        System.out.println(employee2.getMonthSalary());
*/
        Company company = new Company();

        for (int i = 0; i < 270 ; i++)
        {
            if (i % 50 == 0){
                company.hireStaff(i, new TopManager());
            }
            else if (i % 10 == 0){
                company.hireStaff(i, new Manager());
            }
            else {
                company.hireStaff(i, new Clerk());
            }
        }

        System.out.println(company.getStaff().size());
/*        Employee employee = new Manager();
        System.out.println(Manager.getSales());
        System.out.println(company.getStaff().get(50).getMonthSalary());
        System.out.println(company.getStaff().get(100).getMonthSalary());
        System.out.println(company.getStaff().get(150).getMonthSalary());
        System.out.println(company.getStaff().get(200).getMonthSalary());
        System.out.println(company.getStaff().get(250).getMonthSalary());
        System.out.println(company.getStaff().get(250).getMonthSalary());
        System.out.println(company.getStaff().get(200).getMonthSalary());
        System.out.println(company.getStaff().get(10).getMonthSalary());
*/
        company.getTopSalaryStaff(10);
        company.getLowestSalaryStaff(10);

    }
}
