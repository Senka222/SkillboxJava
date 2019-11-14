public class Clerk implements Employee
{

    private int salary;

    public Clerk()
    {
        this.salary = (int) (Math.random() * 5000 + 15000);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

}
