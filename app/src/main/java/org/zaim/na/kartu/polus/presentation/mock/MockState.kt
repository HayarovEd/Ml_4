package org.zaim.na.kartu.polus.presentation.mock

sealed interface MockState {
    object LoanGet:MockState
    object UserData:MockState
    object Finish:MockState
}