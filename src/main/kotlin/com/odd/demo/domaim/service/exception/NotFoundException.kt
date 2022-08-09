package com.odd.demo.domaim.service.exception

import java.lang.Exception

class NotFoundException(override val message: String): Exception(message)