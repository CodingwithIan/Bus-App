package com.ian.busapp.studenthandler

import com.google.firebase.database.Exclude

data class Students(
    var name:String? = null,
    var imageUrl:String? = null,
    var school:String? = null,
    var clas:String? = null,
    var mobile:String? = null,
    var station:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null

)