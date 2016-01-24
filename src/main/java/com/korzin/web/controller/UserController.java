package com.korzin.web.controller;

import com.korzin.services.OrdersService;
import com.korzin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 24-Dec-15.
 */
public class UserController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    ProductService productService;

//    @RequestMapping(value = "/user/cart", method = RequestMethod.GET)
//    public String showCart(Model model){
//        model("products", ordersService.showProducts());
//    }
}
