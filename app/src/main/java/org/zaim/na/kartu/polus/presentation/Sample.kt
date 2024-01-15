package org.zaim.na.kartu.polus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.zaim.na.kartu.polus.domain.model.StatusApplication
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Loading
import org.zaim.na.kartu.polus.domain.model.StatusApplication.NoConnect
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Web

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()

    when (val currentState = state.value.statusApplication) {


        Loading -> {
            LoadingScreen()
        }


        is Web -> {
            WebViewScreen(
                url = currentState.url,
            )
        }

        NoConnect -> {
            NoInternetScreen(viewModel = viewModel)
        }
    }

}