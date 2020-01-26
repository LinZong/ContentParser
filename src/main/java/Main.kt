//import ContentParser.Steps.DaggerContentParserFactory

import ContentParser.ContentParserFactory
import ContentParser.Model.RecommendTagModel
import com.alibaba.fastjson.JSONObject
import java.io.File

fun main() {

    val parser = ContentParserFactory.Provide()

    val rootRules = JSONObject.parseObject(File("ContentParserRule.json").readText())
    val RecommendTag = rootRules.getJSONObject("RecommendTag")

    val Result = parser.ParseRule(RecommendTag) as Array<*>

    for (ttag in Result) {
        val tag = ttag as RecommendTagModel
        println("${tag.URL}  ${tag.Text}")
    }
}