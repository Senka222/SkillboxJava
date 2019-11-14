public class TopManager extends Clerk implements Employee
{
    public TopManager()
    {
        if (Company.getSales() >= 10000000) {
            setSalary((int) (Math.random() * 20000 + 50000) + 200000);
        }
        else setSalary((int) (Math.random() * 20000 + 50000));
    }
}
