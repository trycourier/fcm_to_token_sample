package com.example.fcm_to_token
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyNotificationService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        // Send token to server
        ManualTokenSyncService.sync(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        // This is the messages received on the device
        print(message)

        // FCM makes this tricky, but here is a run down of what to expect:
        // 1. By default, FCM messages send "notifications"
        // If the app is in the foreground, they will be consumed here in this function
        // If the app is in the background or killed state, this function will be ignored and the Android OS will take over and present the notification

        // 2. If you send FCM messages with the "data" block
        // This function will be called no matter what.
        // Courier does this automatically for you if you use "Apply Recommended Courier Mobile SDK Formatting" in your provider configuration

        // Also worth noting that the Courier SDK automatically handles click and delivery tracking metrics here as well.
        // If you do not use the SDK, you have to do this manually.

    }

}