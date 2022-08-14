package com.rsk

import java.security.Provider
import java.security.Security


fun main(args: Array<String>) {
    val providers = Providers()
    val details = providers.getAllProviders()

    //Note the usage of it
    details.forEach {
        // println("${it.providerName},${it.name}")
        println(it)
    }

    details.forEach(::println)
    println()
    val random = providers.getAllProviders("Random")
    random.forEach(::println)

}

data class ProviderDetails(val providerName: String, val name: String)
class Providers {

    fun getProviders(): List<Provider> {
        val providers = Security.getProviders()

        return providers.asList()
    }

    fun getAllProviders(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviders = mutableListOf<ProviderDetails>()

        providers.forEach { provider ->
            val providerDetails = provider.entries.filter { it -> it.key.toString().contains(filter, true) }
                .map { ProviderDetails(provider.name, it.key.toString()) }
            listOfProviders += providerDetails
        }
        return listOfProviders
    }


    fun getAllProviders(): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviders = mutableListOf<ProviderDetails>()

        providers.forEach { provider ->
            //val providerDetails = provider.entries.map { entry -> ProviderDetails(provider.name, entry.key.toString()) }

            //Note the usage of it
            val providerDetails = provider.entries.map { ProviderDetails(provider.name, it.key.toString()) }
            listOfProviders += providerDetails
        }
        return listOfProviders
    }


    companion object {
        fun getProviders(): List<Provider> {
            val providers = Security.getProviders()

            return providers.asList()
        }
    }
}