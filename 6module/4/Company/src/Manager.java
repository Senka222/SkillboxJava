public class Manager extends Clerk implements Employee {


    public Manager()
    {
        Company.setSales(Company.getSales() + (int) (Math.random() * 200000 + 400000));
        setSalary((int) (10000 + Company.getSales() * 0.05));
    }
}
