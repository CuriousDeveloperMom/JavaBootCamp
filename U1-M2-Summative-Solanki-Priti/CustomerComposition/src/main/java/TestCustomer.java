public class TestCustomer {

    public static void main(String[] args) {

        Address billingAddress = new Address("161", "newark lane", "jersey city", "NJ", "08909");
        Address shippingAddress = new Address("383", "bill lane", "Edison", "NJ", "08909");
        Customer cust = new Customer();
        String name = cust.getFirstName();
        System.out.println(name);


    }
}
