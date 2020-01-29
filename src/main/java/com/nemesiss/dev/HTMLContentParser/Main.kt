package com.nemesiss.dev.HTMLContentParser
import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.Model.MusicContentInfo
import com.nemesiss.dev.HTMLContentParser.Model.MusicPlayInfo
import java.io.File

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val parser = ContentParserFactory.Provide()
            val rootRules = JSONObject.parseObject(File("ContentParserRule.json").readText())
            val RecommendTag = rootRules.getJSONObject("MusicPlayInfo")

            val Result = parser.ParseRule(RecommendTag) as MusicPlayInfo

            println(Result.Thumb)
        }
    }
}