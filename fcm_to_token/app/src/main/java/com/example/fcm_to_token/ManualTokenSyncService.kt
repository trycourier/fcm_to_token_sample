package com.example.fcm_to_token

class ManualTokenSyncService {

    companion object {
        fun sync(fcmToken: String) {

            // This is where you will manually sync your FCM token
            // Doing this will require you to:
            // 1. Send this to your server
            // 2. Link it with a user in your system
            // 3. Handle when tokens expire
            print(fcmToken)

            // Courier does all of this automatically for you
            // if you use the Courier Android SDK
            // https://github.com/trycourier/courier-android

        }
    }

}