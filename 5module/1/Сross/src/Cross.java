import java.util.Arrays;
import java.util.Scanner;

public class Cross
{
    public static void main(String[] args)
    {
        System.out.println("Введите размер стороны квадрата (целое число): ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        crossBuilder(number);
    }
    private static void crossBuilder(int number)
    {
        String[][] square = new String[number][number];
        for (int i = 0 ; i < square.length ; i++)
        {
            for (int j = 0 ; j < square[i].length ; j++)
            {
                if (i == j || (i == square[i].length - j -1) || (square.length - i -1 == j) || (square.length - i - 1 == square[i].length - j - 1))
                {
                    square[i][j] = "X";
                }
                else{
                    square[i][j] = " ";
                }
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }
}
