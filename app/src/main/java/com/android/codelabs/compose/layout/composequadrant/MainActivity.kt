package com.android.codelabs.compose.layout.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.codelabs.compose.layout.composequadrant.ui.theme.ColumnContainerColor
import com.android.codelabs.compose.layout.composequadrant.ui.theme.ComposeQuadrantTheme
import com.android.codelabs.compose.layout.composequadrant.ui.theme.ImageContainerColor
import com.android.codelabs.compose.layout.composequadrant.ui.theme.RowContainerColor
import com.android.codelabs.compose.layout.composequadrant.ui.theme.TextContainerColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUi()
                }
            }
        }
    }
}

@Composable
fun MainUi(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            ItemQuadrant(
                modifier = Modifier.fillMaxHeight().weight(1f),
                title = stringResource(id = R.string.text_title),
                content = stringResource(id = R.string.text_content),
                color = TextContainerColor
            )
            ItemQuadrant(
                modifier = Modifier.fillMaxHeight().weight(1f),
                title = stringResource(id = R.string.image_title),
                content = stringResource(id = R.string.image_content),
                color = ImageContainerColor
            )
        }
        Row(
            modifier = Modifier.weight(0.5f)
        ) {
            ItemQuadrant(
                modifier = Modifier.fillMaxHeight().weight(1f),
                title = stringResource(id = R.string.row_title),
                content = stringResource(id = R.string.row_content),
                color = RowContainerColor
            )
            ItemQuadrant(
                modifier = Modifier.fillMaxHeight().weight(1f),
                title = stringResource(id = R.string.column_title),
                content = stringResource(id = R.string.column_content),
                color = ColumnContainerColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        MainUi()
    }
}

@Composable
private fun ItemQuadrant(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    color: Color
) {
    Column(
        modifier = modifier
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}