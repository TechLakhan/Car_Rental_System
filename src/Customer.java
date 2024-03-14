public class Customer {

    private String customerName;

    private String customerId;

    private String documents;

    public Customer(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.documents = documents;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
}
