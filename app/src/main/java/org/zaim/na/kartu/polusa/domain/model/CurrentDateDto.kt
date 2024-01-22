package org.zaim.na.kartu.polusa.domain.model

import com.google.gson.annotations.SerializedName

data class CurrentDateDto (
    @SerializedName("date")
    val date: String
)