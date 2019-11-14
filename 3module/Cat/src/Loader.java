
public class Loader
{
    public static void main(String[] args)
    {
        Cat masya = new Cat();

        System.out.println("Вес Маси: " + masya.getWeight() + "\nНемного покормим...");
        while (masya.getWeight() <= Cat.MAX_WEIGHT) {                    // кормежка до взрыва
            masya.feed(1000.0);
            //System.out.println("Вес Маси: " + masya.getWeight());
        }
        System.out.println("Вес Маси: " + masya.getWeight());
        System.out.println("Мася сейчас: " + masya.getStatus());

        Cat vasya = new Cat();

        vasya.feed(200.0);
        while (vasya.getWeight() >= Cat.MIN_WEIGHT) {                   // замяуканье до смерти
            vasya.meow();
            //System.out.println("Васин вес: " + vasya.getWeight());
        }
        System.out.println("Вася сейчас: " + vasya.getStatus());
        vasya.feed(9000.0);                                   // проверка на двойную смерть
        System.out.println("Васин вес: " + vasya.getWeight());         // и кормелине трупа
        System.out.println("Съел до того как замяукался " + vasya.eaten());


        Cat pushok = new Cat();

        System.out.println("Вес Пушка: " + pushok.getWeight() + "\nПокормим...");
        pushok.feed(pushok.getWeight()/200);
        pushok.feed(300.0);
        System.out.println("Пушок съел: " + pushok.eaten());
        System.out.println("И стал весить: " + pushok.getWeight());
        while (pushok.getWeight() >= Cat.MIN_WEIGHT){
            pushok.toilet();
        }
        System.out.println("Теперь весит: " + pushok.getWeight());
        System.out.println("Пушок сейчас: " + pushok.getStatus());


        Cat snezhok = new Cat(500.0);
        snezhok.setWeight(2000.0);

        snezhok.setColor(CatColors.WHITE);
        System.out.println("Цвет Снежка: " + snezhok.getColor());
        System.out.println("Вес Снежка: " + snezhok.getWeight());
        System.out.println("Снежок сейчас: " + snezhok.getStatus());


        Cat ryzhiy = getCat();

        ryzhiy.setColor(CatColors.RED);
        System.out.println("Цвет Рыжего: " + ryzhiy.getColor());
        System.out.println("Вес Рыжего: " + ryzhiy.getWeight() + "\nНемного попоим...");
        ryzhiy.drink(10000.0);
        System.out.println("Вес Рыжего: " + ryzhiy.getWeight());
        System.out.println("Рыжий сейчас: " + ryzhiy.getStatus());


        Cat bob = new Cat(10000.0,"Боб",CatColors.BROWN);

        bob.feed(300.0);
        System.out.println("Как зоут кота: " + bob.getName() + "\nЕго вес: " + bob.getWeight());
        System.out.println("Цвет кота: " + bob.getColor() + "\nЕго статус: " + bob.getStatus());


        Cat bobsClone = getClone(bob);

   //     System.out.println("Как зоут кота: " + bobsClone.getName() + "\nЕго вес: " + bobsClone.getWeight());
   //     System.out.println("Цвет кота: " + bobsClone.getColor() + "\nЕго статус: " + bobsClone.getStatus());
        bobsClone.setWeight(3200.0);
        bobsClone.setName("Бобоклон");
        bobsClone.setColor(CatColors.BLACK);
        System.out.println("Как теперь зоут кота: " + bobsClone.getName() + "\nЕго вес: " + bobsClone.getWeight());
        System.out.println("Цвет кота: " + bobsClone.getColor() + "\nЕго статус: " + bobsClone.getStatus());


    //    System.out.println("Что то подзабыл, как звали предыдущего кота: " + bob.getName() + "\nЕго вес: " + bob.getWeight());
    //    System.out.println("Цвет кота: " + bob.getColor() + "\nЕго статус: " + bob.getStatus()); // проверка на то что ссылается на разнх котов


        System.out.println("Количество живых котов: " + Cat.getCount());
    }

    public static Cat getCat ()                 // метод генерации кота
    {
        Cat cat = new Cat(1500.0 + 3000.0 * Math.random());
        return cat;
    }

    public static Cat getClone(Cat cat)           // метод клонирования кота
    {
        Cat cat2 = new Cat(cat.getWeight(),cat.getName(),cat.getColor());
        return cat2;
    }
}