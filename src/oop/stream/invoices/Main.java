package oop.stream.invoices;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // default items
        Item item = new Item("BMW", 1050.26, 3324587745L, "M4", 4);
        Item item1 = new Item("Tesla", 902.00, 3324587745L, "Model S", 7);
        Item item2 = new Item("Toyota", 400.26, 3435899987745L, "Camry", 6);
        Item item3 = new Item("Porsche", 114400.00, 1234587745L, "911 Carrera", 17);
        Item item4 = new Item("Audi", 25945.00, 3345627745L, "RS6 Avant", 12);
        Item item5 = new Item("Honda", 43795.00, 111117745L, "Civic Type R", 34);
        Item item6 = new Item("Tarmac SL8", 12500.00, 5544332211L, "Specialized", 2);

        Item item7 = new Item("MacBook Pro 14", 1999.99, 8801234567L, "Apple", 15);
        Item item8 = new Item("WH-1000XM5", 398.00, 4521008742L, "Sony", 28);
        Item item9 = new Item("Galaxy S24 Ultra", 1299.50, 7741200331L, "Samsung", 10);
        Item item10 = new Item("MX Master 3S", 99.00, 6070809000L, "Logitech", 150);
        Item item11 = new Item("EOS R5", 3399.00, 1212131314L, "Canon", 4);
        Item item12 = new Item("Hero 12 Black", 20, 9898979796L, "GoPro", 5);
        Item item13 = new Item("Fenix 7X Pro", 10, 5566443322L, "Garmin", 10);

        Item item14 = new Item("Artisan Stand Mixer", 449.99, 8856213470L, "KitchenAid", 8);
        Item item15 = new Item("V15 Detect", 749.00, 3321455980L, "Dyson", 14);
        Item item16 = new Item("AirFryer XXL", 220.45, 1122334455L, "Philips", 22);
        Item item17 = new Item("Barista Express", 699.95, 2424252526L, "Breville", 18);
        Item item18 = new Item("Pro Staff 97", 279.00, 9912343698L, "Wilson", 45);
        Item item19 = new Item("Al Rihla Ball", 165.00, 6677889900L, "Adidas", 100);
        Item item20 = new Item("Submariner Date", 10500.00, 1122334455L, "Rolex", 2);
        Item item21 = new Item("Speedmaster Professional", 7600.00, 9988776655L, "Omega", 5);
        Item item22 = new Item("Stratocaster American Professional II", 1699.00, 4433221100L, "Fender", 12);
        Item item23 = new Item("Les Paul Standard '60s", 2799.00, 7766554433L, "Gibson", 7);
        Item item24 = new Item("Aeron Chair", 1805.00, 1020304050L, "Herman Miller", 20);
        Item item25 = new Item("Aeron Chair 23", 1805.00, 1020304050L, "Herman Miller", 39);

        // default lists
        List<Item> automotiveList = new ArrayList<>();
        List<Item> electronicsList = new ArrayList<>();
        List<Item> lifestyleList = new ArrayList<>();
        List<Item> alexList = new ArrayList<>();

        Collections.addAll(alexList, item, item1, item2, item25, item19, item20, item21);
        Collections.addAll(automotiveList, item, item1, item2, item3, item4, item5, item6, item25, item19, item20, item21, item22, item23, item24);
        Collections.addAll(electronicsList, item13, item12);
        Collections.addAll(lifestyleList, item14, item15, item16, item17, item18, item19, item20, item21, item22, item23, item24);

        // clone items
        Item cloneItem = item.clone();
        Item cloneItem1 = item1.clone();
        Item cloneItem2 = item2.clone();
        Item cloneItem3 = item3.clone();
        Item cloneItem4 = item4.clone();
        Item cloneItem5 = item5.clone();
        Item cloneItem6 = item6.clone();

        Item cloneItem7 = item7.clone();
        Item cloneItem8 = item8.clone();
        Item cloneItem9 = item9.clone();
        Item cloneItem10 = item10.clone();
        Item cloneItem11 = item11.clone();
        Item cloneItem12 = item12.clone();
        Item cloneItem13 = item13.clone();

        Item cloneItem14 = item14.clone();
        Item cloneItem15 = item15.clone();
        Item cloneItem16 = item16.clone();
        Item cloneItem17 = item17.clone();
        Item cloneItem18 = item18.clone();
        Item cloneItem19 = item19.clone();
        Item cloneItem20 = item20.clone();
        Item cloneItem21 = item21.clone();
        Item cloneItem22 = item22.clone();
        Item cloneItem23 = item23.clone();
        Item cloneItem24 = item24.clone();

        // clone lists
        List<Item> cloneAutomotiveList = new ArrayList<>();
        List<Item> cloneElectronicsList = new ArrayList<>();
        List<Item> cloneLifestyleList = new ArrayList<>();
        List<Item> cloneAlexList = new ArrayList<>();

        Collections.addAll(cloneAlexList, cloneItem, cloneItem1, cloneItem2, cloneItem3, cloneItem4, cloneItem5, cloneItem6, cloneItem17, cloneItem18, cloneItem19, cloneItem20);
        Collections.addAll(cloneAutomotiveList, cloneItem, cloneItem1, cloneItem2, cloneItem3, cloneItem4, cloneItem5, cloneItem6);
        Collections.addAll(cloneElectronicsList, cloneItem7, cloneItem8, cloneItem9, cloneItem10, cloneItem11, cloneItem12, cloneItem13);
        Collections.addAll(cloneLifestyleList, cloneItem14, cloneItem15, cloneItem16, cloneItem17, cloneItem18, cloneItem19, cloneItem20, cloneItem21, cloneItem22, cloneItem23, cloneItem24);

        //
        Employee roman = new Employee(666666666L, "Roman", "+380957778899");
        Employee cloneRoman = roman.clone();
        Employee oleh = new Employee(7898888L, "Oleh", "+380679874512");
        Employee dmytro = new Employee(222222222L, "Dmytro", "+380931112233");
        Employee olena = new Employee(333333333L, "Olena", "+380665554433");
        Employee serhiy = new Employee(444444444L, "Serhiy", "+380630009988");
        Employee anna = new Employee(555555555L, "Anna", "+380974445566");

        Customer igor = new Customer("Igor", "Dnipro", "+380664330306", "Igor@gmail.com");
        Customer svitlana = new Customer("Svitlana", "Kyiv", "+380501234567", "sveta.k@ukr.net");
        Customer maxim = new Customer("Maxim", "Lviv", "+380679998877", "max_lviv@gmail.com");
        Customer yulia = new Customer("Yulia", "Odesa", "+380998887766", "yulia_od@me.com");
        Customer techHub = new Customer("TechHub LLC", "Kharkiv", "+380577006050", null); // "info@techhub.ua"
        Customer andriy = new Customer("Andriy", "Dnipro", "+380681110022", "andriy.work@gmail.com");
        Customer alex = new Customer("alex", "Lviv", "+380681117799", "alex.work@gmail.com");


        Invoice invoice26 = new Invoice(123456789L,
                new Date(2029 - 1900, Calendar.JANUARY, 2),
                new Date(2029 - 1900, Calendar.DECEMBER, 31),
                igor.clone(), roman, automotiveList);

        Invoice invoice25 = new Invoice(987654321L,
                new Date(2026 - 1900, Calendar.FEBRUARY, 10),
                new Date(2026 - 1900, Calendar.FEBRUARY, 28),
                svitlana.clone(), roman, electronicsList);

        Invoice invoice24 = new Invoice(456123789L,
                new Date(2026 - 1900, Calendar.APRIL, 12),
                new Date(2026 - 1900, Calendar.MAY, 12),
                svitlana.clone(), roman, lifestyleList);
        Invoice invoice23 = new Invoice(101020203L,
                new Date(2029 - 1900, Calendar.JANUARY, 2),
                new Date(2029 - 1900, Calendar.DECEMBER, 31),
                igor.clone(),
                roman, automotiveList);
        Invoice invoice22 = new Invoice(555666777L,
                new Date(2026 - 1900, Calendar.MAY, 20),
                new Date(2026 - 1900, Calendar.AUGUST, 20),
                svitlana.clone(),
                oleh, electronicsList);
        Invoice invoice21 = new Invoice(333222111L,
                new Date(2026 - 1900, Calendar.JUNE, 1),
                new Date(2026 - 1900, Calendar.JULY, 1),
                igor.clone(),
                oleh, lifestyleList);

        Invoice invoice30 = new Invoice(789020203L,
                new Date(2029 - 1900, Calendar.JANUARY, 2),
                new Date(2029 - 1900, Calendar.DECEMBER, 31),
                alex.clone(),
                roman, alexList);
        Invoice invoice31 = new Invoice(552586777L,
                new Date(2026 - 1900, Calendar.MAY, 20),
                new Date(2026 - 1900, Calendar.AUGUST, 20),
                alex.clone(),
                oleh, alexList);
        Invoice invoice32 = new Invoice(3336987111L,
                new Date(2026 - 1900, Calendar.JUNE, 1),
                new Date(2026 - 1900, Calendar.JULY, 1),
                alex.clone(),
                oleh, alexList);


        // --- Group 1: Январь - Март (Зимние/Весенние заказы) ---
        Invoice invoice1 = new Invoice(1001L, new Date(2015 - 1900, Calendar.JANUARY, 10), new Date(2026 - 1900, Calendar.JANUARY, 25), igor.clone(), roman, automotiveList);
        Invoice invoice2 = new Invoice(1002L, new Date(2026 - 1900, Calendar.JANUARY, 15), new Date(2026 - 1900, Calendar.FEBRUARY, 1), svitlana.clone(), roman, electronicsList);
        Invoice invoice3 = new Invoice(1003L, new Date(2017 - 1900, Calendar.FEBRUARY, 5), new Date(2026 - 1900, Calendar.FEBRUARY, 20), maxim.clone(), dmytro, automotiveList);
        Invoice invoice4 = new Invoice(1004L, new Date(2017 - 1900, Calendar.FEBRUARY, 20), new Date(2026 - 1900, Calendar.MARCH, 10), yulia.clone(), serhiy, lifestyleList);
        Invoice invoice5 = new Invoice(1005L, new Date(2026 - 1900, Calendar.MARCH, 2), new Date(2026 - 1900, Calendar.MARCH, 15), techHub.clone(), olena, electronicsList);

// --- Group 2: Апрель - Июнь (Весна/Лето) ---
        Invoice invoice6 = new Invoice(1006L, new Date(2015 - 1900, Calendar.APRIL, 12), new Date(2026 - 1900, Calendar.MAY, 1), svitlana.clone(), dmytro, lifestyleList); // Светлана у другого менеджера
        Invoice invoice7 = new Invoice(1007L, new Date(2017 - 1900, Calendar.APRIL, 25), new Date(2026 - 1900, Calendar.MAY, 10), igor.clone(), oleh, electronicsList); // Игорь у другого менеджера
        Invoice invoice8 = new Invoice(1008L, new Date(2026 - 1900, Calendar.MAY, 5), new Date(2026 - 1900, Calendar.MAY, 20), andriy.clone(), anna, automotiveList);
        Invoice invoice9 = new Invoice(1009L, new Date(2017 - 1900, Calendar.MAY, 15), new Date(2026 - 1900, Calendar.JUNE, 1), maxim.clone(), serhiy, electronicsList); // Максим с Сергеем
        Invoice invoice10 = new Invoice(1010L, new Date(2016 - 1900, Calendar.JUNE, 1), new Date(2026 - 1900, Calendar.JUNE, 15), techHub.clone(), roman, automotiveList); // TechHub заказывает авто у Романа
        Invoice invoice33 = new Invoice(1010L, new Date(2015 - 1900, Calendar.JUNE, 1), new Date(2015 - 1900, Calendar.JUNE, 15), techHub.clone(), cloneRoman, automotiveList); // TechHub заказывает авто у Романа

// --- Group 3: Июль - Сентябрь (Лето/Осень) ---
        Invoice invoice11 = new Invoice(1011L, new Date(2025 - 1900, Calendar.JULY, 4), new Date(2025 - 1900, Calendar.JULY, 20), yulia.clone(), olena, electronicsList); // Юлия с Оленой
        Invoice invoice12 = new Invoice(1012L, new Date(2015 - 1900, Calendar.JULY, 15), new Date(2026 - 1900, Calendar.AUGUST, 1), igor.clone(), anna, lifestyleList); // Игорь с Анной
        Invoice invoice13 = new Invoice(1013L, new Date(2026 - 1900, Calendar.AUGUST, 10), new Date(2026 - 1900, Calendar.AUGUST, 25), svitlana.clone(), oleh, automotiveList); // Светлана покупает авто у Олега
        Invoice invoice14 = new Invoice(1014L, new Date(2025 - 1900, Calendar.FEBRUARY, 2), new Date(2025 - 1900, Calendar.SEPTEMBER, 30), andriy.clone(), dmytro, electronicsList);
        Invoice invoice15 = new Invoice(1015L, new Date(2026 - 1900, Calendar.SEPTEMBER, 1), new Date(2026 - 1900, Calendar.SEPTEMBER, 15), maxim.clone(), anna, lifestyleList); // Максим с Анной

// --- Group 4: Октябрь - Декабрь (Конец года) ---
        Invoice invoice16 = new Invoice(1016L, new Date(2026 - 1900, Calendar.OCTOBER, 5), new Date(2026 - 1900, Calendar.OCTOBER, 20), techHub.clone(), oleh, lifestyleList); // TechHub подарки от Олега
        Invoice invoice17 = new Invoice(1017L, new Date(2025 - 1900, Calendar.JANUARY, 1), new Date(2025 - 1900, Calendar.DECEMBER, 15), yulia.clone(), roman, automotiveList); // Юлия снова у Романа
        Invoice invoice18 = new Invoice(1018L, new Date(2026 - 1900, Calendar.NOVEMBER, 11), new Date(2026 - 1900, Calendar.NOVEMBER, 25), andriy, olena, lifestyleList); // Андрей с Оленой
        Invoice invoice19 = new Invoice(1019L, new Date(2025 - 1900, Calendar.JANUARY, 1), new Date(2025 - 1900, Calendar.DECEMBER, 15), igor.clone(), serhiy, automotiveList); // 4-й заказ Игоря (у Сергея)
        Invoice invoice20 = new Invoice(1020L, new Date(2025 - 1900, Calendar.JANUARY, 2), new Date(2025 - 1900, Calendar.DECEMBER, 30), svitlana.clone(), anna, electronicsList); // 4-й заказ Светланы (у Анны)


        // clone invoices
        Invoice cloneInvoice1 = invoice1.clone();
        Invoice cloneInvoice2 = invoice2.clone();
        Invoice cloneInvoice3 = invoice3.clone();
        Invoice cloneInvoice4 = invoice4.clone();
        Invoice cloneInvoice5 = invoice5.clone();
        Invoice cloneInvoice6 = invoice6.clone();
        Invoice cloneInvoice7 = invoice7.clone();
        Invoice cloneInvoice8 = invoice8.clone();
        Invoice cloneInvoice9 = invoice9.clone();
        Invoice cloneInvoice10 = invoice10.clone();
        Invoice cloneInvoice11 = invoice11.clone();
        Invoice cloneInvoice12 = invoice12.clone();
        Invoice cloneInvoice13 = invoice13.clone();
        Invoice cloneInvoice14 = invoice14.clone();
        Invoice cloneInvoice15 = invoice15.clone();

//        System.out.println(" default invoice " + invoice1 + "\n");
//        System.out.println(" * * * *  ");
//        System.out.println(" clone invoice " + cloneInvoice1 + "\n");
//        invoice1.addItem(item7);
//
//        System.out.println(" invoice1.addItem(item7) " + invoice1 + "\n");
//        System.out.println(" default invoice " + invoice1 + "\n");
//        System.out.println(" clone invoice " + cloneInvoice1 + "\n");

        // сделать выборку , для каждого клиента разные даты заказов, разное кол-во инвойсов, у клиентов несколько заказов 2,3 . у 1 менеджера несколько заказов,
        List<Invoice> invoices = new ArrayList<>(Arrays.asList(
                invoice30, invoice31, invoice32,

                invoice33,
                invoice1, invoice2, invoice3, invoice4, invoice5,
                invoice6, invoice7, invoice8, invoice9, invoice10,
                invoice11, invoice12, invoice13, invoice14, invoice15,
                invoice16, invoice17, invoice18, invoice19, invoice20,
                invoice21, invoice22, invoice23, invoice24, invoice25, invoice26,

                invoice1, invoice2, invoice3, invoice4, invoice5,
                invoice6, invoice7, invoice8, invoice9, invoice10,

                cloneInvoice1, cloneInvoice2, cloneInvoice3, cloneInvoice4, cloneInvoice5, cloneInvoice6, cloneInvoice7,
                cloneInvoice8, cloneInvoice9, cloneInvoice10, cloneInvoice11, cloneInvoice12, cloneInvoice13, cloneInvoice14, cloneInvoice15
        ));
//        InvoiceController.removeDuplicates(invoices);

//        Invoice[] orders = invoices.toArray(new Invoice[0]);
//        InvoiceController.deleteDuplicates(orders);

//        Invoice[] orders1 = InvoiceController.getArray(invoices);
//        for (int i = 0; i < orders1.length; i++) {
//            System.out.println(orders1[i]);
//        }

//        double total = InvoiceController.calculateAllSum(invoices);
//        System.out.println("total sum " + total);
//
//        long countElements = InvoiceController.getUniqueAmount(invoices);
//        System.out.println("countElements: " + countElements);
//
//        Invoice[] ordersWithRange = InvoiceController.getOrdersDouToRange(invoices,
//                new Date(2026 - 1900, Calendar.APRIL, 3),
//                new Date(2026 - 1900, Calendar.SEPTEMBER, 25));
//        for (int i = 0; i < ordersWithRange.length; i++) {
//            System.out.println(" ordersWithRange: \n" + ordersWithRange[i] + "\n");
//        }

//        List<Customer> customerList = new ArrayList<>();
//        Collections.addAll(customerList, maxim, techHub, yulia.clone());
//        Invoice[] ordersWithClients = InvoiceController.getClientsOrders(invoices, customerList);
//        for (int i = 0; i < ordersWithClients.length; i++) {
//            System.out.println(" ordersWithClients: \n" + ordersWithClients[i] + "\n");
//        }
//        invoices.forEach(i -> System.out.println(i));
//        System.out.println("* * * * * ");
//        InvoiceController.getInvoicesWithSomeSum(invoices, 150000.99).forEach(i -> System.out.println(i));
//        InvoiceController.calculateDiscountForOrders(invoices, 1700.00, 27);
//        double result = InvoiceController.getManagersTotalSum(invoices, serhiy);
//        System.out.println( " result " + result );

//        Optional<Invoice> min = InvoiceController.getInvoiceWithMinTotalSumBeforeDate(invoices, new Date(2026 - 1900, Calendar.APRIL, 3));
//
//        if (min.isPresent()) {
//            System.out.println(" min Invoice \n" + min);
//        } else System.out.println(" min is not exist ");

//        InvoiceController.getSortedInvoices(invoices).forEach(i -> System.out.println(i));
//        Invoice[] arr = InvoiceController.getInvoicesSortedByTotalSum(invoices);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        List<String> operator = List.of("+38067", "+38068", "+38096", "+38097", "+38098");
//        //   InvoiceController.getInvoicesForCurrentOperator(invoices, operator).forEach(i -> System.out.println(i));
//
//        invoices.forEach(i -> System.out.println(i));
//
//        long result = InvoiceController.getNumCustomerWithoutEmail(invoices);
//        System.out.println(" result " + result);
//
//        List<Employee> list = InvoiceController.getEmployeeListByWorkingStartDate(invoices, new Date(2015 - 1900, Calendar.JANUARY, 2));
//
//        System.out.println(" Employee start 2015, JANUARY, 2 \n ");
//        list.forEach(i -> System.out.println(i));

//        InvoiceController.getCustomersReversedOrder(invoices).forEach(i -> System.out.println(i));
//        int total = InvoiceController.getSalesAmountOfCurrentItem(invoices,
//                new Date(2029 - 1900, Calendar.JANUARY, 1),
//                new Date(2029 - 1900, Calendar.DECEMBER, 31),item25);
//        System.out.println("total for item 25 : " + total);

//        double total = InvoiceController.getTotalInvoiceSum(invoices);
//        System.out.println(" total sum: " + total);
//
//        double total1 = InvoiceController.calculateAllSum(invoices);
//        System.out.println(" total1 sum: " + total1);

//            long unique = InvoiceController.getUniqueAmount(invoices);
//        System.out.println(unique);

//        List<String> itemTitles = InvoiceController.getItemsSortedByAlphabet(invoices);
//        itemTitles.forEach(i -> System.out.println(i + " \n"));
//
//        System.out.println(InvoiceController.getClientWithTheLongestName(invoices));
//        InvoiceController.getCustomersSetVipCustomers(invoices, 210.10).forEach(invoice -> System.out.println(invoice));
//        Item maxItemForDate = InvoiceController.getTheMostExpensiveItemByDay(invoices,new Date(2015 - 1900, Calendar.JANUARY, 10));
//        System.out.println(" maxItemForDate: " + maxItemForDate+ "\n");
//        automotiveList.forEach(i-> System.out.println(i));
//
//        double average = InvoiceController.getAverageInvoicesTotalPriceByPeriodLastTwoMonth(invoices);
//        System.out.println(Math.round(average));

//        Map<Customer, Integer> map = InvoiceController.getOrderAmountForEachCustomer(invoices);
//        map.forEach((k, v) -> System.out.println("Customer: " + k + " Amount: " + v));

//        Map<Customer, List<Invoice>> map = InvoiceController.getAllInvoicesByEachCustomer(invoices);
////        map.forEach((k, v) -> System.out.println("\t customer invoices:" + k.getName()+ "\n" + k + v));
//        for (Customer k : map.keySet()) {
//            System.out.println("Customer: \n" + k);
//            System.out.println("Customer: \n" + k.getName().toUpperCase() + " values\n " + map.get(k));
//        }
//        Map<Employee,Double> map = InvoiceController.getTotalEarnedMoneyForEachEmployee(invoices);
//        for (Employee employee : map.keySet()) {
//            System.out.println(employee);
//            System.out.println(employee.getName().toUpperCase() + " values: " + map.get(employee));
//        }

//        Map<Item, Double> map = InvoiceController.getTotalSaleSumForEachSoldItem(invoices);
//        int j = 1;
//        for (Item i : map.keySet()) {
//            System.out.println("# " + j++ + i + " VALUES TOTAL: " + map.get(i));
//        }

//        Map<Customer, Double> map = InvoiceController.getAverageInvoicesSumForEachCustomer(invoices);
//        int j = 1;
//        for (Customer i : map.keySet()) {
//            System.out.println("# " + j++ + " - " +i + " VALUES AVERAGE : " + map.get(i));
//        }
//
//        System.out.println("invoice30.getTotalInvoice()" + invoice30.getTotalInvoice());
//        System.out.println("invoice31.getTotalInvoice()" + invoice31.getTotalInvoice());
//        System.out.println("invoice32.getTotalInvoice()" + invoice32.getTotalInvoice());

//        invoices
//                .stream().sorted((i1, i2) -> Double.compare(i2.getTotalInvoice(), i1.getTotalInvoice()))
//                .forEach(i -> System.out.println("Employee : " + i.getManager().getName() + " Total: " + i.getTotalInvoice()));
//        System.out.println(" ****************************** ");
//        InvoiceController.getClientsWithTheMostExpensiveOrders(invoices).forEach(customer -> System.out.println("name: " + customer.getName()));
//        invoices
//                .stream()
//                .flatMap(invoice -> invoice.getItems().stream())
//                .sorted()
//                .distinct()
//                .forEach(i -> System.out.println(" invoices item: title: " + i.getTitle() + " price: " +  i.getPrice()));
//
//        InvoiceController.getTheMostExpensiveItems(invoices).forEach(i -> System.out.println(" item name: " + i.getTitle() + " item price: " + i.getPrice()));
//        InvoiceController.getNameAndPhoneOfCustomerWithHighestAmountOfOrders(invoices).forEach(t-> System.out.println(t));
//        invoices.stream().collect(Collectors.toSet()).forEach(invoice -> System.out.println(invoice.getClient().getName()));

//         InvoiceController.getEmployeeWhoGainMuchMoney(invoices).forEach(t-> System.out.println(t));
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//                invoices
//                .stream()
//                .map(invoice -> invoice.getStartDate())
//                .sorted()
//                .distinct()
//                .forEach(i -> System.out.println(" invoices item: title: " + sdf.format(i) + "\n******************"));


//        InvoiceController.getDateWithTheHighestNumberOfOrders(invoices).forEach(date -> System.out.println(sdf.format(date)));

//        InvoiceController.getTheMostSoldItems(invoices).forEach(i -> System.out.println(i.getTitle()));

//        InvoiceController.getManagersOrders(invoices).forEach((k, v) -> {
//            System.out.println("Manager: " + k.getName() + "\n");
//            v.forEach(invoice -> System.out.println("Invoices: " + invoice.getId() + "\n"));
//        });
//        long time = InvoiceController.getFirmsLifeTime(invoices);
//        System.out.println(time);
//
//        Map<Item,LongSummaryStatistics> map = InvoiceController.getSoldItemsAmountByPeriod(invoices, new Date(2015 - 1900, Calendar.JANUARY, 10), new Date(2016 - 1900, Calendar.DECEMBER, 31));
//        map.forEach((k,v)-> System.out.println(" Item name: " + k.getTitle() + ", amount: " + v.getSum()));
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        InvoiceController
//                .getTotalErneadSumForEachDayByYear(invoices, new Date(2026 - 1900, Calendar.JANUARY, 1), new Date(2026 - 1900, Calendar.DECEMBER, 31))
//                .forEach((k, v) -> System.out.println("Day of year: " + sdf.format(k) + " , sum: " + v.getSum()));

        InvoiceController.getAverageInvoicesSumForEachCustomer(invoices).forEach((k, v) -> System.out.println("Client: " + k.getName() + ", average sum: " + v));
    }
}
