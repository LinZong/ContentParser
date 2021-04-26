package com.nemesiss.dev.HTMLContentParser.steps

import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.ContentParserFactory
import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import org.jsoup.nodes.Element

class OutputSingle : SingleInputSingleOutputElementStep<Any> {
    override fun Process(root: Element, JsonConfig: JSONObject): Any {
        val ElementMapClassName = JsonConfig.getString("ElementMapClassName")
        val GenerateOutputRule = JsonConfig.getJSONObject("GenerateOutputRule")
        val ContentKeys = GenerateOutputRule.keys.toTypedArray()
        val innerParser = ContentParserFactory.Provide()
        if (ContentKeys.isEmpty()) {
            return Any()
        }
        val ContentKeyFirst = ContentKeys.first()

        if (ElementMapClassName.isEmpty()) {
            val Steps = GenerateOutputRule.getJSONArray(ContentKeyFirst)
            return innerParser.GoSteps(root, Steps)
        } else {
            val MappedClass = Class.forName(ElementMapClassName)
            val MappedClassInstance = MappedClass.newInstance()

            for (key in ContentKeys) {
                val CurrentKeyField = MappedClass.getField(key)
                val Step = GenerateOutputRule.getJSONArray(key)
                CurrentKeyField.set(MappedClassInstance, innerParser.GoSteps(root, Step))
            }
            return MappedClassInstance
        }
    }
}