package ContentParser.Steps

import ContentParser.SingleInputMultiOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import javax.inject.Inject

class getElementsByClass @Inject constructor() : SingleInputMultiOutputElementStep {
    override fun Process(root: Element, JsonConfig: JSONObject): Elements {
        val className = JsonConfig.getString("Name")
        return root.getElementsByClass(className)
    }
}