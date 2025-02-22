package com.main.taskadoo_app


import android.os.Bundle
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import com.main.taskadoo_app.ui.theme.Taskadoo_appTheme

var FontSize: TextUnit = 0.sp
var FontSizeMuliplier: Float = 0.4F
var DispText: String = "Default"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (FontSize <= 0.sp) {
            DispText = "TextSize \n\nzainicjuj \n\nbalwanie"
            FontSize = 90.sp
        }
        enableEdgeToEdge()
        setContent {
            Taskadoo_appTheme {
                Column {
                    GreetingText(
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    GreetingText()
}

@Composable
fun Greeting(name: String = DispText, modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = FontSize)) {
                withStyle(style = SpanStyle(color = Color.Red, fontSize = FontSize)) {
                    append("$name.")
                }
            }
        }
    )
}

@Composable
fun GreetingText(name: String = DispText) {
    var FontColor: Color = Color.Cyan
    Column {
        Greeting("Radek")
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = FontSize*FontSizeMuliplier)) {
                    withStyle(
                        style = SpanStyle(
                            fontSize = FontSize/FontSizeMuliplier*FontSizeMuliplier,
                            fontWeight = FontWeight.ExtraBold,
                            color = FontColor
                        )
                    ) {
                        if (FontWeight.equals(FontWeight.ExtraBold)) {
                            FontColor = Color.Red
                        }
                        append("$name!")
                    }
                }
            }
        )
    }
}


