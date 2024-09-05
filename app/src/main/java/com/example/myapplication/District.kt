package com.example.myapplication

import java.io.Serializable

data class District(
    val divisionName: String,
    val districtName: String,
    val districtImage: String
): Serializable
