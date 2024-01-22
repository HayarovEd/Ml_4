package org.zaim.na.kartu.polusa.presentation.mock

sealed interface MockState {
    object LoanGet: MockState
    object UserData: MockState
    object Finish: MockState
}