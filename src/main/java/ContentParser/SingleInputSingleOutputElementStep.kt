package ContentParser

import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

interface SingleInputSingleOutputElementStep {
    fun Process(root : Element, JsonConfig : JSONObject) : Element
}