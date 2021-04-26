package com.nemesiss.dev.HTMLContentParser.steps

import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class getElementsByTagSingle :
    SingleInputSingleOutputElementStep<Element> {
    override fun Process(root: Element, JsonConfig: JSONObject): Element {
        val index = JsonConfig.getIntValue("Index")
        return root.getElementsByTag(JsonConfig.getString("Name"))[index]
    }

}