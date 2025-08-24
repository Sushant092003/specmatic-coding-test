package com.store.exceptionHandler

import com.store.models.ErrorResponseBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponseBody> {
        val errorMessage = ex.bindingResult.fieldErrors.joinToString(", ") { it.defaultMessage ?: "Invalid value" }
        val error = ErrorResponseBody(
            timestamp = LocalDateTime.now().toString(),
            status = HttpStatus.BAD_REQUEST.value(),
            error = errorMessage,
            path = ex.parameter.toString()
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }
}