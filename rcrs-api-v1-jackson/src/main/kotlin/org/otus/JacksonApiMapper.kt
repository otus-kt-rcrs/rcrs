package org.otus

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import ru.rcrs.api.v1.models.IRequest

class JacksonApiMapper {

    private val apiMapper: JsonMapper = JsonMapper.builder().run {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        enable(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL)
        build()
    }

    fun apiV1RequestSerialize(request: IRequest): String = apiMapper.writeValueAsString(request)

    fun apiV1RequestDeserialize(request: IRequest): IRequest = apiMapper.readValue(apiV1RequestSerialize(request), IRequest::class.java)
}