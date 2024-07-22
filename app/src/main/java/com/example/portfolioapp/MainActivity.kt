package com.example.portfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.ui.theme.PortfolioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioAppTheme {
                Portfolio()
            }
        }
    }
}

//@Preview
@Composable
fun Portfolio() {
    Surface(
        tonalElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                colorFilter = ColorFilter.tint(Color.Blue),
                contentDescription = "Icon",
                modifier = Modifier.size(80.dp)
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(4.dp)
            )
            Text(
                text = "Shambu Chandran", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Android Compose Developer", fontWeight = FontWeight.SemiBold)
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Image(
                    imageVector = Icons.Filled.Face,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "Linkedin link", modifier = Modifier.padding(start = 8.dp))
            }
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Image(
                    imageVector = Icons.Filled.Face,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "GitHub link", modifier = Modifier.padding(start = 8.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White)
            ) {
                Text(text = "projects")

            }
            LazyColumn {
                items(getProjectList()) {
                    ProjectItem(it)
                }
            }
        }


    }

}

@Composable
fun ProjectItem(projects: Projects) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            imageVector = Icons.Filled.AccountCircle,
            colorFilter = ColorFilter.tint(Color.Blue),
            contentDescription = "Icon",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column(Modifier.padding(8.dp)) {
            Text(text = projects.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = projects.desc)
        }
    }
}


data class Projects(val name: String, val desc: String)

fun getProjectList(): List<Projects> {
    return listOf(
        Projects("Notes app", "Keep notes"),
        Projects("QuotesApp", "Read quotes"),
        Projects("Audio Recorder", "Record audios"),
        Projects("Notes app", "Keep notes"),
        Projects("QuotesApp", "Read quotes"),
        Projects("Audio Recorder", "Record audios"),
        Projects("Notes app", "Keep notes"),
        Projects("QuotesApp", "Read quotes"),
        Projects("Audio Recorder", "Record audios"),
        Projects("Notes app", "Keep notes"),
        Projects("QuotesApp", "Read quotes"),
        Projects("Audio Recorder", "Record audios"),
        Projects("Notes app", "Keep notes"),
        Projects("QuotesApp", "Read quotes"),
        Projects("Audio Recorder", "Record audios")
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioAppTheme {

    }
}