package com.myself223.metube.base.core
sealed class Resourse<T>(val data: T? = null, val message: String? = null) {
    class Loading<T> : Resourse<T>()
    class Success<T>(data: T) : Resourse<T>(data = data)
    class Error<T>(message: String): Resourse<T>(message = message)
}
