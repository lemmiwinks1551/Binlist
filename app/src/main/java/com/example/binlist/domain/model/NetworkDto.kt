package com.example.binlist.domain.model

/**
 * https://binlist.net/
 *
 * {
 *   "number": {
 *     "length": 16,
 *     "luhn": true
 *   },
 *   "scheme": "visa",
 *   "type": "debit",
 *   "brand": "Visa/Dankort",
 *   "prepaid": false,
 *   "country": {
 *     "numeric": "208",
 *     "alpha2": "DK",
 *     "name": "Denmark",
 *     "emoji": "🇩🇰",
 *     "currency": "DKK",
 *     "latitude": 56,
 *     "longitude": 10
 *   },
 *   "bank": {
 *     "name": "Jyske Bank",
 *     "url": "www.jyskebank.dk",
 *     "phone": "+4589893300",
 *     "city": "Hjørring"
 *   }
 * }
 */

data class BinInfoDto(
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: CountryDto?,
    val bank: BankDto?
)

data class CountryDto(
    val name: String?,
    val latitude: Double?,
    val longitude: Double?
)

data class BankDto(
    val name: String?,
    val phone: String?,
    val url: String?,
    val city: String?
)
