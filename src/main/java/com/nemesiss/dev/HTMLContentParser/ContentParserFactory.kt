package com.nemesiss.dev.HTMLContentParser

import com.nemesiss.dev.HTMLContentParser.steps.ContentParserImpl
import com.nemesiss.dev.HTMLContentParser.steps.StepModules

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