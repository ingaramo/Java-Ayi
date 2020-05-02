package com.educacionIt.spring.controller;

import com.educacionIt.spring.model.Item;
import com.educacionIt.spring.service.ShoppingService;
import com.educacionIt.spring.vo.ItemVo;
import com.educacionIt.spring.vo.PaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @PostMapping("/add")
    public void add(@RequestBody ItemVo itemVo){
        if(itemVo != null){
            shoppingService.add(itemVo);
        }
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@RequestParam ItemVo itemVo){
        if(itemVo != null){
            shoppingService.remove(itemVo);
        }
    }

    @PostMapping("/payment")
    public void setPayment(@RequestBody PaymentVo paymentVo){
        if(paymentVo != null){
            shoppingService.setPayment(paymentVo);
        }
    }

    @GetMapping("/get")
    public List<Item> getItems(){

        return shoppingService.getAll();
    }

    @GetMapping("/checkout")
    public void checkOut(){
        shoppingService.checkout();
    }
}
