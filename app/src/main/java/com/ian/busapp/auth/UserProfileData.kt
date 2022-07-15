package com.ian.busapp.auth

import com.google.firebase.database.Exclude

data class UserProfileData(
    var companyName:String? = null,
    var imageUrl:String? = null,
    var companyEmail:String? = null,
    var companyContact:String? = null,
    var krapin:String? = null,

    @get:Exclude
    @set:Exclude
    var key:String? = null

)