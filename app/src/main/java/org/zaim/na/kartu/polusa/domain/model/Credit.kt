package org.zaim.na.kartu.polusa.domain.model



data class Credit(
    val description: String,
    val hidePercentFields: String,
    val hideTermFields: String,
    val id: Int,
    val isActive: String,
    val itemId: String,
    val name: String,
    val order: String,
    val orderButtonText: String,
    val percent: String,
    val percentPostfix: String,
    val percentPrefix: String,
    val position: Int,
    val score: String,
    val screen: String,
    val showCash: String,
    val showMastercard: String,
    val showMir: String,
    val showQiwi: String,
    val showVisa: String,
    val showYandex: String,
    val summMax: String,
    val summMid: String,
    val summMin: String,
    val summPostfix: String,
    val summPrefix: String,
    val termMax: String,
    val termMid: String,
    val termMin: String,
    val termPostfix: String,
    val termPrefix: String
)