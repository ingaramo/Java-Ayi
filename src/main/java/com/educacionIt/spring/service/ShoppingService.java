package com.educacionIt.spring.service;

import com.educacionIt.spring.model.Item;
import com.educacionIt.spring.model.Order;
import com.educacionIt.spring.repository.ItemRepository;
import com.educacionIt.spring.repository.OrderRepository;
import com.educacionIt.spring.session.OrderSession;
import com.educacionIt.spring.vo.ItemVo;
import com.educacionIt.spring.vo.PaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class ShoppingService {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    OrderSession orderSession;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;


    public void remove(ItemVo itemVo) {
        if(orderSession==null){
            System.out.println("no hay nada cargado");
            return;
        }
        try{
            Item i = (Item)entityManager.createQuery("FROM items WHERE 'description' = :p1 AND price = :p2 AND quantity =p3")
                    .setParameter("p1",itemVo.getDescription())
                    .setParameter("p2",itemVo.getPrice())
                    .setParameter("p3",itemVo.getQuantity()).getSingleResult();
            itemRepository.delete(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setPayment(PaymentVo paymentVo) {
        Order o;
        if(orderSession.getOrder()==null){
            o = new Order();
            orderRepository.save(o);
            orderSession.setOrder(o);
        }else{
            o = orderSession.getOrder();
        }
        o.setAmount(paymentVo.getAmount());
        o.setTypePayment(paymentVo.getType());
    }

    public List<Item> getAll() {
        if(orderSession.getOrder()==null){
            System.out.println("no hay nada cargado");
            return null;
        }
        return itemRepository.findAll();
    }

    public void checkout() {
    }

    public void add(ItemVo itemVo) {
        Item u = new Item();
        u.setDescription(itemVo.getDescription());
        u.setPrice(itemVo.getPrice());
        u.setQuantity(itemVo.getQuantity());

        if(orderSession.getOrder()==null){
            Order o = new Order();
            orderRepository.save(o);
            orderSession.setOrder(o);
            u.setIdOrder(o.getId());
        }else{
            u.setIdOrder(orderSession.getOrder().getId());
        }


        itemRepository.save(u);
    }
}
