package ContentParser.Steps

import ContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import java.util.regex.Matcher
import java.util.regex.Pattern

class getRecommendThumbImageSingle : SingleInputSingleOutputElementStep<String> {

    companion object {
        @JvmStatic
        val InternalThumbMap = arrayOf(
            "th-empty",
            "th-miku",
            "th-meiko",
            "th-rin",
            "th-kaito",
            "th-luka"
        )

    }

    override fun Process(root: Element, JsonConfig: JSONObject): String {
        val classAttr = root.attr("class")
        val Filtered = InternalThumbMap.filter { classAttr.contains(it) }
        val defaultThumb = Filtered.firstOrNull()
        if (defaultThumb != null) {
            return defaultThumb
        }
        val styleAttr = root.attr("style")
        val matchBgImg = Pattern.compile("(?<=background-image:( )?url\\()(.*)(?=\\);)").matcher(styleAttr)
        if(matchBgImg.find()) {
           return "http:" + matchBgImg.group(2)
        }
        return "th-empty"
    }
}