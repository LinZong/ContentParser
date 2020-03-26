package com.nemesiss.dev.HTMLContentParser.Model

import java.io.Serializable

class ImageContentInfo : Serializable {
    lateinit var ContentID: String
    lateinit var Title: String
    lateinit var CreateDetail: String
    lateinit var CreateDescription : String
    lateinit var Artist : String
    lateinit var ArtistAvatar : String
    lateinit var URL : String
}