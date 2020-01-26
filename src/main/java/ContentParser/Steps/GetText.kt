package ContentParser.Steps

import ContentParser.SingleInputSingleOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import javax.inject.Inject

class GetText  constructor() : SingleInputSingleOutputElementStep<String> {
    override fun Process(root: Element, JsonConfig: JSONObject): String {
        return root.text()
    }
}