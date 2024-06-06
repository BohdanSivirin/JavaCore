package ifElse;

public class IfElse {
    public static void main(String[] args) {
        // есть температура воздуха Пойдем гулять если температура не ниже 20, иначе сидим дома
        double temperature = 25.7;
        if (temperature >= 20) {
            System.out.println("go for a walk");
            System.out.println("weather is nice!");
        } else {
            System.out.println("stay at home");
        }
        //есть человек с возрастом/ Он совершеннолетний?

        int years = 27;
        if (years >= 18) {
            System.out.println("Вы совершеннолетний");
        } else {
            System.out.println("Вы еще недостатчно взрослый");
        }
        // есть 3 человека с возрастом. Средний возраст этих людей превышает 19.1?

        int age1 = 5;
        int age2 = 12;
        int age3 = 19;
        double ageAverage = (age1 + age2 + age3) / 3.0;
        if (ageAverage > 19.1) {
            System.out.println("Средний возраст слишком большой");
        } else {
            System.out.println("Входите!");
        }
        //есть пара обуви с размером. Есть наш размер. Подходит нам обувь?

        double shoesSize = 41;
        double mySize = 41;

        if (shoesSize != mySize) {
            System.out.println("Размер не подходит");
        } else {
            System.out.println("Размер подходит");
        }
        //есть 2 переменные/ Сравнить их

        int e = 20;
        int t = 50;
        if (e > t) {
            System.out.println(e + ">" + t);
        } else if (e == t) {
            System.out.println(e + "=" + t);
        } else {
            System.out.println(e + "<" + t);
        }

        //есть ящик, который выдерживает столько-то кг. Есть первый товар. единица которого весит столько-то и его
        // у нас такое-то количество. Есть и второй товар с весом и количеством. Выдержит ящик?

        int boxweight = 100; // выдерживает кг
        int firstThingWeight = 100; // кг
        int firstThingAmount = 1; // кол-во товара
        int secondThingWeight = 25;
        int secondThingAmount = 0;
        int sumThingsWeight = firstThingAmount * firstThingWeight + secondThingAmount * secondThingWeight;

        if (sumThingsWeight > boxweight) {
            System.out.println("Ящик не расчитан на такой вес");
        } else if (sumThingsWeight < boxweight) {
            System.out.println("Ящик подходит для такого веса");
        } else if (sumThingsWeight == boxweight) {
            System.out.println("Идеально !!!");
        }


        // ax2 - bx + c = 0
        // D = b2 - 4ac

        int a = 2;
        int b = -7;
        int c = 6;

        double D = Math.pow(b, 2) - 4 * a * c;
        System.out.println(D);
        if (D > 0) {
            System.out.println("Уравнение имеет 2 корня");
            double x1 = (-b + Math.pow(D, 1 / 2.0)) / (2 * a);
            System.out.println("Корень х1 равен =" + x1);
            double x2 = (-b - Math.pow(D, 1 / 2.0)) / (2 * a);
            System.out.println("Корень х2 равен =" + x2);
        } else if (D < 0) {
            System.out.println("В Уравнении нет корней");

        } else if (D == 0) {
            System.out.println("Уравнение имеет 1 корень");
        }
// есть авто что едет с такой-то скоростью и нужное расстояние. Ехало авто столько-то по времени. Преодолели расстояние?
// Если нет, то сколько еще км надо будет ехать?
        int carSpeed = 60; // км.ч
        int distance = 800; // км.
        int timeDriving = 6; // час

        int distanceRemining = distance - (carSpeed * timeDriving);
        System.out.println("Осталось проехать км. =" + distanceRemining);

        if (carSpeed * timeDriving < distance) {
            System.out.println("Не преодолели дистанцию. Осталось ехать =" + distanceRemining);
        } else {
            System.out.println("Проехали дистанцию");
        }
        // есть комната с площадью и 2 разных мебели с площадью. Войдет мебель в комнату? если да то сколько свободного места останется?

        int roomSize = 25; //кв.м
        int sofaSize = 5; //кв.м
        int smallTableSize = 20; //кв.м

        if ((sofaSize + smallTableSize) <= roomSize) {
            System.out.println("Мебель помещается. Остаток площади =" + (roomSize - (sofaSize + smallTableSize)));
        } else {
            System.out.println("Места недостаточно. Остаток площади = " + (roomSize - (sofaSize + smallTableSize)));
        }
        //есть температура влоздуха. Есть переменная с названием Сигнал, которая зависит от температуры.
        // Если температура не выше 15, то сигнал стает -80 . иначе сигнал 100

        temperature = 10;
        int signal;

        if (temperature <= 15)
            signal = -80;
        else
            signal = 100;
        System.out.println("Сигнал равен =" + signal);
        signal = temperature <= 15 ? -80 : 100;
        System.out.println("signal = " + signal);

        // есть 2 переменных и есть третья с именем макс. Записать в нее максимальное значение с первых двух

        double first = 145.25;
        double second = 7.23;
        double maks;
        maks = first > second ? first : second;
        System.out.println("maks =" + maks);

        // есть емкость пустая с объемом и две другие с чемто каких то объемов.
        // Влезут ли две другие в первую полностью? если нет то сколько лишнего объема в них?

        int boxMain = 65; // м куб
        int boxFirst = 60; // м куб
        int boxSecond = 6; // м куб

        if (boxMain >= boxFirst + boxSecond) {
            System.out.println("Емкость влазит полностью");
        } else {
            double result;
            result = boxMain - (boxFirst + boxSecond);
            System.out.println("Емкость не влазит полностью. Осталось =" + result);
        }

        // спортцмен делает по 3 броска чегото/
        // Номатив разряда такой-то. в среднем выполнен норматив? Если нет то сколько в среднем не докинуто до норматива?

        double standart = 185.50; //норматив метры длинна
        double firstGoal = 180.20; // метры длинна
        double secondGoal = 200.80; // метры длинна
        double thirdGoal = 203.77; // метры длинна
        double averageGoal;
        averageGoal = (firstGoal + secondGoal + thirdGoal) / 3.0; // среднее из 3 попыток
        if (averageGoal >= standart) {

            System.out.println("Норматив выполнен");
        } else {
            double result2;
            result2 = standart - averageGoal;
            System.out.println("Норматив не выполнен. Не хватает =" + result2 + "метров");
        }
        System.out.println(standart > 100 && firstGoal == 4 && 2 > 1);
        // есть 3 людей с возрастом/ Все совершеннолетние?

        int firstPerson = 18;
        int secondPerson = 18;
        int thirdPerson = 18;
        if (firstPerson >= 18 && secondPerson >= 18 && thirdPerson >= 18) {
            System.out.println("Все совершеннолетние");
        } else {
            System.out.println("Не все");
        }
        //есть книга с столько страниц. читали 2 дня по столько-то. Каждый день прочитали хотябы 27%?

        int book = 158; // 158-100, x-27
        int firstDayRead = 90;
        int secondDayRead = 52;
        if (book * 0.27 <= firstDayRead && book * 0.27 <= secondDayRead) {
            System.out.println("Прочитали каджый день больше 27%");
        } else {
            System.out.println("Не прочитали 27%");
        }
        //есть 2 авто со средней скорость. каждое/ Есть расстояние которое надо преодолеть/ Ехали столько-то времени. Каждое из авто преодолеет расстояние?

        int firstCarAverageSpeed = 5;
        int secondCarAverageSpeed = 70; // км.ч
        int allDistance = 200; // км
        double time = 6.30; // часов + минут
        if (allDistance <= firstCarAverageSpeed * time && allDistance <= secondCarAverageSpeed * time) {
            System.out.println("Каждое авто преодолело расстояние =" + allDistance);
        } else {
            System.out.println("Не каждое авто преодолело расстояние =" + allDistance);
        }
        // естьт 2 переменные/ Есть третья/ Попадает ли третья в диапазон первых двух?

        int firstNumber = 7;
        int secondNumber = 14;
        int thirdNumber = 10;
        if (thirdNumber >= firstNumber && thirdNumber <= secondNumber) {
            System.out.println("Число попадает в диапазон =" + thirdNumber);
        } else {
            System.out.println("Число не попадает в диапазон");
        }
        //есть 3 переменных и есть четвертая с именем минимум/ Записать в нее минимальное значение с этих трех

        firstNumber = 100;
        secondNumber = 10;
        thirdNumber = 19;
        int min;
        if (firstNumber < secondNumber && firstNumber < thirdNumber) {
            min = firstNumber;
        } else if (secondNumber < firstNumber && secondNumber < thirdNumber) {
            min = secondNumber;
        } else {
            min = thirdNumber;
        }
        System.out.println("Минимально значение переменной =" + min);

        // 1) есть 2 комнаты с площадью и 3 разных мебели с площадью, Войдет ли вся мебель в обое из комнат?
        int roomFirst = 25;
        int roomSecond = 30;
        int sofa = 20;
        int table = 3;
        int wardrobe = 9;
        if (roomFirst >= sofa + table + wardrobe && roomSecond >= sofa + table + wardrobe) {
            System.out.println("Мебель поместится в обе комнаты");
        } else {
            System.out.println("Площади недостаточно");
        }

        //2)есть 2 диапазона, образованных числами и число. Войдет ли число в оба диапазона?
        int firstRangeFirstNumber = -95;
        int firstRangeSecondNumber = 15;
        int secondRangeFirstNumber = 6;
        int secondRangeSecondNumber = 684;
        int symbol = -16;
        if (symbol >= firstRangeFirstNumber && symbol <= firstRangeSecondNumber && symbol >= secondRangeFirstNumber && symbol <= secondRangeSecondNumber) {
            System.out.println("Число = " + symbol + " попадает в оба диапазона");
        } else {
            System.out.println("Число = " + symbol + " не попадает в диапазон");
        }

        //3) есть 3 пары обуви и наш размер. Вся из представленных нам подходит?
        int firstBoots = 45;
        int secondBoots = 45;
        int thirdBoots = 42;
        mySize = 45;
        if (mySize == firstBoots && mySize == secondBoots && mySize == thirdBoots) {
            System.out.println("Вся обувь нам подходит");
        } else {
            System.out.println("Нужно чтоб все пары были = " + mySize + " размера");
        }
        // есть макс глубина в дайвинге 40 м. Погружались 3 раза на разные глубины. Хоть в одном погружении превысили предел?

        int maxDepth = 40;
        int diveFirst = 20;
        int diveSecond = 25;
        int diveThird = 30;
        if (maxDepth >= diveFirst && maxDepth >= diveSecond && maxDepth >= diveThird) {
            System.out.println("Не превысили ниразу");
        } else {
            System.out.println("Хоть раз превысили");
        }
        //есть 2 товара по цене и количеству и деньги. Хотим купить по максимуму, но рассмотреть один единственный возможный вариант

        double productOnePrice = 65.50;
        int productOneAmount = 5;
        double productTwoPrice = 66.99;
        int productTwoAmount = 10;
        double money = 80;
        if (money >= productOnePrice * productOneAmount + productTwoPrice * productTwoAmount) {
            System.out.println("Можем купить все");
        } else if (money >= productOnePrice * productOneAmount) {
            System.out.println("Можем купить только один товар");
        } else if (money >= productTwoPrice * productTwoAmount) {
            System.out.println("Можем купить только один товар");
        } else {
            System.out.println("Не можем купить ничего");
        }
        // есть высота на которую надо взобраться и 2 лестницы, которые можно соединять. Рассмотреть самый оптимальный вариант взобраться (только один)

        int high = 10;
        int ladderOne = 10;
        int ladderTwo = 5;
        if (high <= ladderOne && high <= ladderTwo) {
            System.out.println("Мы можем взобраться на высоту на любой лестнице");
        } else if (high <= ladderOne) {
            System.out.println("Мы можем взобраться на высоту на 1 лестнице");
        } else if (high <= ladderTwo)
            System.out.println("Мы можем взобраться на высоту на 2 лестнице");
        else if (high <= ladderOne + ladderTwo) {
            System.out.println("Мы можем взобраться на высоту соеденив лестницы");
        } else {
            System.out.println("Мы не можем взобраться");
        }
// **********************************************************************************
// **********************************************************************************

        // есть 3 переменных. Сделать так, чтобы в первой стало наименьшее, а в третьей - наибольшее из значений
// Домашка долг 1
        a = 2;
        b = -10;
        c = 15;
        int max;
        int minn;

        if (a >= b) {
            if (a >= c) {
                max = a;
            } else {
                max = c;
            }
        } else {
            if (b >= c) {
                max = b;
            } else {
                max = c;
            }
        }
        if (c <= a) {
            if (c <= b) {
                minn = c;
            } else {
                minn = b;
            }
        } else {
            if (a <= b){
                minn = a;
            } else {
                minn = b;
            }

        }

        System.out.println("a = " + max + " b = " + b + "c = " + minn);


//        // есть 2 авто с ценой и обемом двигателя и есть деньги/ Хотим купить авто с обемом не меньше такого-то. Подходят нам обое авто?
//// Домашка долг 2

        int carOnePrice = 8000;
        int carTwoPrice = 12000;
        double carOneEngine = 1.50;
        double carTwoEngine = 2.0;
        int myMoneyForCar = 15000;
        double mySizeEngine = 1.6;

        if (myMoneyForCar >= carOnePrice && mySizeEngine <= carOneEngine && myMoneyForCar >= carTwoPrice && mySizeEngine <= carTwoEngine) {
            System.out.println("Подходят оба автомобиля");
        } else {
            System.out.println("Есть автомобили которые не подходит");
        }
// **********************************************************************************
// **********************************************************************************

        System.out.println(2 < 100 || high != 20);

// есть 2 костюма с размерами/ Есть наш размер. Хоть какой-то костюм подходит?

        int suitOneSize = 57;
        int suitTwoSize = 58;
        mySize = 57;
        if (mySize == suitOneSize || mySize == suitTwoSize) {
            System.out.println("Хоть какой-то костюм подходит");
        } else {
            System.out.println("Размер не подходит");
        }
        //есть 2 авто со скоростью Каждый из авто проезал сколько-то времени (возможно разное) / Хоть ктото преодолел заданную дистанцию?

        int firstCarSpeed = 55;
        int secondCarSpeed = 45; // км.час
        int firstCarTime = 2;
        int secondCarTime = 1; // часы
        distance = 120; // км

        if (distance <= firstCarSpeed * firstCarTime || distance <= secondCarTime * secondCarSpeed) {
            System.out.println("Хоть одна из машин преодолела дистанцию");
        } else {
            System.out.println("Ни одна машина не преодолела дистанцию");
        }
        //есть 2 диапазона с числами и число/ Входит ли число хоть в какой-то из диапазонов?

        int oneRange = -56;
        int secondRange = 5;
        int thirdRange = 25;
        int fourthRange = 45;
        int number = 28;
        if (number >= oneRange && number <= secondRange || number >= thirdRange && number <= fourthRange) {
            System.out.println("Число попадает в какой-то диапазон");
        } else {
            System.out.println("Число не попадает в диапазон");
        }
        //есть 2 авто со стоимостью и объемом двигателя и деньги/ ищем авто с двигателем не меньшим такого-то Есть хоть одно авто что нам НЕ подходит

        int oneCarPrice = 10000;
        int twoCarPrice = 12000;
        double oneCarEngine = 2.0;
        double twoCarEngine = 2.0;
        int myMoney = 10000;
        double myEngine = 2.0;
        if (myMoney <= oneCarPrice && myEngine >= oneCarEngine || myMoney <= twoCarPrice && myEngine >= twoCarEngine) {
            System.out.println("Есть хоть одно авто которое не подходит");
        } else {
            System.out.println("Нет ни одного авто которое не подходит");
        }
        //в задаче с диапазонами ответить на вопрос есть ли хоть один диапазон в который НЕ войдет число

        if (!(number >= oneRange && number <= secondRange) || !(number >= thirdRange && number <= fourthRange)) {
            System.out.println("Есть хоть один диапазон в который число Не попадает");
        } else {
            System.out.println("Нет ни одного диапазона в которое число попадает");
        }
        //задача с дайвингом через или

        // есть макс глубина в дайвинге 40 м. Погружались 3 раза на разные глубины. Хоть в одном погружении превысили предел?

        maxDepth = 40;
        diveFirst = 50;
        diveSecond = 25;
        diveThird = 30;
        if (maxDepth < diveFirst || maxDepth < diveSecond || maxDepth < diveThird) {
            System.out.println("Хотя бы раз превысили предел глубины");
        } else {
            System.out.println("Ни разу не достигли предела");
        }

// Домашка 3
        //1 ) есть 3 числа, Есть еще  одно/ Находится ли среди трех чисел хоть одно, кратное четвертому?

        double number1 = 777;
        double number2 = -13;
        double number3 = 6;
        double myNumber = 5;
        if (number1 % myNumber == 0 || number2 % myNumber == 0 || number3 % myNumber == 0) {
            System.out.println("Есть хотя бы одно число кратное =" + myNumber);
        } else {
            System.out.println("Нет ни одного числа кратного =" + myNumber);
        }

        int n = 5;
        System.out.println(6 % 2);
    }

}

