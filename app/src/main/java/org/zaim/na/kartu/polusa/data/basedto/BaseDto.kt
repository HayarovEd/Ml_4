package org.zaim.na.kartu.polusa.data.basedto


import com.google.gson.annotations.SerializedName

data class BaseDto(
    @SerializedName("app_config")
    val appConfigDto: AppConfigDto,
    @SerializedName("cards")
    val cardDtos: List<CardDto>?,
    @SerializedName("credits")
    val creditDtos: List<CreditDto>?
)