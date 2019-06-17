public class TestCustomer {

    public static void main(String[] args) {

        Customer cust = new Customer();
        Address billingAddress = new Address();
        Address shippingAddress = new Address();
        String name = cust.getFirstName();
        System.out.println(name);


    }
}
