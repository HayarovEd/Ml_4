package org.zaim.na.kartu.polus.data

import android.util.Log
import org.zaim.na.kartu.polus.data.basedto.mapToBaseDb
import org.zaim.na.kartu.polus.domain.RepositoryServer
import org.zaim.na.kartu.polus.domain.model.BaseDb
import javax.inject.Inject

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseDb> {
        return try {
            val folder = apiServer.getDataDb()
            //Log.d("DATADB", "dATA DB:${folder.loans.first().id}")
            Resource.Success(
                data = folder.mapToBaseDb()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error")
        }
    }
}