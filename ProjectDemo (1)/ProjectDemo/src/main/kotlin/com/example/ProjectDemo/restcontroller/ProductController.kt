package com.example.ProjectDemo.restcontroller

import com.demo.service.ProductService



import com.demo.model.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ProductController(
    private val pservice: ProductService // No need for @Autowired in constructor
) { 

    @GetMapping("/products")
    fun getAllProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(pservice.getAllProducts())
    }


    @GetMapping("/name")
    fun getProductByName(@RequestParam name: String): Product? {
        return pservice.getByName(name)
    }

    @PostMapping("/add")
    fun addNewProduct( product: Product): Product {
        return pservice.addNewProduct(product)
    }


    @PutMapping("/update")
    fun updateProduct(@RequestBody product: Product): ResponseEntity<String> {
        pservice.updateById(product)
        return ResponseEntity.ok("Product updated successfully!")
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<String> {
        pservice.deleteById(id)
        return ResponseEntity.ok("Product deleted successfully!")
    }
}
