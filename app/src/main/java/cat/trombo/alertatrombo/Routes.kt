package cat.trombo.alertatrombo

sealed class Routes(val route: String) {
      object Login : Routes("Login")
      object MainScreen : Routes("MainScreen")
}