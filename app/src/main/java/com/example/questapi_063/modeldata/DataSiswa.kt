package com.example.questapi_063.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class DataSiswa(
    val id : Int,
    val nama : String,
    val alamat : String,
    val telpon : String
)

data class UIStateSiswa(
    val detailSiswa: DataSiswa = DataSiswa(),
    val isEntryValid: Boolean = false
)
