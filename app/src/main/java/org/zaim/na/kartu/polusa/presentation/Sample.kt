package org.zaim.na.kartu.polusa.presentation

import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import org.zaim.na.kartu.polusa.domain.model.StatusApplication
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Connect
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Info
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Loading
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Mock
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.NoConnect
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Offer
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.Web
import org.zaim.na.kartu.polusa.domain.model.StatusApplication.WebPrimary
import org.zaim.na.kartu.polusa.presentation.mock.BaseScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent
    val context = LocalContext.current

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduce { acc, next -> acc && next }
        if (areGranted) {
           Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            //Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    val creditLazyState = rememberLazyListState()
    when (val currentState = state.value.statusApplication) {
        is Connect -> {
            ConnectScreen(
                baseState = currentState.baseState,
                db = state.value.dbData!!,
                creditLazyState = creditLazyState,
                onEvent = viewModel::onEvent
            )
        }

        Loading -> {
            LoadingScreen()
        }

        is Mock -> {
            BaseScreen()
        }

        is Info -> {
        }

        is Offer -> {
            OfferScreen(
                elementOffer = (state.value.statusApplication as Offer).elementOffer,
                baseState = (state.value.statusApplication as Offer).currentBaseState,
                onEvent = viewModel::onEvent,
            )
        }

        is Web -> {
            WebViewScreen(
                url = currentState.url,
                offerName = currentState.offerName,
                onEvent = viewModel::onEvent,
            )
        }

        NoConnect -> {
            NoInternetScreen(onEvent = viewModel::onEvent)
        }

        is WebPrimary -> {
            WebViewScreenPrimary(
                url = currentState.url,
                onEvent = viewModel::onEvent)
        }

        StatusApplication.EmptyData -> {
            EmptyDataScreen()
        }
    }

}