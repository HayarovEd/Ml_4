package org.zaim.na.kartu.polus.presentation.mock

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.zaim.na.kartu.polus.R
import org.zaim.na.kartu.polus.ui.theme.darkText
import org.zaim.na.kartu.polus.ui.theme.grey
import org.zaim.na.kartu.polus.ui.theme.semiWhite
import org.zaim.na.kartu.polus.ui.theme.white
import org.zaim.na.kartu.polus.ui.theme.yellow

@Composable
fun UserDataScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onClick: () -> Unit
) {
    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    val polices = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 13.sp,
                color = white,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.open_sans))
            )
        ) {
            append("${stringResource(id = R.string.police_1)} ")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 13.sp,
                color = yellow,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.open_sans))
            )
        ) {
            append(stringResource(id = R.string.police_2))
        }
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
        ) {
            Icon(
                modifier = modifier.clickable(
                    onClick = onBackClick
                ),
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_30),
                contentDescription = "",
                tint = white
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = stringResource(id = R.string.back),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(600),
                    color = white
                )
            )
        }
        Spacer(modifier = modifier.height(24.dp))
        ItemUserData(
            title = stringResource(id = R.string.name),
            value = name.value,
            type = KeyboardType.Text,
            onClick = {
                name.value = it
            })
        Spacer(modifier = modifier.height(20.dp))
        ItemUserData(
            title = stringResource(id = R.string.phone),
            value = phone.value,
            type = KeyboardType.Phone,
            onClick = {
                phone.value = it
            })
        Spacer(modifier = modifier.height(20.dp))
        ItemUserData(
            title = stringResource(id = R.string.email),
            value = email.value,
            type = KeyboardType.Email,
            onClick = {
                email.value = it
            })
        Spacer(modifier = modifier.height(30.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = modifier.clickable {
                    isChecked.value = !isChecked.value
                },
                imageVector = ImageVector.vectorResource(R.drawable.baseline_circle_18),
                contentDescription = "",
                tint = if (isChecked.value) yellow else grey
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(text = polices)
        }
        Spacer(modifier = modifier.height(30.dp))
        Button(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(
                vertical = 7.dp
            ),
            enabled = (name.value != ""
                    && phone.value != ""
                    && email.value != "") && isChecked.value,
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = darkText,
                disabledContainerColor = grey,
                disabledContentColor = white
            ),
            onClick = onClick
        ) {
            Text(
                text = stringResource(id = R.string.send),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.open_sans)),
                    fontWeight = FontWeight(600),
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemUserData(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    type: KeyboardType,
    onClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight(600),
                color = white
            )
        )
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                onClick(it)
            },
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = type
            ),
            textStyle = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontWeight = FontWeight(600),
                color = semiWhite
            )
        )
    }
}