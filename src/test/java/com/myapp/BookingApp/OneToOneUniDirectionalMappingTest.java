package com.myapp.BookingApp;

import com.myapp.BookingApp.model.Address;
import com.myapp.BookingApp.model.MyOrder;
import com.myapp.BookingApp.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneUniDirectionalMappingTest {

    private OrderRepository orderRepository;

    @Autowired
    public OneToOneUniDirectionalMappingTest(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Test
    void saveOrder(){
        MyOrder myOrder=new MyOrder();
        myOrder.setOrderTracker("order_123456");
        myOrder.setStatus("IN-PROGRESS");

        Address address=new Address();
        address.setCity("Hassan");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("573213");
        myOrder.setBillingAddress(address);

        MyOrder orderDetails = orderRepository.save(myOrder);
        System.out.println(orderDetails);
    }

    @Test
    void updateOrder(){
        MyOrder myOrder = orderRepository.findById(1L).get();
        myOrder.setOrderTracker("order_123456");
        myOrder.setStatus("DELIVERED");

        Address address=myOrder.getBillingAddress();
        address.setCity("Bengaluru");
        address.setState("Karnataka");
        address.setCountry("India");
        address.setZipcode("560016");
        myOrder.setBillingAddress(address);

        MyOrder orderDetails = orderRepository.save(myOrder);
        System.out.println(orderDetails);
    }

    @Test
    void findOrderDetails(){
        MyOrder order = orderRepository.findById(1L).get();
        System.out.println(order);
    }

    @Test
    void deleteOrder(){
        orderRepository.deleteById(1L);
    }
}
