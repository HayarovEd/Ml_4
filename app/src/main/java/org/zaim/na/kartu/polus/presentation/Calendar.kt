package org.zaim.na.kartu.polus.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import org.zaim.na.kartu.polus.ui.theme.color1
import org.zaim.na.kartu.polus.ui.theme.white

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Calendar(
    modifier: Modifier = Modifier
) {
    val back = Brush.linearGradient(colors = listOf(color1, white))
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = white)
            .padding(10.dp)
    ){
        SelectableCalendar(
            modifier = modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFD6E3F3),
                    shape = RoundedCornerShape(size = 15.dp)
                )
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x696F8CB0),
                    ambientColor = Color(0x696F8CB0)
                )
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0xFFFFFFFF),
                    ambientColor = Color(0xFFFFFFFF)
                )
                .shadow(
                    elevation = 4.dp,
                    spotColor = Color(0x1A728EAB),
                    ambientColor = Color(0x1A728EAB)
                )
                .background(brush = back)
                .padding(16.dp),
            dayContent = {
                Box (
                    modifier
                        .clickable {

                        }
                        .padding(vertical = 10.dp, horizontal = 13.dp)
                ){
                    Text(
                        modifier = modifier.align(alignment = Alignment.Center),
                        text = it.date.dayOfMonth.toString(),
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            //fontFamily = FontFamily(Font(R.font.raleway)),
                            fontWeight = FontWeight(400),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        )
    }
}