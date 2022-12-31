package main;

import configuration.JPAConfig;
import entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.CustomerRepo;

import java.time.LocalDate;
import java.util.List;

public class MainCustomer {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepo customerRepo = applicationContext.getBean("customerRepo", CustomerRepo.class);

    public static void main(String[] args) {
//  customerRepo.deleteAll();
//  createNewCustomer();
//============================find all==============================
        List<Customer> lCus1 = (List<Customer>) customerRepo.findAll();
        for (Customer customer:lCus1) {
            System.out.println(customer.toString());
        }
//===========================find by id=============================
        List<Customer> lCus0 = (List<Customer>) customerRepo.findById(5);
        for (Customer customer : lCus0) {
            System.out.println(customer.toString());
        }

//===========================find by name===============================
        List<Customer> lCus2 = (List<Customer>) customerRepo.findByName("ty");
        for (Customer customer : lCus2) {
            System.out.println(customer.toString());
        }
//===========================find by phone of email=====================

        List<Customer> lCus3 = (List<Customer>) customerRepo.getCustomerByPhoneOrEmail(123456, "ty22k2@gmail.com");
        for (Customer customer : lCus3) {
            System.out.println(customer.toString());
        }

//===========================find theo tuổi=============================
        List<Customer> lCus4 = (List<Customer>) customerRepo.getCustomerByAge();
        for (Customer customer : lCus4) {
            System.out.println(customer.toString());
        }
    }



    public static void createNewCustomer() {
        Customer customer = new Customer();
        customer.setName("ty");
        customer.setBirthdate(LocalDate.parse("2022-01-01"));
        customer.setSex("nam");
        customer.setEmail("ty22k2@gmail.com");
        customer.setPhone(123456);
        customer.setAddress("Da nang");
        Customer result = customerRepo.save(customer);
        if (result != null) {
            System.out.println("1 kh mới lưu TC" + customer.getId());
        }

        Customer customer1 = new Customer();
        customer1.setName("tam");
        customer1.setBirthdate(LocalDate.parse("1998-02-02"));
        customer1.setSex("nam");
        customer1.setEmail("tam9x@gmail.com");
        customer1.setPhone(234567);
        customer1.setAddress("Dak Lak");
        Customer result1 = customerRepo.save(customer1);
        if (result1 != null) {
            System.out.println("1 kh mới lưu TC" + customer1.getId());
        }

        Customer customer2 = new Customer();
        customer2.setName("tai");
        customer2.setBirthdate(LocalDate.parse("2005-03-03"));
        customer2.setSex("nam");
        customer2.setEmail("tai9x@gmail.com");
        customer2.setPhone(345678);
        customer2.setAddress("Da nang");
        Customer result2 = customerRepo.save(customer2);
        if (result2 != null) {
            System.out.println("1 kh mới lưu TC" + customer2.getId());
        }

        Customer customer3 = new Customer();
        customer3.setName("ngan");
        customer3.setBirthdate(LocalDate.parse("2002-04-04"));
        customer3.setSex("nu");
        customer3.setEmail("ngan2k@gmail.com");
        customer3.setPhone(456789);
        customer3.setAddress("Quang nam");
        Customer result3 = customerRepo.save(customer3);
        if (result3 != null) {
            System.out.println("1 kh mới lưu TC" + customer3.getId());
        }


    }
}
