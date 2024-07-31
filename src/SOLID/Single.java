package SOLID;

public class Single {
    public static void main(String[] args) {

    }
}

class InvoiceController {
    private int quantity;
    private int price;

    public InvoiceController(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    // 3 reasons to change
    public int totalAmount() {
        return quantity * price;
        // return (quantity * price) + GST;
    }

    public void printInvoice() {
        System.out.println(totalAmount());
    }

    public void saveToDB() {
        // DB Saving
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

// Composition
class InvoiceDao {
    Invoice invoice;

    // Dependency Injection
    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // DB Saving
    }
}

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println(invoice.totalAmount());
    }

}
