
public class Cat {
    public static final int EYE_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private double originWeight;
    private double weight;
    private String name;
    private CatColors catColors;
    private double foodWeight = 0;
    private boolean catIsAlive = false;

    public static int count;


    public Cat(double weight, String name, CatColors catColors) {
        this.weight = weight;
        originWeight = weight;
        this.name = name;
        this.catColors = catColors;
        catIsAlive();
    }

    public Cat(double weight) {
        this(weight, "", CatColors.BLACK);
    }

    public Cat() {
        this(1500.0 + 3000.0 * Math.random());
    }

    public static int getCount()   //метод получения количества котов
    {
        return count;
    }

    public double eaten()          //вес скормелнной еды
    {
        return foodWeight;
    }

    public void toilet()           // метод хождения в туалет
    {
        checkAndPrint(-weight/200, "Опять ходит мимо лотка...");
    }

    public void meow() {
        checkAndPrint(-1, "Мяфь");
    }

    public void feed(double amount) {
        checkAndPrint(amount, "Запихали в кота " + amount + " еды");
        if (catIsAlive) {
            foodWeight += amount;
        }
    }

    public void drink(double amount) {
        checkAndPrint(amount, "Залили в кота " + amount + " воды");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        originWeight = weight;
        catIsAlive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public void setColor(CatColors catColors)       // сеттер цвета
    {
        this.catColors = catColors;
    }

    public CatColors getColor()                     // геттер цвета
    {
        return catColors;
    }

    private void catIsAlive() {
        if ((weight < MIN_WEIGHT || weight > MAX_WEIGHT) && catIsAlive) {
            catIsAlive = false;
            count--;
        } else if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT && !catIsAlive) {
            catIsAlive = true;
            count++;
        }
    }

    private void checkAndPrint (double change, String message)
    {
        if (catIsAlive)
        {
            weight += change;
            System.out.println(message);
            catIsAlive();
        }
        else {
            System.out.println("Ваш кот все Т_Т");
        }
    }
}