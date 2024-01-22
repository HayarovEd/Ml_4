package org.zaim.na.kartu.polusa.domain

import org.zaim.na.kartu.polusa.data.Resource
import org.zaim.na.kartu.polusa.domain.model.BaseDb

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDb>
}