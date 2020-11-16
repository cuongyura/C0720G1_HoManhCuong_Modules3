package model.employee;

public class Employee {
    private int employee_id;
    private String employeeName;
    private String dateOfBirth;
    private String idCard;
    private String employeePhoneNumb;
    private double salary;
    private String employeeEmail;
    private String employeeAddress;
    private String position_id;
    private String education_id;
    private String division_id;
    private String userName;

    public Employee(int employee_id, String employeeName, String dateOfBirth, String idCard, String employeePhoneNumb, double salary,
                    String employeeEmail, String employeeAddress, String position_id, String education_id, String division_id, String userName) {
        this.employee_id = employee_id;
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.employeePhoneNumb = employeePhoneNumb;
        this.salary = salary;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position_id = position_id;
        this.education_id = education_id;
        this.division_id = division_id;
        this.userName = userName;
    }

    public Employee(String employeeName, String dateOfBirth, String idCard, String employeePhoneNumb, double salary, String employeeEmail,
                    String employeeAddress, String position_id, String education_id, String division_id, String userName) {
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.employeePhoneNumb = employeePhoneNumb;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position_id = position_id;
        this.education_id = education_id;
        this.division_id = division_id;
        this.userName = userName;
        this.salary = salary;
    }
    public Employee(){}

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmployeePhoneNumb() {
        return employeePhoneNumb;
    }

    public void setEmployeePhoneNumb(String employeePhoneNumb) {
        this.employeePhoneNumb = employeePhoneNumb;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getEducation_id() {
        return education_id;
    }

    public void setEducation_id(String education_id) {
        this.education_id = education_id;
    }

    public String getDivision_id() {
        return division_id;
    }

    public void setDivision_id(String division_id) {
        this.division_id = division_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employeeName='" + employeeName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idCard='" + idCard + '\'' +
                ", employeePhoneNumb='" + employeePhoneNumb + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", position_id='" + position_id + '\'' +
                ", education_id='" + education_id + '\'' +
                ", division_id='" + division_id + '\'' +
                ", userName='" + userName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
