public class Main
{
    public static void main(String[] args)
    {
        for (int ticketNumber = 200000 ; ticketNumber <= 235000 ; ticketNumber++)
        {
            if (ticketNumber <= 210000 || ticketNumber >= 220000) {
                System.out.println(ticketNumber + " билет");
            }
        }
    }
}
