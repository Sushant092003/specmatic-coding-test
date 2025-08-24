package com.store.models

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.store.config.StringDeserializer
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class ProductDetails(
    @JsonDeserialize(using = StringDeserializer::class)
    @field:NotBlank(message = "Name must not be empty or null")
    val name: String,

    @field:NotNull(message = "Type must not be null")
    val type: ProductType,

    @field:Min(value = 1, message = "Inventory must be at least 0")
    @field:Max(value = 9999, message = "Inventory must not exceed 9999")
    @field:NotNull(message = "Inventory cannot be null")
    val inventory: Int,

    @field:Min(value = 1, message = "Cost must be at least 0")
    @field:Max(value = 9999, message = "Cost must not exceed 9999")
    @field:NotNull(message = "Cost cannot be null")
    val cost: Int
)
