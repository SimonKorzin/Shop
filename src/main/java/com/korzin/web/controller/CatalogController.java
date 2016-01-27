package com.korzin.web.controller;

/**
 * Created by user on 16-Dec-15.
 */

import com.korzin.objects.Groups;
import com.korzin.objects.Product;
import com.korzin.services.GroupsService;
import com.korzin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("/catalog")
public class CatalogController {

    ArrayList<ArrayList<String>> cartName = new ArrayList<ArrayList<String>>(0);
    @Autowired
    private ProductService productService;
    @Autowired
    private GroupsService groupsService;

    @RequestMapping(method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("groups", groupsService.findAll());
        System.out.println("check this shit");
        for(Product p: productService.findAll()){
            System.out.print(p.getId() + " " );
        }
        return "catalog";
    }
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String listProductTest(Model model) {
//        model.addAttribute("products", productService.findAll());
//        model.addAttribute("groups", groupsService.findAll());
////
//        return "catalogAdmin";
//    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String listGroup(@PathVariable(value = "id") int group_id, Model model) {
        Groups groups = groupsService.findById(group_id);
        System.out.println("groupById " + groups.getName());
        model.addAttribute("groups", groupsService.findAll());
        model.addAttribute("products", productService.findByGroup(groups));
        return "catalog";
    }
    @RequestMapping(value = "/limits", method = RequestMethod.POST)
    public String limits(@RequestParam(value="lowerBound") double lowerBound,
                         @RequestParam(value="upperBound") double upperBound,
                         Model model) {
        model.addAttribute("groups", groupsService.findAll());
        System.out.println("upper = " + upperBound + " lower = " + lowerBound);
        for(Product p: productService.findByLimits(lowerBound,upperBound)){
            System.out.println("findByLimits: Name: " + p.getName() + " Price: " + p.getPrice());
        }
        model.addAttribute("products", productService.findByLimits(lowerBound,upperBound));
        return "catalog";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value="pattern") String pattern, Model model) {
        System.err.println(pattern);
        model.addAttribute("groups", groupsService.findAll());
        model.addAttribute("products", productService.findAllProductByPattern(pattern) );
        return "catalog";
    }
    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
    public String deleteFromCart(@PathVariable(value = "id") int cart_list_id){
        System.out.println("In deleteFromCart. cart_list_id = " + cart_list_id);
        for(ArrayList<String> str: cartName){
            System.out.println("cartName before delete " + cart_list_id + "name " + str.get(0));
        }
        cartName.remove(cart_list_id);
        return "redirect:/catalog/cart";
    }
    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable(value = "id") int product_id){
        System.out.println("RESULT! " + productService.findById(product_id).getName());
        Product product = productService.findById(product_id);
        ArrayList<String> tmp = new ArrayList<String>(0);
        tmp.add(product.getName());
        tmp.add(product.getShort_description());
        tmp.add(product.getCode());
        tmp.add("" + product.getPrice());
        cartName.add(tmp);
        for(ArrayList<String> arstr: cartName) {
            System.out.println();

            for (String p : arstr) {
                System.out.println("cartProduct name: " + p);
            }
        }
        return "redirect:/catalog";
    }
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model){
        model.addAttribute("products", cartName);
        return "cart";
    }
}


