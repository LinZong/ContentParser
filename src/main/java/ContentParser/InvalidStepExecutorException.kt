package ContentParser

import java.lang.Exception

class InvalidStepExecutorException : Exception{
    constructor(message: String?) : super(message)
    constructor() : super()
}