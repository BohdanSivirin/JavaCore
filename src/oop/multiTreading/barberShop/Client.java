package oop.multiTreading.barberShop;

public class Client {
    private final long id;
    private final long startTime;

    public Client(long id) {
        this.id = id;
        this.startTime = System.currentTimeMillis();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Client client)) {
            return false;
        }
        return client.id == id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(id);
        return hashCode;
    }

    public long getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "Client{" +
               "id=" + id +
               '}';
    }
}
