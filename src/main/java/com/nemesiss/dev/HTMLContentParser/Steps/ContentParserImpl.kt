package com.nemesiss.dev.HTMLContentParser.Steps

import com.nemesiss.dev.HTMLContentParser.InvalidStepExecutorException
import com.nemesiss.dev.HTMLContentParser.MultiInputMultiOutputElementStep
import com.nemesiss.dev.HTMLContentParser.SingleInputMultiOutputElementStep
import com.nemesiss.dev.HTMLContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.File


class ContentParserImpl  constructor(
    val singleInSingleOut: Map<String, SingleInputSingleOutputElementStep<out Any>>,
    val singleInMultiOut: Map<String, SingleInputMultiOutputElementStep<Element, Elements>>,
    val multiInMultiOut: Map<String, MultiInputMultiOutputElementStep<Any>>
) {


    companion object {
        @JvmStatic
        fun IsSingleOutput(StepName: String): Boolean {
            return StepName.matches(Regex("^.*Single$"))
        }

        fun IsMultiInput(StepName: String): Boolean {
            return StepName.matches(Regex("^forEach.*\$"))
        }
    }

    fun Description() {
        println(singleInMultiOut.size)
        println(singleInSingleOut.size)
        println(multiInMultiOut.size)
    }

    fun ParseRule(content: JSONObject) : Any {
        val RequestUrl = content.getString("RequestUrl")
        val RequestParameters = content.getJSONObject("RequestParameter")
        val RequestCookie = content.getJSONObject("RequestCookie")

//        println(RequestUrl)

        val Steps = content.getJSONArray("Steps")
        val elements = Jsoup.parse(File("htmls/musicplayer.html"), "utf-8")
        return GoSteps(elements, Steps)
    }

    fun GoSteps(root: Element, steps: JSONArray): Any {
        var CurrentStepName: String
        var CurrentStepRule: JSONObject

        var LastStepResult: Any = root

        val StepCount = steps.size

        for (i in 0 until StepCount) {
            var step = steps.getJSONObject(i)
            CurrentStepName = step.keys.first()
            CurrentStepRule = step.getJSONObject(CurrentStepName)
            if (IsSingleOutput(CurrentStepName)) {
                val stepProcessor = singleInSingleOut[CurrentStepName]
                    ?: throw InvalidStepExecutorException("Error! Empty step processor! $CurrentStepName")
                LastStepResult = stepProcessor.Process(LastStepResult as Element, CurrentStepRule)
            } else if (IsMultiInput(CurrentStepName)) {
                val stepProcessor = multiInMultiOut[CurrentStepName]
                    ?: throw InvalidStepExecutorException("Error! Empty step processor! $CurrentStepName")
                LastStepResult = stepProcessor.Process(LastStepResult as Elements, CurrentStepRule)
            } else {
                val stepProcessor = singleInMultiOut[CurrentStepName]
                    ?: throw InvalidStepExecutorException("Error! Empty step processor! $CurrentStepName")
                LastStepResult = stepProcessor.Process(LastStepResult as Element, CurrentStepRule)
            }
        }
        return LastStepResult
    }
}