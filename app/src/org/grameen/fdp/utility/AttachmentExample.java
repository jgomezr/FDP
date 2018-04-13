package org.grameen.fdp.utility;

/**
 * Created by aangjnr on 29/03/2018.
 */


import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MultipartBody;


public class AttachmentExample {


   /* *//**
     * Create attachment SObject from its JSON populating its Body from a file at the same time.
     *//*
    public void createAttachment(String attachmentJson, File attachmentFile) throws Exception {

        PostMethod post = new PostMethod( "https://cs7.salesforce.com/services/data/v24.0/sobjects/Attachment" );// test na14 cs7

        post.setRequestHeader("Authorization", "OAuth " + "00DM000000147ht!AQMAQHHZ1bOXs.xz4Ogza4.G45BtRHw9GiQvs8QgyR4D1dDir1bjXkrMVkfkKyvFPVp6MsA9tr9Dgn13EVwHgj14sQdNLB2a");
        post.setRequestHeader("sessionId", "00DM000000147ht!AQMAQHHZ1bOXs.xz4Ogza4.G45BtRHw9GiQvs8QgyR4D1dDir1bjXkrMVkfkKyvFPVp6MsA9tr9Dgn13EVwHgj14sQdNLB2a");


        try {

            MultipartBody.Part[] parts = new MultipartBody.Part[] {
                    new JsonPart("Json", attachmentJson),
                    new FilePart("Body", attachmentFile)
            };

            post.setRequestEntity(new MultipartRequestEntity(parts, post.getParams()));
            HttpClient httpClient = new HttpClient();
            httpClient.getHostConfiguration().setProxy("138.21.89.90", 3128);

            int status = httpClient.executeMethod(post);
            String response = post.getResponseBodyAsString();

            System.out.println(" status : " + status);
            System.out.println("Response Content Length : " + post.getResponseContentLength());
            System.out.println("response : " + response);
            System.out.println(" getStatusCode " + post.getStatusCode() + " getStatusText : " + post.getStatusText());

            if (post.getStatusCode() == HttpStatus.SC_CREATED) {
                System.out.println("Logic for OK");
            } else {
                System.out.println("Error handling logic");
            }

        } finally {
            post.releaseConnection();
        }
    }

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        try {
            File f = new File("D:\\Public\\Downloads\\TNPSC012014_401757481.pdf");

            obj.put("name", f.getName());
            obj.put("Description", "Last Modified : " + f.lastModified() );
            obj.put("ParentId", "a03M0000005MkW1IAK");

            String name = f.getName();
            int lastIndexOf = name.lastIndexOf(".");

            if (lastIndexOf > -1) {
                obj.put("ContentType", name.substring(lastIndexOf));
            }

            AttachmentExample ob = new AttachmentExample();
            ob.createAttachment(obj.toString(), f);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }*/


}