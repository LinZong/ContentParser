package com.nemesiss.dev.HTMLContentParser.model

import java.io.Serializable

class MusicContentInfo : Serializable {
    lateinit var ContentID: String
    lateinit var CreateDate: String
    lateinit var Title: String
    lateinit var CreateDetail: String
    lateinit var CreateDescription : String
    lateinit var Priority: String
    lateinit var Lyrics: String
    lateinit var Artist : String
    lateinit var ArtistAvatar : String
}