package io.osipxd.issue.ktypenull

import kotlin.reflect.KType
import kotlin.reflect.typeOf

// Reproduces only for function with reified generic used in typeOf
inline fun <reified T> checkNullabilityInconsistency(): Boolean {
    var inconsistencyFound = false

    // Save the result of `typeOf` into a nullable field, however, we know it can never be null
    val type: KType? = typeOf<T>()

    print("Check #1: ")
    if (type == null) println("$type == null").also { inconsistencyFound = true }
    if (type != null) println("$type != null")

    if (inconsistencyFound) {
        // If type is really null, here will be a NullPointerException
        type!!
        println("Nope, it is not null")

        // After the double bang operator, it is not equal to null anymore
        print("Check #2: ")
        if (type == null) println("$type == null")
        if (type != null) println("$type != null")
    } else {
        println("Ok")
    }

    return inconsistencyFound
}
