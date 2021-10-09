package com.wizeline.bootcamp.challenge.data.errors

object ErrorCodes {
    //Creating object to separate HTTP error from business logic error codes to simplify the debugging process

    const val OK_BUT_INFO_NOT_AVAILABLE = -10
    const val EXCEPTION_ON_REQUEST = -11
}