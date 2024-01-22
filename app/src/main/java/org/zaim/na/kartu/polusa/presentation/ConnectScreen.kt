package org.zaim.na.kartu.polusa.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.zaim.na.kartu.polusa.R
import org.zaim.na.kartu.polusa.domain.model.BaseDb
import org.zaim.na.kartu.polusa.domain.model.BaseState
import org.zaim.na.kartu.polusa.domain.model.BaseState.Credits


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectScreen(
    modifier: Modifier = Modifier,
    db: BaseDb,
    baseState: BaseState,
    onEvent: (MainEvent) -> Unit,
    creditLazyState: LazyListState,
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        /*topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            color = white,
                            fontStyle = FontStyle(R.font.open_sans),
                            fontSize = 22.sp,
                            fontWeight = FontWeight(600),
                            text = title
                        )
                        *//*IconButton(onClick = onClickRules) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.info),
                                tint = black,
                                contentDescription = "")
                        }*//*
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = baseBackground
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = baseBackground
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (!db.loans.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = if (baseState is BaseState.Loans) yellow else grey,
                            content = stringResource(id = R.string.loans),
                            icon = ImageVector.vectorResource(id = R.drawable.cashback),
                            onClick = onClickLoans
                        )
                    }
                    if (!db.cards.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = if (baseState is Cards) yellow else grey,
                            content = stringResource(id = R.string.cards),
                            icon = ImageVector.vectorResource(id = R.drawable.card),
                            onClick = onClickCards
                        )
                    }
                    if (!db.credits.isNullOrEmpty()) {
                        ItemBottomBar(
                            color = if (baseState is Credits) yellow else grey,
                            content = stringResource(id = R.string.credits),
                            icon = ImageVector.vectorResource(id = R.drawable.credit),
                            onClick = onClickCredits
                        )
                    }
                }

            }
        }*/
    ) { valuePaddings ->
        when (val type = baseState) {
            Credits -> {
                Credits(
                    valuePaddings = valuePaddings,
                    credits = db.credits,
                    onEvent = onEvent,
                    baseState = baseState,
                    creditLazyState = creditLazyState
                )
            }
        }
    }
}

@Composable
fun ItemBottomBar(
    color: Color,
    icon: ImageVector,
    content: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = color
            ),
            onClick = onClick) {
            Icon(imageVector = icon, contentDescription = "")
        }
        Text(
            color = color,
            fontStyle = FontStyle(R.font.open_sans),
            fontSize = 15.sp,
            fontWeight = FontWeight(600),
            text = content
        )
    }
}
