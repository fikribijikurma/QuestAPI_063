package com.example.questapi_063.apiservice

import com.example.questapi_063.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTeman.php")
    suspend fun insertSiswa(
        @Body dataSiswa: DataSiswa
    ):retrofit2.Response<Void>
}

