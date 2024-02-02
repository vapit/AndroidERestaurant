package fr.isen.wronski.androiderestaurant


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.wronski.androiderestaurant.model.DataResult
import org.json.JSONObject


class Menus : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        fetchData()
        super.onCreate(savedInstanceState)
        val menuType = intent.getIntExtra("menuType", 0)
        setContent {
            Text(text = "test")
            if (menuType == 0) {
                Text(text = "error")
            } else {
                Display(menuType)
            }
        }
    }

    private fun fetchData() {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject=JSONObject()
        jsonObject.put("id_shop","1")
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            jsonObject,
            {
                Log.d("CategoryActivity","les données en brut:$it")
                val gson=Gson()
                val result= gson.fromJson(it.toString(),DataResult::class.java)

            },
            {
                Log.d("CategoryActivity","erreur")
            }
          )
       val requestQueue= Volley.newRequestQueue(this)
        requestQueue.add(jsonObjectRequest)
    }

    fun doNothing() {
        // This function does nothing
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Display(sw: Int) {
    Column {
        TopAppBar(
            title = { Text(text = "Toothless restaurant") }
        )
        IciCestLesMenus(sw)
        DisplayDesChoix(sw)
    }
}


@Composable
fun IciCestLesMenus(sw: Int) {
    Row(Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(R.drawable.chef),
            contentDescription = "loli",
        )
        when (sw) {
            1 -> Text(
                text = "ici c'est les entrees",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically), textAlign = TextAlign.Center
            )

            2 -> Text(
                text = "ici c'est les plats",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically), textAlign = TextAlign.Center
            )

            3 -> Text(
                text = "ici c'est les desserts",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically), textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
fun DisplayDesChoix(sw: Int) {

    when (sw) {
        1 -> LazyColumn {
            item(1) {
                Text(text = "Entrée")
            }
            item {
                Text(text = "Une autre entrée")
            }
        }

        2 -> LazyColumn {
            item(1) {
                Text(text = "Plat")
            }
            item {
                Text(text = "Un autre plat")
            }
        }

        3 -> LazyColumn {
            item(1) {
                Text(text = "Dessert")
            }
            item {
                Text(text = "Un autre dessert")
            }
        }
    }
}