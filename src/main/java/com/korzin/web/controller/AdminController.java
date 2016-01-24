package com.korzin.web.controller;

import com.korzin.objects.Comment;
import com.korzin.objects.Groups;
import com.korzin.objects.Product;
import com.korzin.services.CommentService;
import com.korzin.services.GroupsService;
import com.korzin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by user on 19-Dec-15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/catalog",method = RequestMethod.GET)
    public String listProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        model.addAttribute("groups", groupsService.findAll());
//
        return "catalogAdmin";
    }
    @RequestMapping(value = "/catalog/product/{id}", method = RequestMethod.GET)
    public String productView(@PathVariable(value = "id") int product_id, Model model){
        Product product = productService.findById(product_id);
        System.out.println(product.getName());
        model.addAttribute("product", product);
        model.addAttribute("photos", productService.findAllPhotoOfProduct(product));
        model.addAttribute("comments", productService.findAllCommentOfProduct(product));
        return "productAdmin";
    }
    @RequestMapping(value = "/catalog/comment/delete/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable(value = "id") int comment_id){
        Comment comment = commentService.findById(comment_id);
        System.out.println("commentById \"" + comment.getName() + "\"");
        commentService.delete(comment_id);
        System.out.println("CHECK DELETECOMMENT REDIRECT::: /admin/product/" + comment.getProduct().getId());
        return "redirect:/admin/catalog/product/" + comment.getProduct().getId();
    }
    @RequestMapping(value = "/catalog/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "id") int product_id){
        Product product = productService.findById(product_id);
        System.out.println("productById \"" + product.getName() + "\"");
        productService.delete(product_id);
        return "redirect:/admin/catalog";
    }
    @RequestMapping(value = "/catalog/edit/{id}", method = RequestMethod.GET)
    public String editFormOfProduct(@PathVariable(value = "id")int product_id, Model model){
        Product product = productService.findById(product_id);
        model.addAttribute("product", product);
        return "productEditAdmin";
    }
    @RequestMapping(value = "/catalog/edit/{id}", method = RequestMethod.POST)
    public String editProduct(@PathVariable(value = "id") int product_id,
                              @RequestParam(value = "name") String name,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "short_description") String short_description,
                              @RequestParam(value = "price") float price,
                              @RequestParam(value = "code") String code) {
        Product product = productService.findById(product_id);
        System.out.println("productById \"" + product.getName() + "\"");
        product.setName(name);
        product.setDescription(description);
        product.setShort_description(short_description);
        product.setPrice(price);
        product.setCode(code);
        productService.add(product);
        return "redirect:/admin/catalog";
    }


    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public String listGroup(@PathVariable(value = "id") int group_id, Model model) {
        Groups groups = groupsService.findById(group_id);
        System.out.println("groupById" + groups.getName());
        model.addAttribute("groups", groupsService.findAll());
        model.addAttribute("products", productService.findByGroup(groups));
        return "catalogAdmin";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(value="pattern") String pattern, Model model) {
        System.err.println(pattern);
        model.addAttribute("groups", groupsService.findAll());
        model.addAttribute("products", productService.findAllProductByPattern(pattern) );
        return "catalogAdmin";
    }

}
