package com.store.controllers

import com.store.models.Product
import com.store.models.ProductDetails
import com.store.models.ProductId
import com.store.models.ProductType
import com.store.services.ProductService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class Products(private val productService: ProductService){

    @PostMapping
    fun createProduct(@Valid @RequestBody details: ProductDetails): ResponseEntity<ProductId> {
        val product = productService.createProduct(
            name = details.name,
            type = details.type,
            inventory = details.inventory,
            cost = details.cost
        )
        return ResponseEntity.status(201).body(ProductId(product.id))
    }

    @GetMapping
    fun getProducts(@RequestParam(required = false) type: ProductType?): List<Product> {
        var productsByType: List<Product>? = null;

        productsByType = if (type != null) {
            productService.getProductsByType(type)
        } else {
            productService.getAllProducts()
        }

        return productsByType
    }
}
