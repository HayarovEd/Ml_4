
package org.zaim.na.kartu.polus.presentation

import android.content.Context
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.zaim.na.kartu.polus.R
import org.zaim.na.kartu.polus.data.VALUE_ONE
import org.zaim.na.kartu.polus.domain.model.ElementOffer
import org.zaim.na.kartu.polus.domain.model.StatusApplication
import org.zaim.na.kartu.polus.domain.model.basedto.BaseState
import org.zaim.na.kartu.polus.domain.model.basedto.CardsInstallment
import org.zaim.na.kartu.polus.ui.theme.baseBackground
import org.zaim.na.kartu.polus.ui.theme.grey
import org.zaim.na.kartu.polus.ui.theme.white

@Composable
fun ItemInstallmentCard(
    modifier: Modifier = Modifier,
    card: CardsInstallment,
    onEvent: (MainEvent) -> Unit,
    baseState: BaseState
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 3.dp, color = grey, shape = RoundedCornerShape(15.dp))
            .padding(end = 4.dp, bottom = 4.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = baseBackground)
            .padding(15.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onEvent(
                        MainEvent.OnChangeStatusApplication(
                            StatusApplication.Offer(
                                currentBaseState = baseState,
                                ElementOffer(
                                    nameButton = card.orderButtonText,
                                    name = card.name,
                                    pathImage = card.screen,
                                    rang = card.score,
                                    description = card.description,
                                    amount = card.summPrefix + " " + card.summMin + " " + card.summMid + " " + card.summMax + " " + card.summPostfix,
                                    bet = card.percentPrefix + " " + card.percent + " " + card.percentPostfix,
                                    term = card.termPrefix + " " + card.termMin + " " + card.termMid + " " + card.termMax + " " + card.termPostfix,
                                    showMir = card.showMir,
                                    showVisa = card.showVisa,
                                    showMaster = card.showMastercard,
                                    showQiwi = card.showQiwi,
                                    showYandex = card.showYandex,
                                    showCache = card.showCash,
                                    showPercent = card.hidePercentFields,
                                    showTerm = card.hideTermFields,
                                    order = card.order
                                )
                            )
                        )
                    )
                },
            model = card.screen,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(13.dp))
        Text(
            color = white,
            fontStyle = FontStyle(R.font.open_sans),
            fontSize = 19.sp,
            fontWeight = FontWeight(700),
            text = card.name
        )
        /*Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                color = white,
                fontStyle = FontStyle(R.font.open_sans),
                fontSize = 19.sp,
                fontWeight = FontWeight(700),
                text = card.name
            )
            Rang(
                rang = card.score
            )
        }*/
        Spacer(modifier = modifier.height(13.dp))
        RowData(
            title = stringResource(id = R.string.amount),
            content = card.summPrefix +" " + card.summMin +" " + card.summMid +" " + card.summMax +" " + card.summPostfix
        )
        if (card.hidePercentFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.bet),
                content = card.percentPrefix +" " + card.percent +" " + card.percentPostfix
            )
        }
        if (card.hideTermFields == VALUE_ONE) {
            Spacer(modifier = modifier.height(8.dp))
            RowData(
                title = stringResource(id = R.string.term),
                content = card.termPrefix +" "+ card.termMin +" " + card.termMid +" " + card.termMax +" " + card.termPostfix
            )
        }
        Spacer(modifier = modifier.height(13.dp))
        RowCard(
            showVisa = card.showVisa,
            showMaster = card.showMastercard,
            showYandex = card.showYandex,
            showMir = card.showMir,
            showQivi = card.showQiwi,
            showCache = card.showCash
        )
        Spacer(modifier = modifier.height(13.dp))
        RowButtons(
            titleOffer = card.orderButtonText,
            onEvent = onEvent,
            currentBaseState = baseState,
            name = card.name,
            pathImage = card.screen,
            rang = card.score,
            description = card.description,
            amount = card.summPrefix +" " + card.summMin +" " + card.summMid +" " + card.summMax +" " + card.summPostfix,
            bet  = card.percentPrefix +" " + card.percent +" " + card.percentPostfix,
            term = card.termPrefix +" "+ card.termMin +" " + card.termMid +" " + card.termMax +" " + card.termPostfix,
            showMir = card.showMir,
            showVisa = card.showVisa,
            showMaster = card.showMastercard,
            showQiwi = card.showQiwi,
            showYandex = card.showYandex,
            showCache = card.showCash,
            showPercent = card.hidePercentFields,
            showTerm = card.hideTermFields,
            order = card.order
        )
    }
}
