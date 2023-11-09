package org.zaim.na.kartu.polus.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.zaim.na.kartu.polus.ui.theme.baseBackground
import org.zaim.na.kartu.polus.ui.theme.yellow

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseBackground),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(100.dp),
            color = yellow
        )
    }
}