package com.example.travelmarket.core.utils

object Constants {
    const val BASE_URL = "http://192.168.1.60:8000/api/" //192.168.1.60 //10.0.2.2
    const val TIMEOUT_SECONDS = 30L

    const val DEFAULT_PAGE_SIZE = 20

    const val PREF_NAME = "travel_market_prefs"
    const val KEY_AUTH_TOKEN = "auth_token"
    const val KEY_USER_ID = "user_id"

    const val HEADER_AUTHORIZATION = "Authorization"
    const val HEADER_CONTENT_TYPE = "Content-Type"
    const val CONTENT_TYPE_JSON = "application/json"

    const val TOKEN_PREFIX = "Bearer "
}