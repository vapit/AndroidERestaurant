package fr.isen.wronski.androiderestaurant
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import kotlin.reflect.KFunction1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirstPage(::onMenuClick)
                }
            }
        }
    }


    fun onMenuClick(sw: Int){
        when(sw){
    1->onEntreeClick()
    2->onPlatClick()
    3->onDessertClick()
        }
    }

    fun onEntreeClick(){
        val text = "Entrée!"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(this, text,duration).show()
        val intent= Intent(this@MainActivity,Menus::class.java)
        intent.putExtra("menuType",1)
        startActivity(intent)
    }
    fun onPlatClick(){
        val text = "Plat!"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(this, text,duration).show()
       val intent= Intent(this@MainActivity,Menus::class.java)
        intent.putExtra("menuType",2)
        startActivity(intent)
    }
    fun onDessertClick(){
        val text = "Dessert!"
        val duration = Toast.LENGTH_SHORT
        Toast.makeText(this, text,duration).show()
        val intent= Intent(this@MainActivity,Menus::class.java)
        intent.putExtra("menuType",3)
        startActivity(intent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDeFullBg() {
    TopAppBar(
        title = { Text(text = "Toothless restaurant") }
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
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun ListeBouton(onMenuClick: KFunction1<Int, Unit>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                onMenuClick(1)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Entrée")//ajout d'un modifier possible pour remplacer le bouton "Modifier.Clickable{}"
        }

        Button(
            onClick = {
                onMenuClick(2)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Plat")
        }

        Button(
            onClick = {
                onMenuClick(3)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Dessert")
        }
    }
}
@Composable
fun FirstPage(onMenuClick: KFunction1<Int, Unit>) {

    Column {

        TopBarDeFullBg() //mettre dans un scafold

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            IciCaCuisine()
        }//possibilité de rajouter un margin pour enlever le Spacer

        Spacer(Modifier.padding(0.dp, 20.dp))

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            ListeBouton(onMenuClick)
        }
    }

}
