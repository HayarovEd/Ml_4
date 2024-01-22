package org.zaim.na.kartu.polusaa.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.CalendarState
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import org.zaim.na.kartu.polusa.ui.theme.color1
import org.zaim.na.kartu.polusa.ui.theme.white
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Calendar(
    modifier: Modifier = Modifier
) {

    val selectedBeginDate = remember {
        mutableStateOf(LocalDate.now())
    }
    val back = Brush.linearGradient(colors = listOf(color1, white))
    val calendarState: CalendarState<DynamicSelectionState> = rememberSelectableCalendarState(
        initialSelectionMode = SelectionMode.Period,
        initialSelection = listOf(selectedBeginDate.value)
    )

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
            calendarState = calendarState,
        )

    }
}