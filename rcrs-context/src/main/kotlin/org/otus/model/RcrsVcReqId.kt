package org.otus.model

@JvmInline
value class RcrsVcReqId(private val id: String) {
    fun asString() = id
    companion object {
        val NONE = RcrsVcReqId("")
    }
}