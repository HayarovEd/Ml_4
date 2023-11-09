package org.zaim.na.kartu.polus.domain.model.basedto

import org.zaim.na.kartu.polus.domain.model.TypeCard

sealed class BaseState{
    object Loans: BaseState()
    class Cards(val typeCard: TypeCard): BaseState()
    object Credits: BaseState()
}
