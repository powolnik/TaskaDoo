package com.main.taskadoo_app


import android.os.Bundle
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.main.taskadoo_app.ui.theme.ComposeTestTheme


//region MainActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                FCollumnsPreview()
            }
        }
    }
}
//endregion

/*region Composable*/
@Composable
fun FColumns(){
    var color = MaterialTheme.colorScheme
    ComposeTestTheme {
        Column ( modifier = Modifier
            .fillMaxSize()
            .height(500.dp)
            .height(500.dp)
            .background(color.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
            FSurface(Color.Magenta)
            FSurface(Color.Blue)
        }
    }
}

@Composable
fun ColumnScope.FSurface(color: Color, weight: Float = 1f){
    Surface(modifier = Modifier
        .width(200.dp)
        .weight(weight)
        .wrapContentHeight(Alignment.CenterVertically),
        color = color){
        FText()
    }
}

@Composable
fun FText(color: Color = MaterialTheme.colorScheme.error,inputText: String = "Default") {
    Text( buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.Center, )){
            withStyle(style = SpanStyle(
                color = color,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)) {
                append("$inputText")
            }
        }
    })
}

@Composable
fun FBox(align: Alignment){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = align
    ){
        Box(
            modifier = Modifier
                .background(Color.Blue)
        ){
            FText(Color.Cyan,"TextFrom FBOX")
        }
    }
}

//endregion

//region Composable Preview
    @Preview(showBackground = true)
    @Composable
    fun FCollumnsPreview(){
        ComposeTestTheme {
            FColumns()
        }
    }
//endregion


