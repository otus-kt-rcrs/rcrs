package org.otus

import ru.rcrs.api.v1.models.VcCreatedRequest
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import ru.rcrs.api.v1.models.VcCreateObject


class RequestSerializationTest {

    private val jacksonApiMapper = JacksonApiMapper()
    private val request = VcCreatedRequest(
        requestId = "1",
        requestType = "POST",
        ad = VcCreateObject (
            id = "",
            name = "test",
            description = "desc",
            location = "Moscow"
        )
    )

    @Test
    fun serialize() {
        val json = jacksonApiMapper.apiV1RequestSerialize(request)
        assertContains(json, Regex("\"requestType\":\"POST\""))
        assertContains(json, Regex("\"requestId\":\"1\""))
        assertContains(json, Regex("\"id\":\"\""))
        assertContains(json, Regex("\"name\":\"test\""))
        assertContains(json, Regex("\"description\":\"desc\""))
        assertContains(json, Regex("\"location\":\"Moscow\""))
    }

    @Test
    fun deserialize() {
        val obj = jacksonApiMapper.apiV1RequestDeserialize(request)
        assertEquals(request, obj)
    }
}