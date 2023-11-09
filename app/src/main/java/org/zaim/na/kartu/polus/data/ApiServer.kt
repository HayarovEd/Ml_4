package org.zaim.na.kartu.polus.data

import org.zaim.na.kartu.polus.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("521/db.json")
    suspend fun getDataDb () : BaseDto
}