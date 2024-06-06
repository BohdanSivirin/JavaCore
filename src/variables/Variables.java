package variables;

public class Variables {
    public static void main(String[] args) {
        System.out.println("Class   3 + 5");
        System.out.println(3 + 6);
        byte b;
        b = 26;  // 1 byte  -128  127
        byte[] photo;
        short sh = 3456; // 2 byte  -65000   65000
        int age = 35;  // 4 byte  -2 mlrd  2 mlrd      9 digits
        System.out.println(67);  // int
        System.out.println(age + 2);
        int sum = 4 + 7;
        System.out.println(sum);
        long cardNumber = 1111_2222_3333_4444L; // 8 byte
        //есть цена товара и кол-вою Есть деньги. Сколько останется денег после покупки?
        int productPrice = 10;
        int productAmount = 7;
        int money = 500;
        int rest = money - productPrice * productAmount;
        System.out.println(rest);

        int x = 100;
        age = 36;
        System.out.println("age = " + age);
        System.out.println("sum = " + (12 + 7));
        System.out.println(15 + 3 + " = sum");
        int y = (2 * x + 3) / (2 * age) + 3 * money / (1 + age);
        System.out.println("y = " + y);

        double weight = 2.35; // 8 byte
        System.out.println(45.12); // double

        float depth = 4.55F; //4 byte
        System.out.println(5.0 / 2);
        int a = 5;
        int c = 2;
        double result = a / c;
//        a / c = double result;

        System.out.println("результат деления а и с = " + result);

        result = a / (c * 1.0);
        System.out.println("результат деления а и с = " + result);

        result = (double) a / c;
        System.out.println("результат деления а и с = " + result);

        double formula = (2.0 * x + 3) / (2 * age) + (3.0 * money) / (1 + age);
        System.out.println(formula);


//        есть средняя скорость авто Есть расстояние. Сколько км надо еще проехать чтобы преодолеть расстояние, если  авто ехало столько-то времени?
//
//        distance from A to B = 500 km
//         average speed 110 km per h
//         we spend 2.45 h driving
//         how much distance left

        int speedAverage = 110; //км час
        int distanceAll = 500; // км сколько нужно еще проехать
        double timeAll = 2.45; //ч

        double distanceFinished = speedAverage * timeAll;
        System.out.println("Дистанция которую мы проехали = " + distanceFinished);

        double distanceRemaining = distanceAll - distanceFinished;
        System.out.println("Осталось км проехать = " + distanceRemaining);

        double timeRemaining = distanceRemaining / speedAverage;

        int hours = (int) timeRemaining;
        double minutes = timeRemaining - hours; // дробная часть
        double minutesRound = minutes * 60;

        int minutesRoundResult = (int) Math.round(minutesRound);
        System.out.println("Осталось времени в пути " + hours + " часа " + minutesRoundResult + " минут");
        String text="t";
        text.length();

        char symbol = '*';
        System.out.println('$');
        System.out.println("vasya".replace('a', symbol));

        int number = '/';
        System.out.println("number " + number);

        symbol = 36;
        System.out.println(symbol);

        boolean compare = minutesRound < 10;
        System.out.println(compare);
        System.out.println(speedAverage < hours);

//        int a = 5;
//        a = a + 1;
//        System.out.println("a = "+a);
//        a++; // a = a + 1;
//        a--;
//        a = 3;
//        System.out.println("a = " + a++); // increment postfix
//        System.out.println("a = "+a);
//        a = 10;
//        int sum = 14 - a++;
//        System.out.println("sum = "+sum);
//        System.out.println(a);
//        sum = 4 + ++a; // increment   a = a + 1;  prefix
//        System.out.println("sum = "+sum);
//        a = 6;
//        a/=3; // a = a / 3;
//        a*=4; // a = a * 4;
//        a-=4; // a = a - 4
////
//        double x = 1000;
//        double y = Math.pow((2 * Math.pow(Math.PI, 1.0 / 7) + x) / (3 * x) + ((Math.pow(Math.E, 0.34)) * x) / (1 + a), 1 / 3.0);
//        System.out.println("формула =" + y);
////        System.out.println(1.0/3);
//
//        // есть 2 товара с ценой и кол-вом и деньги/ Найти остаток денег после покупки

        double productOnePrice = 16; // грн
        int productOneAmount = 7; // штук
        int moneyAll = 500; // грн
        double productCost = productOnePrice * productOneAmount;
        System.out.println("Общая сумма покупки =" + productCost);
        double restOfMoneyAll = moneyAll - productCost;
        System.out.println("Осталось денег =" + restOfMoneyAll);


        //есть высота горы/ лезли 2 дня по разному кол-ву / Сколько метров еще осталось чтобы преодолеть

        double moutianHigh = 7865.35; // высота в метрах
        int time = 24; // часа
        int averageSpeedFirstClimber = 200; // метров в час
        int averageSpeedSecondClimber = 205; // метров в час

        double distanceFirstClimberForTime = time * averageSpeedFirstClimber;
        System.out.println("Первый альпинист пролез =" + distanceFirstClimberForTime);

        double distanceRemainderFirstClimber = moutianHigh - distanceFirstClimberForTime;
        System.out.println("Первому альпинисту осталось до веришины =" + distanceRemainderFirstClimber);

        double distanceSecondClimberForTime = time * averageSpeedSecondClimber;
        System.out.println("Второй альпинист пролез =" + distanceSecondClimberForTime);

        double distanceRemainderSecondClimber = moutianHigh - distanceSecondClimberForTime;
        System.out.println("Второму альпинисту осталось до веришины =" + distanceRemainderSecondClimber);

        //есть 2 числа/ Поменять в них значения местами

//        a = 10;
//        int b = 8;
//        int buffer = a;
//        a = b;
//        b = buffer;
//        System.out.println("a = " + a+" b = "+b);
//        a = 5;

        {
            int v = 67;
            v = -2;
            speedAverage = 1;
        }













    }
}
