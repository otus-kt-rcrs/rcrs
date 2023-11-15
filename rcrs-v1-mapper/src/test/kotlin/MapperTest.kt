import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.otus.mapper.fromTransport
import org.otus.ContextRcrsMdl
import org.otus.util.RcrsCommand
import org.otus.util.RcrsState
import ru.rcrs.api.v1.models.VcCreateObject
import ru.rcrs.api.v1.models.VcCreatedRequest

class MapperTest {

    @Test
    fun fromTransport() {
        val req = VcCreatedRequest(
            requestId = "1",
            requestType = "POST",
            ad = VcCreateObject (
                id = "",
                name = "test",
                description = "desc",
                location = "Moscow"
            )
        )

        val context = ContextRcrsMdl()
        context.fromTransport(req)

        assertEquals(RcrsState.NONE, context.state)
        assertEquals(RcrsCommand.CREATE, context.command)
        assertEquals(req.ad?.id, context.requestVc.id)
        assertEquals(req.ad?.name, context.requestVc.name)
        assertEquals(req.ad?.description, context.requestVc.description)
        assertEquals(req.ad?.location, context.requestVc.location)
        assertNotNull(context.requestId)
    }

}