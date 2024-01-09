package org.zaim.na.kartu.polus.presentation

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
import org.zaim.na.kartu.polus.domain.model.StatusApplication
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Connect
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Info
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Loading
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Mock
import org.zaim.na.kartu.polus.domain.model.StatusApplication.NoConnect
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Offer
import org.zaim.na.kartu.polus.domain.model.StatusApplication.Web
import org.zaim.na.kartu.polus.domain.model.StatusApplication.WebPrimary
import org.zaim.na.kartu.polus.domain.model.TypeCard
import org.zaim.na.kartu.polus.domain.model.basedto.BaseState
import org.zaim.na.kartu.polus.domain.model.basedto.BaseState.Cards
import org.zaim.na.kartu.polus.presentation.MainEvent.OnChangeBaseState
import org.zaim.na.kartu.polus.presentation.MainEvent.OnChangeStatusApplication
import org.zaim.na.kartu.polus.presentation.mock.BaseScreen

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
    val loanLazyState = rememberLazyListState()
    val creditLazyState = rememberLazyListState()
    val creditCardloanLazyState = rememberLazyListState()
    val debitCardLazyState = rememberLazyListState()
    val instalmentCardLazyState = rememberLazyListState()
    val typeCard = if (!state.value.creditCards.isNullOrEmpty()) TypeCard.CardCredit
    else if (!state.value.debitCards.isNullOrEmpty()) TypeCard.CardDebit else TypeCard.CardInstallment
    when (val currentState = state.value.statusApplication) {
        is Connect -> {
            ConnectScreen(
                baseState = currentState.baseState,
                db = state.value.dbData!!,
                onClickCards = { onEvent(
                    OnChangeBaseState(
                        Cards(
                    typeCard = typeCard
                )
                    )
                ) },
                onClickCredits = { onEvent(OnChangeBaseState(BaseState.Credits)) },
                onClickLoans = { onEvent(OnChangeBaseState(BaseState.Loans)) },
                onClickRules = {
                    onEvent(
                        OnChangeStatusApplication(
                            Info(
                                currentBaseState = currentState.baseState,
                                content = state.value.dbData!!.appConfig.privacyPolicyHtml
                            )
                        )
                    )
                },
                loanLazyState = loanLazyState,
                creditLazyState = creditLazyState,
                creditCardloanLazyState = creditCardloanLazyState,
                debitCardLazyState = debitCardLazyState,
                instalmentCardLazyState = instalmentCardLazyState,
                creditCards = state.value.creditCards,
                debitCards = state.value.debitCards,
                installmentCards = state.value.installmentCards,
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