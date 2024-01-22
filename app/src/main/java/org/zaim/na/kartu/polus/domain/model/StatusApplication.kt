package org.zaim.na.kartu.polus.domain.model

sealed class StatusApplication {
    object Loading: StatusApplication()
    object Mock : StatusApplication()
    object EmptyData : StatusApplication()
    class Connect (val baseState: BaseState): StatusApplication()

    class Offer (
        val currentBaseState: BaseState,
        val elementOffer: ElementOffer
        ): StatusApplication()

    class Info (
        val currentBaseState: BaseState,
        val content: String
        ): StatusApplication()

    class Web (
        val url: String,
        val offerName: String
    ): StatusApplication()

    class WebPrimary (
        val url: String
    ): StatusApplication()

    object NoConnect: StatusApplication()
}
