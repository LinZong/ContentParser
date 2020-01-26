package ContentParser.Steps

import ContentParser.SingleInputMultiOutputElementStep
import ContentParser.SingleInputSingleOutputElementStep
import javax.inject.Inject

class ContentParserImpl @Inject constructor(
    val singleInSingleOut: Map<@JvmSuppressWildcards String, @JvmSuppressWildcards SingleInputSingleOutputElementStep>,
    val singleInMultiOut: Map<@JvmSuppressWildcards String, @JvmSuppressWildcards SingleInputMultiOutputElementStep>
) {

    fun Description() {
        println(singleInMultiOut.size)
        println(singleInSingleOut.size)
    }
}