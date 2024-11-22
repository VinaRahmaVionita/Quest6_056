package com.example.project6.ui.screen

import android.app.PictureInPictureUiState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project6.R
import com.example.project6.model.Mahasiswa
import com.example.project6.model.RencanaStudy
import com.example.project6.ui.viewmodel.MahasiswaViewModel
import com.example.project6.ui.viewmodel.RencanaStudyViewModel

@Composable
fun TampilView(
    mahasiswaUiState: Mahasiswa,
    krsStateUi: RencanaStudy,
    onBackButtonClicked: () -> Unit
){
    val listDataMhs = listOf(
        Pair("NIM", mahasiswaUiState.nim),
        Pair("Nama", mahasiswaUiState.nama),
        Pair("Email", mahasiswaUiState.email)
    )

    val listDataKrs = listOf(
        Pair("MataKuliah", krsStateUi.mataKuliah),
        Pair("Kelas", krsStateUi.kelas)
    )

    Box(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(
                    topEnd = 50.dp,
                    topStart = 15.dp
                )
            )
            .fillMaxSize()
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){

            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text =  "INFORMASI MAHASISWA",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth()
            )

            listDataMhs.forEach { items ->
                CardSection(
                    judulParam = items.first,
                    isiParam = items.second
                )
            }

            listDataKrs.forEach { items ->
                CardSection(
                    judulParam = items.first,
                    isiParam = items.second
                )
            }

            ElevatedButton(
                onClick = { onBackButtonClicked() }
            ) {
                Text("Kembali")
            }
        }
    }
}

@Composable
//Menampilkan isi data
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)){

        Row (modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam", modifier = Modifier.weight(2f))
        }
    }
}



