
import ContentParser.ContentParserFactory
import ContentParser.Model.RecommendItemModel
import com.alibaba.fastjson.JSONObject
import java.io.File

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val parser = ContentParserFactory.Provide()

            val rootRules = JSONObject.parseObject(File("ContentParserRule.json").readText())
            val RecommendTag = rootRules.getJSONObject("RecommendList")

            val Result = parser.ParseRule(RecommendTag) as Array<*>

            for (ttag in Result) {
                val tag = ttag as RecommendItemModel
                println("${tag.UploadDate} ${tag.UploadTime} -- ${tag.ItemName} -- ${tag.ArtistName} -- ${tag.Thumb}")
            }
        }
    }
}