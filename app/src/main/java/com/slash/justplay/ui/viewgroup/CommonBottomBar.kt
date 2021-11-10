package com.slash.justplay.ui.viewgroup

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.slash.justplay.R
import com.slash.justplay.constant.IS_IN_MAIN
import com.slash.justplay.ui.theme.Black
import com.slash.justplay.ui.theme.White

/**
 * @author Slash.R.Wei
 * on 2021/10/26
 */

@Composable
fun commonBottomBar(
    content: @Composable RowScope.() -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(modifier = Modifier
                .fillMaxHeight()
                .weight(weight = 0.5f),
                onClick = {
                    IS_IN_MAIN.value = true
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_bottom_main),
                    contentDescription = "This is main page icon.",
                    tint = if (isSystemInDarkTheme()) {
                        White
                    } else {
                        Black
                    }
                )
            }
            IconButton(modifier = Modifier
                .fillMaxHeight()
                .weight(weight = 0.5f),
                onClick = {
                    IS_IN_MAIN.value = false
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_bottom_list),
                    contentDescription = "This is play list icon.",
                    tint = if (isSystemInDarkTheme()) {
                        White
                    } else {
                        Black
                    }
                )
            }
        }
    },
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    BottomAppBar(content = content, backgroundColor = backgroundColor, contentColor = contentColor)
}