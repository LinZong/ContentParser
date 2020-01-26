package ContentParser.Steps

import ContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import javax.inject.Inject

class getElementById @Inject constructor() : SingleInputSingleOutputElementStep {

    override fun Process(root: Element, JsonConfig : JSONObject): Element {
        val id = JsonConfig.getString("Name")
        return root.getElementById(id)
    }
}