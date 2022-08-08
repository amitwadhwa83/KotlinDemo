import com.rsk.Providers
import java.security.Provider

fun main(args: Array<String>) {

    val providers = Providers()

    // Instance method
    listProviders(providers.getProviders())

    // Static method (although kotlin dont have static methods, it is via companion object/singleton)
    listProviders(Providers.getProviders())

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
