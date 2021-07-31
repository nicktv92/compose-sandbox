package com.nicktv.composesandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nicktv.composesandbox.data.SampleData
import com.nicktv.composesandbox.ui.theme.ComposeSandboxTheme
import com.nicktv.composesandbox.ui.views.Conversation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSandboxTheme {
                Conversation(
                    messages = SampleData.conversationSample,
                )
            }
        }
    }
}
