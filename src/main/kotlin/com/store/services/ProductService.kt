package com.store.services

import com.store.models.Product
import com.store.models.ProductType

import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class ProductService {
    private val products = mutableListOf<Product>()
    private val idCounter = AtomicLong(1)

    fun createProduct(name: String, type: ProductType, inventory: Int,cost: Int): Product {
        val product = Product(
            id = idCounter.getAndIncrement(),
            name = name,
            type = type,
            inventory = inventory,
            cost = cost
        )
        products.add(product)
        return product
    }

    fun getProductsByType(type: ProductType): List<Product> {
        return products.filter { it.type == type }
    }

    fun getAllProducts(): List<Product> {
        return products;
    }

}