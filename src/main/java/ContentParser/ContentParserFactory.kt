package ContentParser

import ContentParser.Steps.ContentParserImpl
import ContentParser.Steps.StepModules

class ContentParserFactory {
    companion object {
        @JvmStatic
        private var instance : ContentParserImpl = ContentParserImpl(
            StepModules.SingleInSingleOut,
            StepModules.SingleInMultiOut,
            StepModules.MultiInMultiOut)

        @JvmStatic
        fun Provide() : ContentParserImpl {
            return instance
        }
    }
}