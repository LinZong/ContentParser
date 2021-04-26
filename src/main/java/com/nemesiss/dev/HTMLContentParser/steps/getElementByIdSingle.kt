package com.nemesiss.dev.HTMLContentParser.steps

import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class getElementByIdSingle constructor() :
    SingleInputSingleOutputElementStep<Element> {

    override fun Process(root: Element, JsonConfig : JSONObject): Element {
        val id = JsonConfig.getString("Name")
        return root.getElementById(id) ?: Element("none")
    }
}