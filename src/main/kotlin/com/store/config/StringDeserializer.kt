package com.store.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.exc.MismatchedInputException

class StringDeserializer: JsonDeserializer<String>() {
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext?
    ): String? {
        val token = p.currentToken
        if(token != JsonToken.VALUE_STRING){
            throw MismatchedInputException.from(p,String::class.java,"Expected a string value instead of $token")
        }
        return p.text
    }

}