package ContentParser.Steps

import ContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

class getElementsByTagSingle : SingleInputSingleOutputElementStep<Element> {
    override fun Process(root: Element, JsonConfig: JSONObject): Element {
        return root.getElementsByTag(JsonConfig.getString("Name"))[0]
    }

}