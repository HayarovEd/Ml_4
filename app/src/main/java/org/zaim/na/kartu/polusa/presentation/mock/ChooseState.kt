package org.zaim.na.kartu.polusa.presentation.mock

interface ChooseState {
    object NoChoice: ChooseState
    object UntilZeroPerDay: ChooseState
    object MoreZeroPerDay: ChooseState
    object BadHistory: ChooseState
}