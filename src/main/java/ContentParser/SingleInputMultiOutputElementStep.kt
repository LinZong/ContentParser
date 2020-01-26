package ContentParser

import com.alibaba.fastjson.JSONObject
import org.jsoup.nodes.Element

interface SingleInputMultiOutputElementStep<TSingle, TOutput : ArrayList<TSingle>> {
    fun  Process(root : Element, JsonConfig : JSONObject) : TOutput
}