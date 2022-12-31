package repository;

import entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    //tìm theo tên
    List<Customer> findByName(String name);

    //tìm theo id
    List<Customer> findById (int id);

    @Query(value = "select c from Customer c where c.name like %?1%")
    List<Customer> getCustomerByName(String name);

    // tìm theo chữ cái tên
//    @Query(value = "Select * from customer c where c.name like %?1%", nativeQuery = true)
//    List<Customer> getCustomerByName(String name);
//
//    // tìm theo phone of email
    @Query(value = "select c from Customer c where c.phone = ?1 or c.email = ?2")
    List<Customer> getCustomerByPhoneOrEmail (int phone, String email);

//    @Query(value = "Select * from Customer c where c.phone = ?1 or c.email = ?2", nativeQuery = true)
//    List<Customer> getCustomerByPhoneOrEmail(String phone, String email);

    // tìm theo tuổi
    @Query(value = "select * from customer c where DATEDIFF(curdate(), birthdate)/365 between 20 and 30 and sex = 'nam'", nativeQuery = true)
    List<Customer> getCustomerByAge();
}
