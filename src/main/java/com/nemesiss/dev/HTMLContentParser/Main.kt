package com.nemesiss.dev.HTMLContentParser

import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.Model.*
import org.jsoup.Jsoup
import java.io.File
import java.io.FileWriter

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val parser = ContentParserFactory.Provide()
            val rootRules = JSONObject.parseObject(File("ContentParserRule.json").readText())
            val Steps = rootRules.getJSONObject("Submission-IMAGE").getJSONArray("Steps")
            val elements = Jsoup.parse(File("htmls/submission-image.html"), "utf-8")

            val Result = (parser.GoSteps(elements, Steps) as Array<*>).map { elem -> elem as RecommendItemModelImage }
            println(Result.size)
            readLine()
        }

        @JvmStatic
        fun FindUrl() {
            val strWithUrl =
                "ポッピンキャンディ☆フィーバー！(<a href=\"/jump/?url=https%3A%2F%2Fnico.ms%2Fsm35880454\" target=\"_blank\">https://nico.ms/sm35880454</a>)の歌詞になります。"
            val regex = "<a (?<=(.))href=\"(.*)\" .*>(.*)</a>".toRegex()
            val domain = "https://piapro.jp"

            var result = regex.find(strWithUrl)
            if (result != null) {
                val total = result.groups[0]

                val href = result.groups[2]
                val innerText = result.groups[3]

                val hrefBegin = total!!.range.first

                val clickableText = strWithUrl.replace(regex, innerText!!.value)
                println(clickableText)
                println(clickableText.substring(hrefBegin, hrefBegin + innerText.value.length - 1))
            } else {

            }
        }
    }
}