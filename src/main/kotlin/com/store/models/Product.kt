package com.store.models

data class Product(
    val id: Long,
    val name: String,
    val type: ProductType,
    val inventory: Int,
    val cost: Int
)
