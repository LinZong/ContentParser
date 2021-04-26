package com.nemesiss.dev.HTMLContentParser.model

import java.io.Serializable

class TextContentInfo : Serializable {
    lateinit var ContentID: String
    lateinit var CreateDate: String
    lateinit var Title: String
    lateinit var CreateDetail: String
    lateinit var CreateDescription : String
    lateinit var Artist : String
    lateinit var ArtistAvatar : String
    lateinit var Text : String
}