package com.example.cropify

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform