package com.nemesiss.dev.HTMLContentParser.Steps

import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class getRecommendThumbImageSingle :
    SingleInputSingleOutputElementStep<String> {

    companion object {
        @JvmStatic
        val InternalThumbMap = arrayOf(
            "th-empty",
            "th-miku",
            "th-meiko",
            "th-rin",
            "th-kaito",
            "th-luka"
        )

    }

    override fun Process(root: Element, JsonConfig: JSONObject): String {
        val classAttr = root.attr("class")
        val Filtered = InternalThumbMap.filter { classAttr.contains(it) }
        val defaultThumb = Filtered.firstOrNull()
        if (defaultThumb != null) {
            return defaultThumb
        }
        val styleAttr = root.attr("style")
        val bgImagePattern = "(?<=background-image:( )?url\\()(.*)(?=\\);)".toRegex()
        val foundResult = bgImagePattern.find(styleAttr)
        if(foundResult != null) {
            return "http:${foundResult.value}"
        }
        return "th-empty"
    }
}