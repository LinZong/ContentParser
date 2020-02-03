package com.nemesiss.dev.HTMLContentParser.Model

import java.io.Serializable

class RecommendItemModel : Serializable {
    lateinit var Thumb: String
    lateinit var ItemName: String
    lateinit var ArtistName: String
    lateinit var UploadDate: String
    lateinit var UploadTime: String
    lateinit var URL : String
}