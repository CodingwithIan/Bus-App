package com.ian.busapp.drivershandler

import com.google.firebase.database.Exclude

data class Driver(
    var driverName:String? = null,
    var imageUrl:String? = null,
    var driverId:String? = null,
    var driverMobile:String? = null,
    var driverVehicle:String? = null,
    @get:Exclude
    @set:Exclude
    var key:String? = null

)