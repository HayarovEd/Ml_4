package org.zaim.na.kartu.polusa.data

import org.zaim.na.kartu.polusa.data.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("521/db.json")
    suspend fun getDataDb () : BaseDto
}