import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.otus.mapper.fromTransport
import org.otus.model.ContextRcrsMdl
import org.otus.util.RcrsCommand
import org.otus.util.RcrsState
import ru.rcrs.api.v1.models.UsCreateRequest

class MapperTest {

    @Test
    fun fromTransport() {
        val req = UsCreateRequest(
            requestId = "1",
            requestType = "POST",
            name = "test",
            email = "test@mail.ru",
            age = 27
        )

        val context = ContextRcrsMdl()
        context.fromTransport(req)

        assertEquals(RcrsState.NONE, context.state)
        assertEquals(RcrsCommand.CREATE, context.command)
        assertNotNull(context.requestId)
    }

}