package com.compose.flyticketsbooking.data.entity

sealed class CardPages {
    object Visa : CardPages()
    object Mastercard : CardPages()

}


