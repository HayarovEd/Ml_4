package org.zaim.na.kartu.polusa.domain.model

sealed interface TypeCard{
    object CardCredit: TypeCard
    object CardDebit: TypeCard
    object CardInstallment: TypeCard
}