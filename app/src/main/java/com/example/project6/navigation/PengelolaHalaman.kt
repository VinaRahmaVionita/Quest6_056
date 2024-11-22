package com.example.project6.navigation

import android.service.controls.Control
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project6.model.Mahasiswa
import com.example.project6.ui.screen.MahasiswaFormView
import com.example.project6.ui.screen.RencanaStudyView
import com.example.project6.ui.screen.SplashView
import com.example.project6.ui.screen.TampilView
import com.example.project6.ui.viewmodel.MahasiswaViewModel
import com.example.project6.ui.viewmodel.RencanaStudyViewModel
import com.example.project6.ui.widget.DynamicSelectTextField

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsStateUi = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name){
            SplashView(
                onMulaiButton = {
                    navController.navigate(
                        Halaman.Mahasiswa.name
                    )
                }
            )
        }

        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Halaman.Matakuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                    krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name) },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }


    }
}