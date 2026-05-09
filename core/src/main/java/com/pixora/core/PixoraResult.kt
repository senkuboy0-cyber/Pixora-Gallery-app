package com.pixora.core

sealed interface PixoraResult<out T> {
    data class Success<T>(val value: T) : PixoraResult<T>
    data class Failure(val message: String, val cause: Throwable? = null) : PixoraResult<Nothing>
    data object Loading : PixoraResult<Nothing>
}
