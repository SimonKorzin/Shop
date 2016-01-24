package com.korzin.web.controller;

/**
 * Created by user on 16-Dec-15.
 */

import com.korzin.objects.Comment;
import com.korzin.objects.Product;
import com.korzin.objects.ajaxModel.CommentJson;
import com.korzin.services.CommentService;
import com.korzin.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by user on 08-Dec-15.
 */
@Controller
@RequestMapping("/catalog/product")
public class ProductController {

    @Autowired
    MessageSource messageSource;
    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String productView(@PathVariable(value = "id") int product_id, Model model){
        Product product = productService.findById(product_id);
        System.out.println(product.getName());
//       product.setPhotos(productService.findAllPhotoOfProsuct(product));
        model.addAttribute("product", product);
        model.addAttribute("photos", productService.findAllPhotoOfProduct(product));
        for(Comment com: productService.findAllCommentOfProduct(product)){
            System.out.println("PRINT ALL COMMENT OF PRODUCT : " + product.getName());
        }
        model.addAttribute("comments", productService.findAllCommentOfProduct(product));
        return "product";
    }


    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public String productAdmin(@PathVariable(value = "id" ) int product_id, Model model){
        Product product = productService.findById(product_id);
        System.out.println("FROM /ADMIN/{ID}: PRODUCT.GETnAME() " + product.getName());
//       product.setPhotos(productService.findAllPhotoOfProsuct(product));
        model.addAttribute("product", product);
        model.addAttribute("photos", productService.findAllPhotoOfProduct(product));
        return "productAdmin";
    }
//    @RequestMapping(value = "/{id}",params = "form", method = RequestMethod.POST)
//    public String update(Product product, BindingResult bindingResult,
//                         Model uiModel, HttpServletRequest httpServletRequest,
//                         RedirectAttributes redirectAttributes, Locale locale){
//        if(bindingResult.hasErrors()){
//            uiModel.addAttribute("massage", new Message("error", messageSource.getMessage("product_save_fail", new Object[]{}, locale)));
//            uiModel.addAttribute("product", product);
//            return "productupdate";
//        }
//        uiModel.asMap().clear();
//        redirectAttributes.addFlashAttribute(
//                "message", new Message(
//                        "success", messageSource.getMessage(
//                        "product_save_success", new Object[]{}, locale)));
//        return "redirect:/catalog/";

//    }
//    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
//    public String updateForm(@PathVariable("id") int id, Model uiModel) {
//        uiModel.addAttribute("contact", productService.findById(id));
//        return "contacts/update";
//    }

    @RequestMapping(value = "/{id}/add", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String addCommentJson(@PathVariable("id") int id, @RequestBody CommentJson commentJson){
        System.err.println("In method addCommentJsonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        Comment comment = new Comment();
        comment.setName(commentJson.getName());
        comment.setText(commentJson.getText());
        comment.setComment_date(new java.util.Date());
        comment.setProduct(productService.findById(id));
        commentService.add(comment);
        return "ok11111111111";
    }
//    @RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
//    public String addComment(@PathVariable("id") int id,
//                             @RequestParam(value = "name") String name,
//                             @RequestParam(value  ="text") String text,
//                             HttpServletRequest request,
//                             HttpServletResponse response){
////        try{
//        System.err.println("NAAAAMEEE " + name + " TTTEEEXXXTTT " + text);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        //get current date time with Date()
//        java.util.Date date = new java.util.Date();
//        System.out.println(dateFormat.format(date));
//        commentService.add(name,text, date,id);
//        return "redirect:/catalog/product/" + id;
////        }catch(IOException e){
////            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
////            return null;
////        }
//    }
}
