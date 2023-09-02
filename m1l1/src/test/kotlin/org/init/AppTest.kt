package org.init

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals
class AppTest {
    @Test
    fun whenExecuteMethodMainOutputHello() {
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        main()
        assertEquals("Hello World!\n", outContent.toString())
    }
}