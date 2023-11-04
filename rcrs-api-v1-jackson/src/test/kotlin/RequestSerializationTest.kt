import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import org.otus.JacksonApiMapper
import ru.rcrs.api.v1.models.UsCreateRequest


class RequestSerializationTest {

    private val jacksonApiMapper = JacksonApiMapper()
    private val request = UsCreateRequest(
        requestId = "1",
        requestType = "POST",
        name = "test",
        email = "test@mail.ru",
        age = 27
    )

    @Test
    fun serialize() {
        val json = jacksonApiMapper.apiV1RequestSerialize(request)
        assertContains(json, Regex("\"requestType\":\"POST\""))
        assertContains(json, Regex("\"requestId\":\"1\""))
        assertContains(json, Regex("\"name\":\"test\""))
        assertContains(json, Regex("\"email\":\"test@mail.ru\""))
    }

    @Test
    fun deserialize() {
        val obj = jacksonApiMapper.apiV1RequestDeserialize(request)
        assertEquals(request, obj)
    }
}