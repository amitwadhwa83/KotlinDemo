import com.rsk.Providers
import java.security.Provider

fun main(args: Array<String>) {

    val providers = Providers()

    // Instance method
    listProviders(providers.getProviders())

    // Static method (although kotlin dont have static methods, it is via companion object/singleton)
    listProviders(Providers.getProviders())

    //{} indicates we are passing a function
    getAllProviders { key, value ->
        println("\t fun-----$key: $value")
    }
}

fun getAllProviders(fn: (String, String) -> Unit) {
    val allProviders = Providers.getProviders()
    val it = allProviders.iterator()

    while (it.hasNext()) {
        val provider = it.next()
        println(provider.name)

        provider.forEach { key, value -> fn(key.toString(), value.toString()) }
    }
}

fun listProviders(providers: List<Provider>) {
    providers.forEach { provider ->
        println("name>>" + provider.name)
        provider.forEach { key, value -> println("\t$key: $value") }
    }
}

fun listProvidersInstance(providers: List<Provider>) {
    providers.forEach { provider ->
        println("name>>" + provider.name)
        provider.forEach { key, value -> println("\t$key: $value") }
    }
}
