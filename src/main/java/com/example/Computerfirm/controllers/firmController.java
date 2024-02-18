package com.example.Computerfirm.controllers;
import com.example.Computerfirm.models.Product;
import com.example.Computerfirm.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class firmController {

    private final ProductService productService;

    public firmController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "products";
    }
    @GetMapping("/product/{ID}")
    public String productInfo(@PathVariable Long ID, Model model){
        model.addAttribute("product", productService.getProductById(ID));

        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }
    @PostMapping("/product/delete/{ID}")
    public String deleteProduct(@PathVariable Long ID){
        productService.deleteProduct(ID);
        return "redirect:/";
    }
}
