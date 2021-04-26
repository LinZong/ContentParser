package com.nemesiss.dev.HTMLContentParser

import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

interface SingleInputSingleOutputElementStep<TOutput> {
    fun Process(root : Element, JsonConfig : JSONObject) : TOutput
}