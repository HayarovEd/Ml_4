package org.zaim.na.kartu.polus.domain

import org.zaim.na.kartu.polus.data.Resource
import org.zaim.na.kartu.polus.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}