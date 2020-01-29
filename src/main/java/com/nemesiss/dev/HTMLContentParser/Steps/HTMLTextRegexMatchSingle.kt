package com.nemesiss.dev.HTMLContentParser.Steps

import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import org.jsoup.nodes.Element

class HTMLTextRegexMatchSingle : SingleInputSingleOutputElementStep<String> {
    override fun Process(root: Element, JsonConfig: JSONObject): String {
        val RegexStr = JsonConfig.getString("Regex")

        if (RegexStr.isEmpty()) {
            return ""
        }

        val regex = RegexStr.toRegex()
        val rootHTML = root.html()

        val found = regex.findAll(rootHTML).toList()
        if (found.isNotEmpty()) {
            return found.first().value
        }
        return ""
    }

}