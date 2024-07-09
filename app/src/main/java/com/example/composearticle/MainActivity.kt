package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface {
                    GreetingImage(
                        title = stringResource(R.string.jetpack_compose_tutorial),
                        firstParagraph = stringResource(R.string.what_is_compose_text),
                        secondParagraph = stringResource(R.string.what_is_this_tutorial_text),
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )

    Text(
        text = firstParagraph,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp, 0.dp)
    )

    Text(
        text = secondParagraph,
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun GreetingImage(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.composearticle_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier.fillMaxWidth()
        )

        GreetingText(
            title = title,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        GreetingImage(
            title = stringResource(R.string.jetpack_compose_tutorial),
            firstParagraph = stringResource(R.string.what_is_compose_text),
            secondParagraph = stringResource(R.string.jetpack_compose_tutorial),
        )
    }
}