package SOLID;

public class OpenClosed {
    public static void main(String[] args) {

    }
}

class Invoice {
    private int quantity;
    private int price;

    public Invoice(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    // 3 reasons to change
    public int totalAmount() {
        return quantity * price;
        // return (quantity * price) + GST;
    }
}

// Already tested file in production mode
// Now i have to modify it by adding one more method which makes it prone to
// bugs
class InvoiceDao {
    Invoice invoice;

    // Dependency Injection
    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToMysql() {
        // MySql Saving
    }
}

interface InvoiceDaoInterface {
    void save();
}

class InvoiceMySql implements InvoiceDaoInterface {

    @Override
    public void save() {
        // MySQL DB Saving
    }
}

class InvoiceMongo implements InvoiceDaoInterface {

    @Override
    public void save() {
        // Mongo DB Saving
    }
}
