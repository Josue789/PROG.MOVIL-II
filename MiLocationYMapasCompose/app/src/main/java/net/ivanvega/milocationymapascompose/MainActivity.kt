package net.ivanvega.milocationymapascompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.platform.location.locationupdates.LocationUpdatesScreen
import com.example.platform.location.permission.LocationPermissionScreen
import com.google.maps.android.compose.StreetViewActivity
import net.ivanvega.milocationymapascompose.ui.location.CurrentLocationScreen
import net.ivanvega.milocationymapascompose.ui.maps.CamaraControl
import net.ivanvega.milocationymapascompose.ui.maps.DrawingMap
import net.ivanvega.milocationymapascompose.ui.maps.ExperimentalMapScreen
import net.ivanvega.milocationymapascompose.ui.maps.MapCraft
import net.ivanvega.milocationymapascompose.ui.maps.MiMapa
import net.ivanvega.milocationymapascompose.ui.maps.RecomposingScreen
import net.ivanvega.milocationymapascompose.ui.maps.RecomposingWithCustomingInfoScreen
import net.ivanvega.milocationymapascompose.ui.theme.MiLocationYMapasComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiLocationYMapasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //LocationPermissionScreen()
                    //CurrentLocationScreen()
                    //LocationUpdatesScreen()
                    //MiMapa()
                    //MapCraft()
                    //CamaraControl()
                    //DrawingMap()
                    RecomposingScreen()
                    //RecomposingWithCustomingInfoScreen()
                    //StreetViewActivity()
                    //ExperimentalMapScreen()
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiLocationYMapasComposeTheme {
        Greeting("Android")
    }
}