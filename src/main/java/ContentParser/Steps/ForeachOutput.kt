package ContentParser.Steps

import ContentParser.ContentParserFactory
import ContentParser.Model.RecommendTagModel
import ContentParser.MultiInputMultiOutputElementStep
import com.alibaba.fastjson.JSONObject
import org.jsoup.select.Elements
import javax.inject.Inject

class ForeachOutput : MultiInputMultiOutputElementStep<Any> {

    override fun Process(root: Elements, JsonConfig: JSONObject): Array<Any?> {
        val ElementMapClassName = JsonConfig.getString("ElementMapClassName")

        val GenerateOutputRule = JsonConfig.getJSONObject("GenerateOutputRule")

        val OutputObjKeys = GenerateOutputRule.keys.toTypedArray()

        val innerParser = ContentParserFactory.Provide()

        val MappedClass = Class.forName(ElementMapClassName)

        val ResultObjects = IntRange(0, root.size - 1)
                                            .map { MappedClass.getConstructor().newInstance() }
                                            .toTypedArray()

        for (key in OutputObjKeys) {
            val steps = GenerateOutputRule.getJSONArray(key)
            val CurrentKeyField = MappedClass.getField(key)

            for ((index,element) in root.withIndex()) {
                CurrentKeyField.set(ResultObjects[index], innerParser.GoSteps(element, steps))
            }
        }
        return ResultObjects
    }
}