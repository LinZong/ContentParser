package com.nemesiss.dev.HTMLContentParser
import com.alibaba.fastjson.JSONObject
import com.nemesiss.dev.HTMLContentParser.Model.MusicContentInfo
import com.nemesiss.dev.HTMLContentParser.Model.MusicPlayInfo
import com.nemesiss.dev.HTMLContentParser.Model.RelatedMusicInfo
import org.jsoup.Jsoup
import java.io.File
import java.io.FileWriter

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val parser = ContentParserFactory.Provide()
            val rootRules = JSONObject.parseObject(File("ContentParserRule.json").readText())
            val Steps = rootRules.getJSONObject("MusicContent").getJSONArray("Steps")

            val elements = Jsoup.parse(File("htmls/musicid-nolyric.html"), "utf-8")
            val Result = parser.GoSteps(elements, Steps) as MusicContentInfo

            println(Result.ArtistAvatar)

//            val fw = FileWriter("Output.txt")
//                fw.write(Result.CreateDescription)
//            fw.flush()
//            fw.close()

//
//            Result.forEach {
//                println("${it.Thumb}  ${it.Title}  ${it.Artist}")
//            }
//
//            val parts = Result.CreateDetail.split(" | ")
//            parts.forEach { println(it)}
        }
    }
}