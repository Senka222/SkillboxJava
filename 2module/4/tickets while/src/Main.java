public class Main
{
    public static void main(String[] args)
    {
        int ticketNumber = 200000 ;
        while (ticketNumber <= 235000)
        {
            if (ticketNumber <= 210000 || ticketNumber >= 220000) {
                System.out.println(ticketNumber + " билет");
            }
            ticketNumber++;
        }
    }
}
