package model.human;

public class Human {

    private int idCustomer;
    private String customerName;
    private String dateOfBirth;
    private String gender;
    private String customerIdCard;
    private String customerPhoneNumb;
    private String customerEmail;

    public Human() {
    }

    public Human(int idCustomer, String customerName, String dateOfBirth, String gender, String customerIdCard, String customerPhoneNumb, String customerEmail) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.customerIdCard = customerIdCard;
        this.customerPhoneNumb = customerPhoneNumb;
        this.customerEmail = customerEmail;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhoneNumb() {
        return customerPhoneNumb;
    }

    public void setCustomerPhoneNumb(String customerPhoneNumb) {
        this.customerPhoneNumb = customerPhoneNumb;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
