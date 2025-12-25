package com.example.questapi_063.uicontroller.route

import com.example.questapi_063.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}