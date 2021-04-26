package com.nemesiss.dev.HTMLContentParser

import java.lang.Exception

class InvalidStepExecutorException : Exception{
    constructor(message: String?) : super(message)
    constructor() : super()
}