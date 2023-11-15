package org.otus.util

@JvmInline
value class RcrsRequestId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = RcrsRequestId("")
    }
}