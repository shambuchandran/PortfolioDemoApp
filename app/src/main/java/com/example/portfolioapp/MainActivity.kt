package com.example.portfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    val isOpen = remember {
        mutableStateOf(false)
    }
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
                onClick = {
                    isOpen.value = !isOpen.value
                },
                colors = ButtonDefaults.buttonColors(Color.Blue, contentColor = Color.White)
            ) {
                Text(text = "projects")

            }
            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(it)
                    }
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
fun DollerCounter() {
    val counter = remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${counter.value * 100}", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(180.dp))
        CustomButton {
            counter.value++
        }
    }
}

@Composable
fun CustomButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable {
                onClick.invoke()
            }
            .background(Color.Yellow),
        shape = CircleShape,
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }

}

@Composable
fun TipCalculator() {
    Column(modifier = Modifier.fillMaxSize()) {

    }

}

@Composable
fun TotalHeader(amount: Float) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        color = Color.Cyan,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total/person",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Rs: $amount",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }


    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserInputArea(
    amount: String,
    amountChanged: (String) -> Unit,
    personCounter: Int,
    onAddOrReducePerson: (Int) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp), shape = RoundedCornerShape(12.dp), shadowElevation = 12.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = amount,
                onValueChange = { amountChanged.invoke(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Enter your amount") },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Split", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.fillMaxWidth(.5f))
                CustomButton2(imageVector = Icons.Default.KeyboardArrowUp) {
                    onAddOrReducePerson.invoke(+1)
                }
                Text(
                    text = "$personCounter",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                CustomButton2(imageVector = Icons.Default.KeyboardArrowDown) {
                    onAddOrReducePerson.invoke(-1)
                }

            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                
                Text(text = "Tip", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.fillMaxWidth(.7f))
                Text(text = "120", style = MaterialTheme.typography.bodyMedium)


            }

        }

    }
}

@Composable
fun CustomButton2(imageVector: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp)
            .clickable { onClick.invoke() }, shape = CircleShape
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
        )

    }

}