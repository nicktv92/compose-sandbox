package com.nicktv.composesandbox.ui.views

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicktv.composesandbox.R
import com.nicktv.composesandbox.data.Message
import com.nicktv.composesandbox.ui.theme.ComposeSandboxTheme

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        var isExpanded by remember {
            mutableStateOf(false)
        }

        val surfaceColor: Color by animateColorAsState(
            targetValue =
            if (isExpanded) MaterialTheme.colors.primary
            else MaterialTheme.colors.surface
        )

        MessageImage(resId = R.drawable.ic_launcher_foreground)

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded },
        ) {
            TextAuthor(author = msg.author)

            Spacer(modifier = Modifier.height(4.dp))

            TextMessage(
                surfaceColor,
                msg.body,
                isExpanded,
            )
        }
    }
}

@Composable
fun MessageImage(resId: Int) {
    Image(
        painter = painterResource(
            id = resId,
        ),
        contentDescription = "Profile picture",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(
                color = MaterialTheme.colors.secondaryVariant,
                CircleShape
            )
            .border(
                width = 1.5.dp,
                MaterialTheme.colors.secondary,
                CircleShape
            )
    )
}

@Composable
fun TextAuthor(author: String) {
    Text(
        text = author,
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2,
    )
}

@Composable
fun TextMessage(
    surfaceColor: Color,
    body: String,
    isExpanded: Boolean
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 1.dp,
        color = surfaceColor,
        modifier = Modifier
            .animateContentSize()
            .padding(1.dp)
    ) {
        Text(
            text = body,
            modifier = Modifier.padding(4.dp),
            style = MaterialTheme.typography.body2,
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
        )
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
)
@Composable
fun PreviewMessageCard() {
    val msg = Message("Demo", "Message")
    ComposeSandboxTheme {
        MessageCard(msg)
    }
}