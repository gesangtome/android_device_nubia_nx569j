/*
 * Copyright (C) 2016 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

import android.os.Bundle;
import android.os.SystemProperties;
import android.provider.Settings;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.text.TextUtils;

import com.cyanogenmod.settings.device.utils.NodePreferenceActivity;
import com.cyanogenmod.settings.device.utils.Constants;

public class ButtonSettings extends NodePreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.button_panel);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String prop = Constants.sBooleanPropPreferenceMap.get(preference.getKey());
        if (!TextUtils.isEmpty(prop)) {
            //String value = SystemProperties.get(prop,"0");
	    Boolean bool = (Boolean) newValue;
	    String value = bool?"0":"1";
	    Settings.System.putString(getContentResolver(), preference.getKey(), value);
	    SystemProperties.set(prop,value);
            return true;
        }
        return super.onPreferenceChange(preference,newValue);
    }

    @Override
    public void addPreferencesFromResource(int preferencesResId) {
        super.addPreferencesFromResource(preferencesResId);
        // Initialize node preferences

        for (String pref : Constants.sBooleanPropPreferenceMap.keySet()) {
            SwitchPreference b = (SwitchPreference) findPreference(pref);
            if (b == null) continue;
            b.setOnPreferenceChangeListener(this);
            String prop = Constants.sBooleanPropPreferenceMap.get(pref);

	    String value = Settings.System.getString(getContentResolver(),
                pref);
        value = value!=null?value:"1";
	    b.setChecked(value.equals("0"));
        }
    }
}
