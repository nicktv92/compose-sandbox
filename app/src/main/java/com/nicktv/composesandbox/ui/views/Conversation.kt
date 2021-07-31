package com.nicktv.composesandbox.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nicktv.composesandbox.data.Message
import com.nicktv.composesandbox.data.SampleData
import com.nicktv.composesandbox.ui.theme.ComposeSandboxTheme


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { MessageCard(msg = it) }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeSandboxTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}
