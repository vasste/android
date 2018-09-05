package faces2phone.net.notification

import android.os.Bundle
import android.preference.PreferenceFragment

class AppSettingsFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences);
    }
}