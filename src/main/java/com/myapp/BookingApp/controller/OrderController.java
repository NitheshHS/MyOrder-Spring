package com.myapp.BookingApp.controller;

import com.myapp.BookingApp.dto.MyOrderDTO;
import com.myapp.BookingApp.model.MyOrder;
import com.myapp.BookingApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<MyOrderDTO> saveOrder(@RequestBody MyOrder order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/order")
    public ResponseEntity<List<MyOrderDTO>> findAllOrder(){
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<MyOrderDTO> findOrder(@PathVariable("orderId") Long id){
        return new ResponseEntity<>(orderService.findOrder(id), HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<MyOrderDTO> updateOrder(@PathVariable("orderId") Long id, @RequestBody MyOrder myOrder){
        return new ResponseEntity<>(orderService.updateOrder(id, myOrder), HttpStatus.OK);
    }
}
