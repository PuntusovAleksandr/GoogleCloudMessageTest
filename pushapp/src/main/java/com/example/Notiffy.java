package com.example;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

import java.util.ArrayList;

public class Notiffy {
    public static void main(String args[]) {

        String Server_API_Key2 = "AIzaSyDRXw4YlOgwD_UrwEJS3ZkLSypO_-QrMeU";

        try {

            Sender sender = new Sender(Server_API_Key2);


            String devTok = "APA91bHOPdd6iX8_3oIJI_UDi_E93V10LFEAa6stkDQ5ebQuQaOdmzUExeJg8Hb6axOdkyls-uZdCJw_ePtFA41bZvDjoh_lj7hWhrOpObSzlsfdENcx67rEffVKhYFtxT4vpQGGdR-v-8zNlwjOrYZmXQCfNTxTHQ";
            // Mika
            devTok = "APA91bECE58hstI5zgFXqdDO56ROs2Ril5uos1ehXZjbwULmB8xeDFCZQuNYCYkmV4dqcdvCHarH0AFijeP33zoQ8pyPDddaEzd2bQjb7MFUZTwaf-_GfiKUDcw6fZgiOWUETfuYKLIfJy-Px_p6lxUdBjTUXnHeJg";
//dooge
            String devTok1 = "APA91bHr9RKcfw89Y6zp46h8bDwURuBHw3-tw6Xi3O83-g-99ti_TBLUuSGhHR9XlFkWyh_tlLixx6xEDedEsmXrPxxeWouvu7CG_VcKZf65ge9QN5O7Ij-BqcfMT3wLFk0cTaFDdPKx85I9L8SeM7pCsi1X-CUtSg";


            ArrayList<String> devicesList = new ArrayList<String>();
            devicesList.add(devTok);
            devicesList.add(devTok1);

            // Use this line to send message without payload data
            // Message message = new Message.Builder().build();

            // use this line to send message with payload data
            Message message = new Message.Builder()
                    .collapseKey("1")
                    .timeToLive(3)
                    .delayWhileIdle(true)
                    .addData("message",
                            "I send this text from my server!!")
                    .addData("title",
                            "My GCM")
                    .build();

            // Use this code to send to a single device
            // Result result = sender
            // .send(message,
            // "APA91bGiRaramjyohc2lKjAgFGpzBwtEmI8tJC30O89C2b3IjP1CuMeU1h9LMjKhmWuZwcXZjy1eqC4cE0tWBNt61Kx_SuMF6awzIt8WNq_4AfwflaVPHQ0wYHG_UX3snjp_U-5kJkmysdRlN6T8xChB1n3DtIq98w",
            // 1);

            // Use this for multicast messages
            MulticastResult result = sender.send(message, devicesList, 1);
//            sender.send(message, devicesList, 1);

            System.out.println(result.toString());
            if (result.getResults() != null) {
                int canonicalRegId = result.getCanonicalIds();
                if (canonicalRegId != 0) {
                }
            } else {
                int error = result.getFailure();
                System.out.println(error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
