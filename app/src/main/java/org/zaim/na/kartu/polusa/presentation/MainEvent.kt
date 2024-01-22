package org.zaim.na.kartu.polusa.presentation

import org.zaim.na.kartu.polusa.domain.model.StatusApplication
import org.zaim.na.kartu.polusa.domain.model.BaseState


sealed class MainEvent {
    object Reconnect: MainEvent()

    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnChangeBaseState(val baseState: BaseState): MainEvent()

    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
