package com.nemesiss.dev.HTMLContentParser.steps

import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class getElementsByClassSingle  constructor() :
    SingleInputSingleOutputElementStep<Element> {
    override fun Process(root: Element, JsonConfig : JSONObject): Element {
        val className = JsonConfig.getString("Name")
        val index = JsonConfig.getIntValue("Index")
        return root.getElementsByClass(className)[index]
    }
}