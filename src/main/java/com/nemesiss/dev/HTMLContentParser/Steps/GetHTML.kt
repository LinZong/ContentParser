package com.nemesiss.dev.HTMLContentParser.Steps

import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import org.jsoup.nodes.Element

class GetHTML constructor() :
    SingleInputSingleOutputElementStep<String> {
    override fun Process(root: Element, JsonConfig: JSONObject): String {
        return if(root != null) {
            root.html()
        } else {
            "<none></none>"
        }
    }
}