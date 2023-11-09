
package org.zaim.na.kartu.polus.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.zaim.na.kartu.polus.R
import org.zaim.na.kartu.polus.domain.model.TypeCard
import org.zaim.na.kartu.polus.domain.model.basedto.BaseState
import org.zaim.na.kartu.polus.domain.model.basedto.CardsCredit
import org.zaim.na.kartu.polus.domain.model.basedto.CardsDebit
import org.zaim.na.kartu.polus.domain.model.basedto.CardsInstallment
import org.zaim.na.kartu.polus.ui.theme.baseBackground
import org.zaim.na.kartu.polus.ui.theme.white
import org.zaim.na.kartu.polus.ui.theme.yellow

@Composable
fun CardsScreen(
    modifier: Modifier = Modifier,
    valuePaddings: PaddingValues,
    creditCards: List<CardsCredit>,
    debitCards: List<CardsDebit>,
    installmentCards: List<CardsInstallment>,
    typeCard: TypeCard,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState,
    creditCardloanLazyState: LazyListState,
    debitCardLazyState: LazyListState,
    instalmentCardLazyState: LazyListState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground)
            .padding(valuePaddings),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!creditCards.isNullOrEmpty()) {
                Button(
                    modifier = modifier.weight(1f),
                    onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardCredit)) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (typeCard is TypeCard.CardCredit) yellow else baseBackground
                    ),
                    contentPadding = PaddingValues(horizontal = 15.dp, vertical = 5.dp)
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardCredit) baseBackground else white,
                        fontStyle = FontStyle(R.font.open_sans),
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        text = stringResource(id = R.string.credit),
                        textAlign = TextAlign.Center
                    )
                }
            }
            if (!debitCards.isNullOrEmpty()) {
                Button(
                    modifier = modifier.weight(1f),
                    onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardDebit)) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (typeCard is TypeCard.CardDebit) yellow else baseBackground
                    ),
                    contentPadding = PaddingValues(horizontal = 15.dp, vertical = 5.dp)
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardDebit) baseBackground else white,
                        fontStyle = FontStyle(R.font.open_sans),
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        text = stringResource(id = R.string.debit),
                        textAlign = TextAlign.Center
                    )
                }
            }
            if (!installmentCards.isNullOrEmpty()) {
                Button(
                    modifier = modifier.weight(1f),
                    onClick = { onEvent(MainEvent.OnChangeTypeCard(TypeCard.CardInstallment)) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (typeCard is TypeCard.CardInstallment) yellow else baseBackground
                    ),
                    contentPadding = PaddingValues(horizontal = 15.dp, vertical = 5.dp)
                ) {
                    Text(
                        color = if (typeCard is TypeCard.CardInstallment) baseBackground else white,
                        fontStyle = FontStyle(R.font.open_sans),
                        fontSize = 13.sp,
                        fontWeight = FontWeight(600),
                        text = stringResource(id = R.string.installment),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(24.dp))
        when (typeCard) {
            TypeCard.CardCredit -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    state = creditCardloanLazyState
                ) {
                    items(creditCards) { card ->
                        ItemCreditCard(
                            card = card,
                            onEvent = onEvent,
                            baseState = baseState
                        )
                    }
                }
            }

            TypeCard.CardDebit -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    state = debitCardLazyState
                ) {
                    items(debitCards) { card ->
                        ItemDebitCard(
                            card = card,
                            onEvent = onEvent,
                            baseState = baseState,
                        )
                    }
                }
            }

            TypeCard.CardInstallment -> {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    state = instalmentCardLazyState
                ) {
                    items(installmentCards) { card ->
                        ItemInstallmentCard(
                            card = card,
                            baseState = baseState,
                            onEvent = onEvent
                        )
                    }
                }
            }
        }

    }
}
