package org.otus.exception

class RcrsError(clazz: Class<*>) : RuntimeException("Class $clazz cannot be mapped to MkplContext")
