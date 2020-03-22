package org.coepi.android;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Vector;

public class FrontEndAPIClient {

    FrontEndAPIClient (Context ctx){
        this.ctx=ctx;
    }

    private Context ctx = null;

    private String url_api = "https://coepi.wolk.com:8081";

    private String rs="";

    public String sendContactAndSymptoms(String symptom_id, Vector<String> uuIDs ){

        //Instantiate RequestQueue
        RequestQueue queue = Volley.newRequestQueue(ctx);

        //Set the request post body
        String body = "{\"Symptoms\":\""+symptom_id+"\", \n" +
                "\"Contacts\":[";
        String comma="";
        for  ( String uuid : uuIDs )  {
            body += comma+ "{\"UUID\":\""+uuid+"\",Date:\"2020-03-24\"}\n";
            comma=",";
        }
        body+= "]}\";";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_api+"/exposureandsymptoms",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        rs =response.substring(0,500);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                rs ="That didn't work!";
            }
        });
        
        /*With HttpClient
        HttpGet postSymptomsAndContactsRequest = new HttpPost(url_api);
        //Set the API media type in http content-type header
        postSymptomsAndContactsRequest.addHeader("content-type", "application/xml");
        StringEntity symptomAndContact = new StringEntity(body));
        postRequest.setEntity(userEntity);
        //SEND IT
        HttpResponse response = httpClient.execute(postRequest);*/

        return "Sent:"+body+"\n got:"+rs;
    }
}
