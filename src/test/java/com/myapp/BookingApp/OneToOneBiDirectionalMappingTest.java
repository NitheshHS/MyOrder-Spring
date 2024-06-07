package com.myapp.BookingApp;

import com.myapp.BookingApp.model.Address;
import com.myapp.BookingApp.model.MyOrder;
import com.myapp.BookingApp.repository.AddressRepository;
import com.myapp.BookingApp.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class OneToOneBiDirectionalMappingTest {

    private AddressRepository addressRepository;

    @Autowired
    public OneToOneBiDirectionalMappingTest(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Test
    void saveOrder(){
        Address address=new Address();
        address.setCity("Hassan");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("573213");

        MyOrder myOrder=new MyOrder();
        myOrder.setOrderTracker("ORDER_1234567876sjdkjb");
        myOrder.setStatus("IN-PROGRESS");
        address.setOrder(myOrder);

        Address newAddress = addressRepository.save(address);
        System.out.println(newAddress);
    }

    @Test
    void updateOrder(){
        Address myAddress = addressRepository.findById(3L).get();
        myAddress.setCity("Bengaluru");
        myAddress.setState("KA");
        myAddress.setCountry("IN");
        myAddress.setZipcode("560016");

        MyOrder myOrder = myAddress.getOrder();
        myOrder.setStatus("DELIVERED");
        myAddress.setOrder(myOrder);

        addressRepository.save(myAddress);
    }

    @Test
    void deleteOrder(){
        addressRepository.deleteById(3L);
        System.out.println("Success");
    }

}
