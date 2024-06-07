package com.myapp.BookingApp.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.myapp.BookingApp.dto.AddressDTO;
import com.myapp.BookingApp.dto.MyOrderDTO;
import com.myapp.BookingApp.model.Address;
import com.myapp.BookingApp.model.MyOrder;
import com.myapp.BookingApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public MyOrderDTO saveOrder(MyOrder myOrder){
        MyOrder order = orderRepository.save(myOrder);

        return convertToOrderDTO(order);
    }

    private MyOrderDTO convertToOrderDTO(MyOrder order) {
        MyOrderDTO myOrderDTO=new MyOrderDTO();
        myOrderDTO.setOrderTracker(order.getOrderTracker());
        myOrderDTO.setStatus(order.getStatus());
        myOrderDTO.setCreatedDate(order.getCreatedDate());
        myOrderDTO.setUpdatedDate(order.getUpdatedDate());

        Address address = order.getBillingAddress();
        if(address != null){
            AddressDTO addressDTO=new AddressDTO();
            addressDTO.setCity(address.getCity());
            addressDTO.setState(address.getState());
            addressDTO.setCountry(address.getCountry());
            addressDTO.setZipcode(address.getZipcode());
            myOrderDTO.setBillingAddress(addressDTO);
        }else{
            myOrderDTO.setBillingAddress(null);
        }
        return myOrderDTO;
    }

    public List<MyOrderDTO> findAllOrders(){
        List<MyOrder> orderList = orderRepository.findAll();
        return orderList.stream()
                .map(this::convertToOrderDTO).toList();
    }

    public MyOrderDTO findOrder(Long id) {
        Optional<MyOrder> orderOptional=orderRepository.findById(id);
        if(orderOptional.isEmpty()){
            throw new RuntimeException("No Order found for id: "+id);
        }
        return convertToOrderDTO(orderOptional.get());
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public MyOrderDTO updateOrder(Long id, MyOrder updateOrder){
        Optional<MyOrder> orderOptional=orderRepository.findById(id);
        if(orderOptional.isEmpty()){
            throw new RuntimeException("No Order found for id: "+id);
        }
        MyOrder newOrder = orderOptional.get();
        newOrder.setStatus(updateOrder.getStatus());
        newOrder.setOrderTracker(updateOrder.getOrderTracker());

        Address newAddress = newOrder.getBillingAddress();
        newAddress.setCity(updateOrder.getBillingAddress().getCity());
        newAddress.setState(updateOrder.getBillingAddress().getState());
        newAddress.setCountry(updateOrder.getBillingAddress().getCountry());
        newAddress.setZipcode(updateOrder.getBillingAddress().getZipcode());
        newOrder.setBillingAddress(newAddress);

        return convertToOrderDTO(orderRepository.save(newOrder));
    }

    public <T, D> T convertToDTO(D model, T dto){
        ObjectMapper mapper=new ObjectMapper();
        mapper.readValue()
    }
}
