package com.nemesiss.dev.HTMLContentParser.steps

import com.nemesiss.dev.HTMLContentParser.SingleInputMultiOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class getElementsByTag  constructor() :
    SingleInputMultiOutputElementStep<Element, Elements> {
    override fun Process(root: Element, JsonConfig: JSONObject): Elements {
        val className = JsonConfig.getString("Name")
        return root.getElementsByTag(className)
    }
}