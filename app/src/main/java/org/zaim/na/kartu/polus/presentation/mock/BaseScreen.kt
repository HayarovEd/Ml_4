package org.zaim.na.kartu.polus.presentation.mock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.zaim.na.kartu.polus.ui.theme.baseBackground

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier
) {
    val mockState = remember {
        mutableStateOf<MockState>(MockState.LoanGet)
    }
    Box(modifier = modifier
        .fillMaxSize()
        .background(color = baseBackground))
    {
        when (mockState.value) {
            MockState.Finish -> {
                FinishScreen()
            }

            MockState.LoanGet -> {
                LoanGetScreen(
                    onClick = { mockState.value = MockState.UserData }
                )
            }

            MockState.UserData -> {
                UserDataScreen(
                    onBackClick = { mockState.value = MockState.LoanGet },
                    onClick = { mockState.value = MockState.Finish })
            }
        }
    }
}