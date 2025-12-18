package com.example.questapi_063.repositori

import com.example.questapi_063.apiservice.ServiceApiSiswa
import com.example.questapi_063.modeldata.DataSiswa

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun PostDataSiswa(dataSiswa: DataSiswa) : retrofit2.Response<Void>
}

class RepositoryDataSiswaImpl(private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa {
    override suspend fun getDataSiswa(): List<DataSiswa> = serviceApiSiswa
        .getSiswa()
    override suspend fun PostDataSiswa(dataSiswa: DataSiswa): retrofit2.Response<Void> =
        serviceApiSiswa.insertSiswa(dataSiswa)

}




