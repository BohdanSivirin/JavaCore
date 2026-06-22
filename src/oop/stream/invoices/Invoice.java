package oop.stream.invoices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Invoice implements Cloneable, Comparable<Invoice> {
    private long id;
    private Date startDate;
    private Date expDate;
    private Customer client;
    private Employee manager;
    private List<Item> items = new ArrayList<>();
    private double totalDiscount = 1.0;

    public Invoice(long id, Date startDate, Date expDate, Customer client, Employee manager, List<Item> items) {
        this.id = id;
        this.startDate = startDate;
        this.expDate = expDate;
        this.client = client;
        this.manager = manager;
        this.items = items;
    }

    public Invoice(long id, Date startDate, Date expDate, Customer client, Employee manager) {
        this.id = id;
        this.startDate = startDate;
        this.expDate = expDate;
        this.client = client;
        this.manager = manager;
    }

    public void setCustomerVip() {
        client.setVipValue(true);
    }

    public Invoice clone() {
        Invoice invoice = new Invoice(this.id, this.startDate, this.expDate, this.client.clone(), this.manager.clone());
        items.forEach(i -> invoice.addItem(i.clone()));
        return invoice;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder("\nid: " + id
                                             + "\nstart date: " + simpleDateFormat.format(startDate)
                                             + "\nexp date: " + simpleDateFormat.format(expDate)
                                             + "\nclient: " + client
                                             + "\nmanager: " + manager
                                             + "\nitems: \n");
        final int[] i = {1};
        items.forEach(item -> sb.append(i[0]++ + ")" + item + "\n"));
        sb.append("Total: " + getTotalInvoice() + "\n");
        return sb.toString();
    }

    public double getTotalInvoice() {
//        final double[] totalSum = {0};
//        items.forEach(i -> totalSum[0] += i.getTotal());
//        return Math.round(totalSum[0] * 1000) / 1000.0;
        return items
                .stream()
                .map((item -> item.getTotal()))
                .reduce(((sum1, sum2) -> sum1 + sum2))
                .get();
    }

    public void setTotalDiscount(int discount) {
        this.totalDiscount = discount / 100.0;
    }

    public void addItem(Item item) {
        int position = items.indexOf(item);
        if (position == -1) {
            items.add(item);
        } else {
            items.get(position).addAmount();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Invoice invoice)) return false;
        return id == invoice.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        return 17 * hashCode + Long.hashCode(id);
    }

    public long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public Customer getClient() {
        return client;
    }

    public Employee getManager() {
        return manager;
    }

    public List<Item> getItems() {
        return items;
    }

    public Optional<Item> getTheMostExpensiveItem() {
        return items.stream().max((i1, i2) -> Double.compare(i1.getPrice(), i2.getPrice()));
    }

    @Override
    public int compareTo(Invoice o1) {
        return Long.compare(o1.id, this.id);
    }

}
