package org.zaim.na.kartu.polus.domain.model


sealed class StatusApplication {
    object Loading: StatusApplication()

    class Web (
        val url: String
    ): StatusApplication()

    object NoConnect: StatusApplication()
}
