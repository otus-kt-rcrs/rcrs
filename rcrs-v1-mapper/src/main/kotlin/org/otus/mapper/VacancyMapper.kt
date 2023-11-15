package org.otus.mapper

import org.otus.ContextRcrsMdl
import org.otus.util.RcrsCommand
import ru.rcrs.api.v1.models.IRequest
import org.otus.exception.RcrsError
import org.otus.model.RcrsVcReq
import org.otus.model.RcrsVcReqId
import org.otus.util.RcrsState
import ru.rcrs.api.v1.models.IResponse
import ru.rcrs.api.v1.models.ResponseResult
import ru.rcrs.api.v1.models.VcCreateObject
import ru.rcrs.api.v1.models.VcCreateResponse
import ru.rcrs.api.v1.models.VcCreatedRequest
import ru.rcrs.api.v1.models.VcResponseObject
import ru.rcrs.api.v1.models.VcSearchRequest

fun ContextRcrsMdl.fromTransport(request: IRequest) = when (request) {
    is VcCreatedRequest -> fromTransport(request)
    is VcSearchRequest -> fromTransport(request)
    else -> throw RcrsError(request.javaClass)
}

fun ContextRcrsMdl.toTransport(): IResponse = when(val cmd = command) {
    RcrsCommand.CREATE -> toTransportCreate()
    RcrsCommand.NONE -> TODO()
    RcrsCommand.READ -> TODO()
}

fun ContextRcrsMdl.toTransportCreate() = VcCreateResponse (
    responseType = "create",
    requestId = this.requestId,
    result = if (state == RcrsState.RUNNING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    ad = VcResponseObject().toTransport(requestVc)
)

fun ContextRcrsMdl.fromTransport(request: VcCreatedRequest) {
    command = RcrsCommand.CREATE
    requestId = request.requestId.toString()
    requestVc = request.ad?.toInternal() ?: RcrsVcReq()
}

fun ContextRcrsMdl.fromTransport(request: VcSearchRequest) {
    command = RcrsCommand.READ
    requestId = request.requestId.toString()
}

private fun VcCreateObject.toInternal(): RcrsVcReq = RcrsVcReq (
    id = this.id ?: RcrsVcReqId.NONE,
    name = this.name ?: "",
    description = this.description ?: "",
    location = this.location ?: ""
)

private fun VcResponseObject.toTransport(req: RcrsVcReq): VcResponseObject = VcResponseObject (
    title = req.name,
    description = req.description,
)
