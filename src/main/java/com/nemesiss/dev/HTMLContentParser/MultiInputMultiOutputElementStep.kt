package com.nemesiss.dev.HTMLContentParser

import com.alibaba.fastjson.JSONObject
import org.jsoup.select.Elements

interface MultiInputMultiOutputElementStep<TOutput> {
    fun Process(root : Elements, JsonConfig: JSONObject) : Array<TOutput?>
}