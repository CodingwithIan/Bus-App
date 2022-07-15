package com.ian.busapp.bushandler

import com.google.firebase.database.Exclude

data class BusDataClass(
    var busreg:String? = null,
    var imageUrl:String? = null,
    var buscolor:String? = null,
    var busdriver:String? = null,

    @get:Exclude
    @set:Exclude
    var key:String? = null

)