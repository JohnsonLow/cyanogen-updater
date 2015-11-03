Heres how to use incremental updates.

Just add the new Section called "IncrementalUpdateList" to the Json. The Properties are the same as for normal Updates.
The only difference is the new Property called "VersionForApply". This must match exactly the Version the user is currently running. If it matches, the incremental Update will be displayed.

```
{
    "MirrorList": [
        "http://n0rp.chemlab.org/android/",
        "http://n0rp.chemlab.org/android/experimental/",
        "http://www.androidspin.com/files/cyanogen/ROM/",
        "http://android.phaseburn.net/mirrors/cyanogen/",
        "http://android.phaseburn.net/mirrors/cyanogen/experimental/",
        "http://cyanogen-updater.googlecode.com/files/",
        "http://cm.gotr00t.us/",
        "http://cm.xdahost.com/rom/"
    ],
    "UpdateList": [
	{
            "mod": "ADP1",
            "board": "trout|sapphire",
            "type": "rom",
            "name": "CyanogenMod-4.2.15.1",
            "version": "4.2.15.1",
            "description": "Many many many bugfixes, include GTalk and services problems|Updated Phone and Contacts apps|New wallpapers and graphics from Prash|360 degree auto-orientation|Updated to latest Google release code|Lots of Eclair internal guts|Fixed Busybox problems|Improved performance|OpenVPN integration",
            "branch": "S",
            "filename": "update-cm-4.2.15.1-signed.zip"
        }],
    "IncrementalUpdateList": [
	{
            "mod": "ADP1",
            "board": "trout|sapphire",
            "type": "rom",
            "name": "CyanogenMod-4.2.15.1",
            "version": "4.2.15.1",
	    "versionForApply": "4.2.14.1",
            "description": "TEST",
            "branch": "S",
            "filename": "update-cm-4.2.14.1-4.2.15.1-signed.zip"
        },
	{
            "mod": "ADP1",
            "board": "trout|sapphire",
            "type": "rom",
            "name": "CyanogenMod-4.2.16.1",
            "version": "4.2.15.1",
	    "versionForApply": "4.2.15.1",
            "description": "TEST",
            "branch": "S",
            "filename": "update-cm-4.2.14.1-4.2.15.1-signed.zip"
        }]
}
```