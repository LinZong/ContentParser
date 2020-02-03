package com.nemesiss.dev.HTMLContentParser.Steps

import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import org.jsoup.nodes.Element

class getStyleAttributeBgImageSingle : SingleInputSingleOutputElementStep<String> {
    override fun Process(root: Element, JsonConfig: JSONObject): String {
        val styleAttr = root.attr("style")
        val UrlPrefix = JsonConfig.getString("UrlPrefix")
//        val bgImagePattern = "(?<=background-image:( )?url\\()(.*)(?=\\);)".toRegex()
        val bgImagePattern = "(?<=background-image:( )?url\\()(.*)(?=\\);?)".toRegex()
        val foundResult = bgImagePattern.find(styleAttr)
        if(foundResult != null) {
            return "${UrlPrefix}${foundResult.value}"
        }
        return ""
    }
}