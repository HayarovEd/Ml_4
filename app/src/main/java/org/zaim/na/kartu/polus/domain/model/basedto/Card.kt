package org.zaim.na.kartu.polus.domain.model.basedto


import com.google.gson.annotations.SerializedName
import org.zaim.na.kartu.polus.domain.model.basedto.CardsCredit
import org.zaim.na.kartu.polus.domain.model.basedto.CardsDebit
import org.zaim.na.kartu.polus.domain.model.basedto.CardsInstallment

data class Card(
    @SerializedName("cards_credit")
    val cardsCredit: List<CardsCredit> = emptyList(),
    @SerializedName("cards_debit")
    val cardsDebit: List<CardsDebit> = emptyList(),
    @SerializedName("cards_installment")
    val cardsInstallment: List<CardsInstallment> = emptyList()
)