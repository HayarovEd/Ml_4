package org.zaim.na.kartu.polus.domain.model


data class AppConfig(
    val privacyPolicyHtml: String,
    val showCalculatorItem: String,
    val showChat: String,
    val showNewsItem: String,
    val showPhoneAuthentication: String,
    val userTermHtml: String
)