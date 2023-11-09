package org.zaim.na.kartu.polus.presentation.mock

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.zaim.na.kartu.polus.R
import org.zaim.na.kartu.polus.ui.theme.white
import org.zaim.na.kartu.polus.ui.theme.yellow
@Preview
@Composable
fun FinishScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.size(100.dp),
                painter = painterResource(id = R.drawable.lucide_check_circle),
                contentDescription = "",
            )
            Spacer(modifier = modifier.height(40.dp))
            Text(
                text = stringResource(id = R.string.excellent),
                style = TextStyle(
                    fontSize = 45.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(700),
                    color = white
                )
            )
            Spacer(modifier = modifier.height(13.dp))
            Text(
                text = stringResource(id = R.string.meet),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontWeight = FontWeight(500),
                    color = yellow
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}