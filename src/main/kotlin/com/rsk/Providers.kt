package com.rsk

import java.security.Provider
import java.security.Security

class Providers {

    fun getProviders(): List<Provider> {
        val providers = Security.getProviders()

        return providers.asList()
    }

    companion object {
        fun getProviders(): List<Provider> {
            val providers = Security.getProviders()

            return providers.asList()
        }
    }
}