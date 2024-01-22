package org.zaim.na.kartu.polus.data.basedto

import org.zaim.na.kartu.polus.domain.model.AppConfig
import org.zaim.na.kartu.polus.domain.model.BaseDb
import org.zaim.na.kartu.polus.domain.model.Credit


fun BaseDto.mapToBaseDb(): BaseDb {
    val allProducts = mutableListOf<Credit>()
    val credits = this.creditDtos?.mapCreditDtoToCredits() ?: emptyList()
    allProducts.addAll(credits)
    this.cardDtos?.forEach { dto ->
        allProducts.addAll(dto.cardsCreditDto?.mapCardsCreditDtoToCredits() ?: emptyList())
        allProducts.addAll(dto.cardsDebitDto?.mapCardsDebitDtoToCredits() ?: emptyList())
        allProducts.addAll(
            dto.cardsInstallmentDto?.mapCardsInstallmentDtoToCredits() ?: emptyList()
        )
    }
    return BaseDb(
        appConfig = AppConfig(
            privacyPolicyHtml = appConfigDto.privacyPolicyHtml,
            showCalculatorItem = appConfigDto.showCalculatorItem,
            showChat = appConfigDto.showChat,
            showNewsItem = appConfigDto.showNewsItem,
            showPhoneAuthentication = appConfigDto.showPhoneAuthentication,
            userTermHtml = appConfigDto.userTermHtml
        ),
        credits = allProducts
    )
}

private fun List<CreditDto>.mapCreditDtoToCredits(): List<Credit> {
    return this.map { dto ->
        Credit(
            description = dto.description,
            hidePercentFields = dto.hidePercentFields,
            hideTermFields = dto.hideTermFields,
            id = dto.id,
            isActive = dto.isActive,
            itemId = dto.itemId,
            name = dto.name,
            order = dto.order,
            orderButtonText = dto.orderButtonText,
            percent = dto.percent,
            percentPostfix = dto.percentPostfix,
            percentPrefix = dto.percentPrefix,
            position = dto.position,
            score = dto.score,
            screen = dto.screen,
            showCash = dto.showCash,
            showMastercard = dto.showMastercard,
            showMir = dto.showMir,
            showQiwi = dto.showQiwi,
            showVisa = dto.showVisa,
            showYandex = dto.showYandex,
            summMax = dto.summMax,
            summMid = dto.summMid,
            summMin = dto.summMin,
            summPostfix = dto.summPostfix,
            summPrefix = dto.summPrefix,
            termMax = dto.termMax,
            termMid = dto.termMid,
            termMin = dto.termMin,
            termPostfix = dto.termPostfix,
            termPrefix = dto.termPrefix
        )
    }
}

private fun List<CardsCreditDto>.mapCardsCreditDtoToCredits(): List<Credit> {
    return this.map { dto ->
        Credit(
            description = dto.description,
            hidePercentFields = dto.hidePercentFields,
            hideTermFields = dto.hideTermFields,
            id = dto.id,
            isActive = dto.isActive,
            itemId = dto.itemId,
            name = dto.name,
            order = dto.order,
            orderButtonText = dto.orderButtonText,
            percent = dto.percent,
            percentPostfix = dto.percentPostfix,
            percentPrefix = dto.percentPrefix,
            position = dto.position,
            score = dto.score,
            screen = dto.screen,
            showCash = dto.showCash,
            showMastercard = dto.showMastercard,
            showMir = dto.showMir,
            showQiwi = dto.showQiwi,
            showVisa = dto.showVisa,
            showYandex = dto.showYandex,
            summMax = dto.summMax,
            summMid = dto.summMid,
            summMin = dto.summMin,
            summPostfix = dto.summPostfix,
            summPrefix = dto.summPrefix,
            termMax = dto.termMax,
            termMid = dto.termMid,
            termMin = dto.termMin,
            termPostfix = dto.termPostfix,
            termPrefix = dto.termPrefix
        )
    }
}

private fun List<CardsDebitDto>.mapCardsDebitDtoToCredits(): List<Credit> {
    return this.map { dto ->
        Credit(
            description = dto.description,
            hidePercentFields = dto.hidePercentFields,
            hideTermFields = dto.hideTermFields,
            id = dto.id,
            isActive = dto.isActive,
            itemId = dto.itemId,
            name = dto.name,
            order = dto.order,
            orderButtonText = dto.orderButtonText,
            percent = dto.percent,
            percentPostfix = dto.percentPostfix,
            percentPrefix = dto.percentPrefix,
            position = dto.position,
            score = dto.score,
            screen = dto.screen,
            showCash = dto.showCash,
            showMastercard = dto.showMastercard,
            showMir = dto.showMir,
            showQiwi = dto.showQiwi,
            showVisa = dto.showVisa,
            showYandex = dto.showYandex,
            summMax = dto.summMax,
            summMid = dto.summMid,
            summMin = dto.summMin,
            summPostfix = dto.summPostfix,
            summPrefix = dto.summPrefix,
            termMax = dto.termMax,
            termMid = dto.termMid,
            termMin = dto.termMin,
            termPostfix = dto.termPostfix,
            termPrefix = dto.termPrefix
        )
    }
}

private fun List<CardsInstallmentDto>.mapCardsInstallmentDtoToCredits(): List<Credit> {
    return this.map { dto ->
        Credit(
            description = dto.description,
            hidePercentFields = dto.hidePercentFields,
            hideTermFields = dto.hideTermFields,
            id = dto.id,
            isActive = dto.isActive,
            itemId = dto.itemId,
            name = dto.name,
            order = dto.order,
            orderButtonText = dto.orderButtonText,
            percent = dto.percent,
            percentPostfix = dto.percentPostfix,
            percentPrefix = dto.percentPrefix,
            position = dto.position,
            score = dto.score,
            screen = dto.screen,
            showCash = dto.showCash,
            showMastercard = dto.showMastercard,
            showMir = dto.showMir,
            showQiwi = dto.showQiwi,
            showVisa = dto.showVisa,
            showYandex = dto.showYandex,
            summMax = dto.summMax,
            summMid = dto.summMid,
            summMin = dto.summMin,
            summPostfix = dto.summPostfix,
            summPrefix = dto.summPrefix,
            termMax = dto.termMax,
            termMid = dto.termMid,
            termMin = dto.termMin,
            termPostfix = dto.termPostfix,
            termPrefix = dto.termPrefix
        )
    }
}