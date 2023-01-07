import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Test Case First Line: " + Thread.currentThread().name)

    val deferred: Deferred<Any> = GlobalScope.async {
        println("Test Case background  Line: " + Thread.currentThread().name)
        println("Test Case background  Line: " + Thread.currentThread().name)

        delay(2000)
        println("Test Case End Line: " + Thread.currentThread().name)
    }

    deferred.await()

    println("Test Case Last  Line: " + Thread.currentThread().name)


}
