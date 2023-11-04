package org.otus.mapper

import org.otus.model.ContextRcrsMdl
import org.otus.util.RcrsCommand
import org.otus.util.RcrsRequestId
import org.otus.util.RcrsState
import ru.rcrs.api.v1.models.IRequest
import java.util.UUID

    fun ContextRcrsMdl.fromTransport(request: IRequest)  {
        command = RcrsCommand.CREATE
        requestId = RcrsRequestId(UUID.randomUUID().toString())
        state = RcrsState.NONE
}
