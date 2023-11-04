package org.otus.model

import org.otus.exception.RcrsError
import org.otus.util.RcrsCommand
import org.otus.util.RcrsRequestId
import org.otus.util.RcrsState

data class ContextRcrsMdl (
    var command: RcrsCommand = RcrsCommand.NONE,
    var state: RcrsState = RcrsState.NONE,
    val errors: MutableList<RcrsError> = mutableListOf(),
    var requestId: RcrsRequestId = RcrsRequestId.NONE )
