# Perl Custom Runtime for App Engine

Simple guide to running this app on [Google App Engine](https://cloud.google.com/appengine).


1. Create an `app.yaml` in the root of your application with the following contents:

    ```yaml
    runtime: custom
    env: flex
    ```

2. Create a [`Dockerfile`](Dockerfile) in the root of your application.

3. Create a project in the [Google Developers Console](https://console.developers.google.com/).

4. Make sure you have the [Google Cloud SDK](https://cloud.google.com/sdk/) installed.  When you're ready, initialize it:

    ```sh
    $ gcloud init
    ```

5. Deploy your app:

    ```sh
    gcloud app deploy
    ```

You are now running your app on Google App Engine. How cool is that?