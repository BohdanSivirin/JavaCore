package oop.stream.invoices;

import oop.multiTreading.bShop.Client;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InvoiceController {
    //принимаем лист инвойсов и избавляемся от дубликатов. Потом распечатываем инвойсы
    public static void removeDuplicates(List<Invoice> invoiceList) {
        Stream<Invoice> invoiceStream = invoiceList.stream();
        Stream<Invoice> sortedStream = invoiceStream.distinct();
        sortedStream.forEach(invoice -> System.out.println(invoice));
    }

    //принимаем массив инвойсов и избавляемся от дубликатов
    public static void deleteDuplicates(Invoice[] arr) {
        Stream<Invoice> deleted = Arrays.stream(arr).distinct();
        deleted.forEach(i -> System.out.println(i));
    }

    //принимаем лист инвойсов. возвращаем массив инвойсов без дубликатов
    public static Invoice[] getArray(List<Invoice> invoices) {
        Stream<Invoice> stream = invoices.stream().distinct();
        IntFunction<Invoice[]> gen = (i) -> new Invoice[i];
        Invoice[] array = stream.toArray(gen);
        return array;
    }

    //принимаем инвойсы и возвращаем общую заработанную на заказах сумму
    public static double calculateAllSum(List<Invoice> invoices) {
        double[] total = {0};
        invoices.stream().distinct().forEach((invoice -> total[0] += invoice.getTotalInvoice()));
        return total[0];
    }

    //получаем заказы и возвращаем количество уникальных заказов
    public static long getUniqueAmount(List<Invoice> invoices) {
        return invoices.stream().distinct().count();
    }

    //принимаем инвойсы и 2 даты и возвращаем массив заказов , сделанных в этот период
    public static Invoice[] getOrdersDouToRange(List<Invoice> invoices, Date start, Date end) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().after(start) && invoice.getExpDate().before(end))
                .toArray(i -> new Invoice[i]);
    }

    //принимаем заказы и список клиентов и возвращаем массив заказов этих клиентов
    public static Invoice[] getClientsOrders(List<Invoice> invoices, List<Customer> clients) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> clients.contains(invoice.getClient()))
                .toArray(i -> new Invoice[i]);
    }

    //принимаем заказы и сумму и возвращаем лист заказов, общая цена которых меньше переданной
    public static List<Invoice> getInvoicesWithSomeSum(List<Invoice> invoices, double sum) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getTotalInvoice() < sum)
                .toList();
    }

    //возвращаем уникальные заказы не используя дистинкт
    public static Set<Invoice> getOrdersWithoutDuplicates(List<Invoice> invoices) {
        return invoices.stream().collect(Collectors.toSet());
    }

    //    принимаем заказы и некую сумму и процент скидки и делаем скидки на заказы в которых суммы заказа не меньшн переданной
    public static void calculateDiscountForOrders(List<Invoice> invoices, double sum, int discountPercent) {
//        invoices
//                .stream()
//                .distinct()
//                .filter(invoice -> invoice.getTotalInvoice() > sum)
//                .forEach(invoice -> invoice.setTotalDiscount(discountPercent));
        Stream<Invoice> stream = invoices.stream().distinct();
//        stream.forEach(invoice -> {
//            if (invoice.getTotalInvoice() > sum) {
//                invoice.setTotalDiscount(discountPercent);
//            }
//        });
//        stream.forEach(i -> System.out.println(i));

        List<Invoice> invoicesWithDiscount = stream.peek(invoice -> {
            if (invoice.getTotalInvoice() >= sum) {
                invoice.setTotalDiscount(discountPercent);
            }
        }).toList();
        invoicesWithDiscount.forEach(i -> System.out.println(i));
    }

    //принимаем инвойсы и некоторого менеджера и возвращаем сумму которую он принес для компании
    public static Double getManagersTotalSum(List<Invoice> invoices, Employee employee) {
        final double[] total = {0};
        invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getManager().equals(employee))
                .forEach(invoice -> total[0] += invoice.getTotalInvoice());
        return Math.round(total[0] * 1000) / 1000.0;
    }

    //найти самый дешевый заказ сделанный до такогото числа и возвратить его
    public static Optional<Invoice> getInvoiceWithMinTotalSumBeforeDate(List<Invoice> invoices, Date date) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().before(date))
                .min((o1, o2) -> Double.compare(o1.getTotalInvoice(), o2.getTotalInvoice()));
    }

    //найти дату самого старого заказа
    public static Date getOldestDate(List<Invoice> invoices) {
        Optional<Invoice> invoice = invoices
                .stream()
                .distinct()
                .min(((o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate())));
//                .min((Comparator.comparing(Invoice::getStartDate)));
        return invoice.get().getStartDate();
    }

    //возвратить заказы без дублей,  отсортированные по убыванию их номером
    // (использовать метод сортед и имплементировать инвойсу интерфейск комперабле)
    public static List<Invoice> getSortedInvoices(List<Invoice> invoices) {
        return invoices.stream().distinct().sorted().toList();
    }

    //найти и возвратить отсортированный по возрастанию общей стоимости массив инвойсов (метод сортед с аргументом)
    public static Invoice[] getInvoicesSortedByTotalSum(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .sorted((invoice1, invoice2) -> Double.compare(invoice1.getTotalInvoice(), invoice2.getTotalInvoice()))
                .toArray(i -> new Invoice[i]);
    }

    //найти самый дорогой товар, продававшийся в период
    public static Optional<Item> getTheMostExpensiveItemInPeriod(List<Invoice> invoices, Date start, Date end) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().after(start) && invoice.getExpDate().before(end))
                .max(
                        (inv1, inv2) ->
                                Double.compare(inv1.getTheMostExpensiveItem().get().getPrice(), inv2.getTheMostExpensiveItem().get().getPrice())
                ).get().getTheMostExpensiveItem();
    }

    //принимаем инвойсы и возвращаем инвойсы покупателей, телефоны которых такого-то оператора
    public static List<Invoice> getInvoicesForCurrentOperator(List<Invoice> invoices, List<String> operators) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> operators.contains(invoice.getClient().getPhone().substring(0, 6)))
                .toList();
//                .filter(invoice -> {
//                    boolean[] arr = {false};
//                    operators.forEach(operator -> {
//                        if (invoice.getClient().getPhone().startsWith(operator)) {
//                            arr[0] = true;
//                        }
//                    });
//                    return arr[0];
//                }).toList();
    }

    //сколько клиентов не имеют эмейлов?
    public static long getNumCustomerWithoutEmail(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getClient().getEmail() == null || invoice.getClient().getEmail().isEmpty())
                .count();
    }

    //принимаем инвойсы и возвращает список сотрудников, которые оформляют заказы в конторе начиная с такого-то года
    public static List<Employee> getEmployeeListByWorkingStartDate(List<Invoice> invoices, Date date) {
//        Function<Invoice,Employee> mapper = (invoice) -> invoice.getManager();
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().after(date))
                .map((invoice) -> invoice.getManager())
                .distinct()
                .toList();
    }

    //просмотреть список клиентов в отсортированных в порядке их имен но с конца алфавита
    public static List<Customer> getCustomersReversedOrder(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .map((invoice -> invoice.getClient()))
                .sorted((customer1, customer2) -> customer2.getName().compareTo(customer1.getName()))
                .toList();
    }

    //найти количество (шт) проданного такого-то товара за период
    public static int getSalesAmountOfCurrentItem(List<Invoice> invoices, Date start, Date end, Item item) {
        int[] value = {0};
        invoices
                .stream()
                .distinct()
                .filter((invoice -> invoice.getStartDate().after(start) && invoice.getStartDate().before(end)))
                .flatMap((invoice -> invoice.getItems().stream()))
                .filter(item1 -> item1.equals(item))
                .forEach(item1 -> value[0] += item1.getAmount());
        return value[0];
    }

    //без использования массива, найти общую заработанную на заказах сумму денег (используем метод reduce())
    public static Double getTotalInvoiceSum(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .map((invoice -> invoice.getTotalInvoice()))
                .reduce(((invoice, invoice2) -> Double.sum(invoice, invoice2)))
                .get();
    }

    //принимаем заказы и возвращаем количество всех уникальных товаров (не штук)
    public static long getUniqueItemsAmount(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .collect(Collectors.toSet())
                .size();
    }

    //принимаем заказы, возвращаем отсортированный по алфавиту список названий товаров
    public static List<String> getItemsSortedByAlphabet(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .map(item -> item.getTitle())
                .sorted((item1, item2) -> item1.compareTo(item2))
                .distinct()
                .toList();
    }

    //найти клиента в самым длинным именем, возвратить имя
    public static String getClientWithTheLongestName(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .map(invoice -> invoice.getClient().getName())
                .max((n1, n2) -> n1.length() - n2.length())
                .get();

    }

    //у клиентов заказов, стоимость которых превышает заданную сделать отметку что он vip
    public static List<Invoice> getCustomersSetVipCustomers(List<Invoice> invoices, double vipSum) {
        return invoices
                .stream()
                .distinct()
//                .filter(invoice -> invoice.getTotalInvoice() > vipSum)
                .peek(invoice -> {
                    if (invoice.getTotalInvoice() > vipSum) {
                        invoice.setCustomerVip();
                    }
                })
                .toList();
    }

    //найти самый дорогой товар, что продавадся в такой-то день
    public static Item getTheMostExpensiveItemByDay(List<Invoice> invoices, Date date) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().equals(date))
                .flatMap(invoice -> invoice.getItems().stream())
                .max((item1, item2) -> Double.compare(item1.getPrice(), item2.getPrice()))
                .get();

    }

    // найти среднюю стоимость заказов за последний месяц (полтора или 2)
    public static Double getAverageInvoicesTotalPriceByPeriodLastTwoMonth(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice ->
                        invoice
                                .getStartDate()
                                .toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                                .isAfter(LocalDate.now().minusMonths(2)))
                .mapToDouble(invoice -> invoice.getTotalInvoice())
                .average()
                .orElse(0.0);
    }

    //найти количество заказов, сделанных каждым клиентом
    public static Map<Customer, Integer> getOrderAmountForEachCustomer(List<Invoice> invoices) {
        HashMap<Customer, Integer> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Integer count = map.get(invoice.getClient());
                    if (count == null) {
                        map.put(invoice.getClient(), 1);
                    } else {
                        map.put(invoice.getClient(), count + 1);
                    }
                });

//        invoices.stream().distinct().forEach(invoice -> {
//            // Если клиента нет - ставим 1, если есть - прибавляем 1
//            map.merge(invoice.getClient(), 1, Integer::sum);
//        });

//         Integer::sum ==  (oldValue, newValue) -> oldValue + newValue ==
        return map;
    }

    //принимаем заказы и возвращаем заказы каждого из клиентов по отдельности
    public static Map<Customer, List<Invoice>> getAllInvoicesByEachCustomer(List<Invoice> invoices) {
        HashMap<Customer, List<Invoice>> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Customer c = invoice.getClient();
                    if (map.containsKey(c)) {
                        List<Invoice> list = map.get(c);
                        list.add(invoice);
                    } else {
                        List<Invoice> list = new ArrayList<>();
                        list.add(invoice);
                        map.put(c, list);
                    }
                });
        return map;
    }

    //найти заработанные каждым менеджером суммы на оформленных заказах
    public static Map<Employee, Double> getTotalEarnedMoneyForEachEmployee(List<Invoice> invoices) {
        Map<Employee, Double> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Employee e = invoice.getManager();
                    if (map.containsKey(e)) {
                        double value = Double.sum(map.get(e), invoice.getTotalInvoice());
                        map.put(e, Math.round(value * 100) / 100.00);
                    } else map.put(e, 0.0);
                });
        return map;
    }

    //найти суму денег, на которую продано каждый из товаров
    public static Map<Item, Double> getTotalSaleSumForEachSoldItem(List<Invoice> invoices) {
        Map<Item, Double> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .forEach(i -> {
                    if (!map.containsKey(i)) {
                        map.put(i, i.getTotal());
                    } else {
                        double value = Double.sum(map.get(i), i.getTotal());
                        map.put(i, Math.round(value * 100) / 100.00);
                    }
                });
        return map;
    }

    //определить среднюю стоимость заказов для каждого из клиентов
    public static Map<Customer, Double> getAverageInvoicesSumForEachCustomer(List<Invoice> invoices) {
        Map<Customer, Double> map = new HashMap<>();
        Map<Customer, Integer> counter = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Customer c = invoice.getClient();
                    if (!map.containsKey(c)) {
                        map.put(c, invoice.getTotalInvoice());
                        counter.put(c, 1);
                    } else {
                        map.put(c, Double.sum(map.get(c), invoice.getTotalInvoice()));
                        counter.put(c, counter.get(c) + 1);
                    }
                });
        map.forEach((k, v) -> map.put(k, Math.round(v / counter.get(k) * 100) / 100.0));
        return map;
    }

    //найти клиентов, которые сделали самые дорогие заказы
    public static List<Customer> getClientsWithTheMostExpensiveOrders(List<Invoice> invoices) {
        double maxSum = invoices
                .stream()
                .distinct()
                .max((invoice1, invoice2) -> Double.compare(invoice2.getTotalInvoice(), invoice1.getTotalInvoice()))
                .get()
                .getTotalInvoice();

        return new ArrayList<>(invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getTotalInvoice() == maxSum)
                .map(invoice -> invoice.getClient())
                .collect(Collectors.toSet()));
    }

    //принимаем заказы и возвращаем замый дорогой товар (но их может быть несколько)
    public static List<Item> getTheMostExpensiveItems(List<Invoice> invoices) {
        double price = invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .max((i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice()))
                .get()
                .getPrice();

        return new ArrayList<>(invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .filter(i -> i.getPrice() == price)
                .collect(Collectors.toSet()));
    }

    //найти  имяи телефон клиентов? сделавших наибольшее кол-во заказов
    public static List<String> getNameAndPhoneOfCustomerWithHighestAmountOfOrders(List<Invoice> invoices) {
        Map<Customer, Integer> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Customer c = invoice.getClient();
                    if (!map.containsKey(c)) {
                        map.put(c, 1);
                    } else {
                        map.put(c, map.get(c) + 1);
                    }
                });

        Integer maxValue = map
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getValue())
                .max()
                .getAsInt();

        List<String> list = new ArrayList<>();
        map
                .entrySet()
                .stream()
                .filter((k) -> k.getValue().equals(maxValue))
                .forEach((k) -> Collections.addAll(list, "Customer: " + k.getKey().getName() + ", Phone: " + k.getKey().getPhone()));
        return list;
    }

    // найти менеджеров, которые принесли компании наибольшую прибыль
    public static List<String> getEmployeeWhoGainMuchMoney(List<Invoice> invoices) {
        Map<Employee, Double> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .forEach(invoice -> {
                    Employee e = invoice.getManager();
                    if (!map.containsKey(e)) {
                        map.put(e, invoice.getTotalInvoice());
                    } else {
                        map.put(e, Double.sum(invoice.getTotalInvoice(), map.get(e)));
                    }
                });

        Double total = map
                .entrySet()
                .stream()
                .mapToDouble(e -> e.getValue())
                .max()
                .getAsDouble();

        return map
                .entrySet()
                .stream()
                .filter(employeeDoubleEntry -> employeeDoubleEntry.getValue().equals(total))
                .map(employeeDoubleEntry -> employeeDoubleEntry.getKey().getName())
                .toList();
    }

    // найти даты, в которые было больше всего заказов
    public static List<Date> getDateWithTheHighestNumberOfOrders(List<Invoice> invoices) {
        Map<Date, Integer> map = new HashMap<>();
        invoices.stream().distinct().forEach(invoice -> {
            Date date = invoice.getStartDate();
            if (!map.containsKey(date)) {
                map.put(date, 1);
            } else {
                map.put(date, map.get(date) + 1);
            }
        });
        Integer maxValue = map
                .entrySet()
                .stream()
//                .mapToInt(e -> e.getValue())
                .max((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()))
                .get()
                .getValue();
//                .getAsInt();

        return map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(maxValue))
                .map(e -> e.getKey())
                .toList();
    }

    //найти товар, который был продан за все время в максимальном количестве (шт)
    public static List<Item> getTheMostSoldItems(List<Invoice> invoices) {
        Map<Item, Integer> map = new HashMap<>();
        invoices
                .stream()
                .distinct()
                .flatMap(invoice -> invoice.getItems().stream())
                .forEach(i -> {
                    if (!map.containsKey(i)) {
                        map.put(i, i.getAmount());
                    } else {
                        map.put(i, map.get(i) + i.getAmount());
                    }
                });
//        map
//        .entrySet()
//        .stream()
//        .sorted(((e1,e2)->e2.getValue()- e1.getValue()))
//        .forEach(e-> System.out.println(" key: " + e.getKey().getTitle() + " value: " + e.getValue() + "\n*****************"));

        Integer max = map
                .entrySet()
                .stream()
                .max((i1, i2) -> i1.getValue() - i2.getValue())
                .get()
                .getValue();

        return map
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(max))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
    }

    //возвратить оформленные каждым менеджером заказы
    public static Map<Employee, List<Invoice>> getManagersOrders(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(invoice -> invoice.getManager()));
    }

    //найти количество дней, которые работала фирма
    public static Long getFirmsLifeTime(List<Invoice> invoices) {
        return invoices
                .stream()
                .map(invoice -> invoice.getStartDate())
                .distinct()
                .count();
    }

    // принимаем заказы и находим количество заказов сделанных каждым клиентом
    public static Map<Customer, Long> getCustomersAmountOfOrders(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(invoice -> invoice.getClient(), Collectors.counting()));
    }

    //найти количество каждого из проданных товаров в период
    public static Map<Item, LongSummaryStatistics> getSoldItemsAmountByPeriod(List<Invoice> invoices, Date start, Date end) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().after(start) && invoice.getExpDate().before(end))
                .flatMap(invoice -> invoice.getItems().stream())
                .collect(Collectors.groupingBy(item -> item, Collectors.summarizingLong(item -> item.getAmount())));
    }

    // найти заработанные за каждый день такогото года суммы
    public static Map<Date, DoubleSummaryStatistics> getTotalErneadSumForEachDayByYear(List<Invoice> invoices, Date start, Date end) {
        return invoices
                .stream()
                .distinct()
                .filter(invoice -> invoice.getStartDate().after(start) && invoice.getExpDate().before(end))
                .collect(Collectors.groupingBy(
                        invoice -> invoice.getStartDate(),
                        Collectors.summarizingDouble(invoice -> invoice.getTotalInvoice())));
    }

    //найти для каждого клиента среднюю стоимость его заказов
    public static Map<Customer, Double> getAverageOrdersPriceForEachCustomer(List<Invoice> invoices) {
        return invoices
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(invoice -> invoice.getClient(),
                        Collectors.averagingDouble(invoice->invoice.getTotalInvoice())));

    }
}