package org.zaim.na.kartu.polus.presentation.mock

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.zaim.na.kartu.polus.R
import org.zaim.na.kartu.polus.ui.theme.darkText
import org.zaim.na.kartu.polus.ui.theme.grey
import org.zaim.na.kartu.polus.ui.theme.semiWhite
import org.zaim.na.kartu.polus.ui.theme.white
import org.zaim.na.kartu.polus.ui.theme.yellow

@Composable
fun LoanGetScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val sliderPosition = remember { mutableFloatStateOf(0f) }
    val choose = remember {
        mutableStateOf<ChooseState>(ChooseState.NoChoice)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_30),
                    contentDescription = "",
                    tint = white
                )
                Spacer(modifier = modifier.width(10.dp))
                Text(
                    text = stringResource(id = R.string.get_loan),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight(600),
                        color = white
                    )
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.outline_info_30),
                contentDescription = "",
                tint = white
            )
        }
        Spacer(modifier = modifier.height(28.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.amount_loan),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(400),
                    color = white
                )
            )
            Text(
                text = stringResource(id = R.string.max_amount),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(400),
                    color = white
                )
            )
        }
        Spacer(modifier = modifier.height(14.dp))
        Slider(
            modifier = modifier
                .fillMaxWidth(),
            value = sliderPosition.floatValue,
            onValueChange = {
                sliderPosition.floatValue = it
            },
            colors = SliderDefaults.colors(
                activeTrackColor = yellow,
                inactiveTrackColor = grey,
                thumbColor = yellow
            )
        )
        Spacer(modifier = modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.individual_conditions),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight(400),
                color = white
            )
        )
        Spacer(modifier = modifier.height(20.dp))
        ItemCondition(
            title = stringResource(id = R.string.offers_from),
            color = if (choose.value == ChooseState.UntilZeroPerDay) yellow else semiWhite,
            onClick = { choose.value = ChooseState.UntilZeroPerDay }
        )
        Spacer(modifier = modifier.height(15.dp))
        ItemCondition(
            title = stringResource(id = R.string.more_per_day),
            color = if (choose.value == ChooseState.MoreZeroPerDay) yellow else semiWhite,
            onClick = { choose.value = ChooseState.MoreZeroPerDay }
        )
        Spacer(modifier = modifier.height(15.dp))
        ItemCondition(
            title = stringResource(id = R.string.bad_history),
            color = if (choose.value == ChooseState.BadHistory) yellow else semiWhite,
            onClick = { choose.value = ChooseState.BadHistory }
        )
        Spacer(modifier = modifier.height(30.dp))
        Button(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(
                vertical = 7.dp
            ),
            enabled = sliderPosition.floatValue != 0f && choose.value != ChooseState.NoChoice,
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = darkText,
                disabledContainerColor = grey,
                disabledContentColor = white
            ),
            onClick = onClick
        ) {
            Text(
                text = stringResource(id = R.string.checkout),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(600),
                )
            )
        }
        Spacer(modifier = modifier.height(15.dp))
        Text(
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    sliderPosition.floatValue = 0f
                    choose.value = ChooseState.NoChoice
                }),
            text = stringResource(id = R.string.hide_filter),
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight(600),
                color = grey
            ),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
private fun ItemCondition(
    modifier: Modifier = Modifier,
    title: String,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .border(
                width = 1.dp,
                color = grey,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                horizontal = 15.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_check_18),
            contentDescription = "",
            tint = color
        )
        Spacer(modifier = modifier.width(5.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight(600),
                color = color
            )
        )
    }
}

