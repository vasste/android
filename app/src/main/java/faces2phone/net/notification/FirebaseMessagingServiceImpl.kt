package faces2phone.net.notification

import android.preference.PreferenceManager
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject

class FirebaseMessagingServiceImpl : FirebaseMessagingService() {

    private val TAG = "FirebaseMessagingServiceImpl"

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Log.d(TAG, "Message data payload: " + remoteMessage?.data)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = PreferenceManager.getDefaultSharedPreferences(this).getString("destinationUrlKey", "")

        // Request a string response from the provided URL.
        val data = JSONObject(remoteMessage!!.data)
        val stringRequest = JsonObjectRequest(Request.Method.POST, url, data,
                Response.Listener<JSONObject> { response -> },
                Response.ErrorListener { })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    override fun onNewToken(token: String?) {
        Log.d(TAG, "Refreshed token: " + token!!)
    }
}