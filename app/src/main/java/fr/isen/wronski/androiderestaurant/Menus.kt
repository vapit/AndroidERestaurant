package fr.isen.wronski.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import fr.isen.wronski.androiderestaurant.ui.theme.AndroidERestaurantTheme

class Menus : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val menuType=intent.getIntExtra("menuType",0)
        setContent {
            Text(text = "test")
            if(menuType==0){
                Text(text = "error")
            }else{
               Display(menuType)
            }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Display(sw:Int){
    Column {
        TopAppBar(
            title = { Text(text = "Toothless restaurant") }
        )
        IciCestLesMenus(sw)
        DisplayDesChoix(sw)
    }
}


@Composable
fun IciCestLesMenus(sw:Int) {
    Row(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.chef),
            contentDescription = "loli",
        )
        when (sw){
        1->Text(text = "ici c'est les entrees",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
            ,textAlign = TextAlign.Center)
        2->Text(text = "ici c'est les plats",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
            ,textAlign = TextAlign.Center)

        3->Text(text = "ici c'est les desserts",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
            ,textAlign = TextAlign.Center)
        }
    }

}

@Composable
fun DisplayDesChoix(sw:Int){

    when(sw) {
        1->LazyColumn {
            item(1){
                Text(text ="entrée")
            }
            item {
                Text(text ="une autre entrée")
            }
        }
        2->Column {

            Text(text ="plat")
            Text(text ="un autre plat")

        }
            3->Column {

                Text(text ="dessert")
                Text(text ="un autre dessert")

            }
    }
}