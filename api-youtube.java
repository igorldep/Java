package com.google.api.services.samples.youtube.cmdline.data;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.util.ArrayMap;
import com.google.api.services.samples.youtube.cmdline.Auth;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ChannelLocalization;
import com.google.api.client.util.GenericData.Flags
import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * This code is an attempt to retrieves a channel subscribers counter in YouTube-API.
 *
 */
public class ChannelCounter {

    /**
     * YouTube Data API requests.
     */
    private static YouTube youtube;


    public static void main(String[] args) {

        List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube");

        try {
            // Authorize the request.
            Credential credential = Auth.authorize(scopes, "localizations");

            // This object is used to make YouTube Data API requests.
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential)
                    .setApplicationName("youtube-cmdline-localizations-sample").build();

            // Prompt the user to specify the action of the be achieved.
            String actionString = getActionFromUser();
            System.out.println("You chose " + actionString + ".");
            //Map the user input to the enum values.
            Action action = Action.valueOf(actionString.toUpperCase());

		
	    // Channel_ID = Boas Novas
	    String Channel_ID = "UcopVMAEcdblYjF1-4Z7rcvw";

	    getChannelSubs(channel_ID);

        } catch (GoogleJsonResponseException e) {
            System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode()
                    + " : " + e.getDetails().getMessage());
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t) {
            System.err.println("Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    }



    /**
     * Returns the number of subscribers
     *
     */
    private static void getChannelSubs(String channelId)
        throws IOException {
        // Call the YouTube Data API's channels.list method to retrieve channels.
        ChannelListResponse channelListResponse = youtube.channels().
            list("snippet").setId(channelId).execute();

        // Since the API request specified a unique channel ID, the API
        // response should return exactly one channel. If the response does
        // not contain a channel, then the specified channel ID was not found.
        List<Channel> channelList = channelListResponse.getItems();
        if (channelList.isEmpty()) {
            System.out.println("Can't find a channel with ID: " + channelId);
            return;
        }
        Channel channel = channelList.get(0);

        // Print information from the API response.
        System.out.println("\n================== Channel ==================\n");
        System.out.println("  - ID: " + channel.getId());


	// Print the Channel Subscribers Counter
	System.out.println(channel.getStatistics().getSubscriberCount());


        System.out.println("\n-------------------------------------------------------------\n");
    }
}
