package org.zaim.na.kartu.polus.presentation.mock

interface ChooseState {
    object NoChoice:ChooseState
    object UntilZeroPerDay:ChooseState
    object MoreZeroPerDay:ChooseState
    object BadHistory:ChooseState
}