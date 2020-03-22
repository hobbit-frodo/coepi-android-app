# coepi-android-app

Very simple client android applicatio for this client-server flow is as follows:`
1. Contact id and information is generate (Button "new contact")
2. Users record symptoms in their CoEpi app, (Button "New Symptom"), resulting in a POST to `/exposureandsymptoms` endpoint with their `Symptoms` and UUIDs/Dates of `Contacts`
3. Client poll for symptoms of contacted with POST to `/exposurecheck` to see if the server has received any symptoms of the above matching those that the device has seen.


## Endpoints

Test Endpoint: https://coepi.wolk.com:8081
