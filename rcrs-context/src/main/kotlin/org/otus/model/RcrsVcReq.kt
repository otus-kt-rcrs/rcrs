package org.otus.model

data class RcrsVcReq (
    var id: Any = RcrsVcReqId.NONE,
    var name: String = "",
    var description: String = "",
    var location: String = ""
)
