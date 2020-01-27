package com.nemesiss.dev.HTMLContentParser.Steps

class StepModules {
    companion object {
        @JvmStatic
        val SingleInSingleOut = arrayOf(
            "attrSingle",
            "textSingle",
            getElementById::class.java.simpleName,
            getElementsByClassSingle::class.java.simpleName,
            getElementsByTagSingle::class.java.simpleName,
            getRecommendThumbImageSingle::class.java.simpleName
        ).zip(arrayOf(
            GetAttr(),
            GetText(),
            getElementById(),
            getElementsByClassSingle(),
            getElementsByTagSingle(),
            getRecommendThumbImageSingle()
        )).toMap()

        val SingleInMultiOut = arrayOf(
            getElementsByClass::class.java.simpleName,
            getElementsByTag::class.java.simpleName
        ).zip(arrayOf(getElementsByClass(), getElementsByTag())).toMap()

        val MultiInMultiOut = arrayOf("forEachOutput")
            .zip(arrayOf(ForeachOutput())).toMap()
    }
}