
public class Loader
{
    public static void main(String[] args)
    {
        int milkAmount = 1200; // ml
        int powderAmount = 1500; // g
        int eggsCount = 13; // items
        int sugarAmount = 15; // g
        int oilAmount = 1; // ml
        int appleCount = 18;

        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30) {
            //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
            System.out.println("Pancakes");
        }
        if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            //milk - 300 ml, powder - 5 g, eggs - 5
            System.out.println("Omelette");
        }
        if (appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) {
            //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
            System.out.println("Apple pie");
        }
        else {
            System.out.println("Вы ничего не можете приготовить");
        }
    }
}