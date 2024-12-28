# Google_Oauth2_LongLivedCredential
Repo to alow you to download this application, run the command and get the long term required access credential

# How To Use

1. Clone this repo to your local Workspace

2. Set up google cloud OAuth Consent Form and OAuth credentials on google cloud

3. Download the OAuth Credentials Json file to see required details

4. In application.yml, add in the required environment variables to properties

5. Check GenerateLongTermAccessTokenGoogleOauth2.java line 35, Ensure that the token we get will have access to the required data.

6. Check GenerateLongTermAccessTokenGoogleOauth2.java line 39, Change the port to the same port you specified while creating Google Credentials Authorized Redirect URI.

6. Run the build: After all of that is set up cd to base directory and run the command `mvn clean package dependency:copy-dependencies -DincludeScope=runtime`

7. Create Docker Container: After the build we need to containerize locally, run `docker build -t container1 .`

8. Get the ID of the docker image you just created `docker images`

9. Run the container locally `docker run -p 9000:8080 -p <Your Port Specified in Google Cloud>:<Your Port Specified in Google Cloud> <Image ID>`

10. In a seporate terminal, Execute the command to trigger the lambda Locally `curl "http://localhost:9000/2015-03-31/functions/function/invocations" -d '{}'`

11. Follow the instructions in the terminal. It will give you a URL to follow copy and paste into your browser

12. Sign in with the Same Google account you used to configure yor google OAuth credentials

13. After filling everything out, your New Token LongTermToken should be avaliable in the terminal

