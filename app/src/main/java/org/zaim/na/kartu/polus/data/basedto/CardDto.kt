package org.zaim.na.kartu.polus.data.basedto


import com.google.gson.annotations.SerializedName

data class CardDto(
    @SerializedName("cards_credit")
    val cardsCreditDto: List<CardsCreditDto>?,
    @SerializedName("cards_debit")
    val cardsDebitDto: List<CardsDebitDto>?,
    @SerializedName("cards_installment")
    val cardsInstallmentDto: List<CardsInstallmentDto>?
)