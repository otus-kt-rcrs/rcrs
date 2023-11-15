package org.otus

import org.otus.exception.RcrsError
import org.otus.model.RcrsVcReq
import org.otus.util.RcrsCommand
import org.otus.util.RcrsState

data class ContextRcrsMdl (
    var command: RcrsCommand = RcrsCommand.NONE,
    var state: RcrsState = RcrsState.NONE,
    val errors: MutableList<RcrsError> = mutableListOf(),
    var requestId: String = "",
    var requestVc: RcrsVcReq = RcrsVcReq(),
    var responseVc: RcrsVcReq = RcrsVcReq()
)
