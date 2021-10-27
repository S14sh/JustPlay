package com.slash.justplay.ui.viewgroup

import android.content.res.Resources
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.slash.justplay.R
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
            IconButton(onClick = {

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
            IconButton(onClick = {

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
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    BottomAppBar(content = content, backgroundColor = backgroundColor, contentColor = contentColor)
}