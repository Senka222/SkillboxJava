public class Main
{
    public static void main(String[] args)
    {
        for (char letter = 'A'; letter <= 'z'; letter++)
        {
            if ( letter > 'Z' && letter < 'a'){
               continue;
            }
            System.out.println("Символу " + letter + " соответствует код " + (int) letter);
        }
        for (char letter = 'А'; letter <= 'я'; letter++)
        {
            System.out.println("Символу " + letter + " соответствует код " + (int) letter);
        }
    }
}
