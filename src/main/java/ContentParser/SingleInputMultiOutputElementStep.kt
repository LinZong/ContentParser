package ContentParser

import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

interface SingleInputMultiOutputElementStep {
    fun Process(root : Element, JsonConfig : JSONObject) : Elements
}