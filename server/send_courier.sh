#!/bin/bash

# Courier API Send Script
# Usage: ./send_courier.sh [courier_token] [fcm_token]
# Or set COURIER_TOKEN and FCM_TOKEN environment variables

COURIER_TOKEN=${1:-${COURIER_TOKEN:-"YOUR_AUTH_KEY"}}
FCM_TOKEN=${2:-${FCM_TOKEN:-"YOUR_FCM_TOKEN"}}

curl --request POST \
  --url https://api.courier.com/send \
  --header "Authorization: Bearer ${COURIER_TOKEN}" \
  --header 'Content-Type: application/json' \
  --data "{
  \"message\": {
    \"to\": {
      \"firebaseToken\": \"${FCM_TOKEN}\"
    },
    \"content\": {
      \"title\": \"Hey there 👋\",
      \"body\": \"Have a great day 😁\"
    },
    \"routing\": {
      \"method\": \"all\",
      \"channels\": [
        \"firebase-fcm\"
      ]
    },
    \"providers\": {
      \"firebase-fcm\": {
        \"override\": {
          \"body\": {
            \"data\": {
              \"YOUR_CUSTOM_KEY\": \"YOUR_CUSTOM_VALUE\"
            },
            \"apns\": {
              \"payload\": {
                \"aps\": {
                  \"sound\": \"ping.aiff\",
                  \"badge\": 99
                }
              }
            }
          }
        }
      }
    }
  }
}"

