package com.demo.service

import com.demo.model.Product
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
 interface ProductService {
    fun getAllProducts(): List<Product>
    fun addNewProduct(p: Product): Product
    fun getByName(name: String): Product?
    fun updateById(product: Product)
    fun deleteById(id: Int)

}

