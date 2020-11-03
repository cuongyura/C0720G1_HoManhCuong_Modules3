
import java.util.ArrayList;
import java.util.List;

    public class CreateCustomer {
        static List<Customer> customerList = new ArrayList<>();

        static {
            customerList.add(new Customer("Bé Anh 2k1","01/01/2001","Huế","image/1.jpg"));
            customerList.add(new Customer("Bé Ngân 2k","01/02/2000","Đà Nẵng","image/2.jpg"));
            customerList.add(new Customer("Bé Thảo 99","06/01/1999","Quảng Ngãi","image/3.png"));
            customerList.add(new Customer("Bé Na 2k2","29/06/2002","Phú Thọ","image/4.jpg"));

        }

        public static List<Customer> getCustomerList() {
            return customerList;
        }
    }

