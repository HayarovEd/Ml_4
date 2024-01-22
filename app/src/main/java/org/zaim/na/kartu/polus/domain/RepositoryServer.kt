package org.zaim.na.kartu.polus.domain

import org.zaim.na.kartu.polus.data.Resource
import org.zaim.na.kartu.polus.domain.model.BaseDb

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDb>
}