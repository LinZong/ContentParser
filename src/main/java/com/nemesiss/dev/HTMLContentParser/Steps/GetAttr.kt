package com.nemesiss.dev.HTMLContentParser.Steps

import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class GetAttr  constructor() :
    SingleInputSingleOutputElementStep<String> {
    override fun Process(root: Element, JsonConfig: JSONObject): String {
        return root.attr(JsonConfig.getString("Name"))
    }
}