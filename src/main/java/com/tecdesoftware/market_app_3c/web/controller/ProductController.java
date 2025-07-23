package com.tecdesoftware.market_app_3c.web.controller;

import com.tecdesoftware.market_app_3c.domain.Product;
import com.tecdesoftware.market_app_3c.domain.service.ProductService;
import com.tecdesoftware.market_app_3c.persistence.ProductoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins= "*")
// esto conectó con la base de datos
@RestController
@RequestMapping("/products")
//nombre para swager a través de @Tag
@Tag(name= "product controller", description = "Manage products in the store")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/all")
    @Operation(
            summary = "get all products",
            description = "return a list of all aviable products"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of products")

    @ApiResponse(responseCode = "500", description = "Internal server error")
    public List<Product> getAll() {
        return productService.getAll();

    }

    @GetMapping("/{productId}")
    @Operation(
            summary = "get product by ID",
            description = "Return a product by its ID fi exist"

    )
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @Parameter(description = "Id of the product to be retrieved",
    example = "7", required = true)
    public Optional<Product> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get product by category",
            description = "returns all products in a specific categoy")
    @ApiResponse(responseCode = "200", description = "Products found in the category")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @ApiResponse(responseCode = "204", description = "Category not found")
    @Parameter(description = "Category ID",
            example = "7", required = true)
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    @Operation(
            summary = "Save a new product",
            description = "Registers a new product and returns the created product"
    )
    @ApiResponse(responseCode = "200", description = "Product saved Successfully")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{productId}")
    @Operation(
            summary = "Delete product by ID",
            description = "Delete a product and check by OK"
    )
    @ApiResponse(responseCode = "200", description = "Deleted Successfully")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public boolean delete(@PathVariable("productId") int productId) {
        return productService.delete(productId);
    }
}
