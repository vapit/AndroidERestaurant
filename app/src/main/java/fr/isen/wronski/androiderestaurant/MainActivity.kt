package fr.isen.wronski.androiderestaurant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.isen.wronski.androiderestaurant.ui.theme.AndroidERestaurantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val padding = 16
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TopBarDeFullBg()

                        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                            IciCaCuisine()
                        }

                        Spacer(Modifier.padding(0.dp, 20.dp))
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            ListeBouton()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDeFullBg() {

    TopAppBar(
        title = { Text(text = "Toothless restaurant")}
    )

}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
    )
}

@Composable
fun IciCaCuisine() {
    Row(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.chef),
            contentDescription = "loli",
        )

        Text(
            text = "ici ca cuisine", modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }


}


@Composable
fun ListeBouton() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                // Handle button click for
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Entrée")
        }
        Button(
            onClick = {
                // Handle button click for
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Plat")
        }
        Button(
            onClick = {
                // Handle button click for
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Dessert")
        }
    }
}
