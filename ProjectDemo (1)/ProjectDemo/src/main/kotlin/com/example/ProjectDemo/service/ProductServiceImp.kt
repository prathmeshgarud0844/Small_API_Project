package com.example.ProjectDemo.service

import com.demo.model.Product
import com.demo.service.ProductService
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl : ProductService {

    private val productList = mutableListOf<Product>() // Use a MutableList instead of an Array

    // Initialize the list with sample products
    init {
        println("Initializing ProductServiceImpl...") // Debugging

        productList.add(Product(1, "Laptop", 5, 1200.99))
        productList.add(Product(2, "Smartphone", 10, 699.49))
        productList.add(Product(3, "Tablet", 7, 399.99))
        println("Products added: $productList") // Debugging
    }

    override fun getAllProducts(): List<Product> {
        println("Fetching products: $productList") // Debugging

        return productList // No null issues since it's a MutableList

    }

    override fun getByName(pname: String): Product? {
        return productList.find { it.name.equals(pname, ignoreCase = true) }
    }

    override fun addNewProduct(p: Product): Product {
        productList.add(p)
        return p
    }

    override fun updateById(product: Product) {
        val index = productList.indexOfFirst { it.pid == product.pid }
        if (index != -1) {
            productList[index] = product
        }
    }

    override fun deleteById(id: Int) {
        productList.removeIf { it.pid == id }
    }


}
