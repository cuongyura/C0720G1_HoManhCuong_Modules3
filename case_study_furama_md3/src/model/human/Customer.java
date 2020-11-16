package model.human;

public class Customer extends Human {
    private String typeCustomer;
    private String customerAddress;

    public Customer() {
    }

    public Customer(int idCustomer, String customerName, String dateOfBirth, String gender, String customerIdCard, String customerPhoneNumb, String customerEmail, String typeCustomer, String customerAddress) {
        super(idCustomer, customerName, dateOfBirth, gender, customerIdCard, customerPhoneNumb, customerEmail);
        this.typeCustomer = typeCustomer;
        this.customerAddress = customerAddress;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
