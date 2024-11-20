package com.edu.unab.diegocastro.ggaplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.unab.diegocastro.ggaplication.ActividadScreen
import com.edu.unab.diegocastro.ggaplication.Actividades
import com.edu.unab.diegocastro.ggaplication.BuscarScreen
import com.edu.unab.diegocastro.ggaplication.CuentaScreen
import com.edu.unab.diegocastro.ggaplication.HomeScreen
import com.edu.unab.diegocastro.ggaplication.InscritasScreen
import com.edu.unab.diegocastro.ggaplication.LoginScreen
import com.edu.unab.diegocastro.ggaplication.MoreScreen
import com.edu.unab.diegocastro.ggaplication.RegisterScreen

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") { LoginScreen(navController) }
                composable("register") { RegisterScreen(navController) }
                composable("home") { HomeScreen(navController) }
                composable("mas") { MoreScreen(navController) }
                composable("inscritas") { InscritasScreen(navController) }
                composable("cuenta") { CuentaScreen(navController) }
                composable("buscar") { BuscarScreen(navController) }
                composable("actividad/{actividadNombre}") { backStackEntry ->
                    val actividadNombre = backStackEntry.arguments?.getString("actividadNombre") ?: ""
                    ActividadScreen(navController = navController, actividadNombre = actividadNombre)
                }

                composable("actividades/{eventTitle}") { backStackEntry ->
                    val eventTitle = backStackEntry.arguments?.getString("eventTitle") ?: ""
                    Actividades(navController, eventTitle)
                }
                composable("crear_actividad/{eventTitle}") { backStackEntry ->
                    val eventTitle = backStackEntry.arguments?.getString("eventTitle") ?: ""
                    CrearActividadScreen(navController, eventTitle)
                }
            }
        }
    }
}