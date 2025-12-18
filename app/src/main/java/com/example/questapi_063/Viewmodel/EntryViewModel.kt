package com.example.questapi_063.Viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.questapi_063.modeldata.DetailSiswa
import com.example.questapi_063.modeldata.UIStateSiswa
import com.example.questapi_063.repositori.RepositoryDataSiswa
import okhttp3.Response

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    // Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    // Fungsi untuk menyimpan data siswa
    suspend fun addSiswa() {
        if (validasiInput()){
            val sip: Response<Void> = repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toSiswa())
            if (sip.isSuccessful){
                println("Sukses bro : ${sip.message()}")
            }else{
                println("Gagal bro : ${sip.errorBody()}")
            }
        }
    }
}