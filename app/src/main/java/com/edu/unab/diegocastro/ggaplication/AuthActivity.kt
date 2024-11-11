import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.unab.diegocastro.ggaplication.HomeScreen
import com.edu.unab.diegocastro.ggaplication.LoginScreen
import com.edu.unab.diegocastro.ggaplication.RegisterScreen

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                //composable("login") { LoginScreen(navController) }
                //composable("register") { RegisterScreen(navController) }
                //composable("home") { HomeScreen(navController) }
            }
        }
    }
}
